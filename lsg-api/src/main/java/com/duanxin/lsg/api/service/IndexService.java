package com.duanxin.lsg.api.service;

import com.duanxin.lsg.api.module.BookDto;
import com.duanxin.lsg.api.module.BookInfoResponseDto;
import com.duanxin.lsg.api.module.ShowBookLevelsResponseDto;
import com.duanxin.lsg.api.module.IndexResponseDto;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className IndexService
 * @date 2020/10/12 22:25
 */
public interface IndexService {

    IndexResponseDto index();

    BookInfoResponseDto getBookInfoById(int bookId);

    List<BookDto> getBooksByCategoryId(int categoryId);

    ShowBookLevelsResponseDto getLevelsByBookId(int bookId);
}
