package com.euphoria.shop.common.annotation;


import com.euphoria.shop.common.Exception.ApiException;
import com.euphoria.shop.common.annotation.LoginUser;
import com.euphoria.shop.utils.JwtUtil;
import com.euphoria.shop.utils.RedisUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.annotation.Resource;

/**
 * @author: Euphoria
 * @description: @LoginUser注解处理
 * @date: 2022/8/29 16:02
 */
@Configuration
public class LoginResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        //获取当前登录用户
        String authorization = nativeWebRequest.getHeader("token");
        if ("".equals(authorization)) {
            throw new ApiException("token不能为空");
        }
        //从token中拿到userId
        Long userId = JwtUtil.getTokenUserId(authorization);
        return userId;

    }
}