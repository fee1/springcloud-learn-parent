package com.zxf.controller;

import com.zxf.api.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RibbonTestController {

    @GetMapping("/getRibbon")
    public CommonResult<Map<String, String>> forGetObject(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "xiaoming");
        map.put("age", "20");
        return CommonResult.success(map);
    }

    @PostMapping("/postRibbon")
    public CommonResult<Map<String, String>> forPostObject(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "xiaoming");
        map.put("age", "20");
        return CommonResult.success(map);
    }

}
