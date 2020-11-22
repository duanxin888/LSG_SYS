package com.duanxin.lsg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author duanxin
 * @version 1.0
 * @className LSGServerApplication
 * @date 2020/09/30 14:16
 */
@SpringBootApplication
@MapperScan("com.duanxin.lsg.infrastructure.repository.mapper")
@EnableCaching
@EnableAsync
@EnableScheduling
public class LSGServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LSGServerApplication.class, args);
    }
}
