#说明：如若图片加载不出来可以直接下载下来查看，或者ctrl+f5刷新几次页面

# SpringCloud学习
开发工具:IDEA

# 目录：
[SpringCloud与SpringBoot对应关系](#SpringCloud与SpringBoot对应关系)

[工程目录](#工程目录)

[每个工程具体职能介绍在相应的md文档中](#每个工程具体职能介绍在相应的md文档中)

# SpringCloud与SpringBoot对应关系

SpringCloud的版本为伦敦地铁名称命名，对应不同的SpringBoot版本。开发相对应的SpringBoot与SpringCloud版本。
避免版本冲突问题。

|SpringCloud Version|SpringBoot Version|
|:--|:--|
|Hoxton|2.2.x|
|Greenwich|2.1.x|
|Finchley|2.0.x|
|Edgware|1.5.x|
|Dalston|1.5.x|

SpringCloud是在SpringBoot的基础上构建的，所以引入SpringCloud相关依赖后不需要引入，SpringBoot启动依赖。

```xml
        <!--请注意父pom规定了其项目下子工程的springboot相关依赖的版本，所以有些pom我不会添加version-->
<parent><!--规定工程创建指定的springboot版本-->
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.3.1.RELEASE</version>
    </parent>
```

# SpringCloud常用服务，打叉表示已经不在维护更新

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200719220517727.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)

# 工程目录
## 每个工程具体职能介绍在相应的md文档中
```text
0.common：工具包和通用代码

1.eureka-server：注册中心微服务demo

2.eureka-client：注册到注册中心的客户端demo

3.eureka-ribbon：负载均衡demo

4.eureka-hystrix：服务容错保护

5.springcloud-openFeign：声明式服务调用

6.eureka-target-service：各服务调用测试工程

7.springcloud-gateway：路由网关工程

8.springcloud-hystrix-dashboard: 断路器执行监控器

9.springboot-admin-server: springboot 微服务应用监控中心

10.springboot-admin-client: springboot 微服务应用监控中心注册使用实例
```