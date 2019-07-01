package com.mlnx.device_manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by amanda.shan on 2019/1/30.
 */
@SpringBootApplication(scanBasePackages={"org.shan", "com.mlnx"})
@MapperScan("com.mlnx.device_manager.mappers")
public class DeviceManagerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeviceManagerServiceApplication.class, args);
    }
}
