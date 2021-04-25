package com.duanxin.lsg.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className UserInfo
 * @date 2020/10/08 18:37
 */
@Setter
@Getter
public class UserInfo {

    private int userId;

    private String nickName;

    private String avatarUrl;

    private String country;

    private String province;

    private String city;

    private String language;

    private int gender;

    private String accountSn;

    private BigDecimal balance;
}
