package com.duanxin.lsg.api.facade;

import com.duanxin.lsg.api.assembler.UserAddressAssembler;
import com.duanxin.lsg.api.assembler.WxLoginAssembler;
import com.duanxin.lsg.api.dto.UserAddressDto;
import com.duanxin.lsg.api.dto.WXLoginRequestDto;
import com.duanxin.lsg.application.service.LoginApplicationService;
import com.duanxin.lsg.application.service.UserApplicationService;
import com.duanxin.lsg.domain.user.entity.UserDO;
import com.duanxin.lsg.infrastructure.common.api.ResponseResult;
import com.duanxin.lsg.infrastructure.common.exception.LSGCheckException;
import com.duanxin.lsg.infrastructure.common.exception.ResultEnum;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author duanxin
 * @version 1.0
 * @className UserController
 * @date 2020/10/06 08:29
 */
@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UserApi {

    @Autowired
    private LoginApplicationService loginApplicationService;
    @Autowired
    private UserApplicationService userApplicationService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody WXLoginRequestDto wxLoginRequestDto) {
        // data validate
        if (StringUtils.isBlank(wxLoginRequestDto.getCode()) ||
                Objects.isNull(wxLoginRequestDto.getUserInfo())) {
            log.warn("failed to login with non code or userInfo is null");
            throw new LSGCheckException(ResultEnum.WX_LOGIN_CODE_OR_USERINFO_IS_NULL);
        }
        UserDO userDO = WxLoginAssembler.toDO(wxLoginRequestDto);
        loginApplicationService.wxLogin(userDO, wxLoginRequestDto.getCode());
        return ResponseResult.success(WxLoginAssembler.toDto(userDO));
    }

    @PostMapping("/address")
    public ResponseResult addAddress(@RequestBody UserAddressDto userAddressDto) {
        checkDto(userAddressDto);
        userApplicationService.addAddress(UserAddressAssembler.toDO(userAddressDto));
        return ResponseResult.success();
    }

    private void checkDto(UserAddressDto dto) {
        if (StringUtils.isBlank(dto.getName())) {
            throw new LSGCheckException(ResultEnum.USER_ADDRESS_NAME_IS_BLANK);
        }
        if (Objects.isNull(dto.getUserId())) {
            throw new LSGCheckException(ResultEnum.USER_ADDRESS_USER_ID_IS_NULL);
        }
        if (StringUtils.isBlank(dto.getProvince())) {
            throw new LSGCheckException(ResultEnum.USER_ADDRESS_PROVINCE_IS_BLANK);
        }
        if (StringUtils.isBlank(dto.getCity())) {
            throw new LSGCheckException(ResultEnum.USER_ADDRESS_CITY_IS_BLANK);
        }
        if (StringUtils.isBlank(dto.getCounty())) {
            throw new LSGCheckException(ResultEnum.USER_ADDRESS_COUNTY_IS_BLANK);
        }
        if (StringUtils.isBlank(dto.getAddressDetails())) {
            throw new LSGCheckException(ResultEnum.USER_ADDRESS_ADDRESS_DETAILS_IS_BLANK);
        }
        if (StringUtils.isBlank(dto.getPhone())) {
            throw new LSGCheckException(ResultEnum.USER_ADDRESS_PHONE_IS_BLANK);
        }
        if (Objects.isNull(dto.getAcquiescence())) {
            throw new LSGCheckException(ResultEnum.USER_ADDRESS_ACQUIESCENCE_IS_NULL);
        }
    }
}
