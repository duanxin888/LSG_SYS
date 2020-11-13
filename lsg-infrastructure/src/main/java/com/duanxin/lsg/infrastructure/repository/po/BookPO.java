package com.duanxin.lsg.infrastructure.repository.po;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className Book
 * @date 2020/10/12 22:29
 */
@Getter
@Setter
public class BookPO {

    private int id;

    private String bookName;

    private String author;

    private int categoryId;

    private BigDecimal price;

    private String picUrl;

    private String details;

    private int sorted;

    private int deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
