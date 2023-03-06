package com.lts.outworld_system.service.impl;

import com.lts.outworld_system.dao.SysUserDao;
import com.lts.outworld_system.entity.SysUser;
import com.lts.outworld_system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUser userInfo(SysUser sysUser) {
        return sysUserDao.userInfo(sysUser);
    }

    @Override
    public Integer registerUser(SysUser sysUser) {
        return sysUserDao.registerUser(sysUser);
    }
}
