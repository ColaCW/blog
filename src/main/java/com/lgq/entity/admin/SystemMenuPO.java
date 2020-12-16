package com.lgq.entity.admin;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lgq.common.util.MapUtil;
import com.lgq.dto.admin.SystemMenuDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

/**
 *  PO
 *
 * @author liugq
 * @since 2020-10-21
 */
@TableName("t_system_menu")
public class SystemMenuPO extends Model<SystemMenuPO> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId("ID")
    private Long id;

    /**
     * 父ID
     */
    @TableField("PARENT_ID")
    private String parentId;

    /**
     * 名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 链接
     */
    @TableField("HREF")
    private String href;

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
     * 排序
     */
    @TableField("SEQ")
    private Integer seq;

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
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

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
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
        return "SystemMenuPO{" +
               "id=" + id +
               ", parentId=" + parentId +
               ", name=" + name +
               ", href=" + href +
               ", isValid=" + isValid +
               ", remark=" + remark +
               ", seq=" + seq +
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
    protected void transDtoToPo(SystemMenuDTO dto) {
        BeanUtils.copyProperties(this, dto, "id");
    }

    /**
     * PO转map
     */
    public Map<String, Object> toMaps() {
        return MapUtil.beanToMap(this);
    }
}
