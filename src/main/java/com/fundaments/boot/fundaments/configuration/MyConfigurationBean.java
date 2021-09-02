package com.fundaments.boot.fundaments.configuration;

import com.fundaments.boot.fundaments.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {

    @Bean
    public MyBean beanOperation(){
        //return new MyBeanImplement();
        return new MyBean2Implement();
    }

    @Bean
    public MyOperation beanOperationLevel(){
        return new MyOperationImplement();
    }

    @Bean MyBeanWithDependency beanOperationIpo(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }
}
