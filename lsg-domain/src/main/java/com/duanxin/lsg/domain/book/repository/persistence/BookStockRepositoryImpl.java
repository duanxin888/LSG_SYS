package com.duanxin.lsg.domain.book.repository.persistence;

import com.duanxin.lsg.domain.book.entity.BookStockDO;
import com.duanxin.lsg.domain.book.repository.facade.BookStockRepositoryInterface;
import com.duanxin.lsg.infrastructure.common.exception.LSGCheckException;
import com.duanxin.lsg.infrastructure.common.exception.ResultEnum;
import com.duanxin.lsg.infrastructure.repository.mapper.BookStockMapper;
import com.duanxin.lsg.infrastructure.repository.po.BookStockPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author duanxin
 * @version 1.0
 * @className BookStockServiceImpl
 * @date 2020/10/19 22:03
 */
@Service
@Slf4j
public class BookStockRepositoryImpl implements BookStockRepositoryInterface {

    @Autowired
    private BookStockMapper bookStockMapper;

    @Override
    public List<BookStockPO> selectByBookIdAndLevelIds(int bookId, List<Integer> levelIds) {
        return bookStockMapper.selectByBookIdAndLevelIds(bookId, levelIds);
    }

    @Override
    public BookStockPO selectByBookIdAndLevelId(int bookId, int bookLevelId) {
        BookStockPO bookStockPO = bookStockMapper.selectByBookIdAndLevelId(bookId, bookLevelId);
        if (Objects.isNull(bookStockPO)) {
            throw new LSGCheckException(ResultEnum.BOOK_STOCK_NOT_ENOUGH);
        }
        return bookStockPO;
    }

    @Override
    public List<BookStockPO> selectByBookId(int bookId) {
        return bookStockMapper.selectByBookId(bookId);
    }

    @Override
    public void updateStockAndSale(BookStockPO bookStockPO) {
        bookStockMapper.updateStockAndSale(bookStockPO);
        log.info("success to update level [{}] book [{}] stock [{}] and sale [{}]",
                bookStockPO.getBookLevelId(), bookStockPO.getBookId(), bookStockPO.getStock(), bookStockPO.getSale());
    }
}
