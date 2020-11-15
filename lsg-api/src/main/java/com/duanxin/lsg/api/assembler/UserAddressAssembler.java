package com.duanxin.lsg.api.assembler;

import com.duanxin.lsg.api.dto.UserAddressDto;
import com.duanxin.lsg.domain.user.entity.UserAddressDO;
import com.duanxin.lsg.domain.user.entity.valueobject.AddressAcquiescence;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAddressAssembler
 * @date 2020/11/15 19:40
 */
public class UserAddressAssembler {

    public static UserAddressDO toDO(UserAddressDto dto) {
        UserAddressDO addressDO = new UserAddressDO();
        addressDO.setId(dto.getId());
        addressDO.setUserId(dto.getUserId());
        addressDO.setName(dto.getName());
        addressDO.setProvince(dto.getProvince());
        addressDO.setCity(dto.getCity());
        addressDO.setCounty(dto.getCounty());
        addressDO.setAddressDetails(dto.getAddressDetails());
        addressDO.setPostalCode(dto.getPostalCode());
        addressDO.setPhone(dto.getPhone());
        addressDO.setAcquiescence(AddressAcquiescence.formatByAddressAcquiescenceEnum(dto.getAcquiescence()));
        return addressDO;
    }

    public static UserAddressDto toDto(UserAddressDO addressDO) {
        UserAddressDto dto = new UserAddressDto();
        dto.setId(addressDO.getId());
        dto.setName(addressDO.getName());
        dto.setProvince(addressDO.getProvince());
        dto.setUserId(addressDO.getUserId());
        dto.setCity(addressDO.getCity());
        dto.setCounty(addressDO.getCounty());
        dto.setAddressDetails(addressDO.getAddressDetails());
        dto.setPostalCode(addressDO.getPostalCode());
        dto.setPhone(addressDO.getPhone());
        dto.setAcquiescence(addressDO.getAcquiescence().getAcquiescence());
        return dto;
    }
}
