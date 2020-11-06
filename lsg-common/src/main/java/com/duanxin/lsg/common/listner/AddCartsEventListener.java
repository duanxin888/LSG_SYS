package com.duanxin.lsg.common.listner;

import com.duanxin.lsg.common.module.AddCartsEvent;
import com.duanxin.lsg.common.module.CartRequestInfo;
import com.duanxin.lsg.common.service.BookLevelService;
import com.duanxin.lsg.common.service.BookService;
import com.duanxin.lsg.common.service.UserShoppingCartService;
import com.duanxin.lsg.common.utils.JsonUtil;
import com.duanxin.lsg.persistent.module.Book;
import com.duanxin.lsg.persistent.module.BookLevel;
import com.duanxin.lsg.persistent.module.UserShoppingCart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className AddCartsEventListener
 * @date 2020/11/01 14:02
 */
@Component
@Slf4j
public class AddCartsEventListener{

    @Autowired
    private UserShoppingCartService userShoppingCartService;
    @Autowired
    private BookLevelService bookLevelService;
    @Autowired
    private BookService bookService;

    @EventListener
    @Async("eventTaskThreadPool")
    public void action(AddCartsEvent event) {
        String eventStr = JsonUtil.toString(event);
        log.info("begin to add carts [{}] to db", eventStr);
        int userId = event.getUserId();
        List<UserShoppingCart> userShoppingCarts =
                userShoppingCartService.selectCartsByUserId(userId);
        Map<Integer, List<UserShoppingCart>> bookGroup =
                userShoppingCarts.stream().collect(Collectors.groupingBy(UserShoppingCart::getBookId));
        event.getCartRequestInfos().forEach(info -> {
            List<UserShoppingCart> list = bookGroup.get(info.getBookId());
            if (Objects.isNull(list)) {
                log.info("user [{}] book [{}] not exist cart, then storage db",
                        userId, info.getBookId());
                // storage db
                storageEvent(info, userId);
            } else {
                Map<String, List<UserShoppingCart>> levelMap =
                        list.stream().collect(Collectors.groupingBy(UserShoppingCart::getBookLevelName));
                BookLevel bookLevel = bookLevelService.getExist(info.getBookLevelId());
                List<UserShoppingCart> carts = levelMap.get(bookLevel.getLevelName());
                if (Objects.isNull(carts)) {
                    log.info("user [{}] book [{}] level [{}] not exist cart, then storage db",
                            userId, info.getBookId(), bookLevel.getLevelName());
                    storageEvent(info, userId);
                } else {
                    log.info("user [{}] book [{}] level [{}] exist cart, then update to up quantity [{}]",
                            userId, info.getBookId(), bookLevel.getLevelName(), info.getQuantity());
                    userShoppingCartService.updateCartQuantity(info.getBookId(), info.getQuantity(),
                            userId, bookLevel.getLevelName());
                }
            }
        });
        log.info("success to add carts [{}] to db", eventStr);
    }

    private void storageEvent(CartRequestInfo info, int userId) {
        UserShoppingCart cart = new UserShoppingCart();
        cart.setUserId(userId);
        Book book = bookService.selectBookById(info.getBookId());
        cart.setBookId(book.getId());
        cart.setBookName(book.getBookName());
        cart.setBookPicUrl(book.getPicUrl());
        cart.setQuantity(info.getQuantity());
        BookLevel bookLevel = bookLevelService.getExist(info.getBookLevelId());
        cart.setBookLevelName(bookLevel.getLevelName());
        cart.setPrice(bookLevel.getConditionFactor().multiply(book.getPrice()).setScale(2));
        userShoppingCartService.insert(cart);
    }
}
