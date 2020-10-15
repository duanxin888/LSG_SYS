package com.duanxin.lsg.common.service;

import com.duanxin.lsg.persistent.module.BookCategory;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookCategoryService
 * @date 2020/10/12 22:37
 */
public interface BookCategoryService {
    List<BookCategory> selectCategoriesByLevel(String levelName);
}
