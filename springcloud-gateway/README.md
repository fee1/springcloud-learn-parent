# spring cloud gateway: api网关

```text
zuul已经不在维护
简单介绍：
    zuul 在springcloud刚推出时承担着api网关的作用，作为微服务架构中的服务提供了统一访问入口，客户端都是通过网关经行路由访问服务，而不是直接访问服务。网关有点类似于web开发中
的拦截器与过滤器，但又不同于拦截器与过滤器。它不仅能实现拦截器与过滤器的功能，还具有负载均衡、校验过滤、服务容错和服务聚合的功能。
（注：过滤器在进入service前执行，拦截器在dispartservlet之后controller之气执行）
```

# 目录

# 简介
```text
    gateway是目前较流行的路由网关，不仅具有zuul的功能特性，还提供了一些更加强大的功能特性。
特性：
    ①动态路由能够匹配任何请求属性
    ②可以对路由进行指定的断言（Predicate）和过滤器（filter）
    ③具有服务法相的功能
    ④请求限流功能与路径重写
```
# 依赖
```xml
<dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-gateway</artifactId>
       <version>2.2.0.RELEASE</version>
</dependency>
```
启动时可能还会出现如下情况：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200920213841122.png#pic_center)

请将web依赖去除即可

# 配置路由
## 第一种方式yml文件配置方式
```yaml
spring:
  application:
    name: gateway
  cloud:
    gateway:
      routes:
        - id: target  #路由的ID，没有固定规则但要求唯一，建议配合服务名
          uri: http://localhost:11000
          predicates:
            - Path=/getRibbon/**, /success/**
```
## 第二种Java bean配置方式
```java
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator targetRouteLocator(RouteLocatorBuilder builder){
        return builder
                .routes().route("target", r -> r.path("/getRibbon/**", "/success/**")
                .uri("http://localhost:11000")).
                build();
    }
}
```
### 示例
#### 原需要访问的url
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201008203625134.bmp?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70#pic_center)
#### 配置gateway后访问的url
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020100820382925.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70#pic_center)

```text
    经过gateway路由后可以访问到需要访问的接口。
```

## 各种路由设置
### 指定路径的请求会匹配
```yaml
          predicates:
            - Path=/getRibbon/**, /success/**
```
### 指定时间后
```yaml
          predicates:
            - Path=/getRibbon/**, /success/**
            - After=2020-10-08T16:30:00+08:00[Asia/Shanghai]
```
### 指定时间前
```yaml
          predicates:
            - Path=/getRibbon/**, /success/**
            - Before=2020-10-08T16:30:00+08:00[Asia/Shanghai]
```
### 指定时间段内
```yaml
          predicates:
            - Path=/getRibbon/**, /success/**
            - Between=2020-10-08T16:30:00+08:00[Asia/Shanghai],2020-10-09T16:30:00+08:00[Asia/Shanghai]
```
### 指定还有指定cookie的匹配
```yaml
          predicates:
            - Path=/getRibbon/**, /success/**
            - Cookie=username,zxf
```
### 指定还有指定header的匹配
```yaml
          predicates:
            - Path=/getRibbon/**, /success/**
            - Header=token,1234567890
```
### 指定还有指定host的匹配
```yaml
          predicates:
            - Path=/getRibbon/**, /success/**
            - Host=**.baidu.com
```
### 指定method类型匹配
```yaml
          predicates:
            - Path=/getRibbon/**, /success/**
            - Method=GET
```
### 指定method类型匹配
```yaml
          predicates:
            - Path=/getRibbon/**, /success/**
            - Method=GET
```
### 指定查询参数的匹配
```yaml
          predicates:
            - Path=/getRibbon/**, /success/**
            - Query=username
```
### 指定远程地址发起的请求的匹配
```yaml
          predicates:
            - Path=/getRibbon/**, /success/**
            - RemoteAddr=192.168.190.128
```
### 权重路由
```yaml
        - id: target1  #路由的ID，没有固定规则但要求唯一，建议配合服务名
          uri: http://127.0.0.1:11000
          predicates:
            - Path=/getRibbon/**, /success/**
            - Weight=group1,6 #60%的请求路由到此路径下
```
```yaml
        - id: target1  #路由的ID，没有固定规则但要求唯一，建议配合服务名
          uri: http://127.0.0.1:12000
          predicates:
            - Path=/getRibbon/**, /success/**
            - Weight=group1,4 #40%的请求路由到此路径下
```
### 给请求添加参数过滤器a
```yaml
- id: target  #路由的ID，没有固定规则但要求唯一，建议配合服务名
          uri: http://127.0.0.1:11000
          predicates:
            - Path=/getRibbon/**, /success/**
          filters:
            - AddRequestParameter=id,12121212 # 相当于给请求添加了一个参数名为id，值为12121212的请求参数
```
