package com.duanxin.lsg.api.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @NotBlank(message = "categoryName not null")
    private String categoryName;

    private Integer sorted = 0;
}
