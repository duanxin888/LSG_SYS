package com.duanxin.lsg.infrastructure.config;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className RestClientProperties
 * @date 2020/10/05 09:46
 */
@Setter
@Getter
@Builder
public class RestClientConfig {

    /**
     * 最大连接数
     * */
    private int maxTotal;

    /**
     * 单个路由最大连接数
     * */
    private int defaultMaxPerRoute;

    /**
     * 连接服务器最长超时时间
     * */
    private int connectTimeout;

    /**
     * 连接池获取连接超时时间
     * */
    private int connectionRequestTimeout;

    /**
     * 服务器返回数据超时时间
     * */
    private int socketTimeout;

    /**
     * 最大空闲时间
     * */
    private int validateAfterInactivity;
}
