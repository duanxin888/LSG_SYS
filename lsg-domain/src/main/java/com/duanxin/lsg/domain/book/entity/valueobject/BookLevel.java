package com.duanxin.lsg.domain.book.entity.valueobject;

import com.duanxin.lsg.infrastructure.common.exception.LSGCheckException;
import com.duanxin.lsg.infrastructure.common.exception.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className BookLevel
 * @date 2020/11/17 17:14
 */
@AllArgsConstructor
@Getter
public enum BookLevel {

    BRAND_NEW(1, "全新", BigDecimal.valueOf(0.90)),
    EXCELLENT(2, "优良", BigDecimal.valueOf(0.60)),
    ORDINARY(3, "普通", BigDecimal.valueOf(0.20)),
    UNQUALIFIED(4, "不合格", BigDecimal.valueOf(0.00));

    private final int id;
    private final String levelName;
    private final BigDecimal conditionFactor;

    public static BookLevel getById(int id) {
        for (BookLevel value : values()) {
            if (value.id == id) {
                return value;
            }
        }
        throw new LSGCheckException(ResultEnum.BOOK_LEVEL_NOT_EXIST);
    }

    public static BookLevel getByName(String name) {
        for (BookLevel value : values()) {
            if (value.levelName.equals(name)) {
                return value;
            }
        }
        throw new LSGCheckException(ResultEnum.BOOK_LEVEL_NOT_EXIST);
    }
}
