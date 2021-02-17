package com.atguigu.glimall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.atguigu.glimall.member.feign")
@SpringBootApplication
@EnableDiscoveryClient
public class GuimallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuimallMemberApplication.class, args);
    }

}
