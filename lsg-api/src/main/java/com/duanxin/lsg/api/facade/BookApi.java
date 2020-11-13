package com.duanxin.lsg.api.facade;

import com.duanxin.lsg.api.assembler.BookAssembler;
import com.duanxin.lsg.api.assembler.BookCategoryAssembler;
import com.duanxin.lsg.application.service.BookApplicationService;
import com.duanxin.lsg.domain.book.entity.BookCategoryDO;
import com.duanxin.lsg.domain.book.entity.BookDO;
import com.duanxin.lsg.infrastructure.common.api.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className BookController
 * @date 2020/10/12 22:07
 */
@RestController
@RequestMapping("/api/v1/books")
public class BookApi {

    @Autowired
    private BookApplicationService bookApplicationService;

    @GetMapping("/categories")
    public ResponseResult categories() {
        List<BookCategoryDO> categories = bookApplicationService.categories();
        return ResponseResult.success(categories.stream().map(BookCategoryAssembler::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseResult bookInfo(@PathVariable("id") int bookId) {
        return ResponseResult.success(BookAssembler.toDto(bookApplicationService.getBookInfoById(bookId)));
    }

    @GetMapping("/categories/{id}")
    public ResponseResult booksByCategory(@PathVariable("id") int categoryId) {
        List<BookDO> bookDOS = bookApplicationService.getBooksByCategoryId(categoryId);
        return ResponseResult.success(bookDOS.stream().map(BookAssembler::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/levels/{id}")
    public ResponseResult showBookLevels(@PathVariable("id") int bookId) {
        return ResponseResult.success(BookAssembler.toDto(bookApplicationService.getLevelsByBookId(bookId)));
    }
}
