package com.euphoria.shop.common.Exception;

import com.euphoria.shop.common.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Euphoria
 * @description: 全局异常
 * @date: 2022/8/29 16:02
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = ApiException.class)
    @ResponseBody
    public ResultInfo<?> ApiExceptionHandler(ApiException e) {
        return ResultInfo.failed(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseBody
    public ResultInfo<?> AccessDeniedExceptionHandler(AccessDeniedException e) {
        return ResultInfo.failed(ResultCode.FORBIDDEN);
    }

    @ExceptionHandler(value = AuthenticationServiceException.class)
    @ResponseBody
    public ResultInfo<?> AuthenticationServiceException(AuthenticationServiceException e) {
        System.out.println("出错");
        return ResultInfo.failed(e.getMessage());
    }
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultInfo<?> exceptionHandler(Exception e) {
        return ResultInfo.failed(e.getMessage());
    }
}
