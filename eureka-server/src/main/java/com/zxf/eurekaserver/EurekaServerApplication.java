package com.zxf.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(EurekaServerApplication.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

