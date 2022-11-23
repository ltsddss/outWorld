package com.lts.outworld_auth.service;

import com.lts.entity.SysUser;
import com.lts.exception.ServiceException;
import com.lts.feign.LoginFegin;
import com.lts.entity.LoginInfo;
import com.lts.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {

    @Autowired
    public LoginFegin loginFegin;
    /**
     * 远程调用system模块的登录接口完成登录（TODO：之后写授权与认证）
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    public LoginInfo Login(String username,String password){
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
        R<SysUser> sysuserResult= loginFegin.getUserInfo(username);

        if(null==sysuserResult.getData()){
//            用户不存在
            throw new ServiceException("该用户不存在");
        }
//        用户存在
        LoginInfo loginInfo=new LoginInfo();
        loginInfo.setUserName(sysuserResult.getData().getUserName());
        loginInfo.setUserPassword(sysuserResult.getData().getUserPassword());
        return loginInfo;
    }
}
