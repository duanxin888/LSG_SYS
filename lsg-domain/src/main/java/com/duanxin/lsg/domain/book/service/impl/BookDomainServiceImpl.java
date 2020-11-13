package com.duanxin.lsg.domain.book.service.impl;

import com.duanxin.lsg.domain.book.entity.BookCategoryDO;
import com.duanxin.lsg.domain.book.entity.BookDO;
import com.duanxin.lsg.domain.book.entity.valueobject.BookCategoryLevel;
import com.duanxin.lsg.domain.book.repository.facade.BookCategoryRepositoryInterface;
import com.duanxin.lsg.domain.book.repository.facade.BookRepositoryInterface;
import com.duanxin.lsg.domain.book.repository.facade.BookStockRepositoryInterface;
import com.duanxin.lsg.infrastructure.repository.po.BookCategoryPO;
import com.duanxin.lsg.infrastructure.repository.po.BookPO;
import com.duanxin.lsg.infrastructure.repository.po.BookStockPO;
import com.duanxin.lsg.domain.book.service.BookDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className BookDomainServiceImpl
 * @date 2020/11/08 20:38
 */
@Service
public class BookDomainServiceImpl implements BookDomainService {

    @Autowired
    private BookCategoryRepositoryInterface bookCategoryRepository;
    @Autowired
    private BookRepositoryInterface bookRepository;
    @Autowired
    private BookStockRepositoryInterface bookStockRepository;
    @Autowired
    private BookFactory bookFactory;

    @Override
    public List<BookCategoryDO> categories() {
        List<BookCategoryPO> bookCategoryPOS =
                bookCategoryRepository.selectCategoriesByLevel(BookCategoryLevel.LEVEL1.getLevelName());
        return bookCategoryPOS.stream().map(bookFactory::createBookCategoryDO).collect(Collectors.toList());
    }

    @Override
    public List<BookDO> getBooksByCategoryId(int categoryId) {
        List<BookPO> bookPOS = bookRepository.selectBooksByCategoryId(categoryId);
        return bookPOS.stream().map(bookFactory::createBookDO).collect(Collectors.toList());
    }

    @Override
    public BookDO getBookInfoById(int id) {
        BookPO bookPO = bookRepository.selectBookById(id);
        return bookFactory.createBookDO(bookPO);
    }

    @Override
    public BookDO getLevelsByBookId(int bookId) {
        BookPO bookPO = bookRepository.selectBookById(bookId);
        BookDO bookDO = bookFactory.createBookDO(bookPO);
        // fetch stock info
        List<BookStockPO> bookStockPOS = bookStockRepository.selectByBookId(bookId);
        bookDO.addBookStock(bookStockPOS.stream().map(bookFactory::createBookStockDO).collect(Collectors.toList()));
        return bookDO;
    }
}
