package com.duanxin.lsg.api.module;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className IndexResponse
 * @date 2020/10/12 22:27
 */
@Setter
@Getter
public class IndexResponseDto {

    private List<BookCategoryDto> bookCategories;

    private List<BookDto> books;
}
