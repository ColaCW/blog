package com.lgq.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgq.dto.admin.SystemMenuDTO;
import com.lgq.service.admin.SystemMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 *  controller
 *
 * @author liugq
 * @since 2020-10-21
 */
@RestController
@RequestMapping("/admin/systemMenu")
@CrossOrigin(allowCredentials = "true", origins = "*", maxAge = 3600)
public class SystemMenuController {

    private final Logger logger = LoggerFactory.getLogger(SystemMenuController.class);

    @Autowired
    private SystemMenuService systemMenuService;

    /**
     * 分页查询数据
     */
    @GetMapping("/selectPageBySql")
    public Page<Map<String, Object>> selectPageBySql(@RequestParam Map<String, Object> queryCondition, @RequestParam
            ("currentPage") int currentPage, @RequestParam("pageSize") int pageSize) {
        Page<Map<String, Object>> page = new Page(currentPage, pageSize);
        return systemMenuService.selectPageBySql(page, queryCondition);
    }

    /**
     * 按ID查询数据
     */
    @GetMapping("/getById/{id}")
    public Map<String, Object> getById(@PathVariable("id") Long id) {
        return systemMenuService.getById(id);
    }

    /**
     * 进行数据新增
     */
    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody SystemMenuDTO systemMenuDTO) {
        return systemMenuService.add(systemMenuDTO);
    }

    /**
     * 进行数据修改
     */
    @PostMapping("/alter/{id}")
    public Map<String, Object> alter(@PathVariable("id") Long id, @RequestBody SystemMenuDTO systemMenuDTO) {
        return systemMenuService.alter(id, systemMenuDTO);
    }

    /**
     * 根据id删除对象
     */
    @PostMapping("/del/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        systemMenuService.deleteById(id);
    }

    /**
     * 根据IDs批量删除对象
     */
    @PostMapping("/deleteBatch/{ids}")
    public void deleteByIds(@PathVariable("ids") String ids) {
        systemMenuService.deleteBatchIds(ids);
    }
}

