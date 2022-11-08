package com.lts.outworld_manage.service.impl;

import com.lts.outworld_manage.dao.sysUserDao;
import com.lts.outworld_manage.service.sysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lts.outworld_manage.entity.sysUser;

@Service
public class sysUserServiceImpl implements sysUserService {

    @Autowired
    private sysUserDao sysUserDao;

    @Override
    public sysUser userInfo(String username) {
        return sysUserDao.userInfo(username);
    }
}
