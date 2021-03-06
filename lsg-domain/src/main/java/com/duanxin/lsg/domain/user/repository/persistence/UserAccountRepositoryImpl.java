package com.duanxin.lsg.domain.user.repository.persistence;

import com.duanxin.lsg.domain.user.repository.facade.UserAccountRepositoryInterface;
import com.duanxin.lsg.infrastructure.repository.mapper.UserAccountMapper;
import com.duanxin.lsg.infrastructure.repository.po.UserAccountPO;
import com.duanxin.lsg.infrastructure.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAccountServiceImpl
 * @date 2020/10/08 20:05
 */
@Service
@Slf4j
public class UserAccountRepositoryImpl implements UserAccountRepositoryInterface {

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Override
    public UserAccountPO insert(UserAccountPO userAccount) {
        userAccountMapper.insert(userAccount);
        log.info("success to insert user account [{}]", userAccount.getId());
        return userAccount;
    }

    @Override
    public UserAccountPO selectUserAccountById(Integer userAccountId) {
        return userAccountMapper.selectUserAccountById(userAccountId);
    }

    @Override
    public UserAccountPO selectByUserId(int userId) {
        return userAccountMapper.selectByUserId(userId);
    }

    @Override
    public void updateForDeduction(UserAccountPO userAccountPO) {
        userAccountMapper.updateForDeduction(userAccountPO);
        log.info("success update user account [{}] for deduction", JsonUtil.toString(userAccountPO));
    }
}
