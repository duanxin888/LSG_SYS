package com.duanxin.lsg.api.module;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className BookCategoryDto
 * @date 2020/10/12 22:40
 */
@Setter
@Getter
public class BookCategoryDto {

    private int id;

    private String categoryName;

    private int sorted;
}
