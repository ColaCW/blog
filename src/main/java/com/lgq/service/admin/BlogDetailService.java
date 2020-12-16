package com.lgq.service.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lgq.dto.admin.BlogDetailDTO;
import com.lgq.entity.admin.BlogDetailPO;

import java.util.Map;

/**
 * <p>
 * 博客详情 服务类
 * </p>
 *
 * @author liugq
 * @since 2020-11-16
 */
public interface BlogDetailService extends IService<BlogDetailPO> {

        Page<Map<String, Object>> selectPageBySql(Page<Map<String, Object>> page, Map<String, Object> queryCondition);

        Map<String, Object> getById(Long id);

        Map<String, Object> add(BlogDetailDTO blogDetailPODTO);

        Map<String, Object> alter(Long id, BlogDetailDTO blogDetailPODTO);

        void deleteById(Long id);

        void deleteBatchIds(String ids);

        Map<String, Object> getByBlogId(Long blogId);
}
