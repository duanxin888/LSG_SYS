package com.duanxin.lsg.domain.user.entity.valueobject;

import com.duanxin.lsg.infrastructure.common.enums.AddressAcquiescenceEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className AddressAcquiescence
 * @date 2020/11/15 20:22
 */
@AllArgsConstructor
@Getter
public enum AddressAcquiescence {

    IS_ACQUIESCENCE(0, AddressAcquiescenceEnum.DEFAULT),
    NOT_ACQUIESCENCE(1, AddressAcquiescenceEnum.DENY);

    private final int code;
    private final AddressAcquiescenceEnum acquiescence;

    public static AddressAcquiescence format(AddressAcquiescenceEnum acquiescence) {
        for (AddressAcquiescence value : values()) {
            if (acquiescence.equals(value.acquiescence)) {
                return value;
            }
        }
        return IS_ACQUIESCENCE;
    }
}
