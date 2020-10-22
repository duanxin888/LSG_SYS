package com.duanxin.lsg.common.service;

import com.duanxin.lsg.persistent.module.BookLevel;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className BookLevelService
 * @date 2020/10/19 21:30
 */
public interface BookLevelService {

    BookLevel getExist(int id);

    BookLevel getExist(String name);

    List<BookLevel> getLevels();
}
