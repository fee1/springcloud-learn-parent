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

    样例: 
        ①获取配置信息: localhost:12000/master/config-dev   
            {
                "name": "master",
                "profiles": [
                    "config-dev"
                ],
                "label": null,
                "version": "6448fff4c40b98f90b391aea13f1610535bf45a5",
                "state": null,
                "propertySources": []
            }
        ②获取配置文件: localhost:12000/master/config-dev.yml
            config: info:"config info for dev(master)"
```
## 新建一个config-client的子工程
### 添加依赖
```xml
<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-client</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
```
### 新建一个bootstrap.yml配置
```yml
spring:
  application:
    name: config-client
  cloud:
    config:
      profile: dev #’-‘后面的名称
      label: master #git上的哪一个分支
      uri: http://localhost:12000 #配置中心地址
      name: config #‘-’前面的名称
server:
  port: 9003
eureka:
  client:
    service-url:
      defaultZone: http://root:root@localhost:10000/eureka/
    register-with-eureka: true
    fetch-registry: false
```
### 新建一个api类获取配置
```java
@RestController
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config-info")
    public String getConfigInfo(){
        return configInfo;
    }

}
```
```text
    这样我们的工程就可以再启动的时候就去gitee上获取我们的配置文件的配置信息，但是这还又一个缺陷就是不能实时获取。bus可以解决此问题。
```
# Spring Cloud Bus 消息总线
```text
简介：
    使用消息代理的思想构建一个工程，所有微服务的服务都连接到这个工程服务上去，当我们想这个bus服务发送消息的时候，搜友连接到这个工程的服务都对消息进行消费。
bus支持两种消息代理：rabbitMQ与kafka。我们可以使用bus实现动态刷新配置。
```
## 你需要安装一个rabbitMQ，步骤略。
## 依赖
```xml
<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-bus-amqp</artifactId>
        </dependency>
<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
      </dependency>
```
```text
    <parent><!--规定工程创建指定的springboot版本-->
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-parent</artifactId>
            <version>2.3.1.RELEASE</version>
        </parent>

    父工程中的pom的parent因为继承关系包含了actuator依赖。

    springboot的actuator是一款健康检查工具。
```
## 配置config-client
```yml
server:
  port: 9003
spring:
  application:
    name: config-client-amqp
  cloud:
    config:
      uri: http://localhost:12000
      name: config
      profile: dev
      label: master
      discovery:
        enabled: true
        service-id: config-server-amqp
  rabbitmq:
    host: 192.168.137.135 # ip
    port: 5672 # 端口 
    username: guest
    password: guest
eureka:
  client:
    service-url:
      defaultZone: http://root:root@localhost:10000/eureka/
    fetch-registry: true
    register-with-eureka: true

management:
  endpoints:
    web:
      exposure:
        include: 'refresh' # 开启actuator端点
```
## 配置config-server
```yml
spring:
  application:
    name: config-server-amqp
  cloud:
    config:
      server:
        git:
          uri: https://gitee.com/zxffe/config.git
          username: zxffe
          password: zxf1063446979
          clone-on-start: true # 启动时直接从git上获取配置
  rabbitmq:
    host: 192.168.137.135
    port: 5672
    username: guest
    password: guest

server:
  port: 12000
eureka:
  client:
    service-url:
      defaultZone: http://root:root@localhost:10000/eureka/
    register-with-eureka: true
    fetch-registry: true
management:
  endpoints: # 暴露bus刷新配置端点
    web:
      exposure:
        include: 'bus-refresh'
```
## 启动config-client和config-server项目
```text
    项目启动完成后，bus会在rabbitMQ上创建一个交换器(exchanges)，和两个项目对应的队列(queues)，springCloudBus交换器会自动绑定上这两个队列。
```
![Image](../images/rabbitMQ1.png)
![Image](../images/rabbitMQ2.png)
![Image](../images/rabbitMQ3.png)
## 修改git上的文件后，刷新配置
```text
http://localhost:12000/actuator/bus-refresh
```