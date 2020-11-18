package com.duanxin.lsg.domain.order.repository.persistence;

import com.duanxin.lsg.domain.order.repository.facade.UserOrderRepositoryInterface;
import com.duanxin.lsg.infrastructure.repository.mapper.UserOrderMapper;
import com.duanxin.lsg.infrastructure.repository.po.UserOrderPO;
import com.duanxin.lsg.infrastructure.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className UserOrderRepositoryImpl
 * @date 2020/11/14 22:09
 */
@Service
@Slf4j
public class UserOrderRepositoryImpl implements UserOrderRepositoryInterface {

    @Autowired
    private UserOrderMapper userOrderMapper;

    @Override
    public UserOrderPO insert(UserOrderPO userOrderPO) {
        userOrderMapper.insert(userOrderPO);
        log.info("success to insert user order [{}]", JsonUtil.toString(userOrderPO));
        return userOrderPO;
    }
}
