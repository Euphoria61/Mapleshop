//package com.euphoria.shop.security.filter;
//
//import com.baomidou.mybatisplus.core.toolkit.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.lang.Nullable;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationServiceException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.ArrayList;
//
///**
// * @author: Euphoria
// * @description: 手机号登录filter
// * @date: 2022/9/9 21:23
// */
//@Component
//public class MobileCodeTokenFilter extends AbstractAuthenticationProcessingFilter {
//    public static final String SPRING_SECURITY_FORM_MOBILE_KEY = "userName";
//    public static final String SPRING_SECURITY_FORM_CODE_KEY = "password";
//    private static final AntPathRequestMatcher DEFAULT_ANT_PATH_REQUEST_MATCHER = new AntPathRequestMatcher("/user/login", "POST");
//    private String mobileParameter = SPRING_SECURITY_FORM_MOBILE_KEY;
//    private String passwordParameter = SPRING_SECURITY_FORM_CODE_KEY;
//    private boolean postOnly = true;
//
//    public MobileCodeTokenFilter() {
//        super(DEFAULT_ANT_PATH_REQUEST_MATCHER);
//    }
//    public MobileCodeTokenFilter(AuthenticationManager authenticationManager) {
//        super(DEFAULT_ANT_PATH_REQUEST_MATCHER, authenticationManager);
//    }
//
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        if (this.postOnly && !request.getMethod().equals("POST")) {
//            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
//        } else {
//            // 电话号码
//            String telephone = obtainUsername(request);
//            System.out.println("telephone"+telephone);
//            if (StringUtils.isEmpty(telephone)) {
//                throw new AuthenticationServiceException("电话号码不能为空");
//            }
//            // 验证码
//            String code = obtainPassword(request);
//            if (StringUtils.isEmpty(code)) {System.out.println("验证码不能为空");
//                throw new AuthenticationServiceException("验证码不能为空");
//            }
//            System.out.println("filter"+telephone + code);
//            return this.getAuthenticationManager().authenticate(new MobileCodeLoginToken(telephone, code));
//        }
//    }
//
//    @Nullable
//    protected String obtainPassword(HttpServletRequest request) {
//        return request.getParameter(this.passwordParameter);
//    }
//
//    @Nullable
//    protected String obtainUsername(HttpServletRequest request) {
//        return request.getParameter(this.mobileParameter);
//    }
//
//    public void setPostOnly(boolean postOnly) {
//        this.postOnly = postOnly;
//    }
//    @Autowired
//    @Override
//    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
//        super.setAuthenticationManager(authenticationManager);
//    }
//
//}