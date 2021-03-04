# Spring Cloud Security：Oauth2
## 简介
```text
    SpringBoot结合Oauth2可以实现单点登录、令牌中继、令牌交换等功能，OAuth2.0是用于授权行业标准协议。
```
## 四种授权模式
```text
    ①Authorization Code(授权码模式)：正宗OAuth2的授权模式，客户端先去认证服务器获取授权码，然后进行授权，最后使用授权码获取访问令牌。(常用)
    ②Implicit(简化模式)：取消了授权码，直接获取令牌。
    ③Resource Owner Password Credentials(密码模式)：客户端获取用户名和密码，之后向认证服务器获取访问令牌。(常用)
    ④Client Credentials(客户端模式)：客户端直接通过客户端认证，直接从认证服务其获取访问令牌。
```
## 依赖
```xml
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-oauth2</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-security</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
```
## 使用@EnableAuthorizationServer注解开启认证服务
## 使用@EnableResourceServer注解开启资源服务器配置