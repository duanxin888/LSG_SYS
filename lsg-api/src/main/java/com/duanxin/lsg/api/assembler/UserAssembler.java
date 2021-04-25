package com.duanxin.lsg.api.assembler;

import com.duanxin.lsg.api.dto.UserInfo;
import com.duanxin.lsg.api.dto.UserPageResponseDto;
import com.duanxin.lsg.domain.user.entity.UserDO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;

import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAssembler
 * @date 2021/04/25 09:42
 */
public class UserAssembler {

    private UserAssembler() {
    }

    public static UserPageResponseDto do2PageResponseDto(PageInfo<UserDO> pageInfo) {
        UserPageResponseDto dto = new UserPageResponseDto();
        dto.setPageNum(pageInfo.getPageNum());
        dto.setPageSize(pageInfo.getPageSize());
        dto.setPages(pageInfo.getPages());
        dto.setUserInfos(pageInfo.getList().stream().
                map(UserAssembler::do2UserInfo).collect(Collectors.toList()));
        return dto;
    }

    private static UserInfo do2UserInfo(UserDO userDO) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userDO.getUserAccount(), userInfo);
        userInfo.setUserId(userDO.getId());
        userInfo.setNickName(userDO.getUserName());
        userInfo.setAvatarUrl(userDO.getUserImgUrl());
        userInfo.setGender(userDO.getGender().getCode());
        return userInfo;
    }
}
