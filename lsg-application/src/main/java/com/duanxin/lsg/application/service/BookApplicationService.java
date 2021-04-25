package com.duanxin.lsg.application.service;

import com.duanxin.lsg.domain.book.entity.BookCategoryDO;
import com.duanxin.lsg.domain.book.entity.BookDO;
import com.duanxin.lsg.domain.book.service.BookDomainService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookApplicationService
 * @date 2020/11/08 20:35
 */
@Service
public class BookApplicationService {

    @Autowired
    private BookDomainService bookDomainService;

    public List<BookCategoryDO> categories() {
        return bookDomainService.categories();
    }

    public List<BookDO> getBooksByCategoryId(int categoryId) {
        return bookDomainService.getBooksByCategoryId(categoryId);
    }

    public BookDO getBookInfoById(int id) {
        return bookDomainService.getBookInfoById(id);
    }

    public BookDO getLevelsByBookId(int bookId) {
        return bookDomainService.getLevelsByBookId(bookId);
    }

    public PageInfo<BookDO> pageBookByCid(int cid, int pageNum, int pageSize) {
        return bookDomainService.pageBookByCid(cid, pageNum, pageSize);
    }

    public void addCategory(BookCategoryDO categoryDO) {
        bookDomainService.addCategory(categoryDO);
    }
}
