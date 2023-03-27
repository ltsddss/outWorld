package com.lts.outworld_manage.controller;

import com.lts.outworld_manage.entity.system.SysUser;
import com.lts.utils.R;
import org.springframework.web.bind.annotation.*;

@RestController("/mapper/manage")
public class SysUserController {
    /**
     * 实现对于sysUser表的增删查改
     */

    /**
     * 根据username查询用户信息
     * @param sysUser 前台传来的用户信息
     * @return 返回用户的信息
     */
    @GetMapping("/UserInfo")
    public R getSysUserInfo(@RequestBody SysUser sysUser){
        return R.ok();
    }

    /**
     * 逻辑删除用户的信息
     * @param sysUser 前台传来的用户信息
     * @return 是否删除成功
     */
    @PostMapping("/deleteUserInfo")
    public R deleteUserInfo(@RequestBody SysUser sysUser){
        return R.ok();
    }

    /**
     * 向表中新增一个用户的信息
     * @param sysUser 前台传来的用户信息
     * @return 是否插入成功
     */
    @PostMapping("/insertUserInfo")
    public R insertUserInfo(@RequestBody SysUser sysUser){
        return R.ok();
    }

    /**
     * 根据用户的用户名称修改用户的信息
     * @param sysUser 前台传来的用户信息
     * @return 是否修改成功
     */
    @PostMapping("/updateUserInfo")
    public R updateUserInfo(@RequestBody SysUser sysUser){
        return R.ok();
    }
}
