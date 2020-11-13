package com.duanxin.lsg.domain.book.service;

import com.duanxin.lsg.domain.book.entity.BookCategoryDO;
import com.duanxin.lsg.domain.book.entity.BookDO;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookDomainService
 * @date 2020/11/08 20:38
 */
public interface BookDomainService {

    List<BookCategoryDO> categories();

    List<BookDO> getBooksByCategoryId(int categoryId);

    BookDO getBookInfoById(int id);

    BookDO getLevelsByBookId(int bookId);
}
