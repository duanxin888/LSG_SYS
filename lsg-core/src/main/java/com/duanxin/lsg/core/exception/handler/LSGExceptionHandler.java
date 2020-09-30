package com.duanxin.lsg.core.exception.handler;

import com.duanxin.lsg.core.base.ResponseResult;
import com.duanxin.lsg.core.exception.LSGBaseException;
import com.duanxin.lsg.core.exception.ResultEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author duanxin
 * @version 1.0
 * @className LSGExceptionHandler
 * @date 2020/09/30 09:16
 */
@ControllerAdvice
public class LSGExceptionHandler {

    @ExceptionHandler(LSGBaseException.class)
    @ResponseBody
    public ResponseResult lsgBaseExceptionHandler(LSGBaseException exception) {
        ResultEnum resultEnum = exception.getResultEnum();
        return ResponseResult.error(resultEnum.getCode(), resultEnum.getDescription());
    }
}
