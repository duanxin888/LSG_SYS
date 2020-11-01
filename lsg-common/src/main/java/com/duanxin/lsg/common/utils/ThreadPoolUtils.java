package com.duanxin.lsg.common.utils;

import com.duanxin.lsg.common.module.ThreadPoolProperties;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author duanxin
 * @version 1.0
 * @className ThreadPoolUtils
 * @date 2020/11/01 15:24
 */
@Slf4j
public class ThreadPoolUtils {

    private ThreadPoolUtils() {

    }

    public static ThreadPoolExecutor threadPoolExecutor(ThreadPoolProperties properties) {
        return new ThreadPoolExecutor(properties.getCorePoolSize(),
                properties.getMaximumPoolSize(),
                properties.getKeepAliveTime(),
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(properties.getWorkQueueSize()),
                (execute, r) -> log.info("[{}] thread pool is full and can`t receive tasks", properties.getThreadPoolName()));
    }
}
