package org.example.config;

import org.example.bean.BeanE;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "org.example.bean")
@Import({AppConfig1.class, AppConfig2.class})
/*@ImportResource("classpath:hibernate.cfg.xml")//Class eke root eke xml file eka tiyanawanm mehema denna puluwan*/
/*@ImportResource("file:absolute-path-of-hibernate.cfg.xml")*/ // Replace with the actual path to your XML configuration file(xml file eke root eke newei nm tiyenne mehema absolute path eka denna puluwan)
public class AppConfig {

}
