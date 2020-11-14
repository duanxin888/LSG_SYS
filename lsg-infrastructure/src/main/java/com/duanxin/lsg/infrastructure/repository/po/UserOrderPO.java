package com.duanxin.lsg.infrastructure.repository.po;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className UserOrderPO
 * @date 2020/11/14 20:43
 */
@Setter
@Getter
public class UserOrderPO {

    private int id;

    private int userId;

    private String orderSn;

    private BigDecimal totalPrice;

    private int totalQuantity;

    private int orderStatusId;

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

    private int deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
