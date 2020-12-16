package com.lgq.dto.admin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lgq.common.util.BeanMapperUtil;
import com.lgq.entity.admin.SystemMenuPO;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *  DTO
 *
 * @author liugq
 * @since 2020-10-21T10:29:33.457
 */
public class SystemMenuDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * ID
     */
    private Long id;

    /**
     * 父ID
     */
    private String parentId;

    /**
     * 名称
     */
    private String name;

    /**
     * 链接
     */
    private String href;

    /**
     * 是否有效
     */
    private Integer isValid;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序
     */
    private Integer seq;

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
    public String toString() {
    return "SystemMenuDTO{" +
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
    *  将DTO 转换为PO
    * @param poClass
    */
    public SystemMenuPO transDtoToPo(Class< SystemMenuPO> poClass) {
        return BeanMapperUtil.copyProperties(this, poClass);
    }

    /**
     * 将DTO 转换为PO
     * @param po 需要转换的对象
     */
    public void transDtoToPo(SystemMenuPO po) {
        BeanMapperUtil.copyProperties(this, po, "id");
    }

}