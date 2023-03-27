package com.lts.outworld_manage.service.system;

import com.lts.outworld_manage.entity.system.SysUser;

public interface SysUserService {
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 用户信息
     */
    SysUser userInfo(String username);
}
