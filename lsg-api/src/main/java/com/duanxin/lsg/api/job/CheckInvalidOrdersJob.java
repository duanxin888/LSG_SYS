package com.duanxin.lsg.api.job;

import java.util.concurrent.Future;
import java.time.Duration;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import com.duanxin.lsg.application.service.BookApplicationService;
import com.duanxin.lsg.application.service.OrderApplicationService;
import com.duanxin.lsg.domain.order.entity.OrderDO;
import com.duanxin.lsg.infrastructure.client.LockClient;
import com.duanxin.lsg.infrastructure.client.RedisCacheClient;
import com.duanxin.lsg.infrastructure.client.impl.RedisLockClientImpl;
import com.duanxin.lsg.infrastructure.common.enums.ConstantEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className CheckInvalidOrdersJob
 * @date 2020/11/21 11:17
 */
@Component
@Slf4j
public class CheckInvalidOrdersJob {

    @Autowired
    private OrderApplicationService orderApplicationService;
    @Autowired
    @Qualifier("checkInvalidOrdersThreadPool")
    private ThreadPoolExecutor executor;
    @Autowired
    private LockClient lockClient;

    @Scheduled(cron = "${check.invalid.orders.job}")
    public void checkInvalidOrdersJob() {
        log.info("begin to execute checkInvalidOrdersJob");
        long start = System.currentTimeMillis();
        // get invalid orders
        List<OrderDO> orderDOS = orderApplicationService.getInvalidOrders(LocalDateTime.now().minusMinutes(30L));
        List<Future<Boolean>> futures = orderDOS.stream().
                filter(order -> lockClient.getJobLock(ConstantEnum.CHECK_INVALID_ORDERS_LOCK.getKey(),
                        Duration.ofMinutes(5L),
                        String.valueOf(order.getUserInfo().getUserId()),
                        String.valueOf(order.getId()))).
                map(order -> executor.submit(() -> executeTask(order))).
                collect(Collectors.toList());
        for (Future<Boolean> future : futures) {
            while (!future.isDone()) ;
        }
        log.info("success to spend {{}ms} execute checkInvalidOrders [{}]",
                System.currentTimeMillis() - start, orderDOS.size());
    }

    private Boolean executeTask(OrderDO orderDO) {
        // async execute to update order status, restore stock
        try {
            orderApplicationService.updateInvalidOrder(orderDO);
        } catch (Exception ex) {
            log.warn("fail to execute check invalid order sn [{}] status [{}]",
                    orderDO.getOrderSn(), orderDO.getOrderStatus(), ex);
        } finally {
            lockClient.releaseLock(ConstantEnum.CHECK_INVALID_ORDERS_LOCK.getKey(),
                    String.valueOf(orderDO.getUserInfo().getUserId()),
                    String.valueOf(orderDO.getId()));
        }
        return true;
    }
}
