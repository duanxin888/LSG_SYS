package com.duanxin.lsg.infrastructure.repository.po;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className RecycleOrderDetails
 * @date 2020/11/22 17:40
 */
@Setter
@Getter
public class RecycleOrderDetailsPO {

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

    private int deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
