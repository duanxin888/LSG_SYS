package com.duanxin.lsg.domain.recycleOrder.entity;

import com.duanxin.lsg.domain.recycleOrder.entity.valueobject.RecycleOrderStatus;
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
}
