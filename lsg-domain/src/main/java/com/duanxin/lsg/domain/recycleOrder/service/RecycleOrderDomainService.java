package com.duanxin.lsg.domain.recycleOrder.service;

import com.duanxin.lsg.domain.recycleOrder.entity.RecycleOrderDO;
import com.duanxin.lsg.domain.recycleOrder.entity.RecycleOrderDetailsDO;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className RecycleOrderDomainService
 * @date 2020/11/22 17:54
 */
public interface RecycleOrderDomainService {

    RecycleOrderDetailsDO addRecycleBook(int userId, String isbn);

    RecycleOrderDO getRecyclingOrders(int userId);

    List<RecycleOrderDO> getRecycledOrders(int userId);

    void deleteRecycleOrderDetails(int detailsId);

    void submitRecyclingOrder(int userId);
}
