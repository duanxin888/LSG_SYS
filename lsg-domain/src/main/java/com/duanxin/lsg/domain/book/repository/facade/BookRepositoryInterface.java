package com.duanxin.lsg.domain.book.repository.facade;

import com.duanxin.lsg.infrastructure.repository.po.BookPO;

import java.util.Collection;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookService
 * @date 2020/10/12 22:37
 */
public interface BookRepositoryInterface {
    List<BookPO> selectBooksByCategoryId(int firstCategoryId);

    BookPO selectBookById(int bookId);

    List<BookPO> getByBookAuthor(String searchContent);

    List<BookPO> getByBookName(String searchContent);
}
