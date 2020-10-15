package com.duanxin.lsg.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className BookCategoryLevelEnum
 * @date 2020/10/15 20:56
 */
@Getter
@AllArgsConstructor
public enum BookCategoryLevelEnum {

    LEVEL1("L1", "level 1");

    private final String levelName;
    private final String levelDescription;
}
