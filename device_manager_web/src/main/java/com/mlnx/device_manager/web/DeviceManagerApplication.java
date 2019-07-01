package com.mlnx.device_manager.web;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by amanda.shan on 2019/1/30.
 */
@SpringBootApplication(scanBasePackages={"org.shan", "com.mlnx"})
@MapperScan("com.mlnx.device_manager.mappers")
public class DeviceManagerApplication {
    @Configuration
    public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        //PaginationInterceptor page = new PaginationInterceptor();
        //page.setDialectType("mysql");
        //return page;
        return new PaginationInterceptor();
    }

}

    public static void main(String[] args) {
        SpringApplication.run(DeviceManagerApplication.class, args);
    }
}
