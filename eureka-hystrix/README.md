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
    
示例：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200909223648470.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200909223736363.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020090922380531.png#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020090922421654.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70#pic_center)


## 请求缓存（扩展）
当系统并发量越来越大的时候，我们可能需要使用到缓存来优化系统，减轻并发请求线程数，或者减轻数据库压力，提升响应速度，优化用户体验。

相关注解：

    @CacheResult：开启缓存，默认所有参数作为缓存的key，cacheKeyMethod可以通过返回String类型的犯法指定key。
    @CacheKey：指定缓存的key，可以指定参数或指定参数中的属性值为缓存key。
    @CacheRemove：移除缓存，需要指定commandKey。

问题：估计是Hystrix自身就存在问题，我的请求缓存不起作用，还有service存在两个HystrixCommand第二个不起作用，网上也没有资料。
Hystrix已经不维护，就当作做随便看看好了增长见识对于后续的sentienl和Resillience4J服务降级学习没有坏处，还有很多东西要学。

## 请求合并
微服务系统中的服务通信，需要通过远程调用来实现，随着调用的次数增多，占用线程资源也会越来越多。Hystrix提供了一种叫
做请求合并的方式解决此问题。通过使用@HystrixCollapser注解可以合并请求，从而达到减少线程通信消耗及线程数量大的效果。

    @HystrixCollapser属性
        batchMethod：用于设置请求合并的方法。
        collapserProperties：请求合并属性，用于控制实例属性，有很多。
        timerDelayInMilliseconds：用于控制间隔多少时间合并一次请求。

