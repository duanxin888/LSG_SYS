package com.duanxin.lsg.api.assembler;

import com.duanxin.lsg.api.dto.OrderDto;
import com.duanxin.lsg.domain.order.entity.OrderDO;
import com.duanxin.lsg.domain.order.entity.valueobject.OrderStatus;
import com.duanxin.lsg.domain.order.entity.valueobject.PayInfo;
import com.duanxin.lsg.domain.order.entity.valueobject.ShipInfo;
import com.duanxin.lsg.domain.order.entity.valueobject.UserInfo;
import com.duanxin.lsg.infrastructure.common.enums.Deleted;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
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
        orderDO.setId(Optional.ofNullable(dto.getId()).orElse(0));
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
        orderDO.setTotalQuantity(Optional.ofNullable(dto.getTotalQuantity()).orElse(0));
        orderDO.setOrderStatus(OrderStatus.formatByName(dto.getOrderStatusName()));
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
        orderDO.setOrderDetailsDOS(Optional.ofNullable(dto.getOrderDetailsDtos()).orElse(Collections.emptyList()).
                stream().map(OrderDetailsAssembler::toDO).
                collect(Collectors.toList()));
        orderDO.setDeleted(Deleted.NOT_DELETE);
        return orderDO;
    }

    public static OrderDto toDto(OrderDO orderDO) {
        OrderDto dto = new OrderDto();
        UserInfo userInfo = orderDO.getUserInfo();
        dto.setUserId(userInfo.getUserId());
        dto.setId(orderDO.getId());
        dto.setPhone(userInfo.getPhone());
        dto.setAddress(userInfo.getAddress());
        dto.setConsignee(userInfo.getConsignee());
        dto.setMessage(userInfo.getMessage());
        dto.setConfirmTime(userInfo.getConfirmTime());
        dto.setRefundTime(userInfo.getRefundTime());
        dto.setOrderSn(orderDO.getOrderSn());
        dto.setTotalPrice(orderDO.getTotalPrice());
        dto.setTotalQuantity(orderDO.getTotalQuantity());
        dto.setOrderStatusName(orderDO.getOrderStatus().getName());

        ShipInfo shipInfo = orderDO.getShipInfo();
        dto.setShipSn(shipInfo.getShipSn());
        dto.setFreightPrice(shipInfo.getFreightPrice());
        dto.setShipTime(shipInfo.getShipTime());
        dto.setShipChannel(shipInfo.getShipChannel());

        PayInfo payInfo = orderDO.getPayInfo();
        dto.setPaySn(payInfo.getPaySn());
        dto.setPayType(payInfo.getPayType());
        dto.setPayTime(payInfo.getPayTime());
        dto.setOrderCloseTime(orderDO.getOrderCloseTime());
        dto.setOrderDetailsDtos(orderDO.getOrderDetailsDOS().stream().
                map(OrderDetailsAssembler::toDto).collect(Collectors.toList()));
        return dto;
    }
}
