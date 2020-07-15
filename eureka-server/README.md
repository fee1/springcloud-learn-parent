# eureka-server——注册中心demo

[介绍](#介绍)

[创建eureka-server演示](#创建eureka-server演示)

[注册中心集群](#注册中心集群)

[给注册中心添加认证](#给注册中心添加认证)

# 介绍
微服务架构的服务注册中心,服务会向注册中心注册自己的ip地址和端口信息.每个微服务都会定时向注册中心获取服务列表,汇报自己的运行状态.

服务需要调用其它服务时,就可以从获取到的服务列表中获取其它微服务实例的ip地址进行调用.

eureka实现了这一套服务注册于发现机制.

# 创建eureka-server演示

注册中心依赖
```$xslt
<!--eureka server-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
```

![Image text](https://img-blog.csdnimg.cn/20200710173633944.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)

![Image text](https://img-blog.csdnimg.cn/20200710173819259.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)

![Image text](https://img-blog.csdnimg.cn/20200710174021712.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)

写入配置

![Image text](https://img-blog.csdnimg.cn/20200710174300425.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)

启动@EnableEurekaServer注解不能少，表为注册中心服务
![Image text](https://img-blog.csdnimg.cn/20200710174427570.png)

访问localhost:10000
![Image text](https://img-blog.csdnimg.cn/202007101747195.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)

# 注册中心集群

在eureka-server创建两个项目配置文件 application-server1.properties、application-server2.properties

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200712230427200.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200712230435400.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)

复制，并设置启动的配置文件

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200712230721359.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)

随便访问一个注册中心

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200712230923501.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)

# 给注册中心添加认证

依赖

```yaml
<!--SpringSecurity-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
```

springboot 添加配置用户名和密码

```yaml
#SpringSecurity 登录的用户名和密码
spring.security.user.name=root
spring.security.user.password=root
```

添加配置类，配置对应需要验证的路径，默认情况下，所有的路径均需要CSRF token验证
```yaml
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }
}
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200713154743476.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)
