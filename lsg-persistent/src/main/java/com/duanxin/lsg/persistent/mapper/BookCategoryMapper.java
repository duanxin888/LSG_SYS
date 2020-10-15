package com.duanxin.lsg.persistent.mapper;

import com.duanxin.lsg.persistent.module.BookCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookCategoryMapper
 * @date 2020/10/12 22:31
 */
public interface BookCategoryMapper {
    List<BookCategory> selectCategoriesByLevel(@Param("levelName") String levelName);
}
