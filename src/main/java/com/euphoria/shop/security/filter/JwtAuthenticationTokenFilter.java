package com.euphoria.shop.security.filter;

import com.alibaba.fastjson.JSON;
import com.euphoria.shop.common.Exception.ApiException;
import com.euphoria.shop.common.Exception.ResultCode;
import com.euphoria.shop.common.annotation.PassToken;
import com.euphoria.shop.entity.LoginUser;
import com.euphoria.shop.utils.JwtUtil;
import com.euphoria.shop.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @package: com.euphoria.shop.filter
 * @className: JwtAuthenticationTokenFilter
 * @author: Euphoria
 * @description: jwt认证过滤器
 * @date: 2022/8/8 8:32
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private RedisUtil redisUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取请求头中token
        String token = request.getHeader("token");
        if (StringUtils.hasText(token))          {
            Long userId = JwtUtil.getTokenUserId(token);
            //if (userId != null) {
            String redisKey = "userLogin:" + userId;
            if (JwtUtil.isNeedUpdate(token)) {
                LoginUser loginuser = JSON.parseObject(JSON.toJSONString(redisUtil.get(redisKey)), LoginUser.class);
                //取userId，
                //濒死token，过期token刷新
                if (loginuser != null) {
                    String newToken = JwtUtil.refreshToken(token);
                    System.out.println(newToken);
                    Cookie cookie = new Cookie("token", URLEncoder.encode(newToken, "utf-8"));
                    response.addCookie(cookie);
                    //放行
                } else
                //token缓存过期
                {
                    SecurityContextHolder.clearContext();
                    throw new ApiException(ResultCode.UNAUTHORIZED.getMessage());
                }
            } else
                //正常通行
                if (SecurityContextHolder.getContext().getAuthentication() == null) {
                    LoginUser loginuser = JSON.parseObject(JSON.toJSONString(redisUtil.get(redisKey)), LoginUser.class);
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(loginuser, null, loginuser.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
        } else
            //token为空，清空 SecurityContextHolder
            SecurityContextHolder.clearContext();
        filterChain.doFilter(request, response);

    }
}

