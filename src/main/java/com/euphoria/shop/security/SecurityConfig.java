package com.euphoria.shop.security;


import com.euphoria.shop.security.filter.JwtAuthenticationTokenFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("MobileUserDetailsServiceImpl")
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
//    @Autowired
//    private MobileCodeTokenFilter mobileCodeTokenFilter;
//
//    @Autowired
//    private MobileAuthenticationProvider mobileAuthenticationProvider;
    /**
     * 自定义用户认证逻辑
     */


//    @Resource
//    private MyUserDetailService userDetailService;
//    @Resource
//    private MyAuthenticationSuccessHandler successHandler;
//    @Resource
//    private MyAuthenticationFailureHandler failureHandler;
    /**
     * 认证不通过的处理类
     */
//    @Resource
//    private MyAuthenticationEntryPointHandler entryPointHandler;
    /**
     * 令牌认证过滤
     */
//    @Resource
//    private JwtAuthenticationFilter jwtAuthenticationFilter;

    /**
     * 匹配器
     */
//    @Resource
//    private JwtAuthenticationProvider provider;

//    @Resource
//    private MyLogoutSuccessHandler logoutSuccessHandler;
//    @Resource
//    private CorsFilter corsFilter;

    /**
     * 自定义 AuthenticationManager 在工厂中暴露
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 自定义登录页面的页面放行
     * <p>
     * <p>
     * /**
     * anyRequest          |   匹配所有请求路径
     * access              |   SpringEl表达式结果为true时可以访问
     * anonymous           |   匿名可以访问
     * denyAll             |   用户不能访问
     * fullyAuthenticated  |   用户完全认证可以访问（非remember-me下自动登录）
     * hasAnyAuthority     |   如果有参数，参数表示权限，则其中任何一个权限可以访问
     * hasAnyRole          |   如果有参数，参数表示角色，则其中任何一个角色可以访问
     * hasAuthority        |   如果有参数，参数表示权限，则其权限可以访问
     * hasIpAddress        |   如果有参数，参数表示IP地址，如果用户IP和参数匹配，则可以访问
     * hasRole             |   如果有参数，参数表示角色，则其角色可以访问
     * permitAll           |   用户可以任意访问
     * rememberMe          |   允许通过remember-me登录的用户访问
     * authenticated       |   用户登录后可访问
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        MobileCodeTokenFilter mobileCodeTokenFilter = new MobileCodeTokenFilter();
//        // 下面这个authenticationManager必须设置，否则在MobilePhoneAuthenticationFilter#attemptAuthentication
//        // 方法中调用this.getAuthenticationManager().authenticate(authRequest)方法时会报NullPointException
//        mobileCodeTokenFilter.setAuthenticationManager(authenticationManagerBean());
//        //mobileCodeTokenFilter.setAllowSessionCreation(true);
//        //mobileCodeTokenFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
//        MobileAuthenticationProvider mobileAuthenticationProvider =new MobileAuthenticationProvider();
//        mobileAuthenticationProvider.setUserDetailsService(userDetailsService);
//        http.addFilterBefore(mobileCodeTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http
                // CSRF禁用,因为不使用session
                .csrf().disable()
                // 没有token认证不通过
                // .exceptionHandling().authenticationEntryPoint(entryPointHandler)
//                .and()
                // 基于token不使用session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 过滤请求
                .authorizeRequests()
                // 允许匿名访问，防止重定向锁死
                .antMatchers("/captchaImage", "/login").anonymous()
                .antMatchers("/swagger-ui/**").anonymous()
                .antMatchers("/v3/**").anonymous()
                .antMatchers("/swagger-resources/**").anonymous()
                .antMatchers("/user/login").anonymous()//未登录
                .antMatchers("/user/register").anonymous()//未登录
                // 除了以上，均要鉴权
                .anyRequest()
                .authenticated();
//                .and() // 登出成功处理
//                .logout()
//                .logoutUrl("/logout")
        // .logoutSuccessHandler(logoutSuccessHandler);


    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//        auth.authenticationProvider(mobileAuthenticationProvider);
//    }






}
