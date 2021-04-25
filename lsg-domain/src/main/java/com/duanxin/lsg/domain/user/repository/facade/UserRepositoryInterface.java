package com.duanxin.lsg.domain.user.repository.facade;


import com.duanxin.lsg.domain.user.entity.UserDO;
import com.duanxin.lsg.infrastructure.repository.po.UserPO;
import com.github.pagehelper.PageInfo;

/**
 * @author duanxin
 * @version 1.0
 * @className UserService
 * @date 2020/10/06 09:13
 */
public interface UserRepositoryInterface {

    UserPO getUserByOpenId(String openId);

    UserPO insert(UserPO user);

    UserPO updateWXSessionKey(UserPO user);

    UserPO selectByPrimaryId(int userId);

    PageInfo<UserDO> pageUser(int pageNum, int pageSize);
}
