package com.zxf.controller;

import com.zxf.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class TargetRibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getRibbon")
    @ResponseBody
    public CommonResult getRibbon(String id){
        return restTemplate.getForObject("http://target/getRibbon?id={1}", CommonResult.class, id);
    }

    @PostMapping("/postRibbon")
    @ResponseBody
    public CommonResult postRibbon(){
        return restTemplate.postForObject("http://target/postRibbon", "", CommonResult.class);
    }

}
