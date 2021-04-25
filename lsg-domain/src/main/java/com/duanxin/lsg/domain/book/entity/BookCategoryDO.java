package com.duanxin.lsg.domain.book.entity;

import com.duanxin.lsg.domain.book.entity.valueobject.BookCategoryLevel;
import com.duanxin.lsg.infrastructure.common.enums.Constants;
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

    private BookCategoryLevel categoryLevel = BookCategoryLevel.LEVEL1;

    private int sorted;

    private Deleted deleted = Deleted.NOT_DELETE;

    private LocalDateTime cdate = LocalDateTime.now();

    private String creator = Constants.CREATOR;

    private LocalDateTime edate = LocalDateTime.now();

    private String editor = Constants.EDITOR;
}
