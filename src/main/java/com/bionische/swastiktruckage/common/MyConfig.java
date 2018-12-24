package com.bionische.swastiktruckage.common;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyConfig implements WebMvcConfigurer{
    @Override
   public void addInterceptors(InterceptorRegistry registry){
       registry.addInterceptor(new CheckUserInterceptor()).addPathPatterns("/**");
   }
}