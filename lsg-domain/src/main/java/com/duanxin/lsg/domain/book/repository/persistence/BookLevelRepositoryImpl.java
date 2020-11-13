package com.duanxin.lsg.domain.book.repository.persistence;

import com.duanxin.lsg.domain.book.repository.facade.BookLevelRepositoryInterface;
import com.duanxin.lsg.infrastructure.repository.mapper.BookLevelMapper;
import com.duanxin.lsg.infrastructure.repository.po.BookLevelPO;
import com.duanxin.lsg.infrastructure.common.exception.LSGCheckException;
import com.duanxin.lsg.infrastructure.common.exception.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author duanxin
 * @version 1.0
 * @className BookLevelServiceImpl
 * @date 2020/10/19 21:30
 */
@Service
@Slf4j
public class BookLevelRepositoryImpl implements BookLevelRepositoryInterface {

    @Autowired
    private BookLevelMapper bookLevelMapper;

    @Override
    @Cacheable(value = "BOOK_LEVEL_CACHE", key = "':id:' + #p0")
    public BookLevelPO getExist(int id) {
        BookLevelPO bookLevel = bookLevelMapper.selectById(id);
        if (Objects.isNull(bookLevel)) {
            log.warn("get bookLevel info by id [{}] not exist", id);
            throw new LSGCheckException(ResultEnum.BOOK_LEVEL_NOT_EXIST);
        }
        return bookLevel;
    }

    @Override
    @Cacheable(value = "BOOK_LEVEL_CACHE", key = "':name:' + #p0")
    public BookLevelPO getExist(String name) {
        BookLevelPO bookLevel = bookLevelMapper.selectByName(name);
        if (Objects.isNull(bookLevel)) {
            log.warn("get bookLevel info by name [{}] not exist", name);
            throw new LSGCheckException(ResultEnum.BOOK_LEVEL_NOT_EXIST);
        }
        return bookLevel;
    }

    @Override
    @Cacheable(value = "BOOK_LEVEL_CACHE", key = "':list'")
    public List<BookLevelPO> getLevels() {
        List<BookLevelPO> bookLevels = bookLevelMapper.selectAll();
        if (CollectionUtils.isEmpty(bookLevels)) {
            log.error("database not exist levels info");
            throw new LSGCheckException(ResultEnum.BOOK_LEVEL_NOT_EXIST);
        }
        return bookLevels;
    }
}
