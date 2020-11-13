package com.duanxin.lsg.infrastructure.client;


import com.duanxin.lsg.infrastructure.common.enums.CacheTypeEnum;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

/**
 * @author duanxin
 * @version 1.0
 * @className CacheService
 * @date 2020/10/08 09:32
 */
public interface RedisCacheClient {
    void refreshCache(CacheTypeEnum typeEnum, Object value, String... args);

    void refreshCache(String key, Object value, Duration ttl, String... args);

    <T> Optional<T> getValue(String key, Class<T> cls, String... args);

    <T> Optional<List<T>> getValueList(String key, Class<T> cls, String... args);

    boolean removeCache(String key, String... args);
}
