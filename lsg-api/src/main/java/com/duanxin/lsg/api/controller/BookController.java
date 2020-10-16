package com.duanxin.lsg.api.controller;

import com.duanxin.lsg.api.service.IndexService;
import com.duanxin.lsg.core.base.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author duanxin
 * @version 1.0
 * @className BookController
 * @date 2020/10/12 22:07
 */
@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private IndexService indexService;

    @GetMapping("/index")
    public ResponseResult index() {
        return ResponseResult.success(indexService.index());
    }

    @GetMapping("/{id}")
    public ResponseResult bookInfo(@PathVariable("id") int bookId) {
        return ResponseResult.success(indexService.getBookInfoById(bookId));
    }

    @GetMapping("/categories/{id}")
    public ResponseResult booksByCategory(@PathVariable("id") int categoryId) {
        return ResponseResult.success(indexService.getBooksByCategoryId(categoryId));
    }
}
