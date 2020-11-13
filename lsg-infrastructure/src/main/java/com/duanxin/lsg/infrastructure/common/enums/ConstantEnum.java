package com.duanxin.lsg.infrastructure.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className ConstantEnum
 * @date 2020/10/08 16:25
 */
@Getter
@AllArgsConstructor
public enum ConstantEnum {

    CACHE_SEP("::"),
    CACHE_DEFAULT_KEY("DEFAULT_KEY"),
    CREATOR("SYSTEM");

    private final String key;
}
