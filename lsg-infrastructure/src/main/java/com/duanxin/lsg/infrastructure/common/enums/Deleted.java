package com.duanxin.lsg.infrastructure.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className DeletedEnum
 * @date 2020/10/08 19:52
 */
@Getter
@AllArgsConstructor
public enum Deleted {
    NOT_DELETE(0, "没有删除"),
    IS_DELETED(1, "逻辑删除");

    private final int code;
    private final String description;

    public static Deleted format(int code) {
        for (Deleted value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        return NOT_DELETE;
    }
}
