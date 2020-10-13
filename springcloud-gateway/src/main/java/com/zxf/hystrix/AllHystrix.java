package com.zxf.hystrix;

import com.zxf.api.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllHystrix {

    @GetMapping("/fallBack")
    public CommonResult<Object> fallBack(){
        return CommonResult.failed();
    }

}
