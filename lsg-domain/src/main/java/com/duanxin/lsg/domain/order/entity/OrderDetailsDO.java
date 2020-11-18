package com.duanxin.lsg.domain.order.entity;

import com.duanxin.lsg.infrastructure.common.enums.ConstantEnum;
import com.duanxin.lsg.infrastructure.common.enums.Deleted;
import com.duanxin.lsg.infrastructure.repository.po.OrderDetailsPO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderDetailsDO
 * @date 2020/11/14 22:00
 */
@Getter
@Setter
public class OrderDetailsDO {

    private int id;

    private int orderId;

    private int bookId;

    private String bookName;

    private String bookPicUrl;

    private int bookLevelId;

    private int quantity;

    private BigDecimal price;

    private Deleted deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;

    public OrderDetailsDO create(int orderId) {
        this.setOrderId(orderId);
        this.setDeleted(Deleted.NOT_DELETE);
        this.setCdate(LocalDateTime.now());
        this.setCreator(ConstantEnum.CREATOR.getKey());
        this.setEdate(LocalDateTime.now());
        this.setEditor(ConstantEnum.CREATOR.getKey());
        return this;
    }
}
