package com.duanxin.lsg.domain.user.service.impl;

import com.duanxin.lsg.domain.user.entity.UserAddressDO;
import com.duanxin.lsg.infrastructure.repository.po.UserAddressPO;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAddressFactory
 * @date 2020/11/15 19:56
 */
@Service
public class UserAddressFactory {

    public UserAddressPO createUserAddressPO(UserAddressDO addressDO) {
        UserAddressPO po = new UserAddressPO();
        po.setId(addressDO.getId());
        po.setName(addressDO.getName());
        po.setUserId(addressDO.getUserId());
        po.setProvince(addressDO.getProvince());
        po.setCity(addressDO.getCity());
        po.setCounty(addressDO.getCounty());
        po.setAddressDetails(addressDO.getAddressDetails());
        po.setPostalCode(addressDO.getPostalCode());
        po.setPhone(addressDO.getPhone());
        po.setAcquiescence(addressDO.getAcquiescence().getCode());
        po.setDeleted(addressDO.getDeleted().getCode());
        po.setCdate(addressDO.getCdate());
        po.setCreator(addressDO.getCreator());
        po.setEdate(addressDO.getEdate());
        po.setEditor(addressDO.getEditor());
        return po;
    }
}
