package com.duanxin.lsg.common.service;

import com.duanxin.lsg.persistent.module.BookStock;

import java.util.Collection;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookStockService
 * @date 2020/10/19 22:03
 */
public interface BookStockService {
    List<BookStock> selectByBookIdAndLevelIds(int bookId, List<Integer> levelIds);

    List<BookStock> selectByBookIdAndLevelId(int bookId, int bookLevelId);
}
