package com.duanxin.lsg.common.service;

import com.duanxin.lsg.persistent.module.UserAccount;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAccountService
 * @date 2020/10/08 20:05
 */
public interface UserAccountService {
    UserAccount insert(UserAccount userAccount);

    UserAccount selectUserAccountById(Integer userAccountId);
}
