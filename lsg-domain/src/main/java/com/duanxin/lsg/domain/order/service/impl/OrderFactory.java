package com.duanxin.lsg.domain.order.service.impl;

import com.duanxin.lsg.domain.order.entity.OrderDO;
import com.duanxin.lsg.domain.order.entity.OrderDetailsDO;
import com.duanxin.lsg.domain.order.entity.valueobject.OrderStatus;
import com.duanxin.lsg.domain.order.entity.valueobject.PayInfo;
import com.duanxin.lsg.domain.order.entity.valueobject.ShipInfo;
import com.duanxin.lsg.domain.order.entity.valueobject.UserInfo;
import com.duanxin.lsg.infrastructure.common.enums.Deleted;
import com.duanxin.lsg.infrastructure.repository.po.OrderDetailsPO;
import com.duanxin.lsg.infrastructure.repository.po.UserOrderPO;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.BeanUtils;
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
        BeanUtils.copyProperties(orderDetails, po);
        po.setDeleted(orderDetails.getDeleted().getCode());
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

    public OrderDO createUserOrderDO(UserOrderPO po) {
        OrderDO orderDO = new OrderDO();
        BeanUtils.copyProperties(po, orderDO);
        UserInfo userInfo = UserInfo.builder().build();
        BeanUtils.copyProperties(po, userInfo);
        orderDO.setUserInfo(userInfo);
        orderDO.setOrderStatus(OrderStatus.formatById(po.getOrderStatusId()));

        ShipInfo shipInfo = ShipInfo.builder().build();
        BeanUtils.copyProperties(po, shipInfo);
        orderDO.setShipInfo(shipInfo);

        PayInfo payInfo = PayInfo.builder().build();
        BeanUtils.copyProperties(po, payInfo);
        orderDO.setPayInfo(payInfo);
        orderDO.setDeleted(Deleted.format(po.getDeleted()));
        return orderDO;
    }

    public OrderDetailsDO createOrderDetailsDO(OrderDetailsPO orderDetailsPO) {
        OrderDetailsDO orderDetailsDO = new OrderDetailsDO();
        BeanUtils.copyProperties(orderDetailsPO, orderDetailsDO);
        orderDetailsDO.setDeleted(Deleted.format(orderDetailsPO.getDeleted()));
        return orderDetailsDO;
    }
}
