# SpringCloud学习
开发工具:IDEA

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

```$xslt
请注意父pom规定了其项目下子工程的springboot相关依赖的版本，所以有些pom我不会添加version
<parent><!--规定工程创建指定的springboot版本-->
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.3.1.RELEASE</version>
    </parent>
```

# 工程目录
## 每个工程具体职能介绍在相应的md文档中
1.eureka-server：注册中心微服务demo

2.eureka-client：注册到注册中心的客户端demo
 

