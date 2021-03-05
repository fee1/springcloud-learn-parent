package com.zxf.external.feign;

import com.zxf.external.feign.impl.UserNameFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 朱晓峰
 */
@FeignClient(value = "nacos-ribbon", fallback = UserNameFeignImpl.class)
public interface UserNameFeign {

    @GetMapping("v1/nacos-ribbon/ribbon/user-name")
    @ResponseBody
    String getUserName();

}
