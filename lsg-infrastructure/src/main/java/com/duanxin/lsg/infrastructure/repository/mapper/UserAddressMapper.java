package com.duanxin.lsg.infrastructure.repository.mapper;

import com.duanxin.lsg.infrastructure.repository.po.UserAddressPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAddressMapper
 * @date 2020/11/15 19:30
 */
public interface UserAddressMapper {
    void insert(@Param("userAddress") UserAddressPO userAddressPO);

    UserAddressPO selectDefaultUserAddress(@Param("userId") int userId);
}
