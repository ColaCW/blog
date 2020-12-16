package com.lgq.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgq.dto.admin.UserDTO;
import com.lgq.entity.admin.UserPO;

import java.util.Map;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author liugq
 * @since 2020-09-25
 */
public interface UserService extends IService<UserPO> {

        Page<Map<String, Object>> selectPageBySql(Page<Map<String, Object>> page, Map<String, Object> queryCondition);

        Map<String, Object> getById(Long id);

        Map<String, Object> add(UserDTO userPODTO);

        Map<String, Object> alter(Long id, UserDTO userPODTO);

        void deleteById(Long id);

        void deleteBatchIds(String ids);

}
