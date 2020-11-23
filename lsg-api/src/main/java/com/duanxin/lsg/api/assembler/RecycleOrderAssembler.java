package com.duanxin.lsg.api.assembler;

import com.duanxin.lsg.api.dto.RecycleOrderDto;
import com.duanxin.lsg.domain.recycleOrder.entity.RecycleOrderDO;
import org.springframework.beans.BeanUtils;

import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className RecycleOrderAssembler
 * @date 2020/11/23 21:14
 */
public class RecycleOrderAssembler {

    public static RecycleOrderDto toDto(RecycleOrderDO recycleOrder) {
        RecycleOrderDto dto = new RecycleOrderDto();
        BeanUtils.copyProperties(recycleOrder, dto);
        dto.setRecycleOrderStatusName(recycleOrder.getRecycleOrderStatus().getName());
        dto.setRecycleOrderDetailsDtos(recycleOrder.getRecycleOrderDetailsDOS().
                stream().map(RecycleOrderDetailsAssembler::toDto).collect(Collectors.toList()));
        return dto;
    }
}
