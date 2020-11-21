package com.duanxin.lsg.domain.order.repository.persistence;

import com.duanxin.lsg.domain.order.repository.facade.OrderDetailsRepositoryInterface;
import com.duanxin.lsg.infrastructure.repository.mapper.OrderDetailsMapper;
import com.duanxin.lsg.infrastructure.repository.po.OrderDetailsPO;
import com.duanxin.lsg.infrastructure.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderDetailsRepositoryImpl
 * @date 2020/11/17 21:28
 */
@Service
@Slf4j
public class OrderDetailsRepositoryImpl implements OrderDetailsRepositoryInterface {

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;

    @Override
    public OrderDetailsPO insert(OrderDetailsPO orderDetailsPO) {
        orderDetailsMapper.insert(orderDetailsPO);
        log.info("success to insert orderDetails [{}]", JsonUtil.toString(orderDetailsPO));
        return orderDetailsPO;
    }

    @Override
    public List<OrderDetailsPO> selectByOrderId(int id) {
        return orderDetailsMapper.selectByOrderId(id);
    }
}
