package com.duanxin.lsg.infrastructure.repository.mapper;

import com.duanxin.lsg.infrastructure.repository.po.RecycleOrderDetailsPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className RecycleOrderDetailsMapper
 * @date 2020/11/22 17:41
 */
public interface RecycleOrderDetailsMapper {
    void insert(@Param("recycleOrderDetailsPO") RecycleOrderDetailsPO recycleOrderDetailsPO);

    RecycleOrderDetailsPO selectByISBNAndOrderId(@Param("isbn") String isbn,
                                                 @Param("recycleOrderId") int recycleOrderId);

    List<RecycleOrderDetailsPO> selectByOrderId(@Param("recycleOrderId") int recycleOrderId);
}
