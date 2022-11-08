package com.lts.outworld_system.service.impl;

import com.lts.outworld_system.dao.sysUserDao;
import com.lts.outworld_system.entity.sysUser;
import com.lts.outworld_system.service.sysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sysUserServiceImpl implements sysUserService {

    @Autowired
    private sysUserDao sysUserDao;

    @Override
    public sysUser userInfo(String username) {
        return sysUserDao.userInfo(username);
    }
}
