package com.lts.outworld_auth.controller;

import com.lts.outworld_auth.entity.LoginBody;
import com.lts.outworld_auth.entity.LoginInfo;
import com.lts.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    /**
     * 登录接口
     * @param loginBody 登录信息
     * @return Token信息
     */
    @GetMapping("/login")
    public R Login(@RequestBody LoginBody loginBody){

        return R.ok();
    }
}
