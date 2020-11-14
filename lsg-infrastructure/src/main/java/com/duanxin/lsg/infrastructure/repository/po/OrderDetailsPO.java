package com.duanxin.lsg.infrastructure.repository.po;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderDetails
 * @date 2020/11/14 21:00
 */
@Setter
@Getter
public class OrderDetailsPO {

    private int id;

    private int orderId;

    private int bookId;

    private String bookName;

    private String bookPicUrl;

    private int bookLevelId;

    private int quantity;

    private BigDecimal price;

    private int deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
