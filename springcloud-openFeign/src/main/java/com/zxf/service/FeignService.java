package com.zxf.service;

import com.zxf.api.CommonResult;
import com.zxf.feign.FeignServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FeignService {

    @Autowired
    private FeignServiceFeign feignServiceFeign;

    public CommonResult<Object> test(){
        return feignServiceFeign.test();
    }

    public CommonResult<Object> testError() {
        return feignServiceFeign.testError();
    }

    public CommonResult<Object> testSimpleParam(String id) {
        return feignServiceFeign.testSimpleParam(id);
    }

    public CommonResult<Object> testListParam() {
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        return feignServiceFeign.testListParam(list);
    }

    public CommonResult<Object> testListMapParam() {
        List<Map<String, String>> mapList = new ArrayList<>();
        for (int i=1 ; i<=3; i++){
            Map<String, String> map = new HashMap<>();
            map.put(String.valueOf(i), i+""+i+""+i);
            mapList.add(map);
        }
        return feignServiceFeign.testListMapParam(mapList);
    }
}
