package com.duanxin.lsg.api.service.impl;

import com.duanxin.lsg.api.module.AddBook2CartRequestDto;
import com.duanxin.lsg.api.module.CartRequestInfo;
import com.duanxin.lsg.api.service.ShoppingCartService;
import com.duanxin.lsg.common.service.BookStockService;
import com.duanxin.lsg.common.service.CacheService;
import com.duanxin.lsg.common.service.UserService;
import com.duanxin.lsg.common.utils.JsonUtil;
import com.duanxin.lsg.core.enums.CacheTypeEnum;
import com.duanxin.lsg.core.exception.LSGCheckException;
import com.duanxin.lsg.core.exception.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.config.RegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author duanxin
 * @version 1.0
 * @className ShoppingCartServiceImpl
 * @date 2020/10/24 16:56
 */
@Service
@Slf4j
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private CacheService cacheService;
    @Autowired
    private UserService userService;
    @Autowired
    private BookStockService bookStockService;

    @Override
    public void addBook2Cart(AddBook2CartRequestDto request) {
        validate4CartRequest(request);
        log.info("begin to save user [{}] cartInfo [{}] to redis cache",
                request.getUserId(), JsonUtil.toString(request));

        // get redis cache, key: SHOPPING_CART_CACHE::USER_ID::NOW_DATE
        Optional<AddBook2CartRequestDto> cartCacheOptional
                = cacheService.getValue(CacheTypeEnum.SHOPPING_CART_CACHE.getPrefix(), AddBook2CartRequestDto.class,
                String.valueOf(request.getUserId()), LocalDate.now().toString());
        cartCacheOptional.ifPresent(cartCache -> addUp2Request(cartCache, request));

        // save to redis
        cacheService.refreshCache(CacheTypeEnum.SHOPPING_CART_CACHE, request,
                String.valueOf(request.getUserId()), LocalDate.now().toString());
        log.info("success to save user [{}] cartInfo [{}] to redis cache",
                request.getUserId(), JsonUtil.toString(request));
    }

    private void addUp2Request(AddBook2CartRequestDto cartCache, AddBook2CartRequestDto request) {
        List<CartRequestInfo> cartInfos = request.getCartInfos();
        cartCache.getCartInfos().forEach(cartRequestInfo -> {
            if (cartInfos.contains(cartRequestInfo)) {
                CartRequestInfo info = cartInfos.get(cartInfos.indexOf(cartRequestInfo));
                info.setQuantity(info.getQuantity() + cartRequestInfo.getQuantity());
            } else {
                cartInfos.add(cartRequestInfo);
            }
        });
    }

    private void validate4CartRequest(AddBook2CartRequestDto request) {
        if (Objects.isNull(userService.selectByPrimaryId(request.getUserId()))) {
            throw new LSGCheckException(ResultEnum.USER_NOT_EXIST);
        }
        List<CartRequestInfo> cartInfos = request.getCartInfos();
        if (CollectionUtils.isEmpty(cartInfos) || cartInfos.get(0).getQuantity() == 0) {
            throw new LSGCheckException(ResultEnum.CART_REQUEST_INFO_IS_EMPTY);
        }
        if (CollectionUtils.isEmpty(bookStockService.selectByBookIdAndLevelId(
                cartInfos.get(0).getBookId(), cartInfos.get(0).getBookLevelId()))) {
            throw new LSGCheckException(ResultEnum.KIND_OF_BOOK_IS_OUT_OF_STOCK);
        }
    }
}
