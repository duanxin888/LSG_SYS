package com.duanxin.lsg.api.dto;

import com.duanxin.lsg.infrastructure.common.enums.AddressAcquiescenceEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAddressDto
 * @date 2020/11/15 19:27
 */
@Setter
@Getter
public class UserAddressDto {

    private Integer id;

    private String name;

    private Integer userId;

    private String province;

    private String city;

    private String county;

    private String addressDetails;

    private String postalCode;

    private String phone;

    private AddressAcquiescenceEnum acquiescence;
}
