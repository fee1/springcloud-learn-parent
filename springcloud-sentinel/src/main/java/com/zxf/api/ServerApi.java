package com.zxf.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 朱晓峰
 */
@RestController
public class ServerApi {

    @Value("${spring.application.name:wuming}")
    String applicationName;

    /**
     * 获取服务名
     * @return str
     */
    @GetMapping("application-name")
    public String getApplciationName(){
        return applicationName;
    }

}
