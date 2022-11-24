package com.lts.outworld_manage.service.impl;

import com.lts.outworld_manage.dao.SysUserDao;
import com.lts.outworld_manage.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lts.outworld_manage.entity.SysUser;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;
    @Override
    public SysUser userInfo(String username) {
        return sysUserDao.userInfo(username);
    }
}
