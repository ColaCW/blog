package com.lgq.dto.admin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lgq.common.util.BeanMapperUtil;
import com.lgq.entity.admin.UserPO;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户 DTO
 *
 * @author liugq
 * @since 2020-09-25T14:38:38.496
 */
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 用户ID
     */
    private Long id;

    /**
     * 账号名称
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 性别
     */
    private String gender;

    /**
     * 头像
     */
    private String photo;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 省／市
     */
    private Integer provinceId;

    /**
     * 市
     */
    private Integer cityId;

    /**
     * 区县
     */
    private Integer areaId;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 浏览器
     */
    private String useragent;

    /**
     * 微信OpenID
     */
    private String openId;

    /**
     * 微信UnionID
     */
    private String unionId;

    /**
     * 最后登录时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime loginLastAt;

    /**
     * 登陆jwt
     */
    private String jwt;

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
    public String toString() {
    return "UserDTO{" +
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
    *  将DTO 转换为PO
    * @param poClass
    */
    public UserPO transDtoToPo(Class< UserPO> poClass) {
        return BeanMapperUtil.copyProperties(this, poClass);
    }

    /**
     * 将DTO 转换为PO
     * @param po 需要转换的对象
     */
    public void transDtoToPo(UserPO po) {
        BeanMapperUtil.copyProperties(this, po, "id");
    }

}