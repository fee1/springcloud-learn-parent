package com.zxf.controller;

import com.zxf.api.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class FeignTestController {

    @GetMapping("feignTest")
    @ResponseBody
    public CommonResult<Object> test(){
        return CommonResult.success("feign", "feign 调用成功！");
    }

    @GetMapping("feignTestError")
    @ResponseBody
    public CommonResult<Object> testError() throws Exception{
//        return CommonResult.success("feign", "feign 调用成功！");
        throw new RuntimeException("容错测试");
    }

    @GetMapping("feignTestSimpleParam/{id}")
    @ResponseBody
    public CommonResult<Object> testSimpleParam(@PathVariable String id){
        return CommonResult.success(id, "成功");
    }

    @PostMapping("testListParam")
    @ResponseBody
    public CommonResult<Object> testListParam(@RequestBody List<String> list){
        return CommonResult.success(list, "成功");
    }

    @PostMapping("testListMapParam")
    @ResponseBody
    public CommonResult<Object> testListMapParam(@RequestBody List<Map<String, String>> mapList){

        return CommonResult.success(mapList, "成功");
    }

}
