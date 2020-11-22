package com.duanxin.lsg.infrastructure.client.impl;

import com.duanxin.lsg.infrastructure.client.LockClient;
import com.duanxin.lsg.infrastructure.common.enums.ConstantEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import sun.security.pkcs11.wrapper.Constants;

import java.time.Duration;

/**
 * @author duanxin
 * @version 1.0
 * @className RedisLockClientImpl
 * @date 2020/11/21 14:50
 */
@Service
@Slf4j
public class RedisLockClientImpl implements LockClient {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean getJobLock(String key, Duration ttl, String... params) {
        key = generateKey(key, params);
        try {
            return redisTemplate.boundValueOps(key).setIfAbsent("existed", ttl);
        } catch (Exception ex) {
            log.info("failed to get [{}] job lock", key, ex);
            return false;
        }
    }

    @Override
    public boolean releaseLock(String key, String... params) {
        key = generateKey(key, params);
        try {
            return redisTemplate.delete(key);
        } catch (Exception ex) {
            log.info("failed to release [{}] job lock", key, ex);
            return false;
        }
    }

    private String generateKey(String key, String... params) {
        if (StringUtils.isAllBlank(params)) {
            return key;
        }
        return new StringBuilder(key).
                append(ConstantEnum.CACHE_SEP.getKey()).
                append(StringUtils.join(params, ConstantEnum.CACHE_SEP.getKey())).
                toString();
    }
}
