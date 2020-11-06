package com.duanxin.lsg.api.module;

import com.duanxin.lsg.common.module.CartRequestInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className AddBook2CartRequest
 * @date 2020/10/24 16:39
 */
@Setter
@Getter
public class AddBook2CartRequestDto {

    private int userId;

    private List<CartRequestInfo> cartInfos;
}
