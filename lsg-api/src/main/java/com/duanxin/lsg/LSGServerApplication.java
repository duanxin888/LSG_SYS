package com.duanxin.lsg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author duanxin
 * @version 1.0
 * @className LSGServerApplication
 * @date 2020/09/30 14:16
 */
@SpringBootApplication
@MapperScan("com.duanxin.lsg.persistent.mapper")
public class LSGServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LSGServerApplication.class, args);
    }
}
