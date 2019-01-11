package com.fay.bike.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动APP
 * @author fanqingfeng
 * @date 2018/11/5 17:48
 */
@MapperScan(basePackages = "com.fay.bike.services.**.mapper")
@SpringBootApplication(scanBasePackages = "com.fay.bike")
public class BikeAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BikeAppApplication.class, args);
    }
}

