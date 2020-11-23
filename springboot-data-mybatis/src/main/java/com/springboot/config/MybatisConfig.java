package com.springboot.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 21:15 2020/11/23
 * @ Description：配置mybatis自定义属性
 */
@org.springframework.context.annotation.Configuration
public class MybatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizers(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }

//    @Bean
//    public Configuration configuration(){
//        Configuration configuration = new Configuration();
//        configuration.setMapUnderscoreToCamelCase(true);
//        return  configuration;
//    }
}
