package com.duanxin.lsg.domain.recycleOrder.repository.facade;

import com.duanxin.lsg.infrastructure.repository.po.RecycleOrderDetailsPO;

/**
 * @author duanxin
 * @version 1.0
 * @className RecycleOrderDetailsRepositoryInterface
 * @date 2020/11/22 17:53
 */
public interface RecycleOrderDetailsRepositoryInterface {
    RecycleOrderDetailsPO insert(RecycleOrderDetailsPO creRecycleOrderDetailsPO);

    RecycleOrderDetailsPO selectByISBNAndOrderId(String isbn, int recycleOrderId);
}
