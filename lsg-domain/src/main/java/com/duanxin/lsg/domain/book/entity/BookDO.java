package com.duanxin.lsg.domain.book.entity;

import com.duanxin.lsg.domain.book.entity.valueobject.BookCategory;
import com.duanxin.lsg.infrastructure.common.enums.Deleted;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookDO
 * @date 2020/11/08 20:12
 */
@Setter
@Getter
public class BookDO {

    private int id;

    private String bookName;

    private String author;

    private BookCategory bookCategory;

    private BigDecimal price;

    private String picUrl;

    private String details;

    private int sorted;

    private Deleted deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;

    private List<BookStockDO> bookStockDOS;

    public BookDO addBookStock(List<BookStockDO> bookStockDOS) {
        this.setBookStockDOS(bookStockDOS);
        return this;
    }
}
