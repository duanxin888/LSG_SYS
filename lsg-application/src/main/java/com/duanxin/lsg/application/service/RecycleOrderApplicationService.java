package com.duanxin.lsg.application.service;

import com.duanxin.lsg.domain.recycleOrder.entity.RecycleOrderDetailsDO;
import com.duanxin.lsg.domain.recycleOrder.service.RecycleOrderDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public RecycleOrderDetailsDO addRecycleBook(int userId, String isbn) {
        return recycleOrderDomainService.addRecycleBook(userId, isbn);
    }
}
