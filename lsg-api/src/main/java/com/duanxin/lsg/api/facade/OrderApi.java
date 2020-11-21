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
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.stream.Collectors;

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
        checkForAdd(orderDto);
        OrderDO orderDO = OrderAssembler.toDO(orderDto);
        orderApplicationService.addOrder(orderDO);
        return ResponseResult.success(OrderAssembler.toDto(orderDO));
    }

    @PutMapping("/pay")
    public ResponseResult payOrder(@RequestBody OrderDto orderDto) {
        checkForPay(orderDto);
        orderApplicationService.payOrder(OrderAssembler.toDO(orderDto));
        return ResponseResult.success();
    }

    @GetMapping("/users/{userId}")
    public ResponseResult getOrders(@PathVariable("userId") int userId) {
        return ResponseResult.success(orderApplicationService.getOrders(userId).
                stream().map(OrderAssembler::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/users/{userId}/orderSn/{orderSn}")
    public ResponseResult getOrder(@PathVariable("userId") int userId,
                                   @PathVariable("orderSn") String orderSn) {
        return ResponseResult.success(OrderAssembler.toDto(orderApplicationService.getOrder(userId, orderSn)));
    }

    private void checkForPay(OrderDto dto) {
        if (Objects.isNull(dto.getUserId())) {
            throw new LSGCheckException(ResultEnum.ORDER_USER_ID_IS_NULL);
        }
        if (StringUtils.isBlank(dto.getOrderSn())) {
            throw new LSGCheckException(ResultEnum.ORDER_SN_IS_BLANK);
        }
        if (StringUtils.isBlank(dto.getOrderStatusName())) {
            throw new LSGCheckException(ResultEnum.ORDER_STATUS_NAME_IS_BLANK);
        }
    }

    private void checkForAdd(OrderDto dto) {
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
