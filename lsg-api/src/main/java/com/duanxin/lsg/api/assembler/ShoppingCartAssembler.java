package com.duanxin.lsg.api.assembler;

import com.duanxin.lsg.api.dto.ShoppingCartDto;
import com.duanxin.lsg.domain.shoppingcart.entity.BookInfo;
import com.duanxin.lsg.domain.shoppingcart.entity.UserShoppingCartDO;
import com.duanxin.lsg.infrastructure.common.enums.Deleted;

/**
 * @author duanxin
 * @version 1.0
 * @className ShoppingCartAssembler
 * @date 2020/11/11 20:44
 */
public class ShoppingCartAssembler {

    public static UserShoppingCartDO toDO(ShoppingCartDto dto) {
        UserShoppingCartDO shoppingCartDO = new UserShoppingCartDO();
        shoppingCartDO.setUserId(dto.getUserId());
        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookId(dto.getUserId());
        bookInfo.setBookName(dto.getBookName());
        bookInfo.setBookLevelName(dto.getBookLevelName());
        bookInfo.setBookPicUrl(dto.getBookPicUrl());
        bookInfo.setPrice(dto.getPrice());
        bookInfo.setQuantity(dto.getQuantity());
        shoppingCartDO.setBookInfo(bookInfo);
        shoppingCartDO.setDeleted(Deleted.NOT_DELETE);
        return shoppingCartDO;
    }

    public static ShoppingCartDto toDto(UserShoppingCartDO cartDO) {
        ShoppingCartDto dto = new ShoppingCartDto();
        dto.setUserId(cartDO.getUserId());
        BookInfo bookInfo = cartDO.getBookInfo();
        dto.setBookId(bookInfo.getBookId());
        dto.setBookName(bookInfo.getBookName());
        dto.setBookPicUrl(bookInfo.getBookPicUrl());
        dto.setBookLevelName(bookInfo.getBookLevelName());
        dto.setPrice(bookInfo.getPrice());
        dto.setQuantity(bookInfo.getQuantity());
        return dto;
    }
}
