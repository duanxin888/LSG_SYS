package com.duanxin.lsg.domain.shoppingcart.repository.facade;


import com.duanxin.lsg.infrastructure.repository.po.UserShoppingCartPO;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className UserShoppingCartService
 * @date 2020/10/24 16:54
 */
public interface UserShoppingCartRepositoryInterface {

    List<UserShoppingCartPO> selectCartsByUserId(int userId);

    UserShoppingCartPO insert(UserShoppingCartPO cart);

    void updateCartQuantity(UserShoppingCartPO userShoppingCartPO);

    UserShoppingCartPO selectByUserIdAndBookIdAndLevelId(int userId, int bookId, String bookLevelName);
}
