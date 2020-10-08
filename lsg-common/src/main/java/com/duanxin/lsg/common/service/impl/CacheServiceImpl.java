package com.duanxin.lsg.common.service.impl;

import com.duanxin.lsg.common.service.CacheService;
import com.duanxin.lsg.core.enums.ConstantEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

/**
 * @author duanxin
 * @version 1.0
 * @className CacheServiceImpl
 * @date 2020/10/08 09:32
 */
@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void cache(String k, String value, Duration ttl, String... args) {
        String key = generateKey(k, args);
        if (StringUtils.isBlank(key)) {
            key = ConstantEnum.CACHE_DEFAULT_KEY.getKey();
        }
        redisTemplate.boundValueOps(key).setIfAbsent(value);
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
