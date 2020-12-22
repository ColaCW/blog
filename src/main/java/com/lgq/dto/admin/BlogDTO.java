package com.lgq.dto.admin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lgq.common.util.BeanMapperUtil;
import com.lgq.entity.admin.BlogPO;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 博客 DTO
 *
 * @author liugq
 * @since 2020-11-16T15:22:51.331
 */
public class BlogDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    private Long id;

    /**
     * 博客标题
     */
    private String name;

    /**
     * 简介
     */
    private String brief;

    /**
     * 标签
     */
    private String tags;

    /**
     * 博客分类ID
     */
    private Long categoryId;

    /**
     * 观看次数
     */
    private Integer viewNum;

    /**
     * 点赞次数
     */
    private Integer likeNum;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 图片路径
     */
    private String imgSrc;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除
     */
    private Boolean isDeleted;

    /**
     * 创建人ID
     */
    private String createdBy;

    /**
     * 创建人姓名
     */
    private String createdName;

    /**
     * 创建时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    /**
     * 更新人ID
     */
    private String updatedBy;

    /**
     * 更新人姓名
     */
    private String updatedName;

    /**
     * 更新时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    /**
     * 版本号(乐观锁)
     */
    private Integer version;

    /**
     * 明细对象
     */
    private BlogDetailDTO blogDetailDTO;

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

    public BlogDetailDTO getBlogDetailDTO() {
        return blogDetailDTO;
    }

    public void setBlogDetailDTO(BlogDetailDTO blogDetailDTO) {
        this.blogDetailDTO = blogDetailDTO;
    }

    @Override
    public String toString() {
    return "BlogDTO{" +
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
    *  将DTO 转换为PO
    * @param poClass
    */
    public BlogPO transDtoToPo(Class< BlogPO> poClass) {
        return BeanMapperUtil.copyProperties(this, poClass);
    }

    /**
     * 将DTO 转换为PO
     * @param po 需要转换的对象
     */
    public void transDtoToPo(BlogPO po) {
        BeanMapperUtil.copyProperties(this, po, "id");
    }

}