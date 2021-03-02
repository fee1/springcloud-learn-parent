package com.zxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 朱晓峰
 */
@SpringBootApplication
public class Oauth2Application {

    public static void main(String[] args) {
        try {
            SpringApplication.run(Oauth2Application.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
