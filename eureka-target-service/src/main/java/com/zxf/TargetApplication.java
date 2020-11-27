package com.zxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TargetApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(TargetApplication.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}