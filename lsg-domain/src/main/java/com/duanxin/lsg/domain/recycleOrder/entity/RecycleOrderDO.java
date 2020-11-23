package com.duanxin.lsg.domain.recycleOrder.entity;

import com.duanxin.lsg.domain.recycleOrder.entity.valueobject.RecycleOrderStatus;
import com.duanxin.lsg.infrastructure.common.enums.ConstantEnum;
import com.duanxin.lsg.infrastructure.common.enums.Deleted;
import com.duanxin.lsg.infrastructure.utils.SnUtil;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className RecycleOrderDO
 * @date 2020/11/22 17:44
 */
@Setter
@Getter
public class RecycleOrderDO {

    private int id;

    private String recycleOrderSn;

    private int userId;

    private RecycleOrderStatus recycleOrderStatus;

    private LocalDateTime recycleTime;

    private String shipSn;

    private String shipChannel;

    private LocalDateTime shipTime;

    private LocalDateTime verifyTime;

    private int deleted;

    private LocalDateTime cdate;

    private LocalDateTime edate;

    private String creator;

    private String editor;

    private List<RecycleOrderDetailsDO> recycleOrderDetailsDOS;

    public void create(int userId) {
        this.setUserId(userId);
        this.setRecycleOrderSn(SnUtil.generateRecycleOrderSn(userId));
        this.setRecycleOrderStatus(RecycleOrderStatus.RECYCLING);
        this.setDeleted(Deleted.NOT_DELETE.getCode());
        this.setCdate(LocalDateTime.now());
        this.setCreator(ConstantEnum.CREATOR.getKey());
        this.setEdate(LocalDateTime.now());
        this.setEditor(ConstantEnum.CREATOR.getKey());
    }

    public void addDetails(List<RecycleOrderDetailsDO> orderDetailsDOS) {
        this.setRecycleOrderDetailsDOS(orderDetailsDOS);
    }
}
