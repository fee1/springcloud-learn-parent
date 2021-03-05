package com.zxf.external.feign.impl;

import com.zxf.external.feign.UserNameFeign;
import org.springframework.stereotype.Component;

/**
 * @author 朱晓峰
 */
@Component
public class UserNameFeignImpl implements UserNameFeign {
    @Override
    public String getUserName() {
        return "调用失败";
    }
}
