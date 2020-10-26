package com.duanxin.lsg.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;

/**
 * @author duanxin
 * @version 1.0
 * @className CacheTypeEnum
 * @date 2020/10/08 09:05
 */
@Getter
@AllArgsConstructor
public enum CacheTypeEnum {

    DEFAULT("DEFAULT", Duration.ofDays(1L)),
    BOOK_LEVEL_CACHE("BOOK_LEVEL_CACHE", Duration.ofDays(15L)),
    SHOPPING_CART_CACHE("SHOPPING_CART_CACHE", Duration.ofDays(1L));

    private final String prefix;
    private final Duration ttl;
}
