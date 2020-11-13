package com.duanxin.lsg.domain.shoppingcart.repository.persistence;

import com.duanxin.lsg.domain.shoppingcart.repository.facade.UserShoppingCartRepositoryInterface;
import com.duanxin.lsg.infrastructure.common.enums.Deleted;
import com.duanxin.lsg.infrastructure.repository.mapper.UserShoppingCartMapper;
import com.duanxin.lsg.infrastructure.repository.po.UserShoppingCartPO;
import com.duanxin.lsg.infrastructure.utils.JsonUtil;
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
public class UserShoppingCartRepositoryImpl implements UserShoppingCartRepositoryInterface {

    @Autowired
    private UserShoppingCartMapper userShoppingCartMapper;

    @Override
    public List<UserShoppingCartPO> selectCartsByUserId(int userId) {
        return userShoppingCartMapper.selectCartsByUserId(userId);
    }

    @Override
    public UserShoppingCartPO insert(UserShoppingCartPO cart) {
        userShoppingCartMapper.insert(cart);
        log.info("success to insert user cart [{}]", JsonUtil.toString(cart));
        return cart;
    }

    @Override
    public void updateCartQuantity(UserShoppingCartPO po) {
        userShoppingCartMapper.updateCartQuantity(po.getUserId(), po.getBookId(),
                po.getBookLevelName(), po.getQuantity(), po.getDeleted());
        log.info("success to update user [{}] book [{}] level [{}] quantity [{}] deleted [{}]",
                po.getUserId(), po.getBookId(), po.getBookLevelName(), po.getQuantity(), Deleted.format(po.getDeleted()));
    }

    @Override
    public UserShoppingCartPO selectByUserIdAndBookIdAndLevelId(int userId, int bookId, String bookLevelName) {
        return userShoppingCartMapper.selectByUserIdAndBookIdAndLevelId(userId, bookId, bookLevelName);
    }

    @Override
    public void deletedUserCart(int userId, int bookId, String bookLevelName, int deleted) {
        userShoppingCartMapper.updateUserCartStatus(userId, bookId, bookLevelName, deleted);
        log.info("success to delete user [{}] level [{}] book [{}] status [{}]",
                userId, bookLevelName, bookId, Deleted.format(deleted));
    }
}
