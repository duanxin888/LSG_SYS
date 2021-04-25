package com.duanxin.lsg.domain.book.repository.facade;

import com.duanxin.lsg.infrastructure.repository.po.BookCategoryPO;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookCategoryService
 * @date 2020/10/12 22:37
 */
public interface BookCategoryRepositoryInterface {
    List<BookCategoryPO> selectCategoriesByLevel(String levelName);

    void insert(BookCategoryPO bookCategoryPO);

    BookCategoryPO selectByName(String categoryName);
}
