package com.Spring.boot;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationCfg {
    @Bean

    public MyFirstClass myFirstClass(){
        return new MyFirstClass("first bean");
    }

    @Bean
    @Primary
    public MyFirstClass mySecondClass(){
        return new MyFirstClass("second bean");
    }
}
