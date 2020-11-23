package com.duanxin.lsg.infrastructure.client;

import com.duanxin.lsg.infrastructure.client.entity.AlISBNResult;

import java.util.Optional;

/**
 * @author duanxin
 * @version 1.0
 * @className isbnClient
 * @date 2020/11/22 21:44
 */
public interface ISBNClient {

    Optional<AlISBNResult> getBookInfo(String isbn);
}
