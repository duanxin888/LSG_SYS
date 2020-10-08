package com.duanxin.lsg.common.service.impl;

import com.duanxin.lsg.common.service.UserService;
import com.duanxin.lsg.common.utils.HttpUtil;
import com.duanxin.lsg.core.enums.ConstantEnum;
import com.duanxin.lsg.persistent.mapper.UserMapper;
import com.duanxin.lsg.persistent.module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className UserServiceImpl
 * @date 2020/10/06 09:13
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByOpenId(String openId) {
        return userMapper.getUserByOpenId(openId);
    }

    @Override
    public User insert(User user) {
        user.setCdate(LocalDateTime.now());
        user.setCreator(ConstantEnum.CREATOR.getKey());
        user.setEdate(LocalDateTime.now());
        user.setEditor(ConstantEnum.CREATOR.getKey());
        userMapper.insert(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        user.setEdate(LocalDateTime.now());
        user.setEditor(HttpUtil.request().getRemoteAddr());
        userMapper.updateWXSessionKey(user);
        return user;
    }
}
