package com.duanxin.lsg.domain.order.repository.facade;

import com.duanxin.lsg.domain.order.entity.OrderDO;
import com.duanxin.lsg.domain.order.entity.valueobject.OrderStatus;
import com.duanxin.lsg.infrastructure.repository.po.UserOrderPO;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className UserOrderRepositoryInterface
 * @date 2020/11/14 22:09
 */
public interface UserOrderRepositoryInterface {
    UserOrderPO insert(UserOrderPO userOrderPO);

    UserOrderPO updateForPay(UserOrderPO userOrderPO);

    UserOrderPO selectByOrderSn(String orderSn);

    List<UserOrderPO> selectByUserId(int userId);

    UserOrderPO selectByUserIdAndOrderSn(int userId, String orderSn);

    List<UserOrderPO> getInvalidOrders(LocalDateTime expiredTime, OrderStatus submitSuccess);

    void updateInvalidOrder(UserOrderPO userOrderPO);
}
