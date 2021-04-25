package com.duanxin.lsg.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className UserPageResponseDto
 * @date 2021/04/25 09:38
 */
@Setter
@Getter
public class UserPageResponseDto {

    private int pageNum;

    private int pageSize;

    private int pages;

    private List<UserInfo> userInfos;
}
