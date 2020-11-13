package com.duanxin.lsg.api.dto;

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
public class WXLoginRequestDto {

    private String code;

    private UserInfo userInfo;
}
