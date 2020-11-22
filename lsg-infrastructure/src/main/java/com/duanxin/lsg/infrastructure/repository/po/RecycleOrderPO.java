package com.duanxin.lsg.infrastructure.repository.po;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className RecycleOrderPO
 * @date 2020/11/22 17:32
 */
@Setter
@Getter
public class RecycleOrderPO {

    private int id;

    private String recycleOrderSn;

    private int userId;

    private int recycleStatusId;

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
}
