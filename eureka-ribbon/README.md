# Spring Cloud Ribbon

# 目录
[简介](#简介)

[RestTemplate的使用](#RestTemplate的使用)

[依赖](#依赖)

[测试使用演示](#测试使用演示)

[ribbon常用配置](#ribbon常用配置)

[负载均衡策略](#负载均衡策略)

## 简介
Spring Cloud Netflix子项目的核心组件之一，主要给服务间调用及API网关
转发提供负载均衡的功能。其中负载均衡均衡可以增加系统的可用性和扩展性。不多
做赘述。
## RestTemplate的使用
RestTemplate是一个HTTP客户端，我们可以使用它调用HTTP接口，支持GET、POST
、PUT、DELETE等restful风格的接口方法。

## 依赖
说明，springcloud依赖中已经默认包含了部分ribbon的依赖，不引入此依赖也能正常使用负载均衡功能，使用的时候应该注意一下，避免依赖冲突
```clike
<!--ribbon负载均衡依赖-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
        </dependency>
```

## 测试使用演示
### 创建一个eureka-target-service微服务工程
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729110550994.png)
### 在eureka-target-service的pom下添加依赖

```clike
<dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <!--包含springboot启动依赖，springcloud是基于springboot理所当然也包含springboot的依赖，详情自己ctrl+左击点进去-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <!--本项目的工具包-->
        <dependency>
            <groupId>com.zxf</groupId>
            <artifactId>common</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>
```
### 创建两个配置文件（启动服务时加载不同的配置文件）
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729111120429.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729111128145.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)
### 创建对外接口
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729111225348.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)
### 启动eureka注册中心，同时启动两个加载不同配置文件的此服务
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729111603564.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)
### 创建一个以负载均衡方式调用此服务的微服务工程
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020072911173891.png)
### 在pom中添加相对应的依赖

```clike
<properties>
        <java.version>1.8</java.version>
        <spring-cloud.version>Hoxton.SR6</spring-cloud.version>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!--ribbon负载均衡依赖-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>com.zxf</groupId>
            <artifactId>common</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>
```
### 添加配置信息

```clike
server.port=9001
spring.application.name=ribbon

eureka.client.service-url.defaultZone=http://root:root@localhost:10000/eureka/
eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
```
### 添加RestTemplate类

```clike
@Configuration
//@Configurable//通常用于对象new的时候，在构造函数之前让spring注入对象
public class BeanConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
```
### 创建调用服务的类
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729112232393.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)
### 查看eureka注册的服务
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729112449131.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)
### 测试
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200729112535494.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020072911255461.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)
## ribbon常用配置
全局配置
```clike
ribbon:
  ConnectTimeout: 1000 #服务请求连接超时时间（毫秒）
  ReadTimeout: 3000 #服务请求处理超时时间（毫秒）
  OkToRetryOnAllOperations: true #对超时请求启用重试机制
  MaxAutoRetriesNextServer: 1 #切换重试实例的最大个数
  MaxAutoRetries: 1 # 切换实例后重试最大次数
  NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule #修改负载均衡算法
```
指定服务配置

```clike
target:
	ribbon:
	  ConnectTimeout: 1000 #服务请求连接超时时间（毫秒）
	  ReadTimeout: 3000 #服务请求处理超时时间（毫秒）
	  OkToRetryOnAllOperations: true #对超时请求启用重试机制
	  MaxAutoRetriesNextServer: 1 #切换重试实例的最大个数
	  MaxAutoRetries: 1 # 切换实例后重试最大次数
	  NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule #修改负载均衡算法
```

## 负载均衡策略

RandomRule：随机
RoundRobinRule：轮询
RetryRule：在RoundRobinRule此基础上添加重试机制
WeightedResponseTimeRule：根据响应速度决定，速度越快，越容易被选择
BestAvailableRule：选择并发小的实例
AvailabilityFilteringRule：过滤故障实例，选择并发小的实例
ZoneAwareLoadBalancer：同时过滤不是统一区域的实例和故障实例，选择并发小的实例