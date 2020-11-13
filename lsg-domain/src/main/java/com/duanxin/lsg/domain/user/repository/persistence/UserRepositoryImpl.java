package com.duanxin.lsg.domain.user.repository.persistence;

import com.duanxin.lsg.domain.user.repository.facade.UserRepositoryInterface;
import com.duanxin.lsg.infrastructure.repository.mapper.UserMapper;
import com.duanxin.lsg.infrastructure.repository.po.UserPO;
import com.duanxin.lsg.infrastructure.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UserRepositoryImpl implements UserRepositoryInterface {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserPO getUserByOpenId(String openId) {
        return userMapper.getUserByOpenId(openId);
    }

    @Override
    public UserPO insert(UserPO user) {
        userMapper.insert(user);
        log.info("success to insert user [{}]", user.getId());
        return user;
    }

    @Override
    public UserPO updateWXSessionKey(UserPO user) {
        user.setEdate(LocalDateTime.now());
        user.setEditor(HttpUtil.request().getRemoteAddr());
        userMapper.updateWXSessionKey(user);
        log.info("success to update user [{}] wxSessionKey", user.getId());
        return user;
    }

    @Override
    public UserPO selectByPrimaryId(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
