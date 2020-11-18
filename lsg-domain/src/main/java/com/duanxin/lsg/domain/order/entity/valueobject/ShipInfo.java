package com.duanxin.lsg.domain.order.entity.valueobject;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className ShipInfo
 * @date 2020/11/14 22:04
 */
@Setter
@Getter
@Builder
public class ShipInfo {

    private BigDecimal freightPrice;

    private String shipSn;

    private String shipChannel;

    private LocalDateTime shipTime;
}
