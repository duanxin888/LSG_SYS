package com.duanxin.lsg.domain.shoppingcart.service.impl;

import com.duanxin.lsg.domain.shoppingcart.entity.BookInfo;
import com.duanxin.lsg.domain.shoppingcart.entity.UserShoppingCartDO;
import com.duanxin.lsg.infrastructure.common.enums.Deleted;
import com.duanxin.lsg.infrastructure.repository.po.UserShoppingCartPO;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className ShoppingCartFactory
 * @date 2020/11/12 20:59
 */
@Service
public class ShoppingCartFactory {

    public UserShoppingCartDO createUserShoppingCartDO(UserShoppingCartPO po) {
        UserShoppingCartDO cartDO = new UserShoppingCartDO();
        cartDO.setId(po.getId());
        cartDO.setUserId(po.getUserId());
        cartDO.setBookInfo(BookInfo.builder().
                bookId(po.getBookId()).
                bookName(po.getBookName()).
                bookPicUrl(po.getBookPicUrl()).
                bookLevelName(po.getBookLevelName()).
                price(po.getPrice()).
                quantity(po.getQuantity()).build());
        cartDO.setDeleted(Deleted.format(po.getDeleted()));
        cartDO.setCdate(po.getCdate());
        cartDO.setCreator(po.getCreator());
        cartDO.setEdate(po.getEdate());
        cartDO.setEditor(po.getEditor());
        return cartDO;
    }

    public UserShoppingCartPO createUserShoppingCartPO(UserShoppingCartDO shoppingCartDO) {
        UserShoppingCartPO po = new UserShoppingCartPO();
        po.setUserId(shoppingCartDO.getUserId());
        BookInfo info = shoppingCartDO.getBookInfo();
        po.setBookId(info.getBookId());
        po.setBookName(info.getBookName());
        po.setBookPicUrl(info.getBookPicUrl());
        po.setQuantity(info.getQuantity());
        po.setBookLevelName(info.getBookLevelName());
        po.setPrice(info.getPrice());
        po.setDeleted(shoppingCartDO.getDeleted().getCode());
        po.setCdate(shoppingCartDO.getCdate());
        po.setCreator(shoppingCartDO.getCreator());
        po.setEdate(shoppingCartDO.getEdate());
        po.setEditor(shoppingCartDO.getEditor());
        return po;
    }
}
