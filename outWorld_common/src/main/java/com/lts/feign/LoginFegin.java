package com.lts.feign;

import com.lts.config.LoginFeginFactory;
import com.lts.contant.ServiceNameContant;
import com.lts.entity.LoginInfo;
import com.lts.entity.SysUser;
import com.lts.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(contextId = "userService" ,value = ServiceNameContant.SYSTEMNAME,fallbackFactory = LoginFeginFactory.class)
public interface LoginFegin {
    /**
     * 远程功能调用
     */
    @GetMapping("/system/login/{username}")
    public R<SysUser> getUserInfo(@PathVariable("username") String username);

    @PostMapping("/system/register")
    public R<Integer> Register(@RequestBody LoginInfo loginInfo);
}
