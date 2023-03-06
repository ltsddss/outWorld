package com.lts.outworld_system.controller;

import com.lts.outworld_system.entity.SysUser;
import com.lts.outworld_system.service.SysUserService;
import com.lts.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     *  登录接口
     * @param username 登录需要的信息（userName）
     * @return 返回结果
     */
    @GetMapping("/login/{username}")
    public R<SysUser> login(@PathVariable("username") String username){
        SysUser sysUser=new SysUser();
        sysUser.setUserName(username);
        SysUser userInfo = sysUserService.userInfo(sysUser);
        return R.ok(userInfo);
    }

    /**
     * 注册接口
     * @param sysUser 注册需要的信息
     * @return 返回结果
     */
    @PostMapping("/register")
    public R<Integer> register(@RequestBody SysUser sysUser){
        Integer registerUser = sysUserService.registerUser(sysUser);
        return R.ok(registerUser);
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
