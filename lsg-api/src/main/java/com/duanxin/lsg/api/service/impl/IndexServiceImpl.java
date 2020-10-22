package com.duanxin.lsg.api.service.impl;

import com.duanxin.lsg.api.module.*;
import com.duanxin.lsg.api.service.IndexService;
import com.duanxin.lsg.common.service.BookCategoryService;
import com.duanxin.lsg.common.service.BookLevelService;
import com.duanxin.lsg.common.service.BookService;
import com.duanxin.lsg.common.service.BookStockService;
import com.duanxin.lsg.core.enums.BookCategoryLevelEnum;
import com.duanxin.lsg.core.exception.LSGCheckException;
import com.duanxin.lsg.core.exception.ResultEnum;
import com.duanxin.lsg.persistent.module.Book;
import com.duanxin.lsg.persistent.module.BookCategory;
import com.duanxin.lsg.persistent.module.BookLevel;
import com.duanxin.lsg.persistent.module.BookStock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className IndexServiceImpl
 * @date 2020/10/12 22:26
 */
@Service
@Slf4j
public class IndexServiceImpl implements IndexService {

    @Autowired
    private BookCategoryService bookCategoryService;
    @Autowired
    private BookService bookService;
    @Autowired
    private BookLevelService bookLevelService;
    @Autowired
    private BookStockService bookStockService;

    @Override
    public IndexResponseDto index() {
        // get categories
        List<BookCategory> bookCategories = bookCategoryService.selectCategoriesByLevel(BookCategoryLevelEnum.LEVEL1.getLevelName());
        List<BookCategoryDto> bookCategoryDtos = categories2Dtos(bookCategories);
        // get first category of books
        int firstCategoryId = bookCategories.stream().
                filter(category -> category.getSorted() == 1).
                findFirst().orElseThrow(() -> new LSGCheckException(ResultEnum.BOOK_CATEGORY_NOT_EXIST)).getId();
        List<Book> books = bookService.selectBooksByCategoryId(firstCategoryId);
        List<BookDto> bookDtos = books2Dtos(books);

        IndexResponseDto response = new IndexResponseDto();
        response.setBooks(bookDtos);
        response.setBookCategories(bookCategoryDtos);
        return response;
    }

    @Override
    public BookInfoResponseDto getBookInfoById(int bookId) {
        Book book = bookService.selectBookById(bookId);
        return BookInfoResponseDto.fetchFromBook(book);
    }

    @Override
    public List<BookDto> getBooksByCategoryId(int categoryId) {
        List<Book> books = bookService.selectBooksByCategoryId(categoryId);
        return books2Dtos(books);
    }

    @Override
    public ShowBookLevelsResponseDto getLevelsByBookId(int bookId) {
        // get level ids
        log.info("begin to get levels by book id [{}]", bookId);
        List<BookLevel> bookLevels = bookLevelService.getLevels();
        List<Integer> levelIds = bookLevels.stream().map(BookLevel::getId).collect(Collectors.toList());
        Map<Integer, BookLevel> levelMap = bookLevels.stream().collect(Collectors.toMap(BookLevel::getId, l -> l));

        // validate stock
        List<BookStock> bookStocks = bookStockService.selectByBookIdAndLevelIds(bookId, levelIds);
        if (CollectionUtils.isEmpty(bookStocks)) {
            log.info("book [{}] stock is empty", bookId);
            return null;
        }
        // fetch response dto
        Book book = bookService.selectBookById(bookId);
        if (Objects.isNull(book)) {
            log.warn("book [{}] info not exist", bookId);
            throw new LSGCheckException(ResultEnum.BOOK_NOT_EXIST);
        }

        ShowBookLevelsResponseDto responseDto = fetchShowBookLevelsResponseDto(book, bookStocks, levelMap);
        log.info("success to get showBookLevelsResponseDto by book id [{}]", bookId);
        return responseDto;
    }

    private ShowBookLevelsResponseDto fetchShowBookLevelsResponseDto(Book book,
                                                                           List<BookStock> bookStocks,
                                                                           Map<Integer, BookLevel> levelMap) {
        ShowBookLevelsResponseDto dto = new ShowBookLevelsResponseDto();
        dto.setBookId(book.getId());
        dto.setBookName(book.getBookName());
        dto.setPicUrl(book.getPicUrl());

        // fetch book levels
        List<BookLevelsDto> bookLevelsDtos = new ArrayList<>(bookStocks.size());
        bookStocks.forEach(stock -> {
            BookLevel bookLevel = levelMap.get(stock.getBookLevelId());

            BookLevelsDto bookLevelsDto = new BookLevelsDto();
            bookLevelsDto.setLevelId(stock.getBookLevelId());
            bookLevelsDto.setLevelName(bookLevel.getLevelName());
            bookLevelsDto.setDetails(bookLevel.getDetails());
            bookLevelsDto.setStock(stock.getStock());
            bookLevelsDto.setPrice(book.getPrice().multiply(bookLevel.getConditionFactor()).setScale(2));
            bookLevelsDtos.add(bookLevelsDto);
        });

        dto.setBookLevelsDtos(bookLevelsDtos);
        return dto;
    }

    private List<BookDto> books2Dtos(List<Book> books) {
        List<BookDto> dtos = new ArrayList<>(books.size());
        books.forEach(book -> {
            BookDto dto = new BookDto();
            BeanUtils.copyProperties(book, dto);
            dtos.add(dto);
        });
        return dtos;
    }

    private List<BookCategoryDto> categories2Dtos(List<BookCategory> bookCategories) {
        List<BookCategoryDto> dtos = new ArrayList<>(bookCategories.size());
        bookCategories.forEach(category -> {
            BookCategoryDto dto = new BookCategoryDto();
            BeanUtils.copyProperties(category, dto);
            dtos.add(dto);
        });
        return dtos;
    }
}
