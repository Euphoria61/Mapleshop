package com.euphoria.shop.common.Exception;

/**
 * @author: Euphoria
 * @description: 返回码
 * @date: 2022/8/29 16:02
 */
public enum ResultCode {

    SUCCESS(200, "操作成功"),

    TOKEN_VALIDATE_FAILED(400, "token验证失败"),
    UNAUTHORIZED(401, "token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    USER_NON_EXISTENT(405, "登录用户不存在"),
    USER_PWD_ERROR(406, "用户名或密码错误"),
    USER_EXIST(407,"用户名已存在"),
    VALIDATE_FAILED(408, "参数验证失败"),

    FAILED(500, "操作失败"),
    SERVICE_UNAVAILABLE(503, "服务器错误");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
