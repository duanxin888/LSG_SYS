package com.duanxin.lsg.infrastructure.client;

import java.time.Duration;

/**
 * @author duanxin
 * @version 1.0
 * @className LockService
 * @date 2020/11/21 14:47
 */
public interface LockClient {

    boolean getJobLock(String key, Duration ttl, String... params);

    boolean releaseLock(String key, String... params);
}
