package com.duanxin.lsg.domain.order.entity.valueobject;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className UserInfo
 * @date 2020/11/14 22:02
 */
@Setter
@Getter
@Builder
public class UserInfo {

    private int userId;

    private String consignee;

    private String phone;

    private String address;

    private String message;

    private LocalDateTime confirmTime;

    private LocalDateTime refundTime;
}
