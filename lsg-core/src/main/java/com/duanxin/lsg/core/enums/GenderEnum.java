package com.duanxin.lsg.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className GenderEnum
 * @date 2020/10/11 21:36
 */
@AllArgsConstructor
@Getter
public enum GenderEnum {

    FEMALE(0, "女"),
    MALE(1, "男");

    private final int code;
    private final String description;
}
