package com.zxf.service;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zxf.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HystrixService {


    @Autowired
    RestTemplate restTemplate;

    @Value("${target-url}")
    String targetService;

//    @HystrixCommand(fallbackMethod = "errorMethod")
    public CommonResult test(){
        return restTemplate.getForObject(targetService+"/error", CommonResult.class);
    }

    public CommonResult errorMethod(){
        CommonResult commonResult = CommonResult.failed();
        return commonResult;
    }

    public CommonResult success() {
        return restTemplate.getForObject("http://target/success", CommonResult.class);
    }
}
