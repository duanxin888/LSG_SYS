package com.duanxin.lsg.core.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className LSGBaseException
 * @date 2020/09/30 09:13
 */
public class LSGBaseException extends RuntimeException{
    private static final long serialVersionUID = 1997278138515098842L;

    @Getter
    @Setter
    private ResultEnum resultEnum;

    public LSGBaseException(ResultEnum resultEnum) {
        super(resultEnum.getDescription());
        this.resultEnum = resultEnum;
    }
}
