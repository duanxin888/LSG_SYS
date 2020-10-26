package com.duanxin.lsg.persistent.module;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className UserShoppingCart
 * @date 2020/10/24 16:48
 */
@Setter
@Getter
public class UserShoppingCart {

    private int id;

    private int userId;

    private int bookId;

    private String bookName;

    private String bookPicUrl;

    private int quantity;

    private String bookLevelName;

    private BigDecimal price;

    private int deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
