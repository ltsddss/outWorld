package com.lts.feign;

import com.lts.config.LoginFeginFactory;
import com.lts.contant.ServiceNameContant;
import com.lts.entity.LoginInfo;
import com.lts.entity.SysUserEntity;
import com.lts.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(contextId = "userService" ,value = ServiceNameContant.SYSTEMNAME,fallbackFactory = LoginFeginFactory.class)
public interface LoginFegin {
    /**
     * 远程功能调用
     */
    @GetMapping("/system/login}")
    public R getUserInfo(@RequestBody SysUserEntity sysUserEntity);

    @PostMapping("/system/register")
    public R Register(@RequestBody LoginInfo loginInfo);
}
