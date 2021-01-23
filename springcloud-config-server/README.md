# springcloud-config：外部集中化配置管理（又称为分布式配置中心）

## 简介
```text
    SpringCloud config 分为两个部分，一个部分为服务端，另一个部分为客户端。服务端存储了客户端的配置信息，客户端
启动工程项目时会去服务端拉取配置信息。本身采取的git来存储配置信息，所以支持配置信息的版本管理，配合git客户端管理配置。
```

## 在gitee下创建一个仓库用于存储配置文件
```text
创建过程略。
将eureka-client的配置文件上传到gitee的仓库上。
```
## 依赖
```yml
        <!--config server-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-server</artifactId>
        </dependency>
```
## 配置
```text
spring:
  application:
    name: config-server
  cloud:
    config:
      server:
        git: #配置存储配置信息的git仓库
          uri: https://gitee.com/zxffe/config.git
          username: zxffe
          password: zxf1063446979
          clone-on-start: true # 开启启动时直接从git获取配置
          
server:
  port: 12000
eureka:
  client:
    service-url: http://root:root@localhost:10000/eureka/
    register-with-eureka: true
    fetch-registry: false
```
## 如何获取配置？
```text
    获取配置信息格式: /{label}/{application}-{profile}
    获取配置文件信息: /{label}/{application}-{profile}.{文件后缀}
    label: 分支名称。可配置为spring.cloud.config.label。
    application: 应用名称，默认spring.application.name，可配置为spring.cloud.config.name。
    profile: 环境名称。可配置为spring.cloud.config.profile。

    样例: 获取配置信息: localhost:12000/master/config-dev   
         获取配置文件: localhost:12000/master/config-dev.yml
```