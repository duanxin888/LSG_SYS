package com.duanxin.lsg.api.module;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className WXLoginRequest
 * @date 2020/10/06 08:48
 */
@Setter
@Getter
public class WXLoginRequest {

    private String code;

    private UserInfo userInfo;
}
