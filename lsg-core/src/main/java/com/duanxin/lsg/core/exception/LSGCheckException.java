package com.duanxin.lsg.core.exception;

/**
 * @author duanxin
 * @version 1.0
 * @className LSGCheckException
 * @date 2020/10/10 22:18
 */
public class LSGCheckException extends LSGBaseException {
    public LSGCheckException(ResultEnum resultEnum) {
        super(resultEnum);
    }
}
