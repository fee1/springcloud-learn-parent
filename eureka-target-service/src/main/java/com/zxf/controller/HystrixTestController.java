package com.zxf.controller;

import com.zxf.api.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HystrixTestController {

    @GetMapping("error")
    @ResponseBody
    public CommonResult errorTest()throws Exception{
        System.out.println("熔断路口");
        throw new RuntimeException("熔断测试");
    }

    @GetMapping("success")
    @ResponseBody
    public CommonResult success(){
        return CommonResult.success(null);
    }

    @GetMapping("testCache/{id}")
    @ResponseBody
    public CommonResult testCache(@PathVariable String id){
        System.out.println("调用了方法");
        return CommonResult.success(id);
    }

}
