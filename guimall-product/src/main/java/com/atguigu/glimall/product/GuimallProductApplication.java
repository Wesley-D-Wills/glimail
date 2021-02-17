package com.atguigu.glimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.atguigu.glimall.product.dao")
@SpringBootApplication
public class GuimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuimallProductApplication.class, args);
    }

}
