package com.duanxin.lsg.api.service;

import com.duanxin.lsg.api.module.BookDto;
import com.duanxin.lsg.api.module.BookInfoResponse;
import com.duanxin.lsg.api.module.IndexResponse;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className IndexService
 * @date 2020/10/12 22:25
 */
public interface IndexService {

    IndexResponse index();

    BookInfoResponse getBookInfoById(int bookId);

    List<BookDto> getBooksByCategoryId(int categoryId);
}
