package com.duanxin.lsg.domain.user.service.impl;

import com.duanxin.lsg.domain.user.entity.UserAddressDO;
import com.duanxin.lsg.domain.user.entity.valueobject.AddressAcquiescence;
import com.duanxin.lsg.domain.user.repository.facade.UserAddressRepositoryInterface;
import com.duanxin.lsg.domain.user.service.UserAddressDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAddressDomainServiceImpl
 * @date 2020/11/15 19:53
 */
@Service
@Slf4j
public class UserAddressDomainServiceImpl implements UserAddressDomainService {

    @Autowired
    private UserAddressRepositoryInterface userAddressRepository;
    @Autowired
    private UserAddressFactory userAddressFactory;

    @Override
    public void addAddress(UserAddressDO addressDO) {
        addressDO.create();
        userAddressRepository.insert(userAddressFactory.createUserAddressPO(addressDO));
    }

    @Override
    public UserAddressDO getDefaultUserAddress(int userId) {
        return userAddressFactory.createUserAddressDO(userAddressRepository.getDefaultUserAddress(userId));
    }

    @Override
    public List<UserAddressDO> getUserAddressList(int userId) {
        return userAddressRepository.getUserAddressList(userId).stream().
                map(userAddressFactory::createUserAddressDO).collect(Collectors.toList());
    }

    @Override
    public void updateDefaultUserAddress(UserAddressDO addressDO) {
        userAddressRepository.updateUserAddressAcquiescence(userAddressRepository.getDefaultUserAddress(addressDO.getUserId()).getId(),
                AddressAcquiescence.NOT_ACQUIESCENCE);
        userAddressRepository.updateUserAddressAcquiescence(addressDO.getId(),
                AddressAcquiescence.IS_ACQUIESCENCE);
    }
}
