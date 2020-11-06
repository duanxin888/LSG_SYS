package com.duanxin.lsg.api.service.impl;

import com.duanxin.lsg.api.module.AddBook2CartRequestDto;
import com.duanxin.lsg.api.module.UserCartsResponseInfo;
import com.duanxin.lsg.common.module.AddCartsEvent;
import com.duanxin.lsg.common.module.CartRequestInfo;
import com.duanxin.lsg.api.module.DeleteBookOfCartRequestDto;
import com.duanxin.lsg.api.module.GetUserCartsResponseDto;
import com.duanxin.lsg.api.service.ShoppingCartService;
import com.duanxin.lsg.common.module.DeleteCartsEvent;
import com.duanxin.lsg.common.service.*;
import com.duanxin.lsg.common.utils.JsonUtil;
import com.duanxin.lsg.core.enums.CacheTypeEnum;
import com.duanxin.lsg.core.exception.LSGCheckException;
import com.duanxin.lsg.core.exception.ResultEnum;
import com.duanxin.lsg.persistent.module.Book;
import com.duanxin.lsg.persistent.module.BookLevel;
import com.duanxin.lsg.persistent.module.UserShoppingCart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.ArrayList;
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
    @Autowired
    private UserShoppingCartService userShoppingCartService;
    @Autowired
    private BookLevelService bookLevelService;
    @Autowired
    private BookService bookService;
    @Autowired
    private ApplicationContext context;

    @Override
    public void addBook2Cart(AddBook2CartRequestDto request) {
        validate4CartRequest(request);
        log.info("begin to save user [{}] cartInfo [{}] to redis cache",
                request.getUserId(), JsonUtil.toString(request));

        // get redis cache, key: SHOPPING_CART_CACHE::USER_ID::NOW_DATE
        Optional<AddBook2CartRequestDto> cartCacheOptional
                = cacheService.getValue(CacheTypeEnum.ADD_SHOPPING_CART_CACHE.getPrefix(), AddBook2CartRequestDto.class,
                String.valueOf(request.getUserId()), LocalDate.now().toString());
        cartCacheOptional.ifPresent(cartCache -> addUp2Request(cartCache, request));

        // save to redis
        cacheService.refreshCache(CacheTypeEnum.ADD_SHOPPING_CART_CACHE, request,
                String.valueOf(request.getUserId()), LocalDate.now().toString());
        log.info("success to save user [{}] cartInfo [{}] to redis cache",
                request.getUserId(), JsonUtil.toString(request));
    }

    @Override
    public GetUserCartsResponseDto getUserCarts(int userId) {
        log.info("begin to get user [{}] carts", userId);
        // validate user exist ?
        if (Objects.isNull(userService.selectByPrimaryId(userId))) {
            log.warn("user [{}] not exist", userId);
            throw new LSGCheckException(ResultEnum.USER_NOT_EXIST);
        }

        GetUserCartsResponseDto dto = new GetUserCartsResponseDto();
        dto.setUserId(userId);
        dto.setUserCartsResponseInfos(new ArrayList<>());
        // 1. get datasource of user carts
        List<UserShoppingCart> userShoppingCarts = userShoppingCartService.selectCartsByUserId(userId);
        if (!CollectionUtils.isEmpty(userShoppingCarts)) {
            log.info("add user [{}] db carts [{}] to response", userId, JsonUtil.toString(userShoppingCarts));
            addDbCarts2Dto(userShoppingCarts, dto);
        }

        // 2. get redis cache of user carts
        // 2.1 get cache of add cart
        Optional<AddBook2CartRequestDto> addBook2CartRequestDto =
                cacheService.getValue(CacheTypeEnum.ADD_SHOPPING_CART_CACHE.getPrefix(), AddBook2CartRequestDto.class,
                        String.valueOf(userId), LocalDate.now().toString());
        addBook2CartRequestDto.ifPresent(addBook2CartRequest -> {
            log.info("add user [{}] cache carts [{}] to response", userId, JsonUtil.toString(addBook2CartRequest));
            addCacheCarts2Dto(addBook2CartRequest, dto);

            // publish event
            AddCartsEvent event = new AddCartsEvent();
            addRequest2Event(addBook2CartRequest, event);
            context.publishEvent(event);
            // remove cache
            cacheService.removeCache(CacheTypeEnum.ADD_SHOPPING_CART_CACHE.getPrefix(),
                    String.valueOf(userId), LocalDate.now().toString());
        });

        // 2.2 get cache of delete cart
        Optional<DeleteBookOfCartRequestDto> deleteBookOfCartRequestDto =
                cacheService.getValue(CacheTypeEnum.DELETE_SHOPPING_CART_CACHE.getPrefix(), DeleteBookOfCartRequestDto.class,
                String.valueOf(userId), LocalDate.now().toString());
        deleteBookOfCartRequestDto.ifPresent(deleteBookOfCartRequest -> {
            log.info("remove user [{}] cache carts [{}] of response", userId, JsonUtil.toString(deleteBookOfCartRequest));
            deleteCacheCarts2Dto(deleteBookOfCartRequest, dto);

            // publish event
            DeleteCartsEvent event = new DeleteCartsEvent();
            deleteRequest2Event(deleteBookOfCartRequest, event);
            context.publishEvent(event);
            // remove cache
            cacheService.removeCache(CacheTypeEnum.DELETE_SHOPPING_CART_CACHE.getPrefix(),
                    String.valueOf(userId), LocalDate.now().toString());
        });

        log.info("success to get user [{}] carts", userId);
        return dto;
    }

    private void deleteRequest2Event(DeleteBookOfCartRequestDto deleteBookOfCartRequest, DeleteCartsEvent event) {
        event.setUserId(deleteBookOfCartRequest.getUserId());
        List<CartRequestInfo> infos = new ArrayList<>();
        deleteBookOfCartRequest.getCartInfos().forEach(info -> {
            CartRequestInfo info1 = new CartRequestInfo();
            BeanUtils.copyProperties(info, info1);
            infos.add(info1);
        });
        event.setCartRequestInfos(infos);
    }

    private void addRequest2Event(AddBook2CartRequestDto addBook2CartRequest, AddCartsEvent event) {
        event.setUserId(addBook2CartRequest.getUserId());
        List<CartRequestInfo> infos = new ArrayList<>();
        addBook2CartRequest.getCartInfos().forEach(info -> {
            CartRequestInfo info1 = new CartRequestInfo();
            BeanUtils.copyProperties(info, info1);
            infos.add(info1);
        });
        event.setCartRequestInfos(infos);
    }

    private void deleteCacheCarts2Dto(DeleteBookOfCartRequestDto deleteBookOfCartRequest, GetUserCartsResponseDto dto) {
        List<UserCartsResponseInfo> infos = dto.getUserCartsResponseInfos();
        deleteBookOfCartRequest.getCartInfos().forEach(request -> {
            UserCartsResponseInfo info = new UserCartsResponseInfo();
            cartsRequest2Response(info, request);
            int index = infos.indexOf(info);
            if (index != -1) {
                UserCartsResponseInfo info1 = infos.get(index);
                info1.setQuantity(info1.getQuantity() - info.getQuantity());
                if (info1.getQuantity() <= 0) {
                    infos.remove(info1);
                }
            }
        });
    }

    private void addCacheCarts2Dto(AddBook2CartRequestDto addBook2CartRequest, GetUserCartsResponseDto dto) {
        List<UserCartsResponseInfo> infos = dto.getUserCartsResponseInfos();
        addBook2CartRequest.getCartInfos().forEach(request -> {
            UserCartsResponseInfo info = new UserCartsResponseInfo();
            cartsRequest2Response(info, request);
            infos.add(info);
        });
    }

    private void cartsRequest2Response(UserCartsResponseInfo response, CartRequestInfo request) {
        response.setBookId(request.getBookId());
        response.setQuantity(request.getQuantity());
        Book book = bookService.selectBookById(request.getBookId());
        response.setBookName(book.getBookName());
        response.setBookPicUrl(book.getPicUrl());

        BookLevel bookLevel = bookLevelService.getExist(request.getBookLevelId());
        response.setBookLevelName(bookLevel.getLevelName());
        response.setPrice(bookLevel.getConditionFactor().multiply(book.getPrice()).setScale(2));
    }

    private void addDbCarts2Dto(List<UserShoppingCart> userShoppingCarts, GetUserCartsResponseDto dto) {
        List<UserCartsResponseInfo> infos = dto.getUserCartsResponseInfos();
        userShoppingCarts.forEach(userShoppingCart -> {
            UserCartsResponseInfo info = new UserCartsResponseInfo();
            BeanUtils.copyProperties(userShoppingCart, info);
            infos.add(info);
        });
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
