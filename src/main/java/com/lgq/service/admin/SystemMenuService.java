package com.lgq.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgq.dto.admin.SystemMenuDTO;
import com.lgq.entity.admin.SystemMenuPO;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liugq
 * @since 2020-10-21
 */
public interface SystemMenuService extends IService<SystemMenuPO> {

        Page<Map<String, Object>> selectPageBySql(Page<Map<String, Object>> page, Map<String, Object> queryCondition);

        Map<String, Object> getById(Long id);

        Map<String, Object> add(SystemMenuDTO systemMenuPODTO);

        Map<String, Object> alter(Long id, SystemMenuDTO systemMenuPODTO);

        void deleteById(Long id);

        void deleteBatchIds(String ids);

}
