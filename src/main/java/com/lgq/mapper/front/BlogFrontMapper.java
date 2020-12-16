package com.lgq.mapper.front;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 博客 Mapper 接口
 *
 * @author liugq
 * @since 2020-07-05
 */
public interface BlogFrontMapper{

    List<Map<String, Object>> getBlogs(Page page, @Param("params") Map<String, Object> queryCondition);

}
