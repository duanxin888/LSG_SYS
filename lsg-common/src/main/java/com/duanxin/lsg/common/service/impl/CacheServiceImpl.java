package com.duanxin.lsg.common.service.impl;

import com.duanxin.lsg.common.service.CacheService;
import com.duanxin.lsg.common.utils.JsonUtil;
import com.duanxin.lsg.core.enums.CacheTypeEnum;
import com.duanxin.lsg.core.enums.ConstantEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Optional;

/**
 * @author duanxin
 * @version 1.0
 * @className CacheServiceImpl
 * @date 2020/10/08 09:32
 */
@Service
@Slf4j
public class CacheServiceImpl implements CacheService {

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
