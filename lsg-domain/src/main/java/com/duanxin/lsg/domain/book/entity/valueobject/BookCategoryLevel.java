package com.duanxin.lsg.domain.book.entity.valueobject;

import com.duanxin.lsg.infrastructure.common.exception.LSGCheckException;
import com.duanxin.lsg.infrastructure.common.exception.ResultEnum;
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
public enum BookCategoryLevel {

    LEVEL1("L1", "level 1");

    private final String levelName;
    private final String levelDescription;

    public static BookCategoryLevel format(String levelName) {
        for (BookCategoryLevel value : values()) {
            if (value.levelName.equalsIgnoreCase(levelName)) {
                return value;
            }
        }
        throw new LSGCheckException(ResultEnum.BOOK_CATEGORY_LEVEL_NAME_NOT_EXIST);
    }
}
