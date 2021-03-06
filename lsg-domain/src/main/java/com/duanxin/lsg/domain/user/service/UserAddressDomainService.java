package com.duanxin.lsg.domain.user.service;

import com.duanxin.lsg.domain.user.entity.UserAddressDO;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAddressDomainService
 * @date 2020/11/15 19:52
 */
public interface UserAddressDomainService {

    void addAddress(UserAddressDO addressDO);

    UserAddressDO getDefaultUserAddress(int userId);

    List<UserAddressDO> getUserAddressList(int userId);

    void updateDefaultUserAddress(UserAddressDO addressDO);
}
