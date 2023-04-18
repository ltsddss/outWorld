package com.lts.outworld_system.dao;

import com.lts.outworld_system.entity.SysUserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-04-18 15:12:33
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {
	
}
