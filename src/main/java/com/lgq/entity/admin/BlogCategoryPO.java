package com.lgq.entity.admin;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lgq.common.util.MapUtil;
import com.lgq.dto.admin.BlogCategoryDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * 博客分类 PO
 *
 * @author liugq
 * @since 2020-09-24
 */
@TableName("t_blog_category")
public class BlogCategoryPO extends Model<BlogCategoryPO> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId("ID")
    private Long id;

    /**
     * 分类名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 是否有效
     */
    @TableField("IS_VALID")
    private Integer isValid;

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
    private Integer isDeleted;

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
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "BlogCategoryPO{" +
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
     * 将PO信息转化为DTO
     */
    protected void transDtoToPo(BlogCategoryDTO dto) {
        BeanUtils.copyProperties(this, dto, "id");
    }

    /**
     * PO转map
     */
    public Map<String, Object> toMaps() {
        return MapUtil.beanToMap(this);
    }
}
