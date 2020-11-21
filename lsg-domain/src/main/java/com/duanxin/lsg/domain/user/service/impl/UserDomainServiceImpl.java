package com.duanxin.lsg.domain.user.service.impl;

import com.duanxin.lsg.domain.user.entity.UserAccountDO;
import com.duanxin.lsg.domain.user.entity.UserDO;
import com.duanxin.lsg.domain.user.repository.facade.UserAccountRepositoryInterface;
import com.duanxin.lsg.domain.user.repository.facade.UserRepositoryInterface;
import com.duanxin.lsg.domain.user.service.UserDomainService;
import com.duanxin.lsg.infrastructure.repository.po.UserAccountPO;
import com.duanxin.lsg.infrastructure.repository.po.UserOrderPO;
import com.duanxin.lsg.infrastructure.repository.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className UserDomainServiceImpl
 * @date 2020/11/07 20:32
 */
@Service
public class UserDomainServiceImpl implements UserDomainService {

    @Autowired
    private UserRepositoryInterface userRepositoryInterface;
    @Autowired
    private UserAccountRepositoryInterface userAccountRepository;
    @Autowired
    private UserFactory userFactory;

    @Override
    public UserDO getUserByOpenId(String openId) {
        UserPO userPO = userRepositoryInterface.getUserByOpenId(openId);
        return userFactory.createUserDO(userPO);
    }

    @Override
    public void createUser(UserDO userDO, String openid, String sessionKey) {
        UserAccountDO userAccountDO = new UserAccountDO();
        userAccountDO.create();
        UserAccountPO userAccountPO = userAccountRepository.insert(userFactory.createUserAccountPO(userAccountDO));
        userAccountDO.setId(userAccountPO.getId());

        userDO.create(userAccountDO, openid, sessionKey);
        UserPO userPO = userRepositoryInterface.insert(userFactory.createUserPO(userDO));
        userDO.setId(userPO.getId());
    }

    @Override
    public void updateWXSessionKey(UserDO userDO, String sessionId) {
        userDO.setWxSessionKey(sessionId);
        userRepositoryInterface.updateWXSessionKey(userFactory.createUserPO(userDO));
    }

    @Override
    public UserDO getUserById(int userId) {
        return userFactory.createUserDO(userRepositoryInterface.selectByPrimaryId(userId));
    }

    @Override
    public UserAccountDO getUserAccount(int userId) {
        return userFactory.createUserAccountDO(userAccountRepository.selectByUserId(userId));
    }

    @Override
    public void deduction(int userId, BigDecimal totalPrice) {
        UserAccountDO accountDO = userFactory.createUserAccountDO(userAccountRepository.selectByUserId(userId));
        accountDO.deduction(totalPrice);
        userAccountRepository.updateForDeduction(userFactory.createUserAccountPO(accountDO));
    }
}
