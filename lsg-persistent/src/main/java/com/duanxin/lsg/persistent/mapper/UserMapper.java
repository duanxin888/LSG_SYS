package com.duanxin.lsg.persistent.mapper;

import com.duanxin.lsg.persistent.module.User;
import org.apache.ibatis.annotations.Param;

/**
 * 用户表(TUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-03 09:35:45
 */
public interface UserMapper {

    User getUserByOpenId(@Param("openId") String openId);

    void insert(@Param("user") User user);

    void updateWXSessionKey(@Param("user") User user);

    User selectByPrimaryKey(@Param("id") int userId);
}