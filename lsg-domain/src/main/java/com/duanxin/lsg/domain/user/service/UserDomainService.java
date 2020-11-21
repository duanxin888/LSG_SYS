package com.duanxin.lsg.domain.user.service;

import com.duanxin.lsg.domain.user.entity.UserAccountDO;
import com.duanxin.lsg.domain.user.entity.UserDO;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className UserDomainService
 * @date 2020/11/07 20:32
 */
public interface UserDomainService {

    UserDO getUserByOpenId(String openId);

    void createUser(UserDO userDO, String openid, String sessionKey);

    void updateWXSessionKey(UserDO userDO, String sessionId);

    UserDO getUserById(int userId);

    UserAccountDO getUserAccount(int userId);

    void deduction(int userId, BigDecimal totalPrice);
}
