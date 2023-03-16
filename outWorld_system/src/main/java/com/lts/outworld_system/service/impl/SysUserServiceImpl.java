package com.lts.outworld_system.service.impl;

import com.lts.outworld_system.dao.SysUserDao;
import com.lts.outworld_system.entity.SysUser;
import com.lts.outworld_system.service.SysUserService;
import com.lts.utils.DateUtils;
import com.lts.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUser userInfo(String username) {
        SysUser sysUser=new SysUser();
//        查询用户名
        sysUser.setUserName(username);
        return sysUserDao.userInfo(sysUser);
    }

    @Override
    public Integer registerUser(SysUser sysUser) {
        Random random=new Random();
//        设置默认的UUID作为user_id
        sysUser.setUserId(UUID.randomUUID().toString());
//        对password进行加密
        sysUser.setUserPassword(MD5.encryptToMD5(sysUser.getUserPassword()));
//        设置用户昵称
        sysUser.setNickName("会员"+random.nextInt(9999-1000+1)+1000);
//        设置创建时间
        sysUser.setCreateTime(DateUtils.getLocalDate());
//        设置用户状态（正常）
        sysUser.setUserStatus("1");
        return sysUserDao.registerUser(sysUser);
    }
}
