package com.duanxin.lsg.application.service;

import com.duanxin.lsg.domain.recycleOrder.entity.RecycleOrderDO;
import com.duanxin.lsg.domain.recycleOrder.entity.RecycleOrderDetailsDO;
import com.duanxin.lsg.domain.recycleOrder.service.RecycleOrderDomainService;
import com.duanxin.lsg.domain.user.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className RecycleOrderApplicationService
 * @date 2020/11/22 17:55
 */
@Service
public class RecycleOrderApplicationService {

    @Autowired
    private RecycleOrderDomainService recycleOrderDomainService;
    @Autowired
    private UserDomainService userDomainService;

    public RecycleOrderDetailsDO addRecycleBook(int userId, String isbn) {
        checkUserExisted(userId);
        return recycleOrderDomainService.addRecycleBook(userId, isbn);
    }

    public RecycleOrderDO getRecyclingOrders(int userId) {
        checkUserExisted(userId);
        return recycleOrderDomainService.getRecyclingOrders(userId);
    }

    public List<RecycleOrderDO> getRecycledOrders(int userId) {
        checkUserExisted(userId);
        return recycleOrderDomainService.getRecycledOrders(userId);
    }

    private void checkUserExisted(int userId) {
        userDomainService.getUserById(userId);
    }
}
