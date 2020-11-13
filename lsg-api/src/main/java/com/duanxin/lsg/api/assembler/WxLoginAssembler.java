package com.duanxin.lsg.api.assembler;

import com.duanxin.lsg.api.dto.UserInfo;
import com.duanxin.lsg.api.dto.WXLoginRequestDto;
import com.duanxin.lsg.api.dto.WXLoginResponseDto;
import com.duanxin.lsg.domain.user.entity.UserDO;
import com.duanxin.lsg.domain.user.entity.valueobject.Gender;

/**
 * @author duanxin
 * @version 1.0
 * @className WxLoginAssembler
 * @date 2020/11/07 19:58
 */
public class WxLoginAssembler {

    public static UserDO toDO(WXLoginRequestDto dto) {
        UserDO userDO = new UserDO();
        UserInfo userInfo = dto.getUserInfo();
        userDO.setNickname(userInfo.getNickName());
        userDO.setUserImgUrl(userInfo.getAvatarUrl());
        userDO.setGender(Gender.format(userInfo.getGender()));
        return userDO;
    }

    public static WXLoginResponseDto toDto(UserDO userDO) {
        WXLoginResponseDto dto = new WXLoginResponseDto();
        dto.setThirdSession(userDO.getThirdSession());
        UserInfo info = new UserInfo();
        info.setUserId(userDO.getId());
        info.setAvatarUrl(userDO.getUserImgUrl());
        info.setNickName(userDO.getNickname());
        info.setGender(userDO.getGender().getCode());
        dto.setUserInfo(info);
        dto.setUserBalance(userDO.getUserAccount().getBalance());
        return dto;
    }
}
