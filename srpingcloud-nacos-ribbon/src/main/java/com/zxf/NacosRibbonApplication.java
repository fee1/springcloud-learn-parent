package com.zxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 朱晓峰
 */
@SpringBootApplication
public class NacosRibbonApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(NacosRibbonApplication.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
