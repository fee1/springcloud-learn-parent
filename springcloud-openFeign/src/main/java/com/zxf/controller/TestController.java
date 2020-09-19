package com.zxf.controller;

import cn.hutool.json.JSONUtil;
import com.zxf.api.CommonResult;
import com.zxf.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    FeignService feignService;

    @GetMapping("test")
    @ResponseBody
    public CommonResult<Object> test(){
        return feignService.test();
    }

    @GetMapping("testError")
    @ResponseBody
    public CommonResult<Object> testError(){
        return feignService.testError();
    }

    @GetMapping("testSimpleParam/{id}")
    @ResponseBody
    public CommonResult<Object> testSimpleParam(@PathVariable String id){
        return feignService.testSimpleParam(id);
    }

    @GetMapping("testListParam")
    @ResponseBody
    public CommonResult<Object> testListParam(){
        return feignService.testListParam();
    }

    @GetMapping("testListMapParam")
    @ResponseBody
    public CommonResult<Object> testListMapParam(){
        CommonResult<Object> objectCommonResult = feignService.testListMapParam();
        System.out.println(JSONUtil.toJsonStr(objectCommonResult));
        return objectCommonResult;
    }
}
