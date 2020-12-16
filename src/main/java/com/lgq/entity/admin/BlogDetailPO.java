package com.lgq.entity.admin;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lgq.common.util.MapUtil;
import com.lgq.dto.admin.BlogDetailDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * 博客详情 PO
 *
 * @author liugq
 * @since 2020-11-16
 */
@TableName("t_blog_detail")
public class BlogDetailPO extends Model<BlogDetailPO> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId("ID")
    private Long id;

    /**
     * 博客ID
     */
    @TableField("BLOG_ID")
    private String blogId;

    /**
     * 博客正文
     */
    @TableField("CONTENT")
    private String content;

    /**
     * 博客Md
     */
    @TableField("MARKDOWN")
    private String markdown;

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

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMarkdown() {
        return markdown;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown;
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
        return "BlogDetailPO{" +
               "id=" + id +
               ", blogId=" + blogId +
               ", content=" + content +
               ", markdown=" + markdown +
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
    protected void transDtoToPo(BlogDetailDTO dto) {
        BeanUtils.copyProperties(this, dto, "id");
    }

    /**
     * PO转map
     */
    public Map<String, Object> toMaps() {
        return MapUtil.beanToMap(this);
    }
}
