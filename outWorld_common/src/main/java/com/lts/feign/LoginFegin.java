package com.lts.feign;

import com.lts.config.LoginFeginFactory;
import com.lts.contant.ServiceNameContant;
import com.lts.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(contextId = "userService" ,value = ServiceNameContant.SYSTEMNAME,fallbackFactory = LoginFeginFactory.class)
public interface LoginFegin {
    /**
     * 远程功能调用
     */
    @GetMapping("/system/login")
    public R getUserInfo(@PathVariable("username") String username);
}
