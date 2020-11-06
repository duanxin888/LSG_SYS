package com.duanxin.lsg.api.module;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className UserCartsResponseInfo
 * @date 2020/10/29 11:12
 */
@Setter
@Getter
@EqualsAndHashCode(exclude = "quantity")
public class UserCartsResponseInfo {

    private int bookId;

    private String bookName;

    private String bookPicUrl;

    private String bookLevelName;

    private BigDecimal price;

    private int quantity;
}
