package com.euphoria.shop.security.filter;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.euphoria.shop.common.Exception.ApiException;
import com.euphoria.shop.common.Exception.ResultCode;
import com.euphoria.shop.entity.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author: Euphoria
 * @description: 用户名登录验证
 * @date: 2022/9/10 10:24
 */
@Slf4j
@Component
public class UserNameAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    @Qualifier("UserDetailsServiceImpl")
    private UserDetailsService userDetailsService;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String userName = (String)token.getPrincipal();
        //todo 首先，验证验证码是否正确
        String password = (String)token.getCredentials();
        if(StringUtils.isEmpty(password) || StringUtils.isEmpty(password)){
            throw new ApiException("用户名或密码为空，请重试！");
        }
        //然后，查询对应用户
        LoginUser user = (LoginUser) userDetailsService.loadUserByUsername(userName);
        log.info("查到用户名为{}",user.getUsername());
//        if (Objects.isNull(user) || !passwordEncoder.matches(password,user.getPassword())) {
//            throw new ApiException(ResultCode.USER_PWD_ERROR);
//         }
        MobileCodeLoginToken authenticationResult = new MobileCodeLoginToken(user,  token.getCredentials(),user.getAuthorities());
        authenticationResult.setDetails(token.getDetails());
        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

}
