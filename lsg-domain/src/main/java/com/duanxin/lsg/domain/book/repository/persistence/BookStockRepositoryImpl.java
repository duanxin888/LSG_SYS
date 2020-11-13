package com.duanxin.lsg.domain.book.repository.persistence;

import com.duanxin.lsg.domain.book.repository.facade.BookStockRepositoryInterface;
import com.duanxin.lsg.infrastructure.repository.mapper.BookStockMapper;
import com.duanxin.lsg.infrastructure.repository.po.BookStockPO;
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
public class BookStockRepositoryImpl implements BookStockRepositoryInterface {

    @Autowired
    private BookStockMapper bookStockMapper;

    @Override
    public List<BookStockPO> selectByBookIdAndLevelIds(int bookId, List<Integer> levelIds) {
        return bookStockMapper.selectByBookIdAndLevelIds(bookId, levelIds);
    }

    @Override
    public List<BookStockPO> selectByBookIdAndLevelId(int bookId, int bookLevelId) {
        return bookStockMapper.selectByBookIdAndLevelId(bookId, bookLevelId);
    }

    @Override
    public List<BookStockPO> selectByBookId(int bookId) {
        return bookStockMapper.selectByBookId(bookId);
    }
}
