package com.duanxin.lsg.infrastructure.client;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;

/**
 * @author duanxin
 * @version 1.0
 * @className WxClient
 * @date 2020/11/06 21:11
 */
public interface WxClient {

    WxMaJscode2SessionResult getSessionInfo(String code);
}
