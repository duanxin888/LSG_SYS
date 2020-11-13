package com.duanxin.lsg.domain.user.entity.valueobject;

import com.duanxin.lsg.infrastructure.common.exception.LSGCheckException;
import com.duanxin.lsg.infrastructure.common.exception.ResultEnum;
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
public enum UserStatus {

    AVAILABLE(0, "可用"),
    DISABLE(1, "禁用"),
    LOGOUT(2, "注销");

    private final int code;
    private final String description;

    public static UserStatus format(int code) {
        for (UserStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new LSGCheckException(ResultEnum.USER_STATUS_CODE_NOT_EXIST);
    }
}
