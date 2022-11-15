package com.lts.outworld_system.service;

import com.lts.outworld_system.entity.SysUser;

public interface sysUserService {
    /**
     * 根据用户名查询用户信息
     * @param sysUser 用户名
     * @return 用户信息
     */
    SysUser userInfo(SysUser sysUser);
}
