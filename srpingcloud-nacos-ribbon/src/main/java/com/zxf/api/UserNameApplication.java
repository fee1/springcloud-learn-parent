package com.zxf.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 朱晓峰
 */
@RestController
@RequestMapping("v1/nacos-ribbon/ribbon")
public class UserNameApplication {

    @Value("${name}")
    String name;

    @GetMapping("user-name")
    public String getUserName(){
        return name;
    }

}
