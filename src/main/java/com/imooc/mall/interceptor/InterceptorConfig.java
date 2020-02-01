package com.imooc.mall.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * created by Leo徐忠春
 * created Time 2020/1/6-2:26
 * email 1437665365@qq.com
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    //配置拦截器
    @Override
    ///user/register","/user/login" 这两个Url不拦截
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserLoginInterceptor()).
                addPathPatterns("/**").excludePathPatterns
                ("/user/register","/user/login","/categories"
                ,"/products","/products/*","/error");
    }
}
