package com.duanxin.lsg.infrastructure.repository.mapper;

import com.duanxin.lsg.infrastructure.repository.po.UserAddressPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAddressMapper
 * @date 2020/11/15 19:30
 */
public interface UserAddressMapper {
    void insert(@Param("userAddress") UserAddressPO userAddressPO);

    UserAddressPO selectDefaultUserAddress(@Param("userId") int userId);

    List<UserAddressPO> selectUserAddressList(@Param("userId") int userId);

    void updateUserAddressAcquiescence(@Param("id") int id,
                                       @Param("acquiescence") int acquiescence);
}
