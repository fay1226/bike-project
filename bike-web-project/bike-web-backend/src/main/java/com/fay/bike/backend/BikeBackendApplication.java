package com.fay.bike.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 启动Backend
 * @author fanqingfeng
 * @date 2018/11/5 17:48
 */
@ImportResource("classpath:spring-mybatis.xml")
@MapperScan(basePackages = "com.fay.bike.services.**.mapper")
@SpringBootApplication(scanBasePackages = "com.fay.bike")
public class BikeBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BikeBackendApplication.class, args);
    }
}
