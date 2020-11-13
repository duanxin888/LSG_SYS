package com.duanxin.lsg.infrastructure.client.impl;

import com.duanxin.lsg.infrastructure.client.RedisCacheClient;
import com.duanxin.lsg.infrastructure.common.enums.CacheTypeEnum;
import com.duanxin.lsg.infrastructure.common.enums.ConstantEnum;
import com.duanxin.lsg.infrastructure.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

/**
 * @author duanxin
 * @version 1.0
 * @className CacheServiceImpl
 * @date 2020/10/08 09:32
 */
@Service
@Slf4j
public class RedisCacheClientImpl implements RedisCacheClient {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void refreshCache(CacheTypeEnum typeEnum, Object value, String... args) {
        String key = generateKey(typeEnum.getPrefix(), args);
        try {
            redisTemplate.boundValueOps(key).set(JsonUtil.toString(value), typeEnum.getTtl());
        } catch (Exception ex) {
            log.warn("refresh cache key [{}] exception", key, ex);
        }
    }

    @Override
    public void refreshCache(String key, Object value, Duration ttl, String... args) {
        key = generateKey(key, args);
        if (StringUtils.isBlank(key)) {
            return ;
        }
        try {
            redisTemplate.boundValueOps(key).set(JsonUtil.toString(value), ttl);
        } catch (Exception ex) {
            log.warn("refresh cache key [{}] exception", key, ex);
        }
    }

    @Override
    public <T> Optional<T> getValue(String key, Class<T> cls, String... args) {
        key = generateKey(key, args);
        if (StringUtils.isBlank(key)) {
            return Optional.empty();
        }
        String value = redisTemplate.boundValueOps(key).get();
        if (StringUtils.isBlank(value)) {
            return Optional.empty();
        }
        return JsonUtil.toObject(value, cls);
    }

    @Override
    public <T> Optional<List<T>> getValueList(String key, Class<T> cls, String... args) {
        key = generateKey(key, args);
        if (StringUtils.isBlank(key)) {
            return Optional.empty();
        }
        String value = redisTemplate.boundValueOps(key).get();
        if (StringUtils.isBlank(value)) {
            return Optional.empty();
        }
        return JsonUtil.toObjectList(value, cls);
    }

    @Override
    public boolean removeCache(String key, String... args) {
        key = generateKey(key, args);
        return redisTemplate.delete(key);
    }

    private String generateKey(String k, String[] args) {
        if (StringUtils.isAllBlank(args)) {
            return k;
        }
        StringBuilder sb = new StringBuilder(k);
        for (String s : args) {
            sb.append(ConstantEnum.CACHE_SEP.getKey()).append(s);
        }
        return sb.toString();
    }
}
