package com.duanxin.lsg.common.module;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className DeleteCartsEvent
 * @date 2020/11/01 14:08
 */
@Setter
@Getter
public class DeleteCartsEvent{

    private int userId;

    private List<CartRequestInfo> cartRequestInfos;
}
