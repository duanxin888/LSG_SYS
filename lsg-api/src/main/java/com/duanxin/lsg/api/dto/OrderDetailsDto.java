package com.duanxin.lsg.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderDetailsDto
 * @date 2020/11/15 19:23
 */
@Setter
@Getter
public class OrderDetailsDto {

    private int id;

    private int orderId;

    private int bookId;

    private String bookName;

    private String bookPicUrl;

    private String bookLevelName;

    private int quantity;

    private BigDecimal price;
}
