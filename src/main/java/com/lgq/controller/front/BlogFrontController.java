package com.lgq.controller.front;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgq.common.authentication.PassToken;
import com.lgq.service.front.BlogFrontService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 博客 controller
 *
 * @author liugq
 * @since 2020-07-05
 */
@RestController
@RequestMapping("/front/blogfront")
@CrossOrigin(allowCredentials="true",origins = "*",maxAge = 3600)
public class BlogFrontController {

    private final Logger logger = LoggerFactory.getLogger(BlogFrontController.class);

    @Autowired
    private BlogFrontService blogFrontService;

    @GetMapping(value = "/getBlogs")
    @PassToken
    public IPage<Map<String,Object>> getBlogs (@RequestParam Map<String,Object> queryCondition, @RequestParam
            ("currentPage") int currentPage, @RequestParam("pageSize") int pageSize) {
        Page<Map<String,Object>> page = new Page(currentPage, pageSize);
        return blogFrontService.getBlogs(page, queryCondition);
    }

}

