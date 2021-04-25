package com.duanxin.lsg.domain.book.repository.persistence;

import com.duanxin.lsg.domain.book.repository.facade.BookCategoryRepositoryInterface;
import com.duanxin.lsg.infrastructure.repository.mapper.BookCategoryMapper;
import com.duanxin.lsg.infrastructure.repository.po.BookCategoryPO;
import com.duanxin.lsg.infrastructure.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookCategoryServiceImpl
 * @date 2020/10/12 22:37
 */
@Service
@Slf4j
public class BookCategoryRepositoryImpl implements BookCategoryRepositoryInterface {

    @Autowired
    private BookCategoryMapper bookCategoryMapper;

    @Override
    public List<BookCategoryPO> selectCategoriesByLevel(String levelName) {
        return bookCategoryMapper.selectCategoriesByLevel(levelName);
    }

    @Override
    public void insert(BookCategoryPO bookCategoryPO) {
        bookCategoryMapper.insert(bookCategoryPO);
        log.info("success to insert bookCategory [{}]", JsonUtil.toString(bookCategoryPO));
    }

    @Override
    public BookCategoryPO selectByName(String categoryName) {
        return bookCategoryMapper.selectByName(categoryName);
    }
}
