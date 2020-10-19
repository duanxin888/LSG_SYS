package com.duanxin.lsg.api.module;

import com.duanxin.lsg.core.exception.LSGCheckException;
import com.duanxin.lsg.core.exception.ResultEnum;
import com.duanxin.lsg.persistent.module.Book;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author: Chris Zhang
 * @create: 2020-10-16
 */
@Setter
@Getter
public class BookInfoResponseDto {

    private int id;

    private String bookName;

    private BigDecimal price;

    private String picUrl;

    private String details;

    public static BookInfoResponseDto fetchFromBook(Book book) {
        if (Objects.isNull(book)) {
            throw new LSGCheckException(ResultEnum.BOOK_NOT_EXIST);
        }
        BookInfoResponseDto response = new BookInfoResponseDto();
        response.setId(book.getId());
        response.setBookName(book.getBookName());
        response.setPrice(book.getPrice());
        response.setPicUrl(book.getPicUrl());
        response.setDetails(book.getDetails());
        return response;
    }
}
