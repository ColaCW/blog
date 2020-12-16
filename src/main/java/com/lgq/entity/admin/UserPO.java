package com.lgq.entity.admin;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.lgq.common.util.MapUtil;
import com.lgq.dto.admin.UserDTO;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * 用户 PO
 *
 * @author liugq
 * @since 2020-09-25
 */
@TableName("t_user")
public class UserPO extends Model<UserPO> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId("ID")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    /**
     * 账号名称
     */
    @TableField("USERNAME")
    private String username;

    /**
     * 邮箱
     */
    @TableField("EMAIL")
    private String email;

    /**
     * 电话
     */
    @TableField("PHONE")
    private String phone;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 真实姓名
     */
    @TableField("REALNAME")
    private String realname;

    /**
     * 性别
     */
    @TableField("GENDER")
    private String gender;

    /**
     * 头像
     */
    @TableField("PHOTO")
    private String photo;

    /**
     * 角色ID
     */
    @TableField("ROLE_ID")
    private Long roleId;

    /**
     * 状态
     */
    @TableField("STATUS")
    private Integer status;

    /**
     * 省／市
     */
    @TableField("PROVINCE_ID")
    private Integer provinceId;

    /**
     * 市
     */
    @TableField("CITY_ID")
    private Integer cityId;

    /**
     * 区县
     */
    @TableField("AREA_ID")
    private Integer areaId;

    /**
     * IP地址
     */
    @TableField("IP")
    private String ip;

    /**
     * 浏览器
     */
    @TableField("USERAGENT")
    private String useragent;

    /**
     * 微信OpenID
     */
    @TableField("OPEN_ID")
    private String openId;

    /**
     * 微信UnionID
     */
    @TableField("UNION_ID")
    private String unionId;

    /**
     * 最后登录时间
     */
    @TableField("LOGIN_LAST_AT")
    private LocalDateTime loginLastAt;

    /**
     * 登陆jwt
     */
    @TableField("JWT")
    private String jwt;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUseragent() {
        return useragent;
    }

    public void setUseragent(String useragent) {
        this.useragent = useragent;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public LocalDateTime getLoginLastAt() {
        return loginLastAt;
    }

    public void setLoginLastAt(LocalDateTime loginLastAt) {
        this.loginLastAt = loginLastAt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
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
        return "UserPO{" +
               "id=" + id +
               ", username=" + username +
               ", email=" + email +
               ", phone=" + phone +
               ", password=" + password +
               ", realname=" + realname +
               ", gender=" + gender +
               ", photo=" + photo +
               ", roleId=" + roleId +
               ", status=" + status +
               ", provinceId=" + provinceId +
               ", cityId=" + cityId +
               ", areaId=" + areaId +
               ", ip=" + ip +
               ", useragent=" + useragent +
               ", openId=" + openId +
               ", unionId=" + unionId +
               ", loginLastAt=" + loginLastAt +
               ", jwt=" + jwt +
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
    protected void transDtoToPo(UserDTO dto) {
        BeanUtils.copyProperties(this, dto, "id");
    }

    /**
     * PO转map
     */
    public Map<String, Object> toMaps() {
        return MapUtil.beanToMap(this);
    }
}
