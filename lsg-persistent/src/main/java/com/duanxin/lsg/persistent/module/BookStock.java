package com.duanxin.lsg.persistent.module;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className BookStock
 * @date 2020/10/19 21:26
 */
@Setter
@Getter
public class BookStock {

    private int id;

    private int bookId;

    private int bookLevelId;

    private int stock;

    private int sale;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
