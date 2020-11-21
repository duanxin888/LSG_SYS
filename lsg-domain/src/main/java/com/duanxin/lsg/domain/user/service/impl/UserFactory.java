package com.duanxin.lsg.domain.user.service.impl;

import com.duanxin.lsg.domain.user.entity.UserAccountDO;
import com.duanxin.lsg.domain.user.entity.UserDO;
import com.duanxin.lsg.domain.user.entity.valueobject.Gender;
import com.duanxin.lsg.domain.user.entity.valueobject.UserStatus;
import com.duanxin.lsg.domain.user.repository.facade.UserAccountRepositoryInterface;
import com.duanxin.lsg.infrastructure.common.enums.Deleted;
import com.duanxin.lsg.infrastructure.repository.po.UserAccountPO;
import com.duanxin.lsg.infrastructure.repository.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className UserFactory
 * @date 2020/11/07 20:33
 */
@Service
public class UserFactory {

    @Autowired
    private UserAccountRepositoryInterface userAccountRepository;

    public UserDO createUserDO(UserPO userPO) {
        UserDO userDO = new UserDO();
        userDO.setId(userPO.getId());
        userDO.setUserName(userPO.getNickname());
        userDO.setPassword(userPO.getPassword());
        userDO.setPhone(userPO.getPhone());
        userDO.setUserImgUrl(userPO.getUserImgUrl());
        userDO.setUserAccount(createUserAccountDO(userAccountRepository.selectUserAccountById(userPO.getUserAccountId())));
        userDO.setNickname(userPO.getNickname());
        userDO.setWxOpenid(userPO.getWxOpenid());
        userDO.setWxSessionKey(userPO.getWxSessionKey());
        userDO.setStatus(UserStatus.format(userPO.getStatus()));
        userDO.setGender(Gender.format(userPO.getGender()));
        userDO.setCdate(userPO.getCdate());
        userDO.setCreator(userPO.getCreator());
        userDO.setEdate(userPO.getEdate());
        userDO.setEditor(userPO.getEditor());
        return userDO;
    }

    public UserAccountDO createUserAccountDO(UserAccountPO userAccountPO) {
        UserAccountDO userAccountDO = new UserAccountDO();
        userAccountDO.setId(userAccountPO.getId());
        userAccountDO.setAccountSn(userAccountPO.getAccountSn());
        userAccountDO.setBalance(userAccountPO.getBalance());
        userAccountDO.setDeleted(Deleted.format(userAccountPO.getDeleted()));
        return userAccountDO;
    }

    public UserPO createUserPO(UserDO userDO) {
        UserPO userPO = new UserPO();
        userPO.setId(userDO.getId());
        userPO.setUserName(userDO.getUserName());
        userPO.setPassword(userDO.getPassword());
        userPO.setPhone(userDO.getPhone());
        userPO.setUserImgUrl(userDO.getUserImgUrl());
        userPO.setUserAccountId(userDO.getUserAccount().getId());
        userPO.setNickname(userDO.getNickname());
        userPO.setWxOpenid(userDO.getWxOpenid());
        userPO.setWxSessionKey(userDO.getWxSessionKey());
        userPO.setStatus(userDO.getStatus().getCode());
        userPO.setGender(userDO.getGender().getCode());
        userPO.setCdate(userDO.getCdate());
        userPO.setCreator(userDO.getCreator());
        userPO.setEdate(userDO.getEdate());
        userPO.setEditor(userDO.getEditor());
        return userPO;
    }

    public UserAccountPO createUserAccountPO(UserAccountDO userAccountDO) {
        UserAccountPO userAccountPO = new UserAccountPO();
        userAccountPO.setId(userAccountDO.getId());
        userAccountPO.setAccountSn(userAccountDO.getAccountSn());
        userAccountPO.setBalance(userAccountDO.getBalance());
        userAccountPO.setDeleted(userAccountDO.getDeleted().getCode());
        userAccountPO.setCdate(userAccountDO.getCdate());
        userAccountPO.setCreator(userAccountDO.getCreator());
        userAccountPO.setEdate(userAccountDO.getEdate());
        userAccountPO.setEditor(userAccountDO.getEditor());
        return userAccountPO;
    }
}
