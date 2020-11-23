package com.duanxin.lsg.infrastructure.client.impl;

import com.duanxin.lsg.infrastructure.client.ISBNClient;
import com.duanxin.lsg.infrastructure.client.entity.AlISBNResult;
import com.duanxin.lsg.infrastructure.config.ISBNRequestConfig;
import com.duanxin.lsg.infrastructure.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * @author duanxin
 * @version 1.0
 * @className alISBNClientImpl
 * @date 2020/11/22 21:44
 */
@Service
@Slf4j
public class AlISBNClientImpl implements ISBNClient {

    @Autowired
    @Qualifier("alISBNRestTemplate")
    private RestTemplate restTemplate;
    @Autowired
    private ISBNRequestConfig config;

    @Override
    public Optional<AlISBNResult> getBookInfo(String isbn) {
        if (StringUtils.isBlank(isbn)) {
            return Optional.empty();
        }
        log.info("begin to request al isbn service by [{}]", isbn);
        String api = config.getApi();
        LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("is_info", "0");
        params.add("isbn", isbn);
        HttpEntity<String> entity = new HttpEntity<>(null, commonHeader());
        try {
            ResponseEntity<String> exchange = restTemplate.exchange(api + "?isbn=" + isbn,
                    HttpMethod.GET, entity, String.class);
            String body = exchange.getBody();
            if (!exchange.getStatusCode().is2xxSuccessful()) {
                log.warn("failed to fetch isbn [{}] bookInfo, response [{}] status [{}]",
                        isbn, body, exchange.getStatusCode().value());
                return Optional.empty();
            }

            Optional<AlISBNResult> result = JsonUtil.toObject(body, AlISBNResult.class);
            if (!result.isPresent()) {
                log.warn("fail to parse isbn [{}] bookInfo, response [{}] status [{}]",
                        isbn, body, exchange.getStatusCode().value());
                return Optional.empty();
            }
            log.info("success to get bookInfo [{}] by isbn [{}]", body, isbn);
            return result;
        } catch (Exception ex) {
            log.warn("request al isbn service by [{}] exception", isbn, ex);
            return Optional.empty();
        }
    }

    private HttpHeaders commonHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "APPCODE " + config.getAppcode());
        return headers;
    }
}
