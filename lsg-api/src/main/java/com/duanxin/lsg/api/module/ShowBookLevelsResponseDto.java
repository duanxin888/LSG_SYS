package com.duanxin.lsg.api.module;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookLevelsDto
 * @date 2020/10/19 21:08
 */
@Getter
@Setter
public class ShowBookLevelsResponseDto {

    private int bookId;

    private String bookName;

    private String picUrl;

    private List<BookLevelsDto> bookLevelsDtos;
}
