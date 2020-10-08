package com.duanxin.lsg.api.service;

import com.duanxin.lsg.api.module.WXLoginRequest;
import com.duanxin.lsg.api.module.WXLoginResponse;

/**
 * @author duanxin
 * @version 1.0
 * @className UserService
 * @date 2020/10/06 08:44
 */
public interface WXService {

    WXLoginResponse login(WXLoginRequest request);
}
