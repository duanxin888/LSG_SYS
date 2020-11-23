package com.duanxin.lsg.api.dto;

import com.duanxin.lsg.domain.recycleOrder.entity.valueobject.RecycleOrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className RecycleOrderDto
 * @date 2020/11/23 21:14
 */
@Setter
@Getter
public class RecycleOrderDto {

    private int id;

    private String recycleOrderSn;

    private int userId;

    private String recycleOrderStatusName;

    private LocalDateTime recycleTime;

    private String shipSn;

    private String shipChannel;

    private LocalDateTime shipTime;

    private LocalDateTime verifyTime;

    private List<RecycleOrderDetailsDto> recycleOrderDetailsDtos;
}
