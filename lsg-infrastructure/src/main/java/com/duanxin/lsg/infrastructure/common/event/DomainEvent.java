package com.duanxin.lsg.infrastructure.common.event;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author duanxin
 * @version 1.0
 * @className DomainEvent
 * @date 2020/11/06 20:15
 */
@Getter
@Setter
public class DomainEvent {
    String id;
    Date timestamp;
    String source;
    String data;
}
