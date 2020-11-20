# springcloud-config：外部集中化配置管理（又称为分布式配置中心）

# 简介
```text
    SpringCloud config 分为两个部分，一个部分为服务端，另一个部分为客户端。服务端存储了客户端的配置信息，客户端
启动工程项目时会去服务端拉取配置信息。本身采取的git来存储配置信息，所以支持配置信息的版本管理，配合git客户端管理配置。
```

# 在gitee下创建一个仓库用于存储配置文件
```text
创建过程略。
将eureka-client的配置文件上传到gitee的仓库上。
```
# 依赖
```yml
        <!--config client-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>

        <!--config server-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-server</artifactId>
        </dependency>
```
# 