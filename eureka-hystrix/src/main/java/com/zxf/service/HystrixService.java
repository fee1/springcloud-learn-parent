package com.zxf.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.zxf.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HystrixService {


    @Autowired
    RestTemplate restTemplate;

    @Value("${target-url}")
    String targetService;

    @HystrixCommand(fallbackMethod = "errorMethod", commandKey = "test")
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

    @CacheResult //默认key为所有参数为key，可以通过cacheKeyMehod指定key
    public CommonResult testCache(String id) {
        return restTemplate.getForObject(targetService+"/testCache/{1}", CommonResult.class, id);
    }

}
