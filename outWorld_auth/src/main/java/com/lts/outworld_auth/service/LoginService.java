package com.lts.outworld_auth.service;

import com.lts.entity.LoginInfo;
import com.lts.entity.SysUserEntity;
import com.lts.feign.LoginFegin;
import com.lts.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {

    @Autowired
    public LoginFegin loginFegin;
    /**
     * 远程调用system模块的登录接口完成登录（TODO：之后写授权与认证）
     * @param username 用户
     * @return 用户信息
     */
    public R Login(String username,String password){
        //TODO: 之后放开
////        判断username与password是否是数字,字符和特殊符号的组合
//        if(Stringutils.isTrue(username)&&Stringutils.isTrue(password)){
//            throw new ServiceException("用户名或密码不是数字，字符或特殊符号的组合");
//        }
////        禁止输入信息录入(sql注入与html注入)
//        if(!(SQLFilter.sql(username)&&SQLFilter.sql(password))){
//            throw new ServiceException("禁止输入无效信息");
//        }
//        查询用户信息
        return loginFegin.getUserInfo(new SysUserEntity(username,password));
    }

    public Boolean Register(String username,String password){
//        TODO: 判断输入是否合法
        //        查询用户信息,是否已经注册过
        R sysuserResult= loginFegin.getUserInfo(new SysUserEntity(username,password));

        if(null==sysuserResult.get("page")){
//            并不存在该用户的信息
            LoginInfo loginInfo=new LoginInfo();
            loginInfo.setUserName(username);
            loginInfo.setUserPassword(password);
            R register = loginFegin.Register(loginInfo);
            if(1==(int)register.get("msg")){
//                注册成功
                return true;
            }
        }
        return false;
    }
}
