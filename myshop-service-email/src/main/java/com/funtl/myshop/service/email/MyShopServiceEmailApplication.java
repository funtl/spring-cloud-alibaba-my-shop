package com.funtl.myshop.service.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = "com.funtl.myshop")
@EnableDiscoveryClient
@EnableBinding({Sink.class})
@EnableAsync
public class MyShopServiceEmailApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyShopServiceEmailApplication.class, args);
    }
}
