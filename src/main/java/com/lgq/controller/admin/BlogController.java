package com.lgq.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgq.dto.admin.BlogDTO;
import com.lgq.service.admin.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 博客 controller
 *
 * @author liugq
 * @since 2020-11-16
 */
@RestController
@RequestMapping("/admin/blog")
@CrossOrigin(allowCredentials = "true", origins = "*", maxAge = 3600)
public class BlogController {

    private final Logger logger = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    private BlogService blogService;

    /**
     * 分页查询数据
     */
    @GetMapping("/selectPageBySql")
    public Page<Map<String, Object>> selectPageBySql(@RequestParam Map<String, Object> queryCondition, @RequestParam
            ("currentPage") int currentPage, @RequestParam("pageSize") int pageSize) {
        Page<Map<String, Object>> page = new Page(currentPage, pageSize);
        return blogService.selectPageBySql(page, queryCondition);
    }

    /**
     * 按ID查询数据
     */
    @GetMapping("/getById/{id}")
    public Map<String, Object> getById(@PathVariable("id") Long id) {
        return blogService.getById(id);
    }

    /**
     * 进行数据新增
     */
    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody BlogDTO blogDTO) {
        return blogService.add(blogDTO);
    }

    /**
     * 进行数据修改
     */
    @PostMapping("/alter/{id}")
    public Map<String, Object> alter(@PathVariable("id") Long id, @RequestBody BlogDTO blogDTO) {
        return blogService.alter(id, blogDTO);
    }

    /**
     * 根据id删除对象
     */
    @PostMapping("/del/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        blogService.deleteById(id);
    }

    /**
     * 根据IDs批量删除对象
     */
    @PostMapping("/deleteBatch/{ids}")
    public void deleteByIds(@PathVariable("ids") String ids) {
        blogService.deleteBatchIds(ids);
    }
}

