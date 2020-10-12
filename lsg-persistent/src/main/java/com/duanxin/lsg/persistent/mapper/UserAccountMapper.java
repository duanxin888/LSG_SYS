package com.duanxin.lsg.persistent.mapper;

import com.duanxin.lsg.persistent.module.UserAccount;
import org.apache.ibatis.annotations.Param;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAccountMapper
 * @date 2020/10/08 19:44
 */
public interface UserAccountMapper {
    void insert(@Param("userAccount") UserAccount userAccount);

    UserAccount selectUserAccountById(@Param("id") Integer userAccountId);
}
