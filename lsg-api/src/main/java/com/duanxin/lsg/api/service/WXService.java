package com.duanxin.lsg.api.service;

import com.duanxin.lsg.api.module.WXLoginRequestDto;
import com.duanxin.lsg.api.module.WXLoginResponseDto;

/**
 * @author duanxin
 * @version 1.0
 * @className UserService
 * @date 2020/10/06 08:44
 */
public interface WXService {

    WXLoginResponseDto login(WXLoginRequestDto request);
}
