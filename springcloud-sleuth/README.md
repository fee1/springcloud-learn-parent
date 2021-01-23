# springcloud-sleuth: 分布式请求链路跟踪

## 简介
```text
    分布式系统跟中服务间调用的工具，直观展示出一次请求的调用过程。
```
## 依赖（需要在目标项目中都添加相应的依赖，为了方便演示，我在target与openfeign工程配合演示此功能）
```xml
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zipkin</artifactId>
        </dependency>
```
## 配置（需要在目标项目中添加相对应的配置）
```properties
# sleuth服务端地址
spring.zipkin.base-url=http://localhost:9411
# 设置sleuth的抽样收集概率
spring.sleuth.sampler.probability=0.1
```
## 下载zipkin-server (spring-boot 2.0以上的版本不需要自行搭建)
```text
地址：https://repo1.maven.org/maven2/io/zipkin/java/zipkin-server/2.12.9/zipkin-server-2.12.9-exec.jar
```
## 运行zipkin-server
```text
java -jar zipkin-server-2.12.9-exec.jar
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020111222585242.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70#pic_center)
### 默认访问路径为localhost:9411
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201112230000676.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70#pic_center)
## 多次发送请求之后就会有记录出现
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201112230300740.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201112230315323.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201112230340511.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTUyODk4Nw==,size_16,color_FFFFFF,t_70#pic_center)
