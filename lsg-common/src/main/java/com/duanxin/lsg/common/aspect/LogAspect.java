package com.duanxin.lsg.common.aspect;

import com.duanxin.lsg.common.utils.HttpUtil;
import com.duanxin.lsg.common.utils.JsonUtil;
import com.duanxin.lsg.core.exception.LSGCheckException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.UUID;

/**
 * @author duanxin
 * @version 1.0
 * @className LogAspect
 * @date 2020/10/03 10:01
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(public * com.duanxin.lsg.*.controller.*.*(..))")
    public void log(){}

    @Around("log()")
    public Object doLog(ProceedingJoinPoint point) throws Throwable {
        // request
        long start = System.currentTimeMillis();
        HttpServletRequest request = HttpUtil.request();
        String args = JsonUtil.toString(Arrays.asList(point.getArgs()));
        String uri = request.getRequestURI();
        String methodName = point.getSignature().getName();
        String requestId = UUID.randomUUID().toString();
        log.info("request uri [{}] requestId [{}] method [{}] args {}",
                uri, requestId, methodName, args);
        // process
        Object res = null;
        try {
            res = point.proceed();
        } catch (LSGCheckException ex) {
            log.warn("request uri [{}] requestId [{}] method [{}] args {}",
                    uri, requestId, methodName, args, ex);
            throw ex;
        }catch (Exception ex) {
            log.error("request uri [{}] requestId [{}] method [{}] args {}",
                    uri, requestId, methodName, args, ex);
            throw ex;
        }
        // response
        long end = System.currentTimeMillis();
        String result = JsonUtil.toString(res);
        log.info("response uri [{}] requestId [{}] spend [{}s] method [{}] result [{}]",
                uri, requestId, (end - start) / 1000, methodName, StringUtils.substring(result, 0, 2000));
        return res;
    }
}
