package com.duanxin.lsg.domain.book.repository.persistence;

import com.duanxin.lsg.domain.book.repository.facade.BookCategoryRepositoryInterface;
import com.duanxin.lsg.infrastructure.repository.mapper.BookCategoryMapper;
import com.duanxin.lsg.infrastructure.repository.po.BookCategoryPO;
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
public class BookCategoryRepositoryImpl implements BookCategoryRepositoryInterface {

    @Autowired
    private BookCategoryMapper bookCategoryMapper;

    @Override
    public List<BookCategoryPO> selectCategoriesByLevel(String levelName) {
        return bookCategoryMapper.selectCategoriesByLevel(levelName);
    }
}
