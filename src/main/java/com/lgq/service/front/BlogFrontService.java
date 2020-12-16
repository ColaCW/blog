package com.lgq.service.front;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Map;

/**
 *
 * 博客前端 服务类
 *
 * @author liuguoqiang
 * @since 2020-04-08
 */
public interface BlogFrontService {

    IPage<Map<String, Object>> getBlogs(Page<Map<String, Object>> page, Map<String, Object> queryCondition);

}
