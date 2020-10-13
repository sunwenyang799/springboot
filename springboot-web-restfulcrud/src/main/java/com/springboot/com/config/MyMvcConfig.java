package com.springboot.com.config;

import com.springboot.com.component.LoginHandlerInterceptor;
import com.springboot.com.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 21:05 2020/9/27
 * @ Description：定制springmvc配置  2.0以后implements WebMvcConfigurer  在springboot默认支持上增加配置
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 添加视图控制,访问/ 或/index路径为index.html
     * @param registry
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/addView").setViewName("success");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/main").setViewName("dashboard");
    }


    /**
     * 登录拦截器,排除静态资源文件
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/index","/user/login","/asserts/**","/webjars/**");
    }


    /**
     * 添加视图控制,访问/ 或/index路径为index.html
     * @return
     */
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer(){
//        WebMvcConfigurer webMvcConfigurer =   new WebMvcConfigurer() {
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("index");
//                registry.addViewController("/index").setViewName("index");
//                registry.addViewController("/main").setViewName("dashboard");
//            }
//
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
//                        excludePathPatterns("/","/index","/user/login");
//            }
//        };
//        return  webMvcConfigurer;
//    }

    @Bean
    public LocaleResolver localeResolver(){
        return new  MyLocaleResolver();
    }

}
