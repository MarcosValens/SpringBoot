package com.valensmarcos.springbootdemo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Properties;

@Configuration
@EnableWebMvc
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsConfig implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry corsRegistry){
        Properties properties = new Properties();
        corsRegistry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("http://localhost:63343")
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS");
    }
}
