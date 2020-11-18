package com.duanxin.lsg.infrastructure.repository.mapper;

import com.duanxin.lsg.infrastructure.repository.po.UserAccountPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAccountMapper
 * @date 2020/10/08 19:44
 */
public interface UserAccountMapper {
    void insert(@Param("userAccount") UserAccountPO userAccount);

    UserAccountPO selectUserAccountById(@Param("id") Integer userAccountId);

    UserAccountPO selectByUserId(@Param("userId") int userId);
}
