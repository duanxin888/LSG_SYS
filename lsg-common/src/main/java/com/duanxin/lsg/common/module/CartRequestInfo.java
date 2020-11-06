package com.duanxin.lsg.common.module;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className CartRequestInfo
 * @date 2020/10/25 11:02
 */
@Setter
@Getter
@EqualsAndHashCode(exclude = "quantity")
public class CartRequestInfo {

    private int bookId;

    private int bookLevelId;

    private int quantity;
}
