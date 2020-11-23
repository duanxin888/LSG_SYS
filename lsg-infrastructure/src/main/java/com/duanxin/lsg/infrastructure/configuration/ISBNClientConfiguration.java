package com.duanxin.lsg.infrastructure.configuration;

import com.duanxin.lsg.infrastructure.config.ISBNRequestConfig;
import com.duanxin.lsg.infrastructure.config.RestClientConfig;
import com.duanxin.lsg.infrastructure.utils.RestClientUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author duanxin
 * @version 1.0
 * @className RestClientConfiguration
 * @date 2020/11/22 21:41
 */
@Configuration
public class ISBNClientConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "isbn.al.url")
    public ISBNRequestConfig isbnRequestConfig() {
        return new ISBNRequestConfig();
    }

    @Bean("alISBNRestClientConfig")
    @ConfigurationProperties(prefix = "isbn.al.request")
    public RestClientConfig alISBNRestClientConfig() {
        return new RestClientConfig();
    }

    @Bean("alISBNRestTemplate")
    public RestTemplate alISBNRestTemplate(@Qualifier("alISBNRestClientConfig") RestClientConfig config) {
        return RestClientUtil.restTemplate(config);
    }
}
