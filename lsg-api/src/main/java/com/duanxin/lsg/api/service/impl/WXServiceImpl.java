package com.duanxin.lsg.api.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.duanxin.lsg.api.module.UserInfo;
import com.duanxin.lsg.api.module.WXLoginRequest;
import com.duanxin.lsg.api.module.WXLoginResponse;
import com.duanxin.lsg.api.service.WXService;
import com.duanxin.lsg.common.service.CacheService;
import com.duanxin.lsg.common.service.UserAccountService;
import com.duanxin.lsg.common.service.UserService;
import com.duanxin.lsg.core.enums.*;
import com.duanxin.lsg.core.exception.LSGBaseException;
import com.duanxin.lsg.core.exception.ResultEnum;
import com.duanxin.lsg.persistent.module.User;
import com.duanxin.lsg.persistent.module.UserAccount;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * @author duanxin
 * @version 1.0
 * @className UserServiceImpl
 * @date 2020/10/06 08:44
 */
@Service
@Slf4j
public class WXServiceImpl implements WXService {

    @Autowired
    private UserService userService;
    @Autowired
    private WxMaService wxMaService;
    @Autowired
    private CacheService cacheService;
    @Autowired
    private UserAccountService userAccountService;

    @Override
    public WXLoginResponse login(WXLoginRequest request) {
        String code = request.getCode();
        UserInfo userInfo = request.getUserInfo();
        // validate
        if (StringUtils.isBlank(code) || Objects.isNull(userInfo)) {
            log.warn("failed to login with non code or userInfo is null");
            throw new LSGBaseException(ResultEnum.WX_LOGIN_CODE_OR_USERINFO_IS_NULL);
        }

        log.info("login with wx code [{}]", code);
        // request wx client, get openid and sessionKey
        WxMaJscode2SessionResult code2SessionResponse = null;
        try {
            code2SessionResponse = wxMaService.getUserService().getSessionInfo(code);
        } catch (WxErrorException e) {
            log.warn("request wx code [{}] to session exception", code, e);
            throw new LSGBaseException(ResultEnum.REQUEST_WX_CODE2SESSION_API_FAIL);
        }

        if (StringUtils.isBlank(code2SessionResponse.getOpenid()) ||
                StringUtils.isBlank(code2SessionResponse.getSessionKey())) {
            log.warn("request wx code [{}] to session with openid is null or sessionKey is null", code);
            throw new LSGBaseException(ResultEnum.REQUEST_WX_CODE2SESSION_API_FAIL);
        }

        // get user by openid
        User user = userService.getUserByOpenId(code2SessionResponse.getOpenid());
        if (Objects.isNull(user)) {
            // user is not exist, create user
            user = createUser(code2SessionResponse, userInfo);
        } else {
            // update user
            user = updateUser(code2SessionResponse, user);
        }

        // storage redis
        String thirdSession = UUID.randomUUID().toString();
        String value = code2SessionResponse.getOpenid() + "--" + code2SessionResponse.getSessionKey();
        cacheService.refreshCache(thirdSession, value, Duration.ofDays(30L));

        WXLoginResponse response = new WXLoginResponse();
        response.setThirdSession(thirdSession);
        response.setUserInfo(request.getUserInfo());
        return response;
    }

    private User updateUser(WxMaJscode2SessionResult code2SessionResponse, User user) {
        user.setWxSessionKey(code2SessionResponse.getSessionKey());
        return userService.updateWXSessionKey(user);
    }

    private User createUser(WxMaJscode2SessionResult code2SessionResponse, UserInfo userInfo) {
        User user = new User();
        String openId = code2SessionResponse.getOpenid();
        user.setUserName(openId);
        user.setUserImgUrl(userInfo.getAvatarUrl());
        UserAccount account = createAccount();
        user.setUserAccountId(account.getId());
        user.setNickname(userInfo.getNickName());
        user.setWxOpenid(code2SessionResponse.getOpenid());
        user.setWxSessionKey(code2SessionResponse.getSessionKey());
        user.setStatus(UserStatusEnum.AVAILABLE.getCode());
        user.setDeleted(DeletedEnum.NOT_DELETE.getCode());
        return userService.insert(user);
    }

    private UserAccount createAccount() {
        UserAccount userAccount = new UserAccount();
        userAccount.setAccountSn(generateAccountSn());
        userAccount.setBalance(BigDecimal.ZERO);
        userAccount.setDeleted(DeletedEnum.NOT_DELETE.getCode());
        return userAccountService.insert(userAccount);
    }

    /**
     * account sn: 账户编号标识(2位) + 年月日时分秒(16位) + 版本号(2位)
     * */
    private String generateAccountSn() {
        LocalDateTime now = LocalDateTime.now();
        NumberFormat format = NumberFormat.getInstance();
        return new StringBuilder(SerialNumberEnum.ACCOUNT_SN.getSn()).
                append(numberFormat(format, 4, now.getYear())).
                append(numberFormat(format, 2, now.getMonthValue())).
                append(numberFormat(format, 2, now.getDayOfMonth())).
                append(numberFormat(format, 2, now.getHour())).
                append(numberFormat(format, 2, now.getMinute())).
                append(numberFormat(format, 2, now.getSecond())).
                append(VersionEnum.ACCOUNT_SN_VERSION.getVersionId()).
                toString();
    }

    private String numberFormat(NumberFormat format, int size, int num) {
        format.setGroupingUsed(false);
        format.setMinimumIntegerDigits(size);
        format.setMaximumIntegerDigits(size);
        return format.format(num);
    }
}
