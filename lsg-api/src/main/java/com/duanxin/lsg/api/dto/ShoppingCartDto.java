package com.duanxin.lsg.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className ShoppingCartDto
 * @date 2020/11/11 20:34
 */
@Setter
@Getter
public class ShoppingCartDto {

    private int userId;

    private int bookId;

    private String bookName;

    private String bookPicUrl;

    private String bookLevelName;

    private BigDecimal price;

    private int quantity;
}
