package com.duanxin.lsg.common.utils;

import com.duanxin.lsg.common.module.RestClientProperties;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author duanxin
 * @version 1.0
 * @className RestClientUtil
 * @date 2020/10/05 09:39
 */
public class RestClientUtil {

    private RestClientUtil(){
    }

    public static RestTemplate restTemplate(RestClientProperties properties) {
        return new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient(properties)));
    }

    private static HttpClient httpClient(RestClientProperties properties) {
        Registry<ConnectionSocketFactory> factoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager(factoryRegistry);
        manager.setMaxTotal(properties.getMaxTotal());
        manager.setDefaultMaxPerRoute(properties.getDefaultMaxPerRoute());
        manager.setValidateAfterInactivity(properties.getValidateAfterInactivity());
        RequestConfig requestConfig = RequestConfig.custom().
                setSocketTimeout(properties.getSocketTimeout()).
                setConnectTimeout(properties.getConnectTimeout()).
                setConnectionRequestTimeout(properties.getConnectionRequestTimeout()).
                build();
        return HttpClientBuilder.create().
                setDefaultRequestConfig(requestConfig).
                setConnectionManager(manager).
                build();
    }
}
