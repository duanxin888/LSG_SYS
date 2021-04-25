package com.duanxin.lsg.infrastructure.repository.mapper;

import com.duanxin.lsg.infrastructure.repository.po.BookCategoryPO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookCategoryMapper
 * @date 2020/10/12 22:31
 */
public interface BookCategoryMapper {
    List<BookCategoryPO> selectCategoriesByLevel(@Param("levelName") String levelName);

    void insert(@Param("po") BookCategoryPO po);

    BookCategoryPO selectByName(@Param("categoryName") String categoryName);

    BookCategoryPO selectById(@Param("id") int id);

    void update4Delete(@Param("id") int id,
                       @Param("deleted") int deleted,
                       @Param("edate") LocalDateTime edate);
}
