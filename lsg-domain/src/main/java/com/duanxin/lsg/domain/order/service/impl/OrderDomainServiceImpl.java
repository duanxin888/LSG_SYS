package com.duanxin.lsg.domain.order.service.impl;

import com.duanxin.lsg.domain.order.entity.OrderDO;
import com.duanxin.lsg.domain.order.entity.OrderDetailsDO;
import com.duanxin.lsg.domain.order.entity.valueobject.OrderStatus;
import com.duanxin.lsg.domain.order.repository.facade.OrderDetailsRepositoryInterface;
import com.duanxin.lsg.domain.order.repository.facade.UserOrderRepositoryInterface;
import com.duanxin.lsg.domain.order.service.OrderDomainService;
import com.duanxin.lsg.infrastructure.common.exception.LSGCheckException;
import com.duanxin.lsg.infrastructure.common.exception.ResultEnum;
import com.duanxin.lsg.infrastructure.repository.po.OrderDetailsPO;
import com.duanxin.lsg.infrastructure.repository.po.UserOrderPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderDomainServiceImpl
 * @date 2020/11/14 22:10
 */
@Service
public class OrderDomainServiceImpl implements OrderDomainService {

    @Autowired
    private UserOrderRepositoryInterface userOrderRepository;
    @Autowired
    private OrderDetailsRepositoryInterface orderDetailsRepository;
    @Autowired
    private OrderFactory orderFactory;

    @Override
    @Transactional
    public void addOrder(OrderDO toDO) {
        // check total price
        if (!toDO.checkPrice()) {
            throw new LSGCheckException(ResultEnum.ORDER_TOTAL_PRICE_IS_ERROR);
        }
        // init
        toDO.create();
        // insert order
        UserOrderPO po = userOrderRepository.insert(orderFactory.createUserOrderPO(toDO));
        toDO.setId(po.getId());
        // insert order details
        toDO.getOrderDetailsDOS().forEach(orderDetails -> addOrderDetails(orderDetails, po.getId()));
    }

    @Override
    public void payOrder(OrderDO toDO) {
        toDO.pay();
        userOrderRepository.updateForPay(orderFactory.createUserOrderPO(toDO));
    }

    @Override
    public OrderDO selectByOrderSn(String orderSn) {
        OrderDO userOrderDO = orderFactory.createUserOrderDO(userOrderRepository.selectByOrderSn(orderSn));
        userOrderDO.addDetails(orderDetailsRepository.selectByOrderId(userOrderDO.getId()).
                stream().map(orderFactory::createOrderDetailsDO).collect(Collectors.toList()));
        return userOrderDO;
    }

    @Override
    public List<OrderDO> getOrders(int userId) {
        List<OrderDO> orderDOS = userOrderRepository.selectByUserId(userId).
                stream().map(orderFactory::createUserOrderDO).collect(Collectors.toList());
        orderDOS.forEach(order -> order.addDetails(orderDetailsRepository.selectByOrderId(order.getId()).
                stream().map(orderFactory::createOrderDetailsDO).collect(Collectors.toList())));
        return orderDOS;
    }

    @Override
    public OrderDO getOrder(int userId, String orderSn) {
        OrderDO userOrderDO =
                orderFactory.createUserOrderDO(userOrderRepository.selectByUserIdAndOrderSn(userId, orderSn));
        userOrderDO.addDetails(orderDetailsRepository.selectByOrderId(userOrderDO.getId()).
                stream().map(orderFactory::createOrderDetailsDO).collect(Collectors.toList()));
        return userOrderDO;
    }

    @Override
    public List<OrderDO> getInvalidOrders(LocalDateTime expiredTime) {
        List<OrderDO> orderDOS = userOrderRepository.getInvalidOrders(expiredTime, OrderStatus.SUBMIT_SUCCESS).
                stream().map(orderFactory::createUserOrderDO).collect(Collectors.toList());
        orderDOS.forEach(order -> order.addDetails(orderDetailsRepository.selectByOrderId(order.getId()).
                stream().map(orderFactory::createOrderDetailsDO).collect(Collectors.toList())));
        return orderDOS;
    }

    @Override
    public void updateInvalidOrder(OrderDO orderDO) {
        orderDO.expired();
        userOrderRepository.updateInvalidOrder(orderFactory.createUserOrderPO(orderDO));
    }

    private void addOrderDetails(OrderDetailsDO orderDetails, int orderId) {
        orderDetails.create(orderId);
        OrderDetailsPO po = orderDetailsRepository.insert(orderFactory.createOrderDetailsPO(orderDetails));
        orderDetails.setId(po.getId());
    }
}
