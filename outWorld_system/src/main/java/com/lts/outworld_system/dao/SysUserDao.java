package com.lts.outworld_system.dao;

import com.lts.outworld_system.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserDao {
    /**
     * 根据用户名查询用户信息
     * @param sysUser 用户名
     * @return 用户信息
     */
    SysUser userInfo(SysUser sysUser);
}
