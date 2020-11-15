package com.duanxin.lsg.application.service;

import com.duanxin.lsg.domain.user.entity.UserAddressDO;
import com.duanxin.lsg.domain.user.service.UserAddressDomainService;
import com.duanxin.lsg.domain.user.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className UserApplicationService
 * @date 2020/11/15 19:40
 */
@Service
public class UserApplicationService {

    @Autowired
    private UserAddressDomainService userAddressDomainService;
    @Autowired
    private UserDomainService userDomainService;

    public void addAddress(UserAddressDO addressDO) {
        userDomainService.getUserById(addressDO.getUserId());
        userAddressDomainService.addAddress(addressDO);
    }

    public UserAddressDO getDefaultUserAddress(int userId) {
        userDomainService.getUserById(userId);
        return userAddressDomainService.getDefaultUserAddress(userId);
    }
}
