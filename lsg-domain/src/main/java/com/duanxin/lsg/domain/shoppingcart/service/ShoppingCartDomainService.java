package com.duanxin.lsg.domain.shoppingcart.service;

import com.duanxin.lsg.domain.shoppingcart.entity.UserShoppingCartDO;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className ShoppingCartDomainService
 * @date 2020/11/11 20:30
 */
public interface ShoppingCartDomainService {
    List<UserShoppingCartDO> getCartsByUserId(int userId);

    void updateUserCarts(UserShoppingCartDO shoppingCartDO);
}
