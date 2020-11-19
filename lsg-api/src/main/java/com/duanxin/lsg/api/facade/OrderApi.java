package com.duanxin.lsg.api.facade;

import com.duanxin.lsg.api.assembler.OrderAssembler;
import com.duanxin.lsg.api.dto.OrderDto;
import com.duanxin.lsg.application.service.OrderApplicationService;
import com.duanxin.lsg.domain.order.entity.OrderDO;
import com.duanxin.lsg.infrastructure.common.api.ResponseResult;
import com.duanxin.lsg.infrastructure.common.exception.LSGCheckException;
import com.duanxin.lsg.infrastructure.common.exception.ResultEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderApi
 * @date 2020/11/14 20:35
 */
@RestController
@RequestMapping("/api/v1/orders")
public class OrderApi {

    @Autowired
    private OrderApplicationService orderApplicationService;

    @PostMapping
    public ResponseResult addOrder(@RequestBody OrderDto orderDto) {
        checkDto(orderDto);
        OrderDO orderDO = OrderAssembler.toDO(orderDto);
        orderApplicationService.addOrder(orderDO);
        return ResponseResult.success(OrderAssembler.toDto(orderDO));
    }

    private void checkDto(OrderDto dto) {
        if (Objects.isNull(dto.getUserId())) {
            throw new LSGCheckException(ResultEnum.ORDER_USER_ID_IS_NULL);
        }
        if (Objects.isNull(dto.getTotalPrice())) {
            throw new LSGCheckException(ResultEnum.ORDER_TOTAL_PRICE_IS_NULL);
        }
        if (CollectionUtils.isEmpty(dto.getOrderDetailsDtos())) {
            throw new LSGCheckException(ResultEnum.ORDER_DETAILS_IS_EMPTY);
        }
        if (StringUtils.isBlank(dto.getConsignee())) {
            throw new LSGCheckException(ResultEnum.ORDER_CONSIGNEE_IS_BLANK);
        }
        if (StringUtils.isBlank(dto.getPhone())) {
            throw new LSGCheckException(ResultEnum.ORDER_PHONE_IS_BLANK);
        }
        if (StringUtils.isBlank(dto.getAddress())) {
            throw new LSGCheckException(ResultEnum.ORDER_ADDRESS_IS_BLANK);
        }
    }
}
