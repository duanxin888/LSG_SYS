package com.duanxin.lsg.common.module;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className AddCartsEvent
 * @date 2020/11/01 14:06
 */
@Getter
@Setter
public class AddCartsEvent {

    private int userId;

    private List<CartRequestInfo> cartRequestInfos;
}
