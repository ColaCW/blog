package com.lgq.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgq.dto.admin.BlogDetailDTO;
import com.lgq.service.admin.BlogDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 博客详情 controller
 *
 * @author liugq
 * @since 2020-11-16
 */
@RestController
@RequestMapping("/admin/blogDetail")
@CrossOrigin(allowCredentials = "true", origins = "*", maxAge = 3600)
public class BlogDetailController {

    private final Logger logger = LoggerFactory.getLogger(BlogDetailController.class);

    @Autowired
    private BlogDetailService blogDetailService;

    /**
     * 分页查询数据
     */
    @GetMapping("/selectPageBySql")
    public Page<Map<String, Object>> selectPageBySql(@RequestParam Map<String, Object> queryCondition, @RequestParam
            ("currentPage") int currentPage, @RequestParam("pageSize") int pageSize) {
        Page<Map<String, Object>> page = new Page(currentPage, pageSize);
        return blogDetailService.selectPageBySql(page, queryCondition);
    }

    /**
     * 按ID查询数据
     */
    @GetMapping("/getById/{id}")
    public Map<String, Object> getById(@PathVariable("id") Long id) {
        return blogDetailService.getById(id);
    }

    /**
     * 新增数据
     */
    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody BlogDetailDTO blogDetailDTO) {
        return blogDetailService.add(blogDetailDTO);
    }

    /**
     * 进行数据修改
     */
    @PostMapping("/alter/{id}")
    public Map<String, Object> alter(@PathVariable("id") Long id, @RequestBody BlogDetailDTO blogDetailDTO) {
        return blogDetailService.alter(id, blogDetailDTO);
    }

    /**
     * 根据id删除对象
     */
    @PostMapping("/del/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        blogDetailService.deleteById(id);
    }

    /**
     * 根据IDs批量删除对象
     */
    @PostMapping("/deleteBatch/{ids}")
    public void deleteByIds(@PathVariable("ids") String ids) {
        blogDetailService.deleteBatchIds(ids);
    }

    /**
     * 按ID查询数据
     */
    @GetMapping("/getByBlogId/{blogId}")
    public Map<String, Object> getByBlogId(@PathVariable("blogId") Long blogId) {
        return blogDetailService.getByBlogId(blogId);
    }
}

