package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages ={"org.example.bean" ,"org.example.controller"}) // Scan for components in specified packages
@EnableWebMvc// Enable Spring MVC support

public class WebAppConfig implements WebMvcConfigurer {//No need to implements from "WebMvcConfigurer" when Controller is using @RestController annotation
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/views/"); // Set the prefix for view files
        viewResolver.setSuffix(".jsp");//set the suffix for view files
        viewResolver.setOrder(2);//Set the order of view resolver
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/views/**").addResourceLocations("/views/");
    }
}




/*      | Situation                       | Implement `WebMvcConfigurer`?  |
        | ------------------------------- | -------------------------------|
        | Just using `@RestController`    | ❌ Not needed                  |
        | Using JSP views (`@Controller`) | ✅ Needed (for `ViewResolver`) |
        | Serving static files            | ✅ Optional                    |
        | Adding CORS, interceptors, etc. | ✅ Optional                    |*/

