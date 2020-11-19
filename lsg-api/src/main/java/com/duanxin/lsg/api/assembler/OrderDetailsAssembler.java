package com.duanxin.lsg.api.assembler;

import com.duanxin.lsg.api.dto.OrderDetailsDto;
import com.duanxin.lsg.domain.book.entity.valueobject.BookLevel;
import com.duanxin.lsg.domain.order.entity.OrderDetailsDO;
import org.aspectj.weaver.ast.Or;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderDetailsAssembler
 * @date 2020/11/17 14:19
 */
public class OrderDetailsAssembler {

    public static OrderDetailsDO toDO(OrderDetailsDto dto) {
        OrderDetailsDO orderDetails = new OrderDetailsDO();
        orderDetails.setId(dto.getId());
        orderDetails.setOrderId(dto.getOrderId());
        orderDetails.setBookId(dto.getBookId());
        orderDetails.setBookName(dto.getBookName());
        orderDetails.setBookPicUrl(dto.getBookPicUrl());
        orderDetails.setBookLevelId(BookLevel.getByName(dto.getBookLevelName()).getId());
        orderDetails.setQuantity(dto.getQuantity());
        orderDetails.setPrice(dto.getPrice());
        return orderDetails;
    }

    public static OrderDetailsDto toDto(OrderDetailsDO orderDetailsDO) {
        OrderDetailsDto dto = new OrderDetailsDto();
        dto.setId(orderDetailsDO.getId());
        dto.setOrderId(orderDetailsDO.getOrderId());
        dto.setBookId(orderDetailsDO.getBookId());
        dto.setBookName(orderDetailsDO.getBookName());
        dto.setBookPicUrl(orderDetailsDO.getBookPicUrl());
        dto.setBookLevelName(BookLevel.getById(orderDetailsDO.getBookLevelId()).getLevelName());
        dto.setQuantity(orderDetailsDO.getQuantity());
        dto.setPrice(orderDetailsDO.getPrice());
        return dto;
    }
}
