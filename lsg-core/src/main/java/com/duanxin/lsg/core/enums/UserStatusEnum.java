package com.duanxin.lsg.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className UserStatusEnum
 * @date 2020/10/08 19:49
 */
@Getter
@AllArgsConstructor
public enum UserStatusEnum {

    AVAILABLE(0, "可用"),
    DISABLE(1, "禁用"),
    LOGOUT(2, "注销");

    private final int code;
    private final String description;
}
