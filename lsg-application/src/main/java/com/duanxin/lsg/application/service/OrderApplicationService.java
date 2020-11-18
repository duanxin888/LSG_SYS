package com.duanxin.lsg.application.service;

import com.duanxin.lsg.domain.book.entity.BookStockDO;
import com.duanxin.lsg.domain.book.entity.valueobject.BookLevel;
import com.duanxin.lsg.domain.book.service.BookDomainService;
import com.duanxin.lsg.domain.order.entity.OrderDO;
import com.duanxin.lsg.domain.order.service.OrderDomainService;
import com.duanxin.lsg.domain.shoppingcart.entity.BookInfo;
import com.duanxin.lsg.domain.shoppingcart.entity.UserShoppingCartDO;
import com.duanxin.lsg.domain.shoppingcart.service.ShoppingCartDomainService;
import com.duanxin.lsg.domain.user.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderApplicationService
 * @date 2020/11/14 22:10
 */
@Service
public class OrderApplicationService {

    @Autowired
    private OrderDomainService orderDomainService;
    @Autowired
    private UserDomainService userDomainService;
    @Autowired
    private ShoppingCartDomainService shoppingCartDomainService;
    @Autowired
    private BookDomainService bookDomainService;

    @Transactional
    public void addOrder(OrderDO toDO) {
        checkUserExist(toDO.getUserInfo().getUserId());
        orderDomainService.addOrder(toDO);
        checkAndDeleteUserCarts(toDO);
    }

    private void checkUserExist(int userId) {
        userDomainService.getUserById(userId);
    }

    private void checkAndDeleteUserCarts(OrderDO orderDO) {
        orderDO.getOrderDetailsDOS().forEach(orderDetails -> {
            // check stock
            BookStockDO bookStockDO = new BookStockDO();
            bookStockDO.setBookId(orderDetails.getBookId());
            bookStockDO.setBookLevel(bookDomainService.getBookLevelById(orderDetails.getBookLevelId()));
            bookStockDO.setStock(orderDetails.getQuantity());
            bookDomainService.checkStock(bookStockDO);

            // deleted cart
            UserShoppingCartDO shoppingCartDO = new UserShoppingCartDO();
            shoppingCartDO.setUserId(orderDO.getUserInfo().getUserId());
            shoppingCartDO.setBookInfo(BookInfo.builder().
                    bookId(orderDetails.getBookId()).
                    bookName(orderDetails.getBookName()).
                    bookLevelName(BookLevel.getById(orderDetails.getBookLevelId()).
                            getLevelName()).
                    bookPicUrl(orderDetails.getBookPicUrl()).
                    price(orderDetails.getPrice()).
                    quantity(orderDetails.getQuantity()).build());
            shoppingCartDomainService.deleteUserCart(shoppingCartDO);

            // down stock
            bookDomainService.downStock(bookStockDO);
        });
    }
}
