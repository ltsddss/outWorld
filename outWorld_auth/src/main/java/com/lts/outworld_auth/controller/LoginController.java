package com.lts.outworld_auth.controller;

import com.lts.exception.ServiceException;
import com.lts.outworld_auth.entity.LoginBody;
import com.lts.entity.LoginInfo;
import com.lts.outworld_auth.service.LoginService;
import com.lts.utils.JWTUtils;
import com.lts.utils.MD5;
import com.lts.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录接口
     * @param loginBody 登录信息
     * @return Token信息
     */
    @PostMapping("/login")
    public R Login(@RequestBody LoginBody loginBody){
        R login = loginService.Login(loginBody.getUserName(),loginBody.getUserPassword());
//        判断密码是否正确
        if(!Objects.equals(MD5.encryptToMD5(loginBody.getUserName()), loginBody.getUserPassword())){
            throw new ServiceException("密码错误");
        }
        if(!Objects.equals("1",login.get("msg"))){
            throw new ServiceException("用户被禁用");
        }
//        利用login来制作token
        String token=JWTUtils.acquireJWT("令牌",loginBody.getUserName(),loginBody.getUserPassword());
        return R.ok(token);
    }

    @PostMapping("/Register")
    public R Register(@RequestBody LoginBody loginBody){
//        注册接口
        Boolean register = loginService.Register(loginBody.userName, loginBody.userPassword);
        return R.ok().put("msg",register);
    }
}
