package com.duanxin.lsg.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className WXLoginResponse
 * @date 2020/10/06 08:49
 */
@Setter
@Getter
public class WXLoginResponseDto {

    private String thirdSession;

    private UserInfo userInfo;

    private BigDecimal userBalance;
}
