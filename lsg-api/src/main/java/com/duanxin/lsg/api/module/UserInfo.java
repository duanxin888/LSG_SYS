package com.duanxin.lsg.api.module;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className UserInfo
 * @date 2020/10/08 18:37
 */
@Setter
@Getter
public class UserInfo {

    private String nickName;

    private String avatarUrl;

    private String country;

    private String province;

    private String city;

    private String language;

    private int gender;
}
