package com.duanxin.lsg.domain.user.repository.facade;


import com.duanxin.lsg.infrastructure.repository.po.UserAccountPO;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAccountService
 * @date 2020/10/08 20:05
 */
public interface UserAccountRepositoryInterface {
    UserAccountPO insert(UserAccountPO userAccount);

    UserAccountPO selectUserAccountById(Integer userAccountId);

    UserAccountPO selectByUserId(int userId);

    void updateForDeduction(UserAccountPO userAccountPO);
}
