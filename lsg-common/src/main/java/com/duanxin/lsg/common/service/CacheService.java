package com.duanxin.lsg.common.service;

import java.time.Duration;

/**
 * @author duanxin
 * @version 1.0
 * @className CacheService
 * @date 2020/10/08 09:32
 */
public interface CacheService {
    void cache(String k, String value, Duration ttl, String... args);
}
