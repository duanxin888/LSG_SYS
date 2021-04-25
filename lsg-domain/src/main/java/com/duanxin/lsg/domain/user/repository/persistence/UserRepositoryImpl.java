package com.duanxin.lsg.domain.user.repository.persistence;

import com.duanxin.lsg.domain.user.entity.UserDO;
import com.duanxin.lsg.domain.user.repository.facade.UserAccountRepositoryInterface;
import com.duanxin.lsg.domain.user.repository.facade.UserAddressRepositoryInterface;
import com.duanxin.lsg.domain.user.repository.facade.UserRepositoryInterface;
import com.duanxin.lsg.domain.user.service.impl.UserFactory;
import com.duanxin.lsg.infrastructure.common.exception.LSGCheckException;
import com.duanxin.lsg.infrastructure.common.exception.ResultEnum;
import com.duanxin.lsg.infrastructure.repository.mapper.UserMapper;
import com.duanxin.lsg.infrastructure.repository.po.UserAccountPO;
import com.duanxin.lsg.infrastructure.repository.po.UserPO;
import com.duanxin.lsg.infrastructure.utils.HttpUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    @Autowired
    private UserAccountRepositoryInterface userAccountRepositoryInterface;
    @Autowired
    private UserFactory userFactory;

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
        UserPO userPO = userMapper.selectByPrimaryKey(userId);
        if (Objects.isNull(userPO)) {
            throw new LSGCheckException(ResultEnum.USER_NOT_EXIST);
        }
        return userPO;
    }

    @Override
    public PageInfo<UserDO> pageUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserPO> pos = userMapper.selectAll();
        List<UserDO> userDOS =
                pos.stream().map(userFactory::createUserDO).collect(Collectors.toList());
        userDOS.forEach(user -> {
            UserAccountPO accountPO = userAccountRepositoryInterface.selectByUserId(user.getId());
            user.setUserAccount(userFactory.createUserAccountDO(accountPO));
        });
        return new PageInfo<>(userDOS);
    }
}
