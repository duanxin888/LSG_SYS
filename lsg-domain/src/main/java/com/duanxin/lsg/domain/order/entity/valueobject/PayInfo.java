package com.duanxin.lsg.domain.order.entity.valueobject;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className PayInfo
 * @date 2020/11/14 22:05
 */
@Setter
@Getter
@Builder
public class PayInfo {

    private String paySn;

    private String payType;

    private LocalDateTime payTime;
}
