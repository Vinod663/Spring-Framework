package org.example.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements DisposableBean, InitializingBean , BeanFactoryAware, BeanNameAware, ApplicationContextAware{
    private SpringBean() {
        System.out.println("Spring Bean Constructor");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Spring Bean Factory Set");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Spring Bean Name Set");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Spring Bean Destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Spring Bean Initializing");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Spring Bean Application Context Set");
    }
}
