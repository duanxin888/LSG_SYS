package com.duanxin.lsg.domain.user.service.impl;

import com.duanxin.lsg.domain.user.entity.UserAddressDO;
import com.duanxin.lsg.domain.user.entity.valueobject.AddressAcquiescence;
import com.duanxin.lsg.infrastructure.common.enums.Deleted;
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

    public UserAddressDO createUserAddressDO(UserAddressPO po) {
        UserAddressDO addressDO = new UserAddressDO();
        addressDO.setName(po.getName());
        addressDO.setUserId(po.getUserId());
        addressDO.setProvince(po.getProvince());
        addressDO.setId(po.getId());
        addressDO.setCity(po.getCity());
        addressDO.setCounty(po.getCounty());
        addressDO.setAddressDetails(po.getAddressDetails());
        addressDO.setPostalCode(po.getPostalCode());
        addressDO.setPhone(po.getPhone());
        addressDO.setAcquiescence(AddressAcquiescence.formatByCode(po.getAcquiescence()));
        addressDO.setDeleted(Deleted.format(po.getDeleted()));
        addressDO.setCdate(po.getCdate());
        addressDO.setCreator(po.getCreator());
        addressDO.setEdate(po.getEdate());
        addressDO.setEditor(po.getEditor());
        return addressDO;
    }
}
