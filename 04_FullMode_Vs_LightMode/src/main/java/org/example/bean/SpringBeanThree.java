package org.example.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanThree {
    //InterBean Dependency Not Satisfied
    @Bean
    public SpringBeanOne springBeanOne() {
        SpringBeanTwo springBeanTwo1 = springBeanTwo();//new SpringBeanTwo(); kiyala dammoth just a object ekk hadenne beaan ekk newei, etakota Spring features access karanna ba
        SpringBeanTwo springBeanTwo2 = springBeanTwo();
        System.out.println(springBeanTwo1);
        System.out.println(springBeanTwo2);

        return new SpringBeanOne();
    }

    @Bean
    public SpringBeanTwo springBeanTwo() {
        return new SpringBeanTwo();
    }
}
