package com.duanxin.lsg.common.config;

import com.duanxin.lsg.common.module.ThreadPoolProperties;
import com.duanxin.lsg.common.utils.ThreadPoolUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author duanxin
 * @version 1.0
 * @className ThreadPoolConfig
 * @date 2020/11/01 15:31
 */
@Configuration
public class ThreadPoolConfig {

    @Bean("eventTaskThreadPoolProperties")
    @ConfigurationProperties(prefix = "event.task")
    public ThreadPoolProperties eventTaskThreadPoolProperties() {
        return new ThreadPoolProperties();
    }

    @Bean("eventTaskThreadPool")
    public ThreadPoolExecutor eventTaskThreadPool(@Qualifier("eventTaskThreadPoolProperties")
                                                          ThreadPoolProperties properties) {
        return ThreadPoolUtils.threadPoolExecutor(properties);
    }
}
