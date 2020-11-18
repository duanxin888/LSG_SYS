package com.duanxin.lsg.domain.order.service.impl;

import com.duanxin.lsg.domain.order.entity.OrderDO;
import com.duanxin.lsg.domain.order.entity.OrderDetailsDO;
import com.duanxin.lsg.domain.order.entity.valueobject.PayInfo;
import com.duanxin.lsg.domain.order.entity.valueobject.ShipInfo;
import com.duanxin.lsg.domain.order.entity.valueobject.UserInfo;
import com.duanxin.lsg.infrastructure.repository.po.OrderDetailsPO;
import com.duanxin.lsg.infrastructure.repository.po.UserOrderPO;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderFactory
 * @date 2020/11/17 21:32
 */
@Service
public class OrderFactory {

    public OrderDetailsPO createOrderDetailsPO(OrderDetailsDO orderDetails) {
        OrderDetailsPO po = new OrderDetailsPO();
        po.setOrderId(orderDetails.getOrderId());
        po.setId(orderDetails.getId());
        po.setBookId(orderDetails.getBookId());
        po.setBookName(orderDetails.getBookName());
        po.setBookPicUrl(orderDetails.getBookPicUrl());
        po.setBookLevelId(orderDetails.getBookLevelId());
        po.setQuantity(orderDetails.getQuantity());
        po.setPrice(orderDetails.getPrice());
        po.setDeleted(orderDetails.getDeleted().getCode());
        po.setCdate(orderDetails.getCdate());
        po.setCreator(orderDetails.getCreator());
        po.setEdate(orderDetails.getEdate());
        po.setEditor(orderDetails.getEditor());
        return po;
    }

    public UserOrderPO createUserOrderPO(OrderDO orderDO) {
        UserOrderPO po = new UserOrderPO();
        po.setId(orderDO.getId());

        UserInfo info = orderDO.getUserInfo();
        po.setUserId(info.getUserId());
        po.setConsignee(info.getConsignee());
        po.setPhone(info.getPhone());
        po.setAddress(info.getAddress());
        po.setMessage(info.getMessage());
        po.setConfirmTime(info.getConfirmTime());
        po.setRefundTime(info.getRefundTime());
        po.setOrderSn(orderDO.getOrderSn());
        po.setTotalPrice(orderDO.getTotalPrice());
        po.setTotalQuantity(orderDO.getTotalQuantity());
        po.setOrderStatusId(orderDO.getOrderStatus().getId());

        ShipInfo shipInfo = orderDO.getShipInfo();
        po.setFreightPrice(shipInfo.getFreightPrice());
        po.setShipSn(shipInfo.getShipSn());
        po.setShipChannel(shipInfo.getShipChannel());
        po.setShipTime(shipInfo.getShipTime());

        PayInfo payInfo = orderDO.getPayInfo();
        po.setPaySn(payInfo.getPaySn());
        po.setPayType(payInfo.getPayType());
        po.setPayTime(payInfo.getPayTime());
        po.setOrderCloseTime(orderDO.getOrderCloseTime());
        po.setDeleted(orderDO.getDeleted().getCode());
        po.setCdate(orderDO.getCdate());
        po.setCreator(orderDO.getCreator());
        po.setEdate(orderDO.getEdate());
        po.setEditor(orderDO.getEditor());
        return po;
    }
}
