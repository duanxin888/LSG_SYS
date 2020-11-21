package com.duanxin.lsg.infrastructure.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className VersionEnum
 * @date 2020/10/08 20:16
 */
@Getter
@AllArgsConstructor
public enum VersionEnum {

    ACCOUNT_SN_VERSION("01"),
    ORDER_SN_VERSION("02"),
    PAY_SN_VERSION("03");

    private final String versionId;
}
