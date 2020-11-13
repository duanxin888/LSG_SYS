package com.duanxin.lsg.infrastructure.common.api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author duanxin
 * @version 1.0
 * @className ResponseResult
 * @date 2020/09/30 08:56
 */
@Setter
@Getter
public class ResponseResult implements Serializable {
    private static final long serialVersionUID = 9077823876702897338L;

    private int code = 200;
    private Object data;
    private String msg;

    private ResponseResult() {}

    public static ResponseResult success() {
        ResponseResult result = new ResponseResult();
        result.setMsg("operator success!");
        return result;
    }

    public static ResponseResult success(Object data) {
        ResponseResult result = new ResponseResult();
        result.setMsg("operator success!");
        result.setData(data);
        return result;
    }

    public static ResponseResult error(int code, String msg, Object data) {
        ResponseResult result = new ResponseResult();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static ResponseResult error(int code, String msg) {
        return error(code, msg, null);
    }

    public static ResponseResult error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static ResponseResult error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "unknown error, please contact the administrator");
    }
}
