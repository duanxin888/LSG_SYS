package com.duanxin.lsg.common.service;

import com.duanxin.lsg.core.enums.CacheTypeEnum;

import java.time.Duration;
import java.util.Optional;

/**
 * @author duanxin
 * @version 1.0
 * @className CacheService
 * @date 2020/10/08 09:32
 */
public interface CacheService {
    void refreshCache(CacheTypeEnum typeEnum, Object value, String... args);

    void refreshCache(String key, Object value, Duration ttl, String... args);

    <T> Optional<T> getValue(String key, Class<T> cls, String... args);
}
