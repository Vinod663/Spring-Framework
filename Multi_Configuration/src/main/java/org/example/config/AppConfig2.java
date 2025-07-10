package org.example.config;

import org.example.bean.BeanC;
import org.example.bean.BeanD;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig2 {
    @Bean
    public BeanC beanC() {
        return new BeanC();
    }
    @Bean
    public BeanD beanD() {
        return new BeanD();
    }
}
