package com.duanxin.lsg.core.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className ResultEnum
 * @date 2020/09/30 09:10
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {

    USER_NOT_LOG_IN(403, "user not log in"),


    REQUEST_WX_CODE2SESSION_API_FAIL(401, "failed to request wx code2session api"),
    WX_LOGIN_CODE_OR_USERINFO_IS_NULL(402, "wx login code or userinfo is null");

    private final int code;
    private final String description;
}
