package com.zxf.controller;

import com.zxf.api.CommonResult;
import com.zxf.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HystrixController {

    @Autowired
    HystrixService hystrixService;

    @GetMapping("test")
    @ResponseBody
    public CommonResult testHystrix(){
        return hystrixService.test();
    }

    @GetMapping("success")
    @ResponseBody
    public CommonResult success(){
        return hystrixService.success();
    }

}
