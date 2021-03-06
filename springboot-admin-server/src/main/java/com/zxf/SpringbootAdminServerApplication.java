package com.zxf;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class SpringbootAdminServerApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(SpringbootAdminServerApplication.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
