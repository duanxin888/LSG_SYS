package com.duanxin.lsg.infrastructure.common.exception;

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
    USER_GENDER_CODE_NOT_EXIST(404, "user gender code not exist"),
    USER_STATUS_CODE_NOT_EXIST(404, "user status code not exist"),
    DELETE_USER_CART_NOT_EXIST(404, "delete user cart not exist"),

    REQUEST_WX_CODE2SESSION_API_FAIL(401, "failed to request wx code2session api"),
    WX_LOGIN_CODE_OR_USERINFO_IS_NULL(402, "wx login code or userinfo is null"),

    BOOK_CATEGORY_NOT_EXIST(404, "book category not exist"),
    BOOK_CATEGORY_IS_EXIST(404, "book category is exist"),
    BOOK_NOT_EXIST(404, "book not exist"),
    BOOK_LEVEL_NOT_EXIST(404, "book level not exist"),
    BOOK_CATEGORY_LEVEL_NAME_NOT_EXIST(404, "book category level name not exist"),
    KIND_OF_BOOK_IS_OUT_OF_STOCK(404, "this kind of book is out of stock"),

    CART_REQUEST_INFO_IS_EMPTY(401, "when add book to cart, cart request info is empty"),

    SHOPPING_CART_BOOK_NAME_IS_BLANK(404, "shopping cart book name is blank"),
    SHOPPING_CART_BOOK_PIC_IS_BLANK(404, "shopping cart book pic is blank"),
    SHOPPING_CART_BOOK_LEVEL_NAME_IS_BLANK(404, "shopping cart book level name is blank"),
    SHOPPING_CART_BOOK_PRICE_IS_EMPTY(404, "shopping cart book price is empty"),

    USER_ADDRESS_ID_IS_NULL(403, "user address id is null"),
    USER_ADDRESS_NAME_IS_BLANK(403, "user address name is blank"),
    USER_ADDRESS_USER_ID_IS_NULL(403, "user address userId is null"),
    USER_ADDRESS_PROVINCE_IS_BLANK(403, "user address province is blank"),
    USER_ADDRESS_CITY_IS_BLANK(403, "user address city is blank"),
    USER_ADDRESS_COUNTY_IS_BLANK(403, "user address county is blank"),
    USER_ADDRESS_ADDRESS_DETAILS_IS_BLANK(403, "user address addressDetails is blank"),
    USER_ADDRESS_PHONE_IS_BLANK(403, "user address phone is blank"),
    USER_ADDRESS_ACQUIESCENCE_IS_NULL(403, "user address acquiescence is null"),
    USER_DEFAULT_ADDRESS_NOT_EXIST(403, "user default address not exist"),

    ORDER_STATUS_NAME_NOT_EXIST(405, "order status name not exist"),
    ORDER_USER_ID_IS_NULL(405, "order userId is null"),
    ORDER_TOTAL_PRICE_IS_NULL(405, "order totalPrice is null"),
    ORDER_DETAILS_IS_EMPTY(405, "order details is empty"),
    ORDER_CONSIGNEE_IS_BLANK(405, "order consignee is blank"),
    ORDER_PHONE_IS_BLANK(405, "order phone is blank"),
    ORDER_ADDRESS_IS_BLANK(405, "order address is blank"),
    ORDER_TOTAL_PRICE_IS_ERROR(405, "order total price is error"),
    BOOK_STOCK_NOT_ENOUGH(405, "book stock not enough"),
    ORDER_SN_IS_BLANK(405, "order sn is blank"),
    ORDER_STATUS_NAME_IS_BLANK(405, "order status name is blank"),
    ORDER_NOT_EXIST(405, "order not exist"),

    RECYCLE_BOOK_ISBN_IS_NOT_RULE(406, "recycle book isbn is not rule"),
    RECYCLE_BOOK_GET_USERINFO_BY_ISBN_ERROR(406, "recycle book get userInfo by isbn error"),
    RECYCLE_BOOK_ISBN_EXISTED_ORDER(406, "recycle book isbn existed order"),
    USER_RECYCLING_ORDER_NOT_EXIST(406, "user recycling order not exist");

    private final int code;
    private final String description;
}
