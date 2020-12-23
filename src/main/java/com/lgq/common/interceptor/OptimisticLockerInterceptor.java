package com.lgq.common.interceptor;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.lgq.common.exception.ServiceBizException;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

/**
 * @author liuguoqiang
 */
@Intercepts({@Signature(
        type = Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class}
)})
public class OptimisticLockerInterceptor implements Interceptor {

    private static final String UPDATE_ERROR="此数据已经被修改，请刷新重试。";

    public OptimisticLockerInterceptor() {
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement)args[0];
        if (SqlCommandType.UPDATE != ms.getSqlCommandType()) {
            return invocation.proceed();
        } else {
            Object param = args[1];
            if (param instanceof Map) {
                Map map = (Map)param;
                Object et = map.getOrDefault("et", (Object)null);
                if (et != null) {
                    String methodId = ms.getId();
                    String methodName = methodId.substring(methodId.lastIndexOf(".") + 1);
                    TableInfo tableInfo = TableInfoHelper.getTableInfo(et.getClass());
                    if (tableInfo != null && tableInfo.isWithVersion()) {
                        TableFieldInfo fieldInfo = tableInfo.getVersionFieldInfo();
                        Field versionField = fieldInfo.getField();
                        Object originalVersionVal = versionField.get(et);
                        if (originalVersionVal == null) {
                            return invocation.proceed();
                        }

                        String versionColumn = fieldInfo.getColumn();
                        Object updatedVersionVal = this.getUpdatedVersionVal(fieldInfo.getPropertyType(), originalVersionVal);
                        if ("update".equals(methodName)) {
                            AbstractWrapper<?, ?, ?> aw = (AbstractWrapper)map.getOrDefault("ew", (Object)null);
                            if (aw == null) {
                                UpdateWrapper<?> uw = new UpdateWrapper();
                                uw.eq(versionColumn, originalVersionVal);
                                map.put("ew", uw);
                            } else {
                                aw.apply(versionColumn + " = {0}", new Object[]{originalVersionVal});
                            }
                        } else {
                            map.put("MP_OPTLOCK_VERSION_ORIGINAL", originalVersionVal);
                        }

                        versionField.set(et, updatedVersionVal);

                        Object resultObj = invocation.proceed();
                        if (Integer.parseInt(resultObj.toString()) == 0) {
                            throw new ServiceBizException(UPDATE_ERROR);
                        }

                        return resultObj;
                    }

                    return invocation.proceed();
                }
            }

            return invocation.proceed();
        }
    }

    protected Object getUpdatedVersionVal(Class<?> clazz, Object originalVersionVal) {
        if (!Long.TYPE.equals(clazz) && !Long.class.equals(clazz)) {
            if (!Integer.TYPE.equals(clazz) && !Integer.class.equals(clazz)) {
                if (Date.class.equals(clazz)) {
                    return new Date();
                } else if (Timestamp.class.equals(clazz)) {
                    return new Timestamp(System.currentTimeMillis());
                } else {
                    return LocalDateTime.class.equals(clazz) ? LocalDateTime.now() : originalVersionVal;
                }
            } else {
                return (Integer)originalVersionVal + 1;
            }
        } else {
            return (Long)originalVersionVal + 1L;
        }
    }

    @Override
    public Object plugin(Object target) {
        return target instanceof Executor ? Plugin.wrap(target, this) : target;
    }

    @Override
    public void setProperties(Properties properties) {
    }
}
