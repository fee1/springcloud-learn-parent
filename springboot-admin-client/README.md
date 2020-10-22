# Spring Boot Admin

## 简介
```text
    通过Actuator查看spring boot 应用运行的过程中的各项指标，通过图形化界面呈现出来。
```
## 依赖
```yml
<dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>de.codecentric</groupId>
            <artifactId>spring-boot-admin-starter-server</artifactId>
            <version>2.1.6</version>
        </dependency>

<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
```
## 