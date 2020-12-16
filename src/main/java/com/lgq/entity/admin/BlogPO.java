package com.lgq.entity.admin;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lgq.common.util.MapUtil;
import com.lgq.dto.admin.BlogDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * 博客 PO
 *
 * @author liugq
 * @since 2020-11-16
 */
@TableName("t_blog")
public class BlogPO extends Model<BlogPO> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId("ID")
    private Long id;

    /**
     * 博客标题
     */
    @TableField("NAME")
    private String name;

    /**
     * 简介
     */
    @TableField("BRIEF")
    private String brief;

    /**
     * 标签
     */
    @TableField("TAGS")
    private String tags;

    /**
     * 博客分类ID
     */
    @TableField("CATEGORY_ID")
    private Long categoryId;

    /**
     * 观看次数
     */
    @TableField("VIEW_NUM")
    private Integer viewNum;

    /**
     * 点赞次数
     */
    @TableField("LIKE_NUM")
    private Integer likeNum;

    /**
     * 状态
     */
    @TableField("STATUS")
    private Integer status;

    /**
     * 图片路径
     */
    @TableField("IMG_SRC")
    private String imgSrc;

    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;

    /**
     * 是否删除
     */
    @TableField("IS_DELETED")
    @TableLogic
    private Boolean isDeleted;

    /**
     * 创建人ID
     */
    @TableField("CREATED_BY")
    private String createdBy;

    /**
     * 创建人姓名
     */
    @TableField("CREATED_NAME")
    private String createdName;

    /**
     * 创建时间
     */
    @TableField("CREATED_AT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    /**
     * 更新人ID
     */
    @TableField("UPDATED_BY")
    private String updatedBy;

    /**
     * 更新人姓名
     */
    @TableField("UPDATED_NAME")
    private String updatedName;

    /**
     * 更新时间
     */
    @TableField("UPDATED_AT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    /**
     * 版本号(乐观锁)
     */
    @TableField("VERSION")
    @Version
    private Integer version;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedName() {
        return createdName;
    }

    public void setCreatedName(String createdName) {
        this.createdName = createdName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedName() {
        return updatedName;
    }

    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "BlogPO{" +
               "id=" + id +
               ", name=" + name +
               ", brief=" + brief +
               ", tags=" + tags +
               ", categoryId=" + categoryId +
               ", viewNum=" + viewNum +
               ", likeNum=" + likeNum +
               ", status=" + status +
               ", imgSrc=" + imgSrc +
               ", remark=" + remark +
               ", isDeleted=" + isDeleted +
               ", createdBy=" + createdBy +
               ", createdName=" + createdName +
               ", createdAt=" + createdAt +
               ", updatedBy=" + updatedBy +
               ", updatedName=" + updatedName +
               ", updatedAt=" + updatedAt +
               ", version=" + version +
               "}";
    }

    /**
     * 将PO信息转化为DTO
     */
    protected void transDtoToPo(BlogDTO dto) {
        BeanUtils.copyProperties(this, dto, "id");
    }

    /**
     * PO转map
     */
    public Map<String, Object> toMaps() {
        return MapUtil.beanToMap(this);
    }
}
