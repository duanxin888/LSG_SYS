package com.duanxin.lsg.application.service;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.duanxin.lsg.domain.user.entity.UserDO;
import com.duanxin.lsg.domain.user.service.UserDomainService;
import com.duanxin.lsg.infrastructure.client.RedisCacheClient;
import com.duanxin.lsg.infrastructure.client.WxClient;
import com.duanxin.lsg.infrastructure.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.channels.SeekableByteChannel;
import java.time.Duration;
import java.util.Objects;
import java.util.UUID;

/**
 * @author duanxin
 * @version 1.0
 * @className LoginApplicationService
 * @date 2020/11/06 20:38
 */
@Service
@Slf4j
public class LoginApplicationService {

    @Autowired
    private WxClient wxClient;
    @Autowired
    private UserDomainService userDomainService;
    @Autowired
    private RedisCacheClient redisCacheClient;

    public void wxLogin(UserDO userDO, String code) {
        log.info("user [{}] begin to login with wx code [{}]", JsonUtil.toString(userDO), code);
        WxMaJscode2SessionResult sessionInfo = wxClient.getSessionInfo(code);
        UserDO user = userDomainService.getUserByOpenId(sessionInfo.getOpenid());
        if (Objects.isNull(user)) {
            userDomainService.createUser(userDO, sessionInfo.getOpenid(), sessionInfo.getSessionKey());
        } else {
            userDO = user;
            userDomainService.updateWXSessionKey(userDO, sessionInfo.getSessionKey());
        }
        String thirdSession = UUID.randomUUID().toString();
        String value = sessionInfo.getOpenid() + "--" + sessionInfo.getSessionKey();
        redisCacheClient.refreshCache(thirdSession, value, Duration.ofDays(30L));
        userDO.setThirdSession(thirdSession);
        log.info("user [{}] success login with wx code [{}]", JsonUtil.toString(userDO), code);
    }
}
