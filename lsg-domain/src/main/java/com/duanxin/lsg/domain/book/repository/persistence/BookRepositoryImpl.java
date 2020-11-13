package com.duanxin.lsg.domain.book.repository.persistence;

import com.duanxin.lsg.domain.book.repository.facade.BookRepositoryInterface;
import com.duanxin.lsg.infrastructure.repository.mapper.BookMapper;
import com.duanxin.lsg.infrastructure.repository.po.BookPO;
import com.duanxin.lsg.infrastructure.common.exception.LSGCheckException;
import com.duanxin.lsg.infrastructure.common.exception.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author duanxin
 * @version 1.0
 * @className BookServiceImpl
 * @date 2020/10/12 22:38
 */
@Service
public class BookRepositoryImpl implements BookRepositoryInterface {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookPO> selectBooksByCategoryId(int firstCategoryId) {
        return bookMapper.selectBooksByCategoryId(firstCategoryId);
    }

    @Override
    public BookPO selectBookById(int bookId) {
        BookPO bookPO = bookMapper.selectBookById(bookId);
        return Optional.ofNullable(bookPO).orElseThrow(() -> new LSGCheckException(ResultEnum.BOOK_NOT_EXIST));
    }
}
