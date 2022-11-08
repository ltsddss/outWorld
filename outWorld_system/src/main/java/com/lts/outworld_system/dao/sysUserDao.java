package com.lts.outworld_system.dao;

import com.lts.outworld_system.entity.sysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface sysUserDao {
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 用户信息
     */
    sysUser userInfo(String username);
}
