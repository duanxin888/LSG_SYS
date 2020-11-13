package com.duanxin.lsg.domain.shoppingcart.service.impl;

import com.duanxin.lsg.domain.shoppingcart.entity.BookInfo;
import com.duanxin.lsg.domain.shoppingcart.entity.UserShoppingCartDO;
import com.duanxin.lsg.domain.shoppingcart.repository.facade.UserShoppingCartRepositoryInterface;
import com.duanxin.lsg.domain.shoppingcart.service.ShoppingCartDomainService;
import com.duanxin.lsg.infrastructure.common.exception.LSGCheckException;
import com.duanxin.lsg.infrastructure.common.exception.ResultEnum;
import com.duanxin.lsg.infrastructure.repository.po.UserShoppingCartPO;
import com.duanxin.lsg.infrastructure.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className ShoppingCartDomainServiceImpl
 * @date 2020/11/11 20:31
 */
@Service
@Slf4j
public class ShoppingCartDomainServiceImpl implements ShoppingCartDomainService {

    @Autowired
    private UserShoppingCartRepositoryInterface userShoppingCartRepository;
    @Autowired
    private ShoppingCartFactory shoppingCartFactory;

    @Override
    public List<UserShoppingCartDO> getCartsByUserId(int userId) {
        return userShoppingCartRepository.selectCartsByUserId(userId).stream().
                map(shoppingCartFactory::createUserShoppingCartDO).collect(Collectors.toList());
    }

    @Override
    public void updateUserCarts(UserShoppingCartDO shoppingCartDO) {
        log.info("begin to update user [{}] carts [{}]", shoppingCartDO.getUserId(), JsonUtil.toString(shoppingCartDO));
        BookInfo bookInfo = shoppingCartDO.getBookInfo();
        UserShoppingCartPO po = userShoppingCartRepository.selectByUserIdAndBookIdAndLevelId(
                        shoppingCartDO.getUserId(), bookInfo.getBookId(), bookInfo.getBookLevelName());
        if (shoppingCartDO.isAddCart()) {
            // add book to carts
            upBookToCarts(shoppingCartDO, bookInfo, po);
            return ;
        }

        // down cart quantity
        downBookFromCarts(shoppingCartDO, bookInfo, po);
    }

    @Override
    public void deleteUserCart(UserShoppingCartDO cartDO) {
        cartDO.deletedStatus();
        BookInfo info = cartDO.getBookInfo();
        userShoppingCartRepository.deletedUserCart(cartDO.getUserId(), info.getBookId(),
                info.getBookLevelName(), cartDO.getDeleted().getCode());
    }

    private void downBookFromCarts(UserShoppingCartDO shoppingCartDO, BookInfo bookInfo, UserShoppingCartPO po) {
        if (Objects.isNull(po)) {
            log.warn("fail to delete level [{}] book [{}] to user [{}] cart",
                    bookInfo.getBookLevelName(), bookInfo.getBookId(), shoppingCartDO.getUserId());
            throw new LSGCheckException(ResultEnum.DELETE_USER_CART_NOT_EXIST);
        }
        UserShoppingCartDO dbCart = shoppingCartFactory.createUserShoppingCartDO(po);
        dbCart.downQuantity(bookInfo.getQuantity());
        userShoppingCartRepository.updateCartQuantity(shoppingCartFactory.createUserShoppingCartPO(dbCart));
        log.info("success to update level [{}] book [{}] to user [{}] cart",
                bookInfo.getBookLevelName(), bookInfo.getBookId(), shoppingCartDO.getUserId());
    }

    private void upBookToCarts(UserShoppingCartDO shoppingCartDO, BookInfo bookInfo, UserShoppingCartPO po) {
        log.info("begin to update level [{}] book [{}] to user [{}] cart",
                bookInfo.getBookLevelName(), bookInfo.getBookId(), shoppingCartDO.getUserId());
        if (Objects.isNull(po)) {
            // add cart to db
            log.info("begin to add level [{}] book [{}] to user [{}] cart",
                    bookInfo.getBookLevelName(), bookInfo.getBookId(), shoppingCartDO.getUserId());
            userShoppingCartRepository.insert(shoppingCartFactory.createUserShoppingCartPO(shoppingCartDO));
            log.info("success to add level [{}] book [{}] to user [{}] cart",
                    bookInfo.getBookLevelName(), bookInfo.getBookId(), shoppingCartDO.getUserId());
            return ;
        }
        // update cart
        UserShoppingCartDO dbCart = shoppingCartFactory.createUserShoppingCartDO(po);
        dbCart.upQuantity(shoppingCartDO.getBookInfo().getQuantity());
        userShoppingCartRepository.updateCartQuantity(shoppingCartFactory.createUserShoppingCartPO(dbCart));
        log.info("success to update level [{}] book [{}] to user [{}] cart",
                bookInfo.getBookLevelName(), bookInfo.getBookId(), shoppingCartDO.getUserId());
    }
}
