package com.duanxin.lsg.domain.recycleOrder.service.impl;

import com.duanxin.lsg.domain.recycleOrder.entity.RecycleOrderDO;
import com.duanxin.lsg.domain.recycleOrder.entity.RecycleOrderDetailsDO;
import com.duanxin.lsg.domain.recycleOrder.repository.facade.RecycleOrderDetailsRepositoryInterface;
import com.duanxin.lsg.domain.recycleOrder.repository.facade.RecycleOrderRepositoryInterface;
import com.duanxin.lsg.domain.recycleOrder.service.RecycleOrderDomainService;
import com.duanxin.lsg.infrastructure.client.ISBNClient;
import com.duanxin.lsg.infrastructure.client.entity.AlISBNResult;
import com.duanxin.lsg.infrastructure.common.exception.LSGCheckException;
import com.duanxin.lsg.infrastructure.common.exception.ResultEnum;
import com.duanxin.lsg.infrastructure.repository.po.RecycleOrderDetailsPO;
import com.duanxin.lsg.infrastructure.repository.po.RecycleOrderPO;
import com.duanxin.lsg.infrastructure.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className RecycleOrderDomainServiceImpl
 * @date 2020/11/22 17:54
 */
@Service
@Slf4j
public class RecycleOrderDomainServiceImpl implements RecycleOrderDomainService {

    @Autowired
    private RecycleOrderRepositoryInterface recycleOrderRepository;
    @Autowired
    private RecycleOrderDetailsRepositoryInterface recycleOrderDetailsRepository;
    @Autowired
    private RecycleOrderFactory recycleOrderFactory;
    @Autowired
    private ISBNClient isbnClient;

    @Override
    @Transactional
    public RecycleOrderDetailsDO addRecycleBook(int userId, String isbn) {
        log.info("begin to add user [{}] RecycleBook by isbn [{}]", userId, isbn);
        RecycleOrderPO po = recycleOrderRepository.selectByUserId(userId);
        RecycleOrderDO recycleOrderDO = null;
        if (Objects.isNull(po)) {
            // insert order
            recycleOrderDO = new RecycleOrderDO();
            recycleOrderDO.create(userId);
            po = recycleOrderRepository.insert(recycleOrderFactory.createRecycleOrderPO(recycleOrderDO));
            recycleOrderDO.setId(po.getId());
        } else {
            recycleOrderDO = recycleOrderFactory.createRecycleOrderDO(po);
        }

        // check isbn of recycleOrderDetails
        checkISBNOfDetails(isbn, recycleOrderDO.getId());

        // fetch book info
        Optional<AlISBNResult> bookInfo = isbnClient.getBookInfo(isbn);
        if (!bookInfo.isPresent()) {
            log.warn("fail to fetch user [{}] isbn [{}]", userId, isbn);
            throw new LSGCheckException(ResultEnum.RECYCLE_BOOK_GET_USERINFO_BY_ISBN_ERROR);
        }
        // insert details
        RecycleOrderDetailsDO recycleOrderDetailsDO = new RecycleOrderDetailsDO();
        recycleOrderDetailsDO.create(recycleOrderDO.getId(), bookInfo.get());
        recycleOrderDetailsRepository.insert(recycleOrderFactory.creRecycleOrderDetailsPO(recycleOrderDetailsDO));
        log.info("success to add user [{}] RecycleBook [{}] by isbn [{}]",
                userId, JsonUtil.toString(recycleOrderDetailsDO), isbn);
        return recycleOrderDetailsDO;
    }

    @Override
    public RecycleOrderDO getRecyclingOrders(int userId) {
        RecycleOrderPO po = recycleOrderRepository.selectByUserId(userId);
        if (Objects.isNull(po)) {
            return null;
        }
        RecycleOrderDO recycleOrderDO = recycleOrderFactory.createRecycleOrderDO(po);
        List<RecycleOrderDetailsPO> detailsPOS = recycleOrderDetailsRepository.selectByOrderId(recycleOrderDO.getId());
        if (CollectionUtils.isEmpty(detailsPOS)) {
            return null;
        }
        recycleOrderDO.addDetails(detailsPOS.stream().
                map(recycleOrderFactory::creRecycleOrderDetailsDO).collect(Collectors.toList()));
        return recycleOrderDO;
    }

    @Override
    public List<RecycleOrderDO> getRecycledOrders(int userId) {
        List<RecycleOrderPO> recycleOrderPOS = recycleOrderRepository.selectOrdersByUserId(userId);
        if (CollectionUtils.isEmpty(recycleOrderPOS)) {
            return Collections.emptyList();
        }
        List<RecycleOrderDO> orderDOS = recycleOrderPOS.stream().
                map(recycleOrderFactory::createRecycleOrderDO).collect(Collectors.toList());
        orderDOS.forEach(order -> order.addDetails(recycleOrderDetailsRepository.selectByOrderId(order.getId()).
                stream().map(recycleOrderFactory::creRecycleOrderDetailsDO).collect(Collectors.toList())));
        return orderDOS;
    }

    private void checkISBNOfDetails(String isbn, int recycleOrderId) {
        RecycleOrderDetailsPO po = recycleOrderDetailsRepository.selectByISBNAndOrderId(isbn, recycleOrderId);
        if (!Objects.isNull(po)) {
            log.info("check isbn [{}] existed recycle order[{}]", isbn, recycleOrderId);
            throw new LSGCheckException(ResultEnum.RECYCLE_BOOK_ISBN_EXISTED_ORDER);
        }
    }
}
