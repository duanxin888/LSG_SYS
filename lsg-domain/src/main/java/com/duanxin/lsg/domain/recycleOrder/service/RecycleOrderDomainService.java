package com.duanxin.lsg.domain.recycleOrder.service;

import com.duanxin.lsg.domain.recycleOrder.entity.RecycleOrderDO;
import com.duanxin.lsg.domain.recycleOrder.entity.RecycleOrderDetailsDO;

/**
 * @author duanxin
 * @version 1.0
 * @className RecycleOrderDomainService
 * @date 2020/11/22 17:54
 */
public interface RecycleOrderDomainService {

    RecycleOrderDetailsDO addRecycleBook(int userId, String isbn);

    RecycleOrderDO getRecyclingOrders(int userId);
}
