package com.duanxin.lsg.application.service;

import com.duanxin.lsg.domain.shoppingcart.entity.BookInfo;
import com.duanxin.lsg.domain.shoppingcart.entity.UserShoppingCartDO;
import com.duanxin.lsg.domain.shoppingcart.service.ShoppingCartDomainService;
import com.duanxin.lsg.infrastructure.client.RedisCacheClient;
import com.duanxin.lsg.infrastructure.common.enums.CacheTypeEnum;
import com.duanxin.lsg.infrastructure.utils.JsonUtil;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import sun.misc.Cache;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author duanxin
 * @version 1.0
 * @className ShoppingCartApplicationService
 * @date 2020/11/11 20:32
 */
@Service
@Slf4j
public class ShoppingCartApplicationService {

    @Autowired
    private ShoppingCartDomainService shoppingCartDomainService;

    public void updateUserCarts(UserShoppingCartDO shoppingCartDO) {
        shoppingCartDomainService.updateUserCarts(shoppingCartDO);
    }

    public List<UserShoppingCartDO> getUserCarts(int userId) {
        return shoppingCartDomainService.getCartsByUserId(userId);
    }
}
