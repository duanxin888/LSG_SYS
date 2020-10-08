package com.duanxin.lsg.common.service.impl;

import com.duanxin.lsg.common.service.UserAccountService;
import com.duanxin.lsg.core.enums.ConstantEnum;
import com.duanxin.lsg.persistent.mapper.UserAccountMapper;
import com.duanxin.lsg.persistent.module.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAccountServiceImpl
 * @date 2020/10/08 20:05
 */
@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Override
    public UserAccount insert(UserAccount userAccount) {
        userAccount.setCdate(LocalDateTime.now());
        userAccount.setCreator(ConstantEnum.CREATOR.getKey());
        userAccount.setEdate(LocalDateTime.now());
        userAccount.setEditor(ConstantEnum.CREATOR.getKey());
        userAccountMapper.insert(userAccount);
        return userAccount;
    }
}
