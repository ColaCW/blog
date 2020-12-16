package com.lgq.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgq.dto.admin.BlogDTO;
import com.lgq.entity.admin.BlogPO;

import java.util.Map;

/**
 * <p>
 * 博客 服务类
 * </p>
 *
 * @author liugq
 * @since 2020-11-16
 */
public interface BlogService extends IService<BlogPO> {

        Page<Map<String, Object>> selectPageBySql(Page<Map<String, Object>> page, Map<String, Object> queryCondition);

        Map<String, Object> getById(Long id);

        Map<String, Object> add(BlogDTO blogPODTO);

        Map<String, Object> alter(Long id, BlogDTO blogPODTO);

        void deleteById(Long id);

        void deleteBatchIds(String ids);

}
