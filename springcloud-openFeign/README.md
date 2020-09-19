# Spring Cloud OpenFeign 基于Ribbon和Hystrix的声明式服务调用

# 目录：
[简介](#简介)

[依赖](#依赖)

[注解](#注解)

[配置](#配置)

[示例](#示例)

[配置Feign日志](#配置Feign日志)

# 简介
OpenFeign声明式服务调用，整合了Ribbon和Hystrix拥有两者的功能，具有负载均衡和服务容错保护。

# 依赖
```xml
<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
```

# 注解
@EnableFeignClients //开启feign服务

@FeignClent(value="eureka中服务注册的名字", fallback= xxx.class) //fallback服务调用出错启动的容错保护类

# 配置
```yaml
feign:
  hystrix:
    enabled: true # 开启容错功能
```

# 示例
需要调用的服务接口

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200916223914471.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70#pic_center)

service中使用openFeign定义的接口类型调用
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200916224045224.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70#pic_center)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200916224122439.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70#pic_center)

定义的容错处理类

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200916224253949.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70#pic_center)

测试服务容错

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200916225001929.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70#pic_center)

测试传入简单参数

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200916225051764.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70#pic_center)

测试传入list参数

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200916225142340.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70#pic_center)

# 配置Feign日志
日志级别：
```text
    NONE：默认的，不显示任何日志。
    BASIC：仅记录请求方法、URL、响应状态码及执行时间。
    HEADERS：比BASIC，还多出了请求和响应的头信息。
    FULL：比HEADERS，还多出了请求和响应的正文和元数据信息。
```

配置：
```java
@Configuration
public class Feignconfig {

    /**
     * feign开启日志配置
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
```

springboot的yml配置文件配置日志级别
```yaml
logging:
  level:
    com.zxf.feign.FeignServiceFeign: debug #注意debug前面有一个空格，确实会报错并且很难排查
```

示例
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200918164136282.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70#pic_center)

