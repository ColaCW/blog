package com.lgq.service.front.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgq.mapper.front.BlogFrontMapper;
import com.lgq.service.front.BlogFrontService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 *
 * 博客前端 服务实现类
 *
 * @author liugq
 * @since 2020-04-08
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BlogFrontServiceImpl implements BlogFrontService {

    //日志对象
    private static final Logger logger = LoggerFactory.getLogger(BlogFrontServiceImpl.class);

    @Autowired
    private BlogFrontMapper blogFrontMapper;

    /**
     * 分页查询对应数据
     */
    @Override
    @Transactional(readOnly = true)
    public IPage<Map<String, Object>> getBlogs(Page<Map<String, Object>> page, Map<String, Object> queryCondition) {
        // 获取总条数
        page.setRecords(blogFrontMapper.getBlogs(page, queryCondition));
        return page;
    }

}
