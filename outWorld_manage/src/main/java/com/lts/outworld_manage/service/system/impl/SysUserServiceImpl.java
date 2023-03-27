package com.lts.outworld_manage.service.system.impl;

import com.lts.outworld_manage.mapper.systemMapper.SysUserMapper;
import com.lts.outworld_manage.service.system.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lts.outworld_manage.entity.system.SysUser;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserDao;
    @Override
    public SysUser userInfo(String username) {
        return sysUserDao.userInfo(username);
    }
}
