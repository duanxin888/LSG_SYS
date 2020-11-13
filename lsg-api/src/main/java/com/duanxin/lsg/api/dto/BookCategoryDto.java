package com.duanxin.lsg.api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className CategoryDto
 * @date 2020/11/08 20:36
 */
@Setter
@Getter
public class BookCategoryDto {

    private int id;

    private String categoryName;

    private int sorted;
}
