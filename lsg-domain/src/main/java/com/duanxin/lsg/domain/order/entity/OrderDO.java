package com.duanxin.lsg.domain.order.entity;

import com.duanxin.lsg.domain.order.entity.valueobject.OrderStatus;
import com.duanxin.lsg.domain.order.entity.valueobject.PayInfo;
import com.duanxin.lsg.domain.order.entity.valueobject.ShipInfo;
import com.duanxin.lsg.domain.order.entity.valueobject.UserInfo;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderDO
 * @date 2020/11/14 21:14
 */
@Setter
@Getter
public class OrderDO {

    private int id;

    private UserInfo userInfo;

    private String orderSn;

    private BigDecimal totalPrice;

    private int totalQuantity;

    private OrderStatus orderStatus;

    private ShipInfo shipInfo;

    private PayInfo payInfo;

    private LocalDateTime orderCloseTime;

    private int deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;

    private List<OrderDetailsDO> orderDetailsDOS;
}
