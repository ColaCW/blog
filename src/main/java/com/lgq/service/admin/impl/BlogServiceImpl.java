package com.lgq.service.admin.impl;

import com.lgq.entity.admin.BlogPO;
import com.lgq.mapper.admin.BlogMapper;
import com.lgq.service.admin.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgq.common.exception.ServiceBizException;
import com.lgq.common.util.StringUtils;
import com.lgq.dto.admin.BlogDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 博客 服务实现类
 *
 * @author liugq
 * @since 2020-11-16
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BlogServiceImpl extends ServiceImpl<BlogMapper, BlogPO> implements BlogService {

        //日志对象
        private static final Logger logger = LoggerFactory.getLogger(BlogServiceImpl.class);

        @Autowired
        private BlogMapper blogMapper;

        /**
         * 分页查询对应数据
         */
        @Override
        @Transactional(readOnly = true)
        public Page<Map<String, Object>> selectPageBySql(Page<Map<String, Object>> page, Map<String, Object> queryCondition) {
            // 获取总条数
            page.setRecords(blogMapper.selectPageBySql(page, queryCondition));
            return page;
        }

        /**
         * 根据查询条件返回结果集
         */
        @Override
        @Transactional(readOnly = true)
        public Map<String, Object> getById(Long id) {
            BlogPO blogPO = blogMapper.selectById(id);
            if(blogPO!=null){
                return blogPO.toMaps();
            }else{
                throw new ServiceBizException("查询失败,没有符合条件的数据");
            }
        }

        /**
         * 根据DTO 进行数据新增
         */
        @Override
        public Map<String,Object> add(BlogDTO blogDTO){
            //对对象进行赋值操作
            BlogPO blogPO = blogDTO.transDtoToPo(BlogPO.class);
            //执行插入
            blogMapper.insert(blogPO);
            //返回插入的值
            return blogPO.toMaps();
        }

        /**
         * 根据DTO 及ID 进行数据更新
         */
        @Override
        public Map<String,Object> alter(Long id, BlogDTO blogDTO) {
            BlogPO blogPO = blogMapper.selectById(id);
            //对对象进行赋值操作
            blogDTO.transDtoToPo(blogPO);
            //执行更新
            blogMapper.updateById(blogPO);
            return blogPO.toMaps();
        }

        /**
         * 根据ID 进行删除数据
         */
        @Override
        public void deleteById(Long id) {
            int deleteCount = blogMapper.deleteById(id);
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
            int deleteCount = blogMapper.deleteBatchIds(longList);
            logger.debug("删除数量：{}",deleteCount);
            if (deleteCount!=longList.size()) {
                throw new ServiceBizException("删除失败,没有符合条件的数据");
            }
        }

}
