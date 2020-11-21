package com.duanxin.lsg.infrastructure.configuration;

import com.duanxin.lsg.infrastructure.config.ThreadPoolConfig;
import com.duanxin.lsg.infrastructure.utils.ThreadPoolUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author duanxin
 * @version 1.0
 * @className ThreadPoolConfig
 * @date 2020/11/01 15:31
 */
@Configuration
public class ThreadPoolConfiguration {

}
