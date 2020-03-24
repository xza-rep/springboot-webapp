package com.xza.config;

import com.xza.handler.MyLocaleResolver;
import com.xza.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //     我们自己编写一个视图解析，路由！
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 视图跳转的控制！
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","index","/asserts/**","/user/login");
    }
}
