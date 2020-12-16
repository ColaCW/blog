package com.lgq.common.util;

import com.aliyuncs.utils.MapUtils;
import com.lgq.common.exception.ServiceBizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: liugq
 * @time: 2020/7/5
 */
public class BeanMapperUtil extends MapUtils {

    private static final Logger logger = LoggerFactory.getLogger(BeanMapperUtil.class);

    public static <T> T copyProperties(Object orig, Class<T> clazz) {
        if (orig == null) {
            throw new ServiceBizException("空");
        } else {
            Object t = null;

            try {
                t = clazz.getDeclaredConstructor().newInstance();
            } catch (ReflectiveOperationException var4) {
                logger.error(var4.getMessage(), var4);
            }

            BeanUtils.copyProperties(orig, t);
            return (T) t;
        }
    }

    public static void copyProperties(Object orig, Object destObj, String... ignoreProperties) {
        BeanUtils.copyProperties(orig, destObj, ignoreProperties);
    }

    public static Map<String, Object> toMap(Object obj) {
        try {
            if (obj == null) {
                return null;
            } else {
                Map<String, Object> map = new HashMap();
                BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
                PropertyDescriptor[] var4 = propertyDescriptors;
                int var5 = propertyDescriptors.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    PropertyDescriptor property = var4[var6];
                    String key = property.getName();
                    if (key.compareToIgnoreCase("class") != 0) {
                        Method getter = property.getReadMethod();
                        Object value = getter != null ? getter.invoke(obj) : null;
                        map.put(key, value);
                    }
                }

                return map;
            }
        } catch (Exception var11) {
            throw new ServiceBizException("转换失败");
        }
    }

}
