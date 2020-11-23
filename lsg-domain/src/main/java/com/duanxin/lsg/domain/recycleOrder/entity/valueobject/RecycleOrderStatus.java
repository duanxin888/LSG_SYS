package com.duanxin.lsg.domain.recycleOrder.entity.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className RecycleOrderStatus
 * @date 2020/11/22 17:45
 */
@AllArgsConstructor
@Getter
public enum RecycleOrderStatus {

    RECYCLING(1, "回收中"),
    COMPLETED(2, "已完成"),
    CANCELLED(3, "已取消");

    private final int id;
    private final String name;

    public static RecycleOrderStatus formatById(int id) {
        for (RecycleOrderStatus value : values()) {
            if (value.getId() == id) {
                return value;
            }
        }
        return null;
    }
}
