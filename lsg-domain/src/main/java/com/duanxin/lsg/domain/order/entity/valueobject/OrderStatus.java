package com.duanxin.lsg.domain.order.entity.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderStatus
 * @date 2020/11/14 21:14
 */
@Getter
@AllArgsConstructor
public enum OrderStatus {

    SUBMIT_SUCCESS(1, "提交成功"),
    PAY_SUCCESS(2, "支付成功"),
    DELIVERY_SUCCESS(3, "发货成功"),
    CONFIRM_SUCCESS(4, "确认收货"),
    CLOSE(5, "已关闭"),
    REFUND_SUCCESS(6, "退款成功");

    private final int id;
    private final String name;
}
