package com.zxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 朱晓峰
 */
@SpringBootApplication
@EnableFeignClients
public class NacosClientApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(NacosClientApplication.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
