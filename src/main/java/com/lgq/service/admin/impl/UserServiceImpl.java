package com.lgq.service.admin.impl;

import com.lgq.entity.admin.UserPO;
import com.lgq.mapper.admin.UserMapper;
import com.lgq.service.admin.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgq.common.exception.ServiceBizException;
import com.lgq.common.util.StringUtils;
import com.lgq.dto.admin.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 用户 服务实现类
 *
 * @author liugq
 * @since 2020-09-25
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements UserService {

        //日志对象
        private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

        @Autowired
        private UserMapper userMapper;

        /**
         * 分页查询对应数据
         */
        @Override
        @Transactional(readOnly = true)
        public Page<Map<String, Object>> selectPageBySql(Page<Map<String, Object>> page, Map<String, Object> queryCondition) {
            // 获取总条数
            page.setRecords(userMapper.selectPageBySql(page, queryCondition));
            return page;
        }

        /**
         * 根据查询条件返回结果集
         */
        @Override
        @Transactional(readOnly = true)
        public Map<String, Object> getById(Long id) {
            UserPO userPO = userMapper.selectById(id);
            if(userPO!=null){
                return userPO.toMaps();
            }else{
                throw new ServiceBizException("查询失败,没有符合条件的数据");
            }
        }

        /**
         * 根据DTO 进行数据新增
         */
        @Override
        public Map<String,Object> add(UserDTO userDTO){
            //对对象进行赋值操作
            UserPO userPO = userDTO.transDtoToPo(UserPO.class);
            //执行插入
            userMapper.insert(userPO);
            //返回插入的值
            return userPO.toMaps();
        }

        /**
         * 根据DTO 及ID 进行数据更新
         */
        @Override
        public Map<String,Object> alter(Long id, UserDTO userDTO) {
            UserPO userPO = userMapper.selectById(id);
            //对对象进行赋值操作
            userDTO.transDtoToPo(userPO);
            //执行更新
            userMapper.updateById(userPO);
            return userPO.toMaps();
        }

        /**
         * 根据ID 进行删除数据
         */
        @Override
        public void deleteById(Long id) {
            int deleteCount = userMapper.deleteById(id);
            logger.debug("删除数量：{}",deleteCount);
            if (deleteCount<=0) {
                throw new ServiceBizException("删除失败,没有符合条件的数据");
            }
        }

        /**
         * 根据ids 进行删除
         */
        @Override
        public void deleteBatchIds(String ids) {
            List<Long> longList = StringUtils.convertStrToArray(ids,",", Long.class);
            int deleteCount = userMapper.deleteBatchIds(longList);
            logger.debug("删除数量：{}",deleteCount);
            if (deleteCount!=longList.size()) {
                throw new ServiceBizException("删除失败,没有符合条件的数据");
            }
        }

}
