package com.duanxin.lsg.application.service;

import com.duanxin.lsg.domain.book.entity.BookDO;
import com.duanxin.lsg.domain.book.service.BookDomainService;
import com.duanxin.lsg.infrastructure.common.enums.SearchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className SearchApplicationService
 * @date 2020/11/24 14:28
 */
@Service
public class SearchApplicationService {

    @Autowired
    private BookDomainService bookDomainService;

    public List<BookDO> search(String searchContent, SearchType searchType) {
        if (searchType.equals(SearchType.NAME)) {
            return bookDomainService.getByBookName(searchContent);
        }
        return bookDomainService.getByBookAuthor(searchContent);
    }
}
