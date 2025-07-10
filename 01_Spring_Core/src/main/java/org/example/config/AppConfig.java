package org.example.config;

import org.example.bean.MyConnection;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration//class ekakata meta data provide karanna use karai
@ComponentScan(basePackages = "org.example.bean") //Base package path---->basePackages = "org.example.bean"
                                                    // Base Class---->basePackageClasses = SpringBean.class
public class AppConfig {
    @Bean("fernando") //Bean ID
    /*@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)*/ // This bean will be created as a new instance each time it is requested
    public MyConnection myConnection() {
        return new MyConnection();
    }
}
