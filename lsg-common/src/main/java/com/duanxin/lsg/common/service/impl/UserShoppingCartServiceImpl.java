package com.duanxin.lsg.common.service.impl;

import com.duanxin.lsg.common.module.CartRequestInfo;
import com.duanxin.lsg.common.service.UserShoppingCartService;
import com.duanxin.lsg.common.utils.JsonUtil;
import com.duanxin.lsg.persistent.mapper.UserShoppingCartMapper;
import com.duanxin.lsg.persistent.module.UserShoppingCart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className UserShoppingCartServiceImpl
 * @date 2020/10/24 16:55
 */
@Service
@Slf4j
public class UserShoppingCartServiceImpl implements UserShoppingCartService {

    @Autowired
    private UserShoppingCartMapper userShoppingCartMapper;

    @Override
    public List<UserShoppingCart> selectCartsByUserId(int userId) {
        return userShoppingCartMapper.selectCartsByUserId(userId);
    }

    @Override
    public UserShoppingCart insert(UserShoppingCart cart) {
        userShoppingCartMapper.insert(cart);
        log.info("success to insert user cart [{}]", JsonUtil.toString(cart));
        return cart;
    }

    @Override
    public void updateCartQuantity(int bookId, int quantity, int userId, String levelName) {
        userShoppingCartMapper.updateCartQuantity(userId, bookId, levelName, quantity);
        log.info("success to update user [{}] book [{}] level [{}] quantity [{}]",
                userId, bookId, levelName, quantity);
    }
}
