package com.duanxin.lsg.domain.book.entity;

import com.duanxin.lsg.domain.book.entity.valueobject.BookCategoryLevel;
import com.duanxin.lsg.infrastructure.common.enums.Deleted;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className BookCategory
 * @date 2020/10/12 22:28
 */
@Setter
@Getter
public class BookCategoryDO {

    private int id;

    private String categoryName;

    private int pid;

    private BookCategoryLevel categoryLevel;

    private int sorted;

    private Deleted deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
