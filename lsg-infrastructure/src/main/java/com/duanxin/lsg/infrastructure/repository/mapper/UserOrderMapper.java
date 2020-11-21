package com.duanxin.lsg.infrastructure.repository.mapper;

import com.duanxin.lsg.infrastructure.repository.po.UserOrderPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author duanxin
 * @version 1.0
 * @className BookMapper
 * @date 2020/10/12 22:31
 */
public interface UserOrderMapper {
    void insert(@Param("userOrderPO") UserOrderPO userOrderPO);

    void updateForPay(@Param("userOrderPO") UserOrderPO userOrderPO);

    UserOrderPO selectByOrderSn(@Param("orderSn") String orderSn);
}
