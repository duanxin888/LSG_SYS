package com.duanxin.lsg.infrastructure.repository.mapper;

import com.duanxin.lsg.infrastructure.repository.po.OrderDetailsPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderDetailsMapper
 * @date 2020/10/12 22:31
 */
public interface OrderDetailsMapper {

    void insert(@Param("orderDetailsPO") OrderDetailsPO orderDetailsPO);
}
