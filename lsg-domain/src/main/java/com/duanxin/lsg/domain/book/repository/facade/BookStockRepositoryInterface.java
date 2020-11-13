package com.duanxin.lsg.domain.book.repository.facade;


import com.duanxin.lsg.infrastructure.repository.po.BookStockPO;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookStockService
 * @date 2020/10/19 22:03
 */
public interface BookStockRepositoryInterface {
    List<BookStockPO> selectByBookIdAndLevelIds(int bookId, List<Integer> levelIds);

    List<BookStockPO> selectByBookIdAndLevelId(int bookId, int bookLevelId);

    List<BookStockPO> selectByBookId(int bookId);
}
