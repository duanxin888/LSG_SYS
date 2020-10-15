package com.duanxin.lsg.common.service;

import com.duanxin.lsg.persistent.module.Book;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookService
 * @date 2020/10/12 22:37
 */
public interface BookService {
    List<Book> selectBooksByCategoryId(int firstCategoryId);
}
