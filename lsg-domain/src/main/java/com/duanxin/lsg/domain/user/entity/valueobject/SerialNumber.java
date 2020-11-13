package com.duanxin.lsg.domain.user.entity.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className SerialNumberEnum
 * @date 2020/10/08 20:13
 */
@Getter
@AllArgsConstructor
public enum SerialNumber {

    ACCOUNT_SN("01", "订单编号标识");

    private final String sn;
    private final String description;
}
