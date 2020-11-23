package com.duanxin.lsg.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className RecycleOrderDetailsDto
 * @date 2020/11/23 19:44
 */
@Setter
@Getter
public class RecycleOrderDetailsDto {

    private int id;

    private int recycleOrderId;

    private String bookName;

    private String bookAuthor;

    private String bookPic;

    private String bookDetails;

    private BigDecimal bookPrice;

    private String bookISBN10;

    private String bookISBN13;

    private int bookLevelId;
}
