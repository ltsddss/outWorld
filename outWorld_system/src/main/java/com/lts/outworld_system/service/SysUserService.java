package com.lts.outworld_system.service;

import com.lts.outworld_system.entity.SysUser;

public interface SysUserService {
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 用户信息
     */
    SysUser userInfo(String username);

    /**
     * 注册用户信息
     * @param sysUser 用户信息
     * @return 是否注册成功
     */
    Integer registerUser(SysUser sysUser);
}
