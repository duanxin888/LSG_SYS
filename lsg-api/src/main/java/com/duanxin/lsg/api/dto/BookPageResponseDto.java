package com.duanxin.lsg.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookPageResponseDto
 * @date 2021/04/25 10:09
 */
@Setter
@Getter
public class BookPageResponseDto {

    private int pageNum;

    private int pageSize;

    private int pages;

    private List<BookDto> books;
}
