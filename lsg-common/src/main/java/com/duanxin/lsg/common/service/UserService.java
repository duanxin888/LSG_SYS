package com.duanxin.lsg.common.service;

import com.duanxin.lsg.persistent.module.User;

/**
 * @author duanxin
 * @version 1.0
 * @className UserService
 * @date 2020/10/06 09:13
 */
public interface UserService {

    User getUserByOpenId(String openId);

    User insert(User user);

    User updateWXSessionKey(User user);

    User selectByPrimaryId(int userId);
}
