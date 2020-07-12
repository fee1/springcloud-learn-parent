#### eureka-server——注册中心工程
###### 介绍
微服务架构的服务注册中心,服务会向注册中心注册自己的ip地址和端口信息.每个微服务都会定时向注册中心获取服务列表,汇报自己的运行状态.

服务需要调用其它服务时,就可以从获取到的服务列表中获取其它微服务实例的ip地址进行调用.

eureka实现了这一套服务注册于发现机制.

创建eureka-server演示地址:

![Image text](https://img-blog.csdnimg.cn/20200710173633944.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)

![Image text](https://img-blog.csdnimg.cn/20200710173819259.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)

![Image text](https://img-blog.csdnimg.cn/20200710174021712.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)

写入配置

![Image text](https://img-blog.csdnimg.cn/20200710174300425.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)

启动@EnableEurekaServer注解不能少，表为注册中心服务
![Image text](https://img-blog.csdnimg.cn/20200710174427570.png)

访问localhost:10000
![Image text](https://img-blog.csdnimg.cn/202007101747195.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70)