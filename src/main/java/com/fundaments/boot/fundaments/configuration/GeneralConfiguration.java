package com.fundaments.boot.fundaments.configuration;

import com.fundaments.boot.fundaments.bean.MyBeanWithProperties;
import com.fundaments.boot.fundaments.bean.MyBeanWithPropertiesImplement;
import com.fundaments.boot.fundaments.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {

    @Value("${value.name}")
    private String name;

    @Value("${value.last-name}")
    private String lastName;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplement(name, lastName);
    }
}
