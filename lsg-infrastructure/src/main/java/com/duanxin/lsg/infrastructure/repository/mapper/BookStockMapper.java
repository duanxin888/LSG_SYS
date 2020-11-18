package com.duanxin.lsg.infrastructure.repository.mapper;

import com.duanxin.lsg.infrastructure.repository.po.BookStockPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookStockMapper
 * @date 2020/10/19 21:27
 */
public interface BookStockMapper {
    List<BookStockPO> selectByBookIdAndLevelIds(@Param("bookId") int bookId,
                                                @Param("levelIds") List<Integer> levelIds);

    BookStockPO selectByBookIdAndLevelId(@Param("bookId") int bookId,
                                             @Param("bookLevelId") int bookLevelId);

    List<BookStockPO> selectByBookId(@Param("bookId") int bookId);

    void updateStockAndSale(@Param("bookStockPO") BookStockPO bookStockPO);
}
