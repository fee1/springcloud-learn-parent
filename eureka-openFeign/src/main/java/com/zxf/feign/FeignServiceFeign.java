package com.zxf.feign;

import com.zxf.api.CommonResult;
import com.zxf.feign.impl.FeignServiceFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@FeignClient(value = "target", fallback = FeignServiceFeignImpl.class)
public interface FeignServiceFeign {

    @GetMapping("feignTest")
    CommonResult<Object> test();

    @GetMapping("feignTestError")
    CommonResult<Object> testError();

    @GetMapping("feignTestSimpleParam/{id}")
    CommonResult<Object> testSimpleParam(@PathVariable String id);

    @PostMapping("testListParam")
    CommonResult<Object> testListParam(@RequestBody List<String> list);

    @PostMapping("testListMapParam")
    CommonResult<Object> testListMapParam(List<Map<String, String>> mapList);
}
