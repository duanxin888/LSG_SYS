package com.duanxin.lsg.common.config;

import com.duanxin.lsg.common.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author duanxin
 * @version 1.0
 * @className WebConfig
 * @date 2020/10/10 21:50
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).
                excludePathPatterns("/api/v1/users/login").
                excludePathPatterns("/api/v1/books/**").
                excludePathPatterns("/api/v1/carts/**");
    }
}
