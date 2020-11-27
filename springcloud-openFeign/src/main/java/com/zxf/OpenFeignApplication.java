package com.zxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OpenFeignApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(OpenFeignApplication.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
