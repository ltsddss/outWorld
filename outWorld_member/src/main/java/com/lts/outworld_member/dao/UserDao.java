package com.lts.outworld_member.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-07-05
 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {
	
}