package com.lts.outworld_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lts.outworld_system.entity.SysUserEntity;
import com.lts.utils.PageUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Map;

/**
 * 系统用户
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-04-18 15:12:33
 */
public interface SysUserService extends IService<SysUserEntity> {

    /**
     * 查询用户信息
     * @param params 查询条件
     * @return 结果
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 登录接口
     * @param sysUserEntity 人员信息哦
     * @return 结果
     */
    String login(SysUserEntity sysUserEntity);
}

