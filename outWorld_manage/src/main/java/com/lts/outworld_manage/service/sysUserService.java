package com.lts.outworld_manage.service;

import com.lts.outworld_manage.entity.sysUser;

public interface sysUserService {
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 用户信息
     */
    sysUser userInfo(String username);
}
