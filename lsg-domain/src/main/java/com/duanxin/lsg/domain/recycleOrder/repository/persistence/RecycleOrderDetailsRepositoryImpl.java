package com.duanxin.lsg.domain.recycleOrder.repository.persistence;

import com.duanxin.lsg.domain.recycleOrder.repository.facade.RecycleOrderDetailsRepositoryInterface;
import com.duanxin.lsg.infrastructure.repository.mapper.RecycleOrderDetailsMapper;
import com.duanxin.lsg.infrastructure.repository.po.RecycleOrderDetailsPO;
import com.duanxin.lsg.infrastructure.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className RecycleOrderDetailsRepositoryImpl
 * @date 2020/11/22 17:53
 */
@Service
@Slf4j
public class RecycleOrderDetailsRepositoryImpl implements RecycleOrderDetailsRepositoryInterface {

    @Autowired
    private RecycleOrderDetailsMapper recycleOrderDetailsMapper;

    @Override
    public RecycleOrderDetailsPO insert(RecycleOrderDetailsPO creRecycleOrderDetailsPO) {
        recycleOrderDetailsMapper.insert(creRecycleOrderDetailsPO);
        log.info("success to insert RecycleOrderDetails [{}]", JsonUtil.toString(creRecycleOrderDetailsPO));
        return creRecycleOrderDetailsPO;
    }

    @Override
    public RecycleOrderDetailsPO selectByISBNAndOrderId(String isbn, int recycleOrderId) {
        return recycleOrderDetailsMapper.selectByISBNAndOrderId(isbn, recycleOrderId);
    }

    @Override
    public List<RecycleOrderDetailsPO> selectByOrderId(int recycleOrderId) {
        return recycleOrderDetailsMapper.selectByOrderId(recycleOrderId);
    }
}
