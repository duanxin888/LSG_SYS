package com.duanxin.lsg.domain.recycleOrder.repository.facade;

import com.duanxin.lsg.infrastructure.repository.po.RecycleOrderPO;

/**
 * @author duanxin
 * @version 1.0
 * @className RecycleOrderRepositoryInterface
 * @date 2020/11/22 17:52
 */
public interface RecycleOrderRepositoryInterface {

    RecycleOrderPO selectByUserId(int userId);

    RecycleOrderPO insert(RecycleOrderPO recycleOrderPO);
}
