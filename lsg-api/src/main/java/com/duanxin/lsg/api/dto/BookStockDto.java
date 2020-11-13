package com.duanxin.lsg.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className BookStockDto
 * @date 2020/11/11 20:00
 */
@Setter
@Getter
public class BookStockDto {

    private int id;

    private int bookId;

    private String bookLevelName;

    private int bookLevelId;

    private int stock;

    private BigDecimal price;
}
