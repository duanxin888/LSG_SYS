package com.duanxin.lsg.api.controller;

import com.duanxin.lsg.api.module.AddBook2CartRequestDto;
import com.duanxin.lsg.api.service.ShoppingCartService;
import com.duanxin.lsg.core.base.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author duanxin
 * @version 1.0
 * @className CartController
 * @date 2020/10/24 16:32
 */
@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping
    public ResponseResult addBookToCart(@RequestBody AddBook2CartRequestDto request) {
        shoppingCartService.addBook2Cart(request);
        return ResponseResult.success();
    }
}
