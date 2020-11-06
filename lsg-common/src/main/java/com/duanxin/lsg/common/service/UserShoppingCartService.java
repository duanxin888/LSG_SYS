package com.duanxin.lsg.common.service;

import com.duanxin.lsg.common.module.CartRequestInfo;
import com.duanxin.lsg.persistent.module.UserShoppingCart;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className UserShoppingCartService
 * @date 2020/10/24 16:54
 */
public interface UserShoppingCartService {

    List<UserShoppingCart> selectCartsByUserId(int userId);

    UserShoppingCart insert(UserShoppingCart cart);

    void updateCartQuantity(int bookId, int quantity, int userId, String levelName);
}
