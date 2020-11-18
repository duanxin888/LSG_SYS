package com.duanxin.lsg.api.assembler;

import com.duanxin.lsg.api.dto.OrderDto;
import com.duanxin.lsg.domain.order.entity.OrderDO;
import com.duanxin.lsg.domain.order.entity.valueobject.OrderStatus;
import com.duanxin.lsg.domain.order.entity.valueobject.PayInfo;
import com.duanxin.lsg.domain.order.entity.valueobject.ShipInfo;
import com.duanxin.lsg.domain.order.entity.valueobject.UserInfo;
import com.duanxin.lsg.infrastructure.common.enums.Deleted;

import java.util.stream.Collectors;


/**
 * @author duanxin
 * @version 1.0
 * @className OrderAssembler
 * @date 2020/11/17 14:38
 */
public class OrderAssembler {

    public static OrderDO toDO(OrderDto dto) {
        OrderDO orderDO = new OrderDO();
        orderDO.setId(dto.getId());
        orderDO.setUserInfo(UserInfo.builder().
                userId(dto.getUserId()).
                address(dto.getAddress()).
                phone(dto.getPhone()).
                message(dto.getMessage()).
                consignee(dto.getConsignee()).
                refundTime(dto.getRefundTime()).
                confirmTime(dto.getConfirmTime()).build());
        orderDO.setOrderSn(dto.getOrderSn());
        orderDO.setTotalPrice(dto.getTotalPrice());
        orderDO.setTotalQuantity(dto.getTotalQuantity());
        if (dto.getId() != 0) {
            orderDO.setOrderStatus(OrderStatus.formatByName(dto.getOrderStatusName()));
        }
        orderDO.setShipInfo(ShipInfo.builder().
                shipSn(dto.getShipSn()).
                shipChannel(dto.getShipChannel()).
                shipTime(dto.getShipTime()).
                freightPrice(dto.getFreightPrice()).build());
        orderDO.setPayInfo(PayInfo.builder().
                paySn(dto.getPaySn()).
                payType(dto.getPayType()).
                payTime(dto.getPayTime()).build());
        orderDO.setOrderCloseTime(dto.getOrderCloseTime());
        orderDO.setOrderDetailsDOS(dto.getOrderDetailsDtos().
                stream().map(OrderDetailsAssembler::toDO).
                collect(Collectors.toList()));
        return orderDO;
    }
}
