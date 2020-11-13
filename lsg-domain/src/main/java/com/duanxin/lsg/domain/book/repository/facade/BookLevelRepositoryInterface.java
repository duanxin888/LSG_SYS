package com.duanxin.lsg.domain.book.repository.facade;

import com.duanxin.lsg.infrastructure.repository.po.BookLevelPO;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookLevelService
 * @date 2020/10/19 21:30
 */
public interface BookLevelRepositoryInterface {

    BookLevelPO getExist(int id);

    BookLevelPO getExist(String name);

    List<BookLevelPO> getLevels();
}
