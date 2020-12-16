package com.lgq.mapper.admin;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgq.entity.admin.BlogCategoryPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 博客分类 Mapper 接口
 *
 * @author liugq
 * @since 2020-11-16
 */
public interface BlogCategoryMapper extends BaseMapper<BlogCategoryPO> {

    List<Map<String, Object>> selectPageBySql(Page<Map<String, Object>> page, @Param("params") Map<String, Object> queryCondition);

}
