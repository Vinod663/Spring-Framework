package org.example.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean {
    @Value("${os.name}")
    private String osName;

    @Value("${db.name}")
    private String dbName;

    @Override
    public void afterPropertiesSet() throws Exception {//Initialize wunata passe tama properties print karanna puluwan
        System.out.println("OS Name: "+osName);
        System.out.println("DB Name: "+dbName);
    }
}
