package com.duanxin.lsg.infrastructure.common.exception.handler;

import com.duanxin.lsg.infrastructure.common.api.ResponseResult;
import com.duanxin.lsg.infrastructure.common.exception.LSGCheckException;
import com.duanxin.lsg.infrastructure.common.exception.ResultEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author duanxin
 * @version 1.0
 * @className LSGExceptionHandler
 * @date 2020/09/30 09:16
 */
@ControllerAdvice
public class LSGExceptionHandler {

    @ExceptionHandler(LSGCheckException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseResult lsgCheckExceptionHandler(LSGCheckException exception) {
        ResultEnum resultEnum = exception.getResultEnum();
        return ResponseResult.error(resultEnum.getCode(), resultEnum.getDescription());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult exceptionHandle(Exception ex) {
        return ResponseResult.error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage());
    }
}
