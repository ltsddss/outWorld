package com.lts.outworld_manage.dao;

import com.lts.outworld_manage.entity.sysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface sysUserDao {
    /**
     * 根据用户名查询用户信息（去掉用户状态是2的用户）
     * @param username 用户名
     * @return 用户信息
     */
    sysUser userInfo(String username);

    /**
     * 新增用户信息
     * @param sysUser 需要新增的用户信息
     * @return
     */
    int insertUserInfo(sysUser sysUser);

    /**
     * 根据用户名删除用户的信息（逻辑删除）
     * @param userName 用户名
     * @return
     */
    int deleteUserInfo(String userName);

    /**
     * 修改用户信息
     * @param sysUser 需要修改的用户信息
     * @return
     */
    int updateUserInfo(sysUser sysUser);
}
