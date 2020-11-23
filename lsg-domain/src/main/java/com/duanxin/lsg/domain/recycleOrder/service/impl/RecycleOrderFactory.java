package com.duanxin.lsg.domain.recycleOrder.service.impl;

import com.duanxin.lsg.domain.recycleOrder.entity.RecycleOrderDO;
import com.duanxin.lsg.domain.recycleOrder.entity.RecycleOrderDetailsDO;
import com.duanxin.lsg.domain.recycleOrder.entity.valueobject.RecycleBookInfo;
import com.duanxin.lsg.domain.recycleOrder.entity.valueobject.RecycleOrderStatus;
import com.duanxin.lsg.infrastructure.common.enums.Deleted;
import com.duanxin.lsg.infrastructure.repository.po.RecycleOrderDetailsPO;
import com.duanxin.lsg.infrastructure.repository.po.RecycleOrderPO;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className RecycleOrderFactory
 * @date 2020/11/22 21:15
 */
@Service
public class RecycleOrderFactory {

    public RecycleOrderDetailsPO creRecycleOrderDetailsPO(RecycleOrderDetailsDO recycleOrderDetailsDO) {
        RecycleOrderDetailsPO po = new RecycleOrderDetailsPO();
        BeanUtils.copyProperties(recycleOrderDetailsDO, po);
        BeanUtils.copyProperties(recycleOrderDetailsDO.getRecycleBookInfo(), po);
        po.setDeleted(recycleOrderDetailsDO.getDeleted().getCode());
        return po;
    }

    public RecycleOrderPO createRecycleOrderPO(RecycleOrderDO recycleOrderDO) {
        RecycleOrderPO po = new RecycleOrderPO();
        BeanUtils.copyProperties(recycleOrderDO, po);
        po.setRecycleStatusId(recycleOrderDO.getRecycleOrderStatus().getId());
        return po;
    }

    public RecycleOrderDO createRecycleOrderDO(RecycleOrderPO po) {
        RecycleOrderDO recycleOrderDO = new RecycleOrderDO();
        BeanUtils.copyProperties(po, recycleOrderDO);
        recycleOrderDO.setRecycleOrderStatus(RecycleOrderStatus.formatById(po.getRecycleStatusId()));
        return recycleOrderDO;
    }

    public RecycleOrderDetailsDO creRecycleOrderDetailsDO(RecycleOrderDetailsPO po) {
        RecycleOrderDetailsDO recycleOrderDetails = new RecycleOrderDetailsDO();
        BeanUtils.copyProperties(po, recycleOrderDetails);
        RecycleBookInfo bookInfo = new RecycleBookInfo();
        BeanUtils.copyProperties(po, bookInfo);
        recycleOrderDetails.setRecycleBookInfo(bookInfo);
        recycleOrderDetails.setDeleted(Deleted.format(po.getDeleted()));
        return recycleOrderDetails;
    }
}
