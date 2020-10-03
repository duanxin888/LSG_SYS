package com.duanxin.lsg.common.aspect;

import com.duanxin.lsg.common.utils.HttpUtil;
import com.duanxin.lsg.common.utils.JsonUtil;
import com.duanxin.lsg.core.exception.LSGBaseException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

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
        log.info("request uri [{}] method [{}] args {}",
                uri, methodName, args);
        // process
        Object res = null;
        try {
            res = point.proceed();
        } catch (LSGBaseException ex) {
            log.warn("request uri [{}] method [{}] args {} exception",
                    uri, methodName, args, ex);
            throw ex;
        }catch (Exception ex) {
            log.error("request uri [{}] method [{}] args {} exception",
                    uri, methodName, args, ex);
            throw ex;
        }
        // response
        long end = System.currentTimeMillis();
        String result = JsonUtil.toString(res);
        log.info("response uri [{}] spend {}s method [{}] result [{}]",
                uri, (end - start) / 1000, methodName, StringUtils.substring(result, 0, 2000));
        return res;
    }
}
