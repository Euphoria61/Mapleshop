package com.euphoria.shop.common.Exception;

import lombok.Data;

/**
 * @author: Euphoria
 * @description: 自定义异常
 * @date: 2022/8/29 16:02
 */

@Data
public class ApiException extends RuntimeException {
    private ResultCode resultCode;
    private int code;
    private  String msg;
    public ApiException() {
    }
    public ApiException(String message) {
        super(message);
    }

    public ApiException(ResultCode resultCode) {
        this.code =resultCode.getCode();
        this.msg =resultCode.getMessage();
    }
}
