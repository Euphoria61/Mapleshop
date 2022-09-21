package com.euphoria.shop.config;

import com.euphoria.shop.common.annotation.LoginResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @package: com.euphoria.shop.common
 * @className: MvcConfig
 * @author: Euphoria
 * @description: 将解析器注入到SpirngMVC
 * @date: 2022/8/13 16:11
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginResolver());
    }

}
