package com.funtl.myshop.commons.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.funtl.myshop.commons.dto.AbstractBaseDomain;
import com.funtl.myshop.commons.utils.RegexpUtils;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Table(name = "tb_user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TbUser extends AbstractBaseDomain {

    /**
     * 用户名
     */
    @NotNull(message = "用户名不可为空")
    @Length(min = 5, max = 20, message = "用户名长度必须介于 5 和 20 之间")
    private String username;

    /**
     * 密码，加密存储
     */
    @JsonIgnore
    private String password;

    /**
     * 注册手机号
     */
    private String phone;

    /**
     * 注册邮箱
     */
    @NotNull(message = "邮箱不可为空")
    @Pattern(regexp = RegexpUtils.EMAIL, message = "邮箱格式不正确")
    private String email;

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码，加密存储
     *
     * @return password - 密码，加密存储
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码，加密存储
     *
     * @param password 密码，加密存储
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取注册手机号
     *
     * @return phone - 注册手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置注册手机号
     *
     * @param phone 注册手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取注册邮箱
     *
     * @return email - 注册邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置注册邮箱
     *
     * @param email 注册邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }
}