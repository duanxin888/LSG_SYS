package com.duanxin.lsg.common.service.impl;

import com.duanxin.lsg.common.service.BookCategoryService;
import com.duanxin.lsg.persistent.mapper.BookCategoryMapper;
import com.duanxin.lsg.persistent.module.BookCategory;
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
public class BookCategoryServiceImpl implements BookCategoryService {

    @Autowired
    private BookCategoryMapper bookCategoryMapper;

    @Override
    public List<BookCategory> selectCategoriesByLevel(String levelName) {
        return bookCategoryMapper.selectCategoriesByLevel(levelName);
    }
}
