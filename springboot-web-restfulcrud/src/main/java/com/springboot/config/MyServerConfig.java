package com.springboot.config;

import com.springboot.filter.MyFilter;
import com.springboot.listener.MyListener;
import com.springboot.servlet.MyServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.embedded.TomcatWebServerFactoryCustomizer;
import org.springframework.boot.web.embedded.jetty.JettyReactiveWebServerFactory;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 21:09 2020/10/20
 * @ Description：自定义server配置
 */
@Configuration
public class MyServerConfig {

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {
            @Override
            public void customize(ConfigurableServletWebServerFactory factory) {
                factory.setPort(8083);
            }
        };
    }

    /**
     * 定制tomcat servlet容器属性(1)
     * @return
     */
//    @Bean
//    public ServletWebServerFactory servletWebServerFactory(){
//        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
//        tomcatServletWebServerFactory.setPort(8083);
//        return  tomcatServletWebServerFactory;
//    }

    /**
     * 定制jetty servlet容器属性
     * @return
     */
//    @Bean
//    public ServletWebServerFactory servletWebServerFactory(){
//        JettyServletWebServerFactory jettyServletWebServerFactory = new JettyServletWebServerFactory();
//        jettyServletWebServerFactory.setPort(8084);
//        return  jettyServletWebServerFactory;
//    }

    /**
     * undertow servlet容器属性
     * @return
     */
//    @Bean
//    public ServletWebServerFactory servletWebServerFactory(){
//        UndertowServletWebServerFactory undertowServletWebServerFactory = new UndertowServletWebServerFactory();
//        undertowServletWebServerFactory.setPort(8084);
//        return  undertowServletWebServerFactory;
//    }

    /**
     * 注册servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new MyServlet(),"/myServlet");
    }

    /**
     * 注册filter
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return filterRegistrationBean;
    }

    /**
     * 注册Listener
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean(new MyListener());
        return servletListenerRegistrationBean;
    }
}
