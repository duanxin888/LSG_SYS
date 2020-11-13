package com.duanxin.lsg.domain.user.entity.valueobject;

import com.duanxin.lsg.infrastructure.common.exception.LSGCheckException;
import com.duanxin.lsg.infrastructure.common.exception.ResultEnum;
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
public enum Gender {

    FEMALE(0, "女"),
    MALE(1, "男");

    private final int code;
    private final String description;

    public static Gender format(int code) {
        for (Gender value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new LSGCheckException(ResultEnum.USER_GENDER_CODE_NOT_EXIST);
    }
}
