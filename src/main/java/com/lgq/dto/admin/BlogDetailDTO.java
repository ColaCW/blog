package com.lgq.dto.admin;

import com.lgq.common.util.BeanMapperUtil;
import com.lgq.entity.admin.BlogDetailPO;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 博客详情 DTO
 *
 * @author liugq
 * @since 2020-11-16T17:41:09.223
 */
public class BlogDetailDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * ID
     */
    private Long id;

    /**
     * 博客ID
     */
    private String blogId;

    /**
     * 博客正文
     */
    private String content;

    /**
     * 博客Md
     */
    private String markdown;

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
    public String toString() {
    return "BlogDetailDTO{" +
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
    *  将DTO 转换为PO
    * @param poClass
    */
    public BlogDetailPO transDtoToPo(Class< BlogDetailPO> poClass) {
        return BeanMapperUtil.copyProperties(this, poClass);
    }

    /**
     * 将DTO 转换为PO
     * @param po 需要转换的对象
     */
    public void transDtoToPo(BlogDetailPO po) {
        BeanMapperUtil.copyProperties(this, po, "id");
    }

}