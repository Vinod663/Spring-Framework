package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "org.example.bean")
@PropertySource("classpath:application.properties")//Give the path of the properties file in Resource Bundle
public class AppConfig {
}
