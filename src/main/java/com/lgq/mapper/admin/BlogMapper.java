package com.lgq.mapper.admin;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgq.entity.admin.BlogPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 博客 Mapper 接口
 *
 * @author liugq
 * @since 2020-07-05
 */
public interface BlogMapper extends BaseMapper<BlogPO> {

    List<Map<String, Object>> selectPageBySql(Page page, @Param("params") Map<String, Object> queryCondition);

}
