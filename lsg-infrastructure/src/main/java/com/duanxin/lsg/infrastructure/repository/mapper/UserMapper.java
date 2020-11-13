package com.duanxin.lsg.infrastructure.repository.mapper;

import com.duanxin.lsg.infrastructure.repository.po.UserPO;
import org.apache.ibatis.annotations.Param;

/**
 * 用户表(TUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-03 09:35:45
 */
public interface UserMapper {

    UserPO getUserByOpenId(@Param("openId") String openId);

    void insert(@Param("user") UserPO user);

    void updateWXSessionKey(@Param("user") UserPO user);

    UserPO selectByPrimaryKey(@Param("id") int userId);
}