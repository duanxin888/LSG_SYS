package com.duanxin.lsg.persistent.module;

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
public class BookCategory {

    private int id;

    private String categoryName;

    private int pid;

    private String categoryLevelName;

    private int sorted;

    private int deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
