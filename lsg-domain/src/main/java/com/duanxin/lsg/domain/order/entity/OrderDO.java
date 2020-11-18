package com.duanxin.lsg.domain.order.entity;

import com.duanxin.lsg.domain.order.entity.valueobject.OrderStatus;
import com.duanxin.lsg.domain.order.entity.valueobject.PayInfo;
import com.duanxin.lsg.domain.order.entity.valueobject.ShipInfo;
import com.duanxin.lsg.domain.order.entity.valueobject.UserInfo;
import com.duanxin.lsg.infrastructure.common.enums.ConstantEnum;
import com.duanxin.lsg.infrastructure.common.enums.Deleted;
import com.duanxin.lsg.infrastructure.utils.SnUtil;
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

    private Deleted deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;

    private List<OrderDetailsDO> orderDetailsDOS;

    public OrderDO create() {
        this.setOrderSn(SnUtil.generateOrderSn(this.getUserInfo().getUserId()));
        this.setOrderStatus(OrderStatus.SUBMIT_SUCCESS);
        this.setDeleted(Deleted.NOT_DELETE);
        this.setCdate(LocalDateTime.now());
        this.setCreator(ConstantEnum.CREATOR.getKey());
        this.setEdate(LocalDateTime.now());
        this.setEditor(ConstantEnum.CREATOR.getKey());
        return this;
    }

    public boolean checkPrice() {
        BigDecimal addPrice = this.getOrderDetailsDOS().stream().map(orderDetails ->
                orderDetails.getPrice().multiply(BigDecimal.valueOf(orderDetails.getQuantity()))).
                reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2);
        return addPrice.equals(this.getTotalPrice());
    }
}
