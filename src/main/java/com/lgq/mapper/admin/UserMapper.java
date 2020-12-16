package com.lgq.mapper.admin;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgq.entity.admin.UserPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户 Mapper 接口
 *
 * @author liugq
 * @since 2020-09-25
 */
public interface UserMapper extends BaseMapper<UserPO> {

    List<Map<String, Object>> selectPageBySql(Page<Map<String, Object>> page, @Param("params") Map<String, Object> queryCondition);

}
