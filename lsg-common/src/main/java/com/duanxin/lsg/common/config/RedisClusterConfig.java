package com.duanxin.lsg.common.config;

import com.duanxin.lsg.core.enums.CacheTypeEnum;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author duanxin
 * @version 1.0
 * @className RedisClusterConfig
 * @date 2020/10/08 08:47
 */
@Configuration
public class RedisClusterConfig {

    @Value("${redis.cluster.url}")
    private String[] clusterUrls;
    @Value("${redis.cluster.password}")
    private String clusterPassword;
    @Value("${redis.cluster.max-Idle}")
    private int clusterMaxIdle;
    @Value("${redis.cluster.min-Idle}")
    private int clusterMinIdle;
    @Value("${redis.cluster.max-total}")
    private int clusterMaxTotal;
    @Value("${redis.cluster.shutdown-timeout}")
    private int clusterShutdownTimeout;
    @Value("${redis.cluster.command-timeout}")
    private int clusterCommandTimeout;

    @Bean
    public RedisConnectionFactory connectionFactory(LettucePoolingClientConfiguration clientConfiguration) {
        Set<String> clusterHostAndPorts = new HashSet<>();
        Collections.addAll(clusterHostAndPorts, clusterUrls);
        RedisClusterConfiguration clusterConfig = new RedisClusterConfiguration(clusterHostAndPorts);
        clusterConfig.setPassword(RedisPassword.of(clusterPassword));
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(clusterConfig, clientConfiguration);
        lettuceConnectionFactory.setValidateConnection(true);
        return lettuceConnectionFactory;
    }

    @Bean
    public LettucePoolingClientConfiguration clientConfiguration() {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxIdle(clusterMaxIdle);
        poolConfig.setMinIdle(clusterMinIdle);
        poolConfig.setMaxTotal(clusterMaxTotal);
        return LettucePoolingClientConfiguration
                .builder()
                .commandTimeout(Duration.ofSeconds(clusterCommandTimeout))
                .shutdownTimeout(Duration.ofSeconds(clusterShutdownTimeout))
                .poolConfig(poolConfig)
                .build();
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
        Stream<CacheTypeEnum> stream = Stream.of(CacheTypeEnum.values());
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = jackson2JsonRedisSerializer();
        stream.forEach(t -> {
            RedisCacheConfiguration tempConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                    .entryTtl(t.getTtl()).prefixKeysWith(t.getPrefix()).serializeValuesWith(RedisSerializationContext
                            .SerializationPair.fromSerializer(jackson2JsonRedisSerializer));
            redisCacheConfigurationMap.put(t.name(), tempConfiguration);
        });
        return new RedisCacheManager(redisCacheWriter, redisCacheConfigurationMap.get(CacheTypeEnum.DEFAULT.name()),
                redisCacheConfigurationMap);

    }

    private Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer() {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer =
                new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.configure(MapperFeature.USE_ANNOTATIONS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.registerModule(new JavaTimeModule());
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        return jackson2JsonRedisSerializer;
    }

    @Bean
    public StringRedisTemplate redisTemplate(RedisConnectionFactory connectionFactory) {
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory);
        Jackson2JsonRedisSerializer jsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        redisTemplate.setValueSerializer(jsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jsonRedisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}

