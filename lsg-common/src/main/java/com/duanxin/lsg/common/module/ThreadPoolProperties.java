package com.duanxin.lsg.common.module;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className ThreadPoolProperties
 * @date 2020/11/01 15:10
 */
@Getter
@Setter
public class ThreadPoolProperties {

    private int corePoolSize;

    private int maximumPoolSize;

    private int keepAliveTime;

    private int workQueueSize;

    private String threadPoolName;
}
