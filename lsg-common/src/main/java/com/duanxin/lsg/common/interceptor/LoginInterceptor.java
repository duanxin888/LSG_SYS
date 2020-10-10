package com.duanxin.lsg.common.interceptor;

import com.duanxin.lsg.common.service.CacheService;
import com.duanxin.lsg.common.service.impl.CacheServiceImpl;
import com.duanxin.lsg.common.utils.HttpUtil;
import com.duanxin.lsg.common.utils.SpringContext;
import com.duanxin.lsg.core.base.ResponseResult;
import com.duanxin.lsg.core.exception.ResultEnum;
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
        try {
            String thirdSession = HttpUtil.getDataFromRequest("token");
            CacheService cacheService = SpringContext.getBean(CacheServiceImpl.class);
            if (StringUtils.isBlank(thirdSession) ||
                    !cacheService.getValue(thirdSession, String.class).isPresent()) {
                responseJson(response, ResultEnum.USER_NOT_LOG_IN);
                return false;
            }
        } catch (Exception ex) {
            log.warn("check user [{}] login exception", request.getRemoteAddr(), ex);
            return false;
        }
        return true;
    }

    private void responseJson(HttpServletResponse response, ResultEnum resultEnum) throws IOException {
        response.setContentType("application/json,charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(ResponseResult.error(resultEnum.getCode(), resultEnum.getDescription()));
        writer.flush();
        writer.close();
    }
}
