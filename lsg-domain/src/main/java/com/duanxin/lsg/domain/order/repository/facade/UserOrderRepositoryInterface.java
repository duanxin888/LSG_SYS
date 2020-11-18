package com.duanxin.lsg.domain.order.repository.facade;

import com.duanxin.lsg.infrastructure.repository.po.UserOrderPO;

/**
 * @author duanxin
 * @version 1.0
 * @className UserOrderRepositoryInterface
 * @date 2020/11/14 22:09
 */
public interface UserOrderRepositoryInterface {
    UserOrderPO insert(UserOrderPO userOrderPO);
}
