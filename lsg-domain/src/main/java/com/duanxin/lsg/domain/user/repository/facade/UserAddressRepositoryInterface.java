package com.duanxin.lsg.domain.user.repository.facade;

import com.duanxin.lsg.infrastructure.repository.po.UserAddressPO;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAddressRepositoryInterface
 * @date 2020/11/15 19:36
 */
public interface UserAddressRepositoryInterface {
    UserAddressPO insert(UserAddressPO userAddressPO);

    UserAddressPO getDefaultUserAddress(int userId);
}
