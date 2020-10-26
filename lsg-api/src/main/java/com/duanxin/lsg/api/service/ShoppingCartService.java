package com.duanxin.lsg.api.service;

import com.duanxin.lsg.api.module.AddBook2CartRequestDto;

/**
 * @author duanxin
 * @version 1.0
 * @className ShoppingCartService
 * @date 2020/10/24 16:55
 */
public interface ShoppingCartService {

    void addBook2Cart(AddBook2CartRequestDto request);
}
