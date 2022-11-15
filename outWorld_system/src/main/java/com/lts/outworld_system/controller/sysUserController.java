package com.lts.outworld_system.controller;

import com.lts.outworld_system.entity.SysUser;
import com.lts.outworld_system.service.sysUserService;
import com.lts.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system")
public class sysUserController {

    @Autowired
    private sysUserService sysUserService;

    /**
     *  登录接口
     * @param sysUser 登录需要的信息
     * @return 返回结果
     */
    @GetMapping("/login")
    public R login(@RequestBody SysUser sysUser){
        SysUser userInfo = sysUserService.userInfo(sysUser);
        return R.ok().put("data",userInfo);
    }

    /**
     * 注册接口
     * @param sysUser 注册需要的信息
     * @return 返回结果
     */
    @PostMapping("/register")
    public R register(@RequestBody SysUser sysUser){
        return R.ok();
    }

    /**
     * 删除用户信息接口（逻辑删除，将用户的状态置2）
     * @param sysUser 需要删除的用户信息
     * @return 返回结果
     */
    @PostMapping("/deleteById")
    public R deleteUser(@RequestBody SysUser sysUser){
        return R.ok();
    }
}
