package com.euphoria.shop.common;

import com.euphoria.shop.common.Exception.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultInfo<T> {
    /**
     * 状态码
     */
    private long code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 数据封装
     */
    private T data;

    /**
     * 操作成功
     */
    public static <T> ResultInfo<T> success() {
        return new ResultInfo<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    /**
     * 操作成功返回结果 (成功常常返回数据而不返回提示)
     *
     * @param data 获取的数据
     */
    public static <T> ResultInfo<T> success(T data) {
        return new ResultInfo<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }


    /**
     * 操作成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> ResultInfo<T> success(T data, String message) {
        return new ResultInfo<T>(ResultCode.SUCCESS.getCode(), message, data);
    }



    /**
     * 操作失败
     */
    public static <T> ResultInfo<T> failed() {
        return new ResultInfo<T>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(), null);
    }

    /**
     * 操作失败返回结果 (失败常常返回错误信息而不返回数据)
     *
     * @param message 错误信息
     */
    public static <T> ResultInfo<T> failed(String message) {
        return new ResultInfo<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 操作失败返回结果 (失败常常返回错误信息而不返回数据)
     *
     * @param resultCode 错误码
     */
    public static <T> ResultInfo<T> failed(ResultCode resultCode) {
        return new ResultInfo<T>(resultCode.getCode(), resultCode.getMessage(), null);
    }





    /**
     * 操作失败返回结果
     * @param data    返回的数据
     * @param message 错误信息
     */
    public static <T> ResultInfo<T> failed(T data, String message) {
        return new ResultInfo<T>(ResultCode.FAILED.getCode(), message, data);
    }




    /**
     * 操作失败返回结果
     *
     * @param code    错误代码
     * @param data    返回的数据
     * @param message 错误信息
     */
    public static <T> ResultInfo<T> failed(Integer code, T data, String message) {
        return new ResultInfo<T>(code, message, data);
    }

    /**
     * 参数验证失败
     */
    public static <T> ResultInfo<T> validateFailed() {
        return new ResultInfo<T>(ResultCode.VALIDATE_FAILED.getCode(), ResultCode.VALIDATE_FAILED.getMessage(), null);
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 错误信息
     */
    public static <T> ResultInfo<T> validateFailed(String message) {
        return new ResultInfo<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录
     */
    public static <T> ResultInfo<T> unauthorized() {
        return new ResultInfo<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), null);
    }

    /**
     * 未登录返回结果
     *
     * @param message 错误信息
     */
    public static <T> ResultInfo<T> unauthorized(String message) {
        return new ResultInfo<T>(ResultCode.UNAUTHORIZED.getCode(), message, null);
    }

    /**
     * 访问权限不够
     */
    public static <T> ResultInfo<T> forbidden() {
        return new ResultInfo<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), null);
    }

    /**
     * 访问权限不够返回结果
     *
     * @param message 错误信息
     */
    public static <T> ResultInfo<T> forbidden(String message) {
        return new ResultInfo<T>(ResultCode.FORBIDDEN.getCode(), message, null);
    }

    /**
     * 服务器异常
     */
    public static <T> ResultInfo<T> serviceUnavailable() {
        return new ResultInfo<T>(ResultCode.SERVICE_UNAVAILABLE.getCode(), ResultCode.SERVICE_UNAVAILABLE.getMessage(), null);
    }

    /**
     * 服务器异常返回结果
     *
     * @param message 错误信息
     */
    public static <T> ResultInfo<T> serviceUnavailable(String message) {
        return new ResultInfo<T>(ResultCode.SERVICE_UNAVAILABLE.getCode(), message, null);
    }

}
