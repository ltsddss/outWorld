package com.lts.outworld_system.service.impl;

import com.lts.outworld_system.dao.sysUserDao;
import com.lts.outworld_system.entity.SysUser;
import com.lts.outworld_system.service.sysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sysUserServiceImpl implements sysUserService {

    @Autowired
    private sysUserDao sysUserDao;

    @Override
    public SysUser userInfo(SysUser sysUser) {
        return sysUserDao.userInfo(sysUser);
    }
}
