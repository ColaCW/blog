package com.lgq.service.admin.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lgq.common.exception.ServiceBizException;
import com.lgq.common.util.StringUtils;
import com.lgq.dto.admin.BlogDetailDTO;
import com.lgq.entity.admin.BlogDetailPO;
import com.lgq.mapper.admin.BlogDetailMapper;
import com.lgq.service.admin.BlogDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 博客详情 服务实现类
 *
 * @author liugq
 * @since 2020-11-16
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BlogDetailServiceImpl extends ServiceImpl<BlogDetailMapper, BlogDetailPO> implements BlogDetailService {

    //日志对象
    private static final Logger logger = LoggerFactory.getLogger(BlogDetailServiceImpl.class);

    @Autowired
    private BlogDetailMapper blogDetailMapper;

    /**
     * 分页查询对应数据
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Map<String, Object>> selectPageBySql(Page<Map<String, Object>> page, Map<String, Object> queryCondition) {
        // 获取总条数
        page.setRecords(blogDetailMapper.selectPageBySql(page, queryCondition));
        return page;
    }

    /**
     * 根据查询条件返回结果集
     */
    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> getById(Long id) {
        BlogDetailPO blogDetailPO = blogDetailMapper.selectById(id);
        if (blogDetailPO != null) {
            return blogDetailPO.toMaps();
        } else {
            throw new ServiceBizException("查询失败,没有符合条件的数据");
        }
    }

    /**
     * 根据DTO 进行数据新增
     */
    @Override
    public Map<String, Object> add(BlogDetailDTO blogDetailDTO) {
        //对对象进行赋值操作
        BlogDetailPO blogDetailPO = blogDetailDTO.transDtoToPo(BlogDetailPO.class);
        //执行插入
        blogDetailMapper.insert(blogDetailPO);
        //返回插入的值
        return blogDetailPO.toMaps();
    }

    /**
     * 根据DTO 及ID 进行数据更新
     */
    @Override
    public Map<String, Object> alter(Long id, BlogDetailDTO blogDetailDTO) {
        BlogDetailPO blogDetailPO = blogDetailMapper.selectById(id);
        //对对象进行赋值操作
        blogDetailDTO.transDtoToPo(blogDetailPO);
        //执行更新
        blogDetailMapper.updateById(blogDetailPO);
        return blogDetailPO.toMaps();
    }

    /**
     * 根据ID 进行删除数据
     */
    @Override
    public void deleteById(Long id) {
        int deleteCount = blogDetailMapper.deleteById(id);
        logger.debug("删除数量：{}", deleteCount);
        if (deleteCount <= 0) {
            throw new ServiceBizException("删除失败,没有符合条件的数据");
        }
    }

    /**
     * 根据ids 进行删除
     */
    @Override
    public void deleteBatchIds(String ids) {
        List<Long> longList = StringUtils.convertStrToArray(ids, ",", Long.class);
        int deleteCount = blogDetailMapper.deleteBatchIds(longList);
        logger.debug("删除数量：{}", deleteCount);
        if (deleteCount != longList.size()) {
            throw new ServiceBizException("删除失败,没有符合条件的数据");
        }
    }

    @Override
    public Map<String, Object> getByBlogId(Long blogId) {
        QueryWrapper<BlogDetailPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("BLOG_ID", blogId);
        queryWrapper.eq("IS_DELETED", 0);
        BlogDetailPO blogDetailPO = blogDetailMapper.selectOne(queryWrapper);
        return blogDetailPO.toMaps();
    }
}
