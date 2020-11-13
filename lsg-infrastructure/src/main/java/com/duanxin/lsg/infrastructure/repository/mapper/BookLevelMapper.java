package com.duanxin.lsg.infrastructure.repository.mapper;

import com.duanxin.lsg.infrastructure.repository.po.BookLevelPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookLevelMapper
 * @date 2020/10/19 21:23
 */
public interface BookLevelMapper {
    BookLevelPO selectById(@Param("id") int id);

    BookLevelPO selectByName(@Param("name") String name);

    List<BookLevelPO> selectAll();
}
