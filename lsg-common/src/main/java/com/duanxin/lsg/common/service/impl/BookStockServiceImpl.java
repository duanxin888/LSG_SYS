package com.duanxin.lsg.common.service.impl;

import com.duanxin.lsg.common.service.BookStockService;
import com.duanxin.lsg.persistent.mapper.BookStockMapper;
import com.duanxin.lsg.persistent.module.BookStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookStockServiceImpl
 * @date 2020/10/19 22:03
 */
@Service
public class BookStockServiceImpl implements BookStockService {

    @Autowired
    private BookStockMapper bookStockMapper;

    @Override
    public List<BookStock> selectByBookIdAndLevelIds(int bookId, List<Integer> levelIds) {
        return bookStockMapper.selectByBookIdAndLevelIds(bookId, levelIds);
    }

    @Override
    public List<BookStock> selectByBookIdAndLevelId(int bookId, int bookLevelId) {
        return bookStockMapper.selectByBookIdAndLevelId(bookId, bookLevelId);
    }
}
