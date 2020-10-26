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
    USER_NOT_EXIST(401, "user not exist"),

    REQUEST_WX_CODE2SESSION_API_FAIL(401, "failed to request wx code2session api"),
    WX_LOGIN_CODE_OR_USERINFO_IS_NULL(402, "wx login code or userinfo is null"),

    BOOK_CATEGORY_NOT_EXIST(404, "book category not exist"),
    BOOK_NOT_EXIST(404, "book not exist"),
    BOOK_LEVEL_NOT_EXIST(404, "book level not exist"),
    KIND_OF_BOOK_IS_OUT_OF_STOCK(404, "this kind of book is out of stock"),

    CART_REQUEST_INFO_IS_EMPTY(401, "when add book to cart, cart request info is empty");

    private final int code;
    private final String description;
}
