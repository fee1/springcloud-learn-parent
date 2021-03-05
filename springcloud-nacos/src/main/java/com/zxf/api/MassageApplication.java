package com.zxf.api;

import com.zxf.external.feign.UserNameFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 朱晓峰
 */
@RestController
@RequestMapping("v1")
public class MassageApplication {

    @Autowired
    UserNameFeign userNameFeign;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("message")
    public String getMessage(){
        return userNameFeign.getUserName();
    }

    @GetMapping("rest-message")
    public String restGetMessage(){
        return restTemplate.getForObject("http://nacos-ribbon/v1/nacos-ribbon/ribbon/user-name", String.class);
    }

}
