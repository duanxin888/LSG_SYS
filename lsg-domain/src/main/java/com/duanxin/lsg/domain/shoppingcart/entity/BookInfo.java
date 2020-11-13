package com.duanxin.lsg.domain.shoppingcart.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className BookInfo
 * @date 2020/11/11 20:29
 */
@Getter
@Setter
@EqualsAndHashCode(exclude = {"bookPicUrl", "quantity", "price"})
public class BookInfo {

    private int bookId;

    private String bookName;

    private String bookPicUrl;

    private int quantity;

    private String bookLevelName;

    private BigDecimal price;
}
