package com.duanxin.lsg.api.module;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className BookLevelsDto
 * @date 2020/10/19 21:16
 */
@Setter
@Getter
public class BookLevelsDto {

    private int levelId;

    private String levelName;

    private String details;

    private int stock;

    private BigDecimal price;
}
