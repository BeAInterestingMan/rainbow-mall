package com.rainbow.mall.goods.service;

import com.rainbow.mall.security.annotations.EnableCloudResourceServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.rainbow.mall.goods.service.mapper")
@EnableFeignClients(basePackages = {"com.rainbow.mall.*"})
@EnableCloudResourceServer
public class GoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class,args);
    }
}
