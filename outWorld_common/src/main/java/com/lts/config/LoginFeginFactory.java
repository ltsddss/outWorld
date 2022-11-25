package com.lts.config;

import com.lts.entity.LoginInfo;
import com.lts.entity.SysUser;
import com.lts.feign.LoginFegin;
import com.lts.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class LoginFeginFactory implements FallbackFactory<LoginFegin> {

    private final Logger log=LoggerFactory.getLogger(LoginFeginFactory.class);

    @Override
    public LoginFegin create(Throwable cause) {
        log.error("用户服务调用失败:{}", cause.getMessage());
        return username -> R.fail("获取用户失败:" + cause.getMessage());
    }
}
