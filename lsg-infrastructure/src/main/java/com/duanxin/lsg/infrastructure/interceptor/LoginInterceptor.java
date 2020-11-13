package com.duanxin.lsg.infrastructure.interceptor;

import com.duanxin.lsg.infrastructure.client.RedisCacheClient;
import com.duanxin.lsg.infrastructure.client.impl.RedisCacheClientImpl;
import com.duanxin.lsg.infrastructure.common.api.ResponseResult;
import com.duanxin.lsg.infrastructure.common.exception.ResultEnum;
import com.duanxin.lsg.infrastructure.utils.HttpUtil;
import com.duanxin.lsg.infrastructure.utils.JsonUtil;
import com.duanxin.lsg.infrastructure.utils.SpringContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author duanxin
 * @version 1.0
 * @className LoginInterceptor
 * @date 2020/10/10 21:31
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userIp = HttpUtil.request().getRemoteAddr();
        try {
            String thirdSession = HttpUtil.getDataFromRequest("token");
            log.info("verify whether the user [{}] is logged in", userIp);
            RedisCacheClient redisCacheClient = SpringContext.getBean(RedisCacheClientImpl.class);
            if (StringUtils.isBlank(thirdSession) ||
                    !redisCacheClient.getValue(thirdSession, String.class).isPresent()) {
                responseJson(response, ResultEnum.USER_NOT_LOG_IN);
                log.info("user [{}] not login", userIp);
                return false;
            }
        } catch (Exception ex) {
            log.warn("check user [{}] login exception", userIp, ex);
            return false;
        }
        return true;
    }

    private void responseJson(HttpServletResponse response, ResultEnum resultEnum) throws IOException {
        response.setContentType("application/json,charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(JsonUtil.toString(ResponseResult.error(resultEnum.getCode(), resultEnum.getDescription())));
        writer.flush();
        writer.close();
    }
}
