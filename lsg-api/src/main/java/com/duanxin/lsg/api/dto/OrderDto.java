package com.duanxin.lsg.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderDto
 * @date 2020/11/15 08:25
 */
@Setter
@Getter
public class OrderDto {

    private Integer id;

    private Integer userId;

    private String orderSn;

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private String orderStatusName;

    private String consignee;

    private String phone;

    private String address;

    private String message;

    private BigDecimal freightPrice;

    private String paySn;

    private String payType;

    private LocalDateTime payTime;

    private String shipSn;

    private String shipChannel;

    private LocalDateTime shipTime;

    private LocalDateTime refundTime;

    private LocalDateTime confirmTime;

    private LocalDateTime orderCloseTime;

    private LocalDateTime cdate;

    private List<OrderDetailsDto> orderDetailsDtos;
}
