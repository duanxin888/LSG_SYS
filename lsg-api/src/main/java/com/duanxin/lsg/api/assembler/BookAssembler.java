package com.duanxin.lsg.api.assembler;

import com.duanxin.lsg.api.dto.BookDto;
import com.duanxin.lsg.api.dto.BookPageResponseDto;
import com.duanxin.lsg.domain.book.entity.BookDO;
import com.github.pagehelper.PageInfo;

import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className BookAssembler
 * @date 2020/11/08 21:10
 */
public class BookAssembler {

    public static BookDto toDto(BookDO bookDO) {
        BookDto dto = new BookDto();
        dto.setId(bookDO.getId());
        dto.setBookName(bookDO.getBookName());
        dto.setAuthor(bookDO.getAuthor());
        dto.setCategoryId(bookDO.getBookCategory().getId());
        dto.setPrice(bookDO.getPrice());
        dto.setPicUrl(bookDO.getPicUrl());
        dto.setDetails(bookDO.getDetails());
        dto.setSorted(bookDO.getSorted());
        dto.setBookStocks(bookDO.getBookStockDOS().stream().map(bookStock ->
                BookStockAssembler.toDto(bookStock, bookDO.getPrice())).collect(Collectors.toList()));
        return dto;
    }

    public static BookPageResponseDto do2PageResponseDto(PageInfo<BookDO> pageInfo) {
        BookPageResponseDto dto = new BookPageResponseDto();
        dto.setPageNum(pageInfo.getPageNum());
        dto.setPageSize(pageInfo.getPageSize());
        dto.setPages(pageInfo.getPages());
        dto.setBooks(pageInfo.getList().stream().map(BookAssembler::toDto).collect(Collectors.toList()));
        return dto;
    }
}
