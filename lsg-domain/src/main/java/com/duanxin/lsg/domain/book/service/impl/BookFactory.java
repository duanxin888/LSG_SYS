package com.duanxin.lsg.domain.book.service.impl;

import com.duanxin.lsg.domain.book.entity.BookCategoryDO;
import com.duanxin.lsg.domain.book.entity.BookDO;
import com.duanxin.lsg.domain.book.entity.BookLevelDO;
import com.duanxin.lsg.domain.book.entity.BookStockDO;
import com.duanxin.lsg.domain.book.entity.valueobject.BookCategory;
import com.duanxin.lsg.domain.book.entity.valueobject.BookCategoryLevel;
import com.duanxin.lsg.domain.book.repository.facade.BookLevelRepositoryInterface;
import com.duanxin.lsg.infrastructure.repository.po.BookCategoryPO;
import com.duanxin.lsg.infrastructure.repository.po.BookLevelPO;
import com.duanxin.lsg.infrastructure.repository.po.BookPO;
import com.duanxin.lsg.infrastructure.repository.po.BookStockPO;
import com.duanxin.lsg.infrastructure.common.enums.Deleted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author duanxin
 * @version 1.0
 * @className BookFactory
 * @date 2020/11/08 20:39
 */
@Service
public class BookFactory {

    @Autowired
    private BookLevelRepositoryInterface bookLevelRepository;

    public BookStockDO createBookStockDO(BookStockPO bookStockPO) {
        BookStockDO bookStockDO = new BookStockDO();
        bookStockDO.setId(bookStockPO.getId());
        bookStockDO.setBookId(bookStockPO.getBookId());
        bookStockDO.setBookLevel(createBookLevelDO(bookLevelRepository.getExist(bookStockPO.getBookLevelId())));
        bookStockDO.setStock(bookStockPO.getStock());
        bookStockDO.setSale(bookStockPO.getSale());
        bookStockDO.setCdate(bookStockPO.getCdate());
        bookStockDO.setCreator(bookStockPO.getCreator());
        bookStockDO.setEdate(bookStockPO.getEdate());
        bookStockDO.setEditor(bookStockPO.getEditor());
        return bookStockDO;
    }

    public BookLevelDO createBookLevelDO(BookLevelPO bookLevelPO) {
        BookLevelDO bookLevelDO = new BookLevelDO();
        bookLevelDO.setId(bookLevelPO.getId());
        bookLevelDO.setLevelName(bookLevelPO.getLevelName());
        bookLevelDO.setConditionFactor(bookLevelPO.getConditionFactor());
        bookLevelDO.setDetails(bookLevelPO.getDetails());
        bookLevelDO.setCdate(bookLevelPO.getCdate());
        bookLevelDO.setCreator(bookLevelPO.getCreator());
        bookLevelDO.setEdate(bookLevelPO.getEdate());
        bookLevelDO.setEditor(bookLevelPO.getEditor());
        return bookLevelDO;
    }

    public BookDO createBookDO(BookPO bookPO) {
        BookDO bookDO = new BookDO();
        bookDO.setId(bookPO.getId());
        bookDO.setBookName(bookPO.getBookName());
        bookDO.setAuthor(bookPO.getAuthor());
        bookDO.setBookCategory(BookCategory.builder().id(bookPO.getCategoryId()).build());
        bookDO.setPrice(bookPO.getPrice());
        bookDO.setPicUrl(bookPO.getPicUrl());
        bookDO.setSorted(bookPO.getSorted());
        bookDO.setDetails(bookPO.getDetails());
        bookDO.setDeleted(Deleted.format(bookPO.getDeleted()));
        bookDO.setCdate(bookPO.getCdate());
        bookDO.setCreator(bookPO.getCreator());
        bookDO.setEdate(bookPO.getEdate());
        bookDO.setEditor(bookPO.getEditor());
        bookDO.setBookStockDOS(Collections.emptyList());
        return bookDO;
    }

    public BookCategoryDO createBookCategoryDO(BookCategoryPO bookCategoryPO) {
        BookCategoryDO bookCategoryDO = new BookCategoryDO();
        bookCategoryDO.setId(bookCategoryPO.getId());
        bookCategoryDO.setCategoryName(bookCategoryPO.getCategoryName());
        bookCategoryDO.setPid(bookCategoryPO.getPid());
        bookCategoryDO.setCategoryLevel(BookCategoryLevel.format(bookCategoryPO.getCategoryLevelName()));
        bookCategoryDO.setSorted(bookCategoryPO.getSorted());
        bookCategoryDO.setDeleted(Deleted.format(bookCategoryPO.getDeleted()));
        bookCategoryDO.setCdate(bookCategoryPO.getCdate());
        bookCategoryDO.setCreator(bookCategoryPO.getCreator());
        bookCategoryDO.setEdate(bookCategoryPO.getEdate());
        bookCategoryDO.setEditor(bookCategoryPO.getEditor());
        return bookCategoryDO;
    }

    public BookStockPO createBookStockPO(BookStockDO bookStockDO) {
        BookStockPO po = new BookStockPO();
        po.setId(bookStockDO.getId());
        po.setBookId(bookStockDO.getBookId());
        po.setBookLevelId(bookStockDO.getBookLevel().getId());
        po.setStock(bookStockDO.getStock());
        po.setSale(bookStockDO.getStock());
        po.setCdate(bookStockDO.getCdate());
        po.setCreator(bookStockDO.getCreator());
        po.setEdate(bookStockDO.getEdate());
        po.setEditor(bookStockDO.getEditor());
        return po;
    }
}
