package com.duanxin.lsg.application.service;

import com.duanxin.lsg.domain.user.entity.UserAccountDO;
import com.duanxin.lsg.domain.user.entity.UserAddressDO;
import com.duanxin.lsg.domain.user.service.UserAddressDomainService;
import com.duanxin.lsg.domain.user.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        checkUserExist(addressDO.getUserId());
        userAddressDomainService.addAddress(addressDO);
    }

    public UserAddressDO getDefaultUserAddress(int userId) {
        checkUserExist(userId);
        return userAddressDomainService.getDefaultUserAddress(userId);
    }

    public List<UserAddressDO> getUserAddressList(int userId) {
        checkUserExist(userId);
        return userAddressDomainService.getUserAddressList(userId);
    }

    public void updateDefaultUserAddress(UserAddressDO addressDO) {
        checkUserExist(addressDO.getUserId());
        userAddressDomainService.updateDefaultUserAddress(addressDO);
    }

    public UserAccountDO getUserAccount(int userId) {
        checkUserExist(userId);
        return userDomainService.getUserAccount(userId);
    }

    private void checkUserExist(int id) {
        userDomainService.getUserById(id);
    }
}
