package com.duanxin.lsg.common.service.impl;

import com.duanxin.lsg.common.service.BookService;
import com.duanxin.lsg.persistent.mapper.BookMapper;
import com.duanxin.lsg.persistent.module.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookServiceImpl
 * @date 2020/10/12 22:38
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> selectBooksByCategoryId(int firstCategoryId) {
        return bookMapper.selectBooksByCategoryId(firstCategoryId);
    }

    @Override
    public Book selectBookById(int bookId) {
        return bookMapper.selectBookById(bookId);
    }
}
