package com.duanxin.lsg.persistent.mapper;

import com.duanxin.lsg.persistent.module.BookStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookStockMapper
 * @date 2020/10/19 21:27
 */
public interface BookStockMapper {
    List<BookStock> selectByBookIdAndLevelIds(@Param("bookId") int bookId,
                                              @Param("levelIds") List<Integer> levelIds);
}
