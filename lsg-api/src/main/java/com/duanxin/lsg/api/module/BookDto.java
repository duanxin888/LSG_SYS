package com.duanxin.lsg.api.module;
import	java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className BookDto
 * @date 2020/10/12 22:41
 */
@Getter
@Setter
public class BookDto {

    private int id;

    private String bookName;

    private String author;

    private int categoryId;

    private BigDecimal price;

    private String picUrl;

    private String details;

    private int sorted;
}
