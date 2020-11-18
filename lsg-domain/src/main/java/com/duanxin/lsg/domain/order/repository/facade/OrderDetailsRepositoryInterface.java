package com.duanxin.lsg.domain.order.repository.facade;

import com.duanxin.lsg.infrastructure.repository.po.OrderDetailsPO;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderDetailsRepositoryInterface
 * @date 2020/11/17 21:28
 */
public interface OrderDetailsRepositoryInterface {
    OrderDetailsPO insert(OrderDetailsPO orderDetailsPO);
}
