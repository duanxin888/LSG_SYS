package com.duanxin.lsg.infrastructure.repository.mapper;

import com.duanxin.lsg.infrastructure.repository.po.RecycleOrderPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author duanxin
 * @version 1.0
 * @className RecycleOrderMapper
 * @date 2020/11/22 17:35
 */
public interface RecycleOrderMapper {
    RecycleOrderPO selectByUserId(@Param("userId") int userId);

    void insert(@Param("recycleOrderPO") RecycleOrderPO recycleOrderPO);
}
