package com.duanxin.lsg.domain.recycleOrder.entity.valueobject;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className RecycleBookInfo
 * @date 2020/11/22 20:43
 */
@Setter
@Getter
public class RecycleBookInfo {

    private String bookName;

    private String bookAuthor;

    private String bookPic;

    private String bookDetails;

    private BigDecimal bookPrice;

    private String bookISBN10;

    private String bookISBN13;
}
