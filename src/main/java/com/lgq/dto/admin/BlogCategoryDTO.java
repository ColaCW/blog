package com.lgq.dto.admin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lgq.common.util.BeanMapperUtil;
import com.lgq.entity.admin.BlogCategoryPO;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 博客分类 DTO
 *
 * @author liugq
 * @since 2020-09-25T11:44:57.453
 */
public class BlogCategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    private Long id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 是否有效
     */
    private Integer isValid;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除
     */
    private Integer isDeleted;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
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
    return "BlogCategoryDTO{" +
                    "id=" + id +
                    ", name=" + name +
                    ", isValid=" + isValid +
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
    public BlogCategoryPO transDtoToPo(Class< BlogCategoryPO> poClass) {
        return BeanMapperUtil.copyProperties(this, poClass);
    }

    /**
     * 将DTO 转换为PO
     * @param po 需要转换的对象
     */
    public void transDtoToPo(BlogCategoryPO po) {
        BeanMapperUtil.copyProperties(this, po, "id");
    }

}