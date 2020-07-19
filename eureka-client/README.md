# eureka-client——客户端服务demo 

[介绍](#介绍)

[创建eureka-client演示](#创建eureka-client演示)

# 介绍
略

# 创建eureka-client演示

服务依赖

```$xslt
<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
```

创建maven工程

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200712194610343.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200712194621396.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200712194631536.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)

添加对应依赖

```yaml
<!--eureka client-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
```
添加application.properties配置

```yaml
server.port=9000
spring.application.name=eureka-client

#是否从注册中心获取服务信息
eureka.client.fetch-registry=true
#是否注册到注册中心
eureka.client.register-with-eureka=true
#注册中心地址
eureka.client.service-url.defaultZone=http://localhost:10000/eureka/
```

启动
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200712194937997.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)

##### 注册到有登录认证的注册中心
 
添加配置信息
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200713161230394.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)

 # 常用配置
registry-fetch-interval-seconds: 30 #定义去eureka服务端获取服务列表的时间间隔

lease-renewal-interval-in-seconds: 30 #定义服务多久去注册中心续约

lease-expiration-duration-in-seconds: 90 #定义服务多久不去续约认为服务失效

prefer-ip-address: false #是否优先使用ip来作为主机名