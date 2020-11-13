package com.duanxin.lsg.domain.book.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className BookLevel
 * @date 2020/10/19 21:21
 */
@Getter
@Setter
public class BookLevelDO {

    private int id;

    private String levelName;

    private BigDecimal conditionFactor;

    private String details;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
