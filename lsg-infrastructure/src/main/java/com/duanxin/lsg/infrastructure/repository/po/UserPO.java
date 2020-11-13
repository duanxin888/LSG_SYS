package com.duanxin.lsg.infrastructure.repository.po;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户表(TUser)实体类
 *
 * @author makejava
 * @since 2020-10-03 09:35:43
 */
@Setter
@Getter
public class UserPO implements Serializable {
    private static final long serialVersionUID = 593028399177778384L;
    /**
     * 用户主键ID
     */
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户手机号
     */
    private String phone;
    /**
     * 用户头像
     */
    private String userImgUrl;
    /**
     * 用户账户ID
     */
    private Integer userAccountId;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 微信登陆openid
     */
    private String wxOpenid;
    /**
     * 微信登陆会话key
     */
    private String wxSessionKey;
    /**
     * 用户状态，0可用，1禁用，2注销
     */
    private Integer status;
    /**
     * 逻辑删除，0不删除，1逻辑删除
     */
    private Integer deleted;
    /**
     * 创建时间
     */
    private LocalDateTime cdate;
    /**
     * 创建者
     */
    private String creator;
    /**
     * 更新时间
     */
    private LocalDateTime edate;
    /**
     * 更新者
     */
    private String editor;

    private int gender;
}