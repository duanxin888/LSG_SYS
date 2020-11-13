package com.duanxin.lsg.infrastructure.client.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.duanxin.lsg.infrastructure.client.WxClient;
import com.duanxin.lsg.infrastructure.common.exception.LSGCheckException;
import com.duanxin.lsg.infrastructure.common.exception.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className WxClientImpl
 * @date 2020/11/06 21:12
 */
@Service
@Slf4j
public class WxClientImpl implements WxClient {

    @Autowired
    private WxMaService wxMaService;

    @Override
    public WxMaJscode2SessionResult getSessionInfo(String code) {
        WxMaJscode2SessionResult code2SessionResponse = null;
        try {
            log.info("begin to get session info by code [{}]", code);
            code2SessionResponse = wxMaService.getUserService().getSessionInfo(code);
        } catch (WxErrorException e) {
            log.warn("request wx code [{}] to session exception", code, e);
            throw new LSGCheckException(ResultEnum.REQUEST_WX_CODE2SESSION_API_FAIL);
        }

        if (StringUtils.isBlank(code2SessionResponse.getOpenid()) ||
                StringUtils.isBlank(code2SessionResponse.getSessionKey())) {
            log.warn("request wx code [{}] to session with openid is null or sessionKey is null", code);
            throw new LSGCheckException(ResultEnum.REQUEST_WX_CODE2SESSION_API_FAIL);
        }
        log.info("success get session info by code [{}]", code);
        return code2SessionResponse;
    }
}
