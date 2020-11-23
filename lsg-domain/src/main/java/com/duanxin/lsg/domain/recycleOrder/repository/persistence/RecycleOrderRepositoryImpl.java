package com.duanxin.lsg.domain.recycleOrder.repository.persistence;

import com.duanxin.lsg.domain.recycleOrder.repository.facade.RecycleOrderRepositoryInterface;
import com.duanxin.lsg.infrastructure.repository.mapper.RecycleOrderMapper;
import com.duanxin.lsg.infrastructure.repository.po.RecycleOrderPO;
import com.duanxin.lsg.infrastructure.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className RecycleOrderRepositoryImpl
 * @date 2020/11/22 17:52
 */
@Service
@Slf4j
public class RecycleOrderRepositoryImpl implements RecycleOrderRepositoryInterface {

    @Autowired
    private RecycleOrderMapper recycleOrderMapper;

    @Override
    public RecycleOrderPO selectByUserId(int userId) {
        return recycleOrderMapper.selectByUserId(userId);
    }

    @Override
    public RecycleOrderPO insert(RecycleOrderPO recycleOrderPO) {
        recycleOrderMapper.insert(recycleOrderPO);
        log.info("success to insert RecycleOrder [{}]", JsonUtil.toString(recycleOrderPO));
        return recycleOrderPO;
    }

    @Override
    public List<RecycleOrderPO> selectOrdersByUserId(int userId) {
        return recycleOrderMapper.selectOrdersByUserId(userId);
    }
}
