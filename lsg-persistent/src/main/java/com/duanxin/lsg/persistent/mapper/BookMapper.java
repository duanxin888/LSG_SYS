package com.duanxin.lsg.persistent.mapper;

import com.duanxin.lsg.persistent.module.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookMapper
 * @date 2020/10/12 22:31
 */
public interface BookMapper {
    List<Book> selectBooksByCategoryId(@Param("categoryId") int firstCategoryId);
}
