package com.duanxin.lsg.persistent.mapper;

import com.duanxin.lsg.persistent.module.BookLevel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookLevelMapper
 * @date 2020/10/19 21:23
 */
public interface BookLevelMapper {
    BookLevel selectById(@Param("id") int id);

    BookLevel selectByName(@Param("name") String name);

    List<BookLevel> selectAll();
}
