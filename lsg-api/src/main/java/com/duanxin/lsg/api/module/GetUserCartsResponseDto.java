package com.duanxin.lsg.api.module;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className GetUserCartsResponseDto
 * @date 2020/10/29 11:07
 */
@Setter
@Getter
public class GetUserCartsResponseDto {

    private int userId;

    private List<UserCartsResponseInfo> userCartsResponseInfos;
}
