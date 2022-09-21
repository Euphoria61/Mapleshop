//package com.euphoria.shop.security.filter;
//
//import com.baomidou.mybatisplus.core.toolkit.StringUtils;
//import com.euphoria.shop.entity.LoginUser;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.InternalAuthenticationServiceException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//
//import java.util.Objects;
//
///**
// * @author: Euphoria
// * @description: TODO
// * @date: 2022/9/10 10:24
// */
//@Slf4j
//@Component
//public class MobileAuthenticationProvider implements AuthenticationProvider {
//    @Autowired
//    @Qualifier("MobileUserDetailsServiceImpl")
//    private UserDetailsService userDetailsService;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        MobileCodeLoginToken token = (MobileCodeLoginToken) authentication;
//        String mobile = (String)token.getPrincipal();
//        //todo 首先，验证验证码是否正确
//        //String code = (String)token.getCredentials();
//        //if(StringUtils.isEmpty(code) ){
//        //    throw new BadCredentialsException("手机验证码错误(Bad credentials)，请重试！");
//        //}
//        //然后，查询对应用户
//        LoginUser user = (LoginUser) userDetailsService.loadUserByUsername(mobile);
//        log.info("查到用户名为{}",user.getUsername());
//        if (Objects.isNull(user)) {
//            throw new InternalAuthenticationServiceException("根据手机号：" + mobile + "，无法获取对应的用户信息！");
//         }
//        MobileCodeLoginToken authenticationResult = new MobileCodeLoginToken(user.getAuthorities(),user,"123456789");
//        authenticationResult.setDetails(token.getDetails());
//        return authenticationResult;
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return MobileCodeLoginToken.class.isAssignableFrom(authentication);
//    }
//    public UserDetailsService getUserDetailsService() {
//        return userDetailsService;
//    }
//
//    public void setUserDetailsService(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//}
