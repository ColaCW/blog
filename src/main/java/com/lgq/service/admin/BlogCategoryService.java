package com.lgq.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgq.dto.admin.BlogCategoryDTO;
import com.lgq.entity.admin.BlogCategoryPO;

import java.util.Map;

/**
 * <p>
 * 博客分类 服务类
 * </p>
 *
 * @author liugq
 * @since 2020-11-16
 */
public interface BlogCategoryService extends IService<BlogCategoryPO> {

        Page<Map<String, Object>> selectPageBySql(Page<Map<String, Object>> page, Map<String, Object> queryCondition);

        Map<String, Object> getById(Long id);

        Map<String, Object> add(BlogCategoryDTO blogCategoryPODTO);

        Map<String, Object> alter(Long id, BlogCategoryDTO blogCategoryPODTO);

        void deleteById(Long id);

        void deleteBatchIds(String ids);

}
