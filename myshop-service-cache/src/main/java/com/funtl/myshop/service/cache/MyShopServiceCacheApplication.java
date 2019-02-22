package com.funtl.myshop.service.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyShopServiceCacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyShopServiceCacheApplication.class, args);
    }
}
