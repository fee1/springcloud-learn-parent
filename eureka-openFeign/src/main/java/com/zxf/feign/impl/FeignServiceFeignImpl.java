package com.zxf.feign.impl;

import com.zxf.api.CommonResult;
import com.zxf.api.ResultCode;
import com.zxf.feign.FeignServiceFeign;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class FeignServiceFeignImpl implements FeignServiceFeign {
    @Override
    public CommonResult<Object> test() {
        System.out.println("服务降级");
        return CommonResult.failed();
    }

    @Override
    public CommonResult<Object> testError() {
        System.out.println("服务降级");
        return CommonResult.failed(ResultCode.FAILED);
    }

    @Override
    public CommonResult<Object> testSimpleParam(String id) {
        System.out.println("服务降级");
        return CommonResult.failed(ResultCode.FAILED);
    }

    @Override
    public CommonResult<Object> testListParam(List<String> list) {
        System.out.println("服务降级");
        return CommonResult.failed(ResultCode.FAILED);
    }

    @Override
    public CommonResult<Object> testListMapParam(List<Map<String, String>> mapList) {
        return null;
    }
}
