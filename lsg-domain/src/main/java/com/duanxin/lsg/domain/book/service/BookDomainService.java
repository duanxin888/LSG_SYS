package com.duanxin.lsg.domain.book.service;

import com.duanxin.lsg.domain.book.entity.BookCategoryDO;
import com.duanxin.lsg.domain.book.entity.BookDO;
import com.duanxin.lsg.domain.book.entity.BookLevelDO;
import com.duanxin.lsg.domain.book.entity.BookStockDO;
import com.duanxin.lsg.domain.book.entity.valueobject.BookLevel;
import com.github.pagehelper.PageInfo;

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

    BookLevelDO getBookLevelById(int levelId);

    void checkStock(BookStockDO bookStockDO);

    void downStock(BookStockDO bookStockDO);

    void upStock(BookStockDO bookStockDO);

    List<BookDO> getByBookAuthor(String searchContent);

    List<BookDO> getByBookName(String searchContent);

    PageInfo<BookDO> pageBookByCid(int cid, int pageNum, int pageSize);
}
