package com.duanxin.lsg.api.assembler;

import com.duanxin.lsg.api.dto.BookStockDto;
import com.duanxin.lsg.domain.book.entity.BookLevelDO;
import com.duanxin.lsg.domain.book.entity.BookStockDO;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className BookStockAssembler
 * @date 2020/11/11 20:01
 */
public class BookStockAssembler {

    public static BookStockDto toDto(BookStockDO bookStockDO, BigDecimal bookPrice) {
        BookStockDto dto = new BookStockDto();
        dto.setId(bookStockDO.getId());
        dto.setBookId(bookStockDO.getBookId());
        BookLevelDO bookLevel = bookStockDO.getBookLevel();
        dto.setBookLevelId(bookLevel.getId());
        dto.setBookLevelName(bookLevel.getLevelName());
        dto.setPrice(bookPrice.multiply(bookLevel.getConditionFactor()));
        dto.setStock(bookStockDO.getStock());
        return dto;
    }
}
