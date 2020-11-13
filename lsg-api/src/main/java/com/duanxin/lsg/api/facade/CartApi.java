package com.duanxin.lsg.api.facade;

import com.duanxin.lsg.api.assembler.ShoppingCartAssembler;
import com.duanxin.lsg.api.dto.ShoppingCartDto;
import com.duanxin.lsg.application.service.ShoppingCartApplicationService;
import com.duanxin.lsg.domain.shoppingcart.entity.UserShoppingCartDO;
import com.duanxin.lsg.infrastructure.common.api.ResponseResult;
import com.duanxin.lsg.infrastructure.common.exception.LSGCheckException;
import com.duanxin.lsg.infrastructure.common.exception.ResultEnum;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className CartController
 * @date 2020/10/24 16:32
 */
@RestController
@RequestMapping("/api/v1/carts")
public class CartApi {

    @Autowired
    private ShoppingCartApplicationService shoppingCartApplicationService;

    @DeleteMapping
    public ResponseResult deleteUserCart(@RequestBody ShoppingCartDto shoppingCartDto) {
        shoppingCartApplicationService.deleteUserCart(ShoppingCartAssembler.toDO(shoppingCartDto));
        return ResponseResult.success();
    }

    @PostMapping
    public ResponseResult updateUserCarts(@RequestBody ShoppingCartDto shoppingCartDto) {
        checkParam(shoppingCartDto);
        shoppingCartApplicationService.updateUserCarts(ShoppingCartAssembler.toDO(shoppingCartDto));
        return ResponseResult.success();
    }

    @GetMapping
    public ResponseResult getUserCarts(int userId) {
        List<UserShoppingCartDO> dos = shoppingCartApplicationService.getUserCarts(userId);
        return ResponseResult.success(dos.stream().map(ShoppingCartAssembler::toDto).collect(Collectors.toList()));
    }

    private void checkParam(ShoppingCartDto dto) {
        if (StringUtils.isBlank(dto.getBookName())) {
            throw new LSGCheckException(ResultEnum.SHOPPING_CART_BOOK_NAME_IS_BLANK);
        }
        if (StringUtils.isBlank(dto.getBookPicUrl())) {
            throw new LSGCheckException(ResultEnum.SHOPPING_CART_BOOK_PIC_IS_BLANK);
        }
        if (StringUtils.isBlank(dto.getBookLevelName())) {
            throw new LSGCheckException(ResultEnum.SHOPPING_CART_BOOK_LEVEL_NAME_IS_BLANK);
        }
        if (Objects.isNull(dto.getPrice())) {
            throw new LSGCheckException(ResultEnum.SHOPPING_CART_BOOK_PRICE_IS_EMPTY);
        }
    }
}
