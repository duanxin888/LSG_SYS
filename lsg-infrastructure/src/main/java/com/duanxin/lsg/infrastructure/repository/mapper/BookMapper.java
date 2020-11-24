package com.duanxin.lsg.infrastructure.repository.mapper;

import com.duanxin.lsg.infrastructure.repository.po.BookPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookMapper
 * @date 2020/10/12 22:31
 */
public interface BookMapper {
    List<BookPO> selectBooksByCategoryId(@Param("categoryId") int firstCategoryId);

    BookPO selectBookById(@Param("id") int id);

    List<BookPO> getByBookAuthor(@Param("searchContent") String searchContent);

    List<BookPO> getByBookName(@Param("searchContent") String searchContent);
}
