package com.duanxin.lsg.domain.recycleOrder.entity;

import com.duanxin.lsg.domain.recycleOrder.entity.valueobject.RecycleBookInfo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className RecycleOrderDetailsDO
 * @date 2020/11/22 17:48
 */
@Setter
@Getter
public class RecycleOrderDetailsDO {

    private int id;

    private int recycleOrderId;

    private RecycleBookInfo recycleBookInfo;

    private int bookLevelId;

    private int deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
