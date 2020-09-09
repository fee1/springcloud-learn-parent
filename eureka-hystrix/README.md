# Spring Cloud Hystrix:服务容器保护（已经不在维护，可以选择直接学习sentienl）

## 目录
[简介](#简介)

[依赖](#依赖)

[配置](#配置)

## 简介
Spring Cloud Netflix的核心组件之一，具有服务容错及线程隔离等一些列的服务保护功能。
在微服务框架中，服务于服务之间通过远程调用的方式进行通信，一旦某个被调用的服务发生了
故障，此时发生的故障就有可能蔓延，也就形成了雪崩效应，进而导致整个系统的瘫痪。
熔断器模式下，某个服务发生了故障时，不会让调用者长时间的等待，而是能够返回一个相关的响
应，不会让调用方长时间得不到响应占用线程，防止故障的蔓延。

Hystrix具有服务降级、服务熔断、线程隔离、请求缓存、请求合并及服务监控等功能。

## 依赖
```yaml
<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
```

## 配置
---提醒：使用restTemplate调用注册到注册中心服务的时候，如果需要使用服务名调用，需要使用在restTemplate上加入注解@LoadBalanced

@EnableCircuitBreaker //开启熔断功能

@HystrixCommand(fallbackMethod = "方法名") //在调用的方法上添加此注解，指定服务降级使用的方法
    fallbackMethod：指定服务降级处理方法；
    ignoreExceptions：忽略某些异常，不发生服务降级；
    commandKey：命令名称，用于区分不同的命令；
    groupKey：分组名称，Hystrix会根据不同的分组来统计命令的告警及仪表盘信息；
    threadPoolKey：线程池名称，用于划分线程池。

## 
