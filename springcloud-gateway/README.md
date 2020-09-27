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

```
## 第二种Java bean配置方式
