package org.example.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyConnection implements DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean {
    //The state of instantiation-1
    public MyConnection() {
        System.out.println("MyConnection Constructor Called(The state of instantiation-1)");
    }
    //there is no method to find state of populate properties-2

    //Bean name aware(Bean Id set)-3
    @Override
    public void setBeanName(String name) {
        System.out.println("SetBean Name(Bean name aware-3)");
    }

    //Add Dependency injection to bean(Bean Factory aware)-4
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("SetBeanFactory is called(Add Dependency injection to bean(Bean Factory aware)-4)");
    }

    //Application context aware(AOP and DP)-5
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("SetApplicationContext is called(Application context aware(AOP and DP)-5)");
    }

    //Complete Bean(Bean Initialization)-6
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyConnection AfterPropertiesSet Called(Complete Bean(Bean Initialization)-6)");
    }

    //Bean close and remove all available beans from context
    @Override
    public void destroy() throws Exception {
        System.out.println("MyConnection Destroy Called-7");//bean eka prototype wunama eya context eke nemei inne.etakota mee destroy eka print wen na.
    }



}
