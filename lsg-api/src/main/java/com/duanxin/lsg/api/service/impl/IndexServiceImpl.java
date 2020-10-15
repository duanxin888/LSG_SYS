package com.duanxin.lsg.api.service.impl;

import com.duanxin.lsg.api.module.BookCategoryDto;
import com.duanxin.lsg.api.module.BookDto;
import com.duanxin.lsg.api.module.IndexResponse;
import com.duanxin.lsg.api.service.IndexService;
import com.duanxin.lsg.common.service.BookCategoryService;
import com.duanxin.lsg.common.service.BookService;
import com.duanxin.lsg.core.enums.BookCategoryLevelEnum;
import com.duanxin.lsg.core.exception.LSGCheckException;
import com.duanxin.lsg.core.exception.ResultEnum;
import com.duanxin.lsg.persistent.module.Book;
import com.duanxin.lsg.persistent.module.BookCategory;
import com.sun.org.apache.regexp.internal.RE;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className IndexServiceImpl
 * @date 2020/10/12 22:26
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private BookCategoryService bookCategoryService;
    @Autowired
    private BookService bookService;

    @Override
    public IndexResponse index() {
        // get categories
        List<BookCategory> bookCategories = bookCategoryService.selectCategoriesByLevel(BookCategoryLevelEnum.LEVEL1.getLevelName());
        List<BookCategoryDto> bookCategoryDtos = categories2Dtos(bookCategories);
        // get first category of books
        int firstCategoryId = bookCategories.stream().
                filter(category -> category.getSorted() == 1).
                findFirst().orElseThrow(() -> new LSGCheckException(ResultEnum.BOOK_CATEGORY_NOT_EXIST)).getId();
        List<Book> books = bookService.selectBooksByCategoryId(firstCategoryId);
        List<BookDto> bookDtos = books2Dtos(books);

        IndexResponse response = new IndexResponse();
        response.setBooks(bookDtos);
        response.setBookCategories(bookCategoryDtos);
        return response;
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
