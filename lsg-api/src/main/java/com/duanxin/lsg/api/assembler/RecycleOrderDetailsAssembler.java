package com.duanxin.lsg.api.assembler;

import com.duanxin.lsg.api.dto.RecycleOrderDetailsDto;
import com.duanxin.lsg.domain.recycleOrder.entity.RecycleOrderDetailsDO;
import org.springframework.beans.BeanUtils;

/**
 * @author duanxin
 * @version 1.0
 * @className RecycleOrderDetailsAssembler
 * @date 2020/11/23 19:46
 */
public class RecycleOrderDetailsAssembler {

    public static RecycleOrderDetailsDto toDto(RecycleOrderDetailsDO recycleOrderDetails) {
        RecycleOrderDetailsDto dto = new RecycleOrderDetailsDto();
        BeanUtils.copyProperties(recycleOrderDetails, dto);
        BeanUtils.copyProperties(recycleOrderDetails.getRecycleBookInfo(), dto);
        return dto;
    }
}
