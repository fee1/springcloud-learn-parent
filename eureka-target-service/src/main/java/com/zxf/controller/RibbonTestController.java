package com.zxf.controller;

import com.zxf.api.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RibbonTestController {

    @Value("${service.name}")
    String serviceName;

    @GetMapping("/getRibbon")
    @ResponseBody
    public CommonResult<Map<String, String>> forGetObject(String id){
        Map<String, String> map = new HashMap<>();
        map.put("name", "xiaoming");
        map.put("age", "20");
        map.put("server", id);
        map.put("serviceName", serviceName);
        return CommonResult.success(map);
    }

    @PostMapping("/postRibbon")
    @ResponseBody
    public CommonResult<Map<String, String>> forPostObject(@RequestParam String id){
        Map<String, String> map = new HashMap<>();
        map.put("name", "xiaoming");
        map.put("age", "20");
        map.put("server", id);
        return CommonResult.success(map);
    }

}
