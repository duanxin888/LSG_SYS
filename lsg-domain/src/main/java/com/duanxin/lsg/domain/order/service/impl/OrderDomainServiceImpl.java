package com.duanxin.lsg.domain.order.service.impl;

import com.duanxin.lsg.domain.order.entity.OrderDO;
import com.duanxin.lsg.domain.order.entity.OrderDetailsDO;
import com.duanxin.lsg.domain.order.repository.facade.OrderDetailsRepositoryInterface;
import com.duanxin.lsg.domain.order.repository.facade.UserOrderRepositoryInterface;
import com.duanxin.lsg.domain.order.service.OrderDomainService;
import com.duanxin.lsg.infrastructure.common.exception.LSGCheckException;
import com.duanxin.lsg.infrastructure.common.exception.ResultEnum;
import com.duanxin.lsg.infrastructure.repository.po.UserOrderPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        // insert order details
        toDO.getOrderDetailsDOS().forEach(orderDetails -> addOrderDetails(orderDetails, po.getId()));
    }

    private void addOrderDetails(OrderDetailsDO orderDetails, int orderId) {
        orderDetails.create(orderId);
        orderDetailsRepository.insert(orderFactory.createOrderDetailsPO(orderDetails));
    }
}
