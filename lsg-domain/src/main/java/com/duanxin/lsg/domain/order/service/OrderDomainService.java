package com.duanxin.lsg.domain.order.service;

import com.duanxin.lsg.domain.order.entity.OrderDO;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderDomainService
 * @date 2020/11/14 22:09
 */
public interface OrderDomainService {
    void addOrder(OrderDO toDO);

    void payOrder(OrderDO toDO);

    OrderDO selectByOrderSn(String orderSn);

    List<OrderDO> getOrders(int userId);
}
