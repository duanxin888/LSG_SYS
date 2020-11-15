package com.duanxin.lsg.domain.user.repository.persistence;

import com.duanxin.lsg.domain.user.entity.valueobject.AddressAcquiescence;
import com.duanxin.lsg.domain.user.repository.facade.UserAddressRepositoryInterface;
import com.duanxin.lsg.infrastructure.common.exception.LSGCheckException;
import com.duanxin.lsg.infrastructure.common.exception.ResultEnum;
import com.duanxin.lsg.infrastructure.repository.mapper.UserAddressMapper;
import com.duanxin.lsg.infrastructure.repository.po.UserAddressPO;
import com.duanxin.lsg.infrastructure.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAddressRepositoryImpl
 * @date 2020/11/15 19:36
 */
@Service
@Slf4j
public class UserAddressRepositoryImpl implements UserAddressRepositoryInterface {

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public UserAddressPO insert(UserAddressPO userAddressPO) {
        userAddressMapper.insert(userAddressPO);
        log.info("success to add user [{}] address [{}]", userAddressPO.getUserId(), JsonUtil.toString(userAddressPO));
        return userAddressPO;
    }

    @Override
    public UserAddressPO getDefaultUserAddress(int userId) {
        UserAddressPO addressPO = userAddressMapper.selectDefaultUserAddress(userId);
        if (Objects.isNull(addressPO)) {
            throw new LSGCheckException(ResultEnum.USER_DEFAULT_ADDRESS_NOT_EXIST);
        }
        return addressPO;
    }

    @Override
    public List<UserAddressPO> getUserAddressList(int userId) {
        return userAddressMapper.selectUserAddressList(userId);
    }

    @Override
    public void updateUserAddressAcquiescence(int id, AddressAcquiescence acquiescence) {
        userAddressMapper.updateUserAddressAcquiescence(id, acquiescence.getCode());
        log.info("success to update user [{}] default address to acquiescence [{}]", id, acquiescence);
    }
}
