package com.lts.outworld_member.dao;

import com.lts.dao.BaseDao;
import com.lts.outworld_member.entity.UserLoginLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 登录记录表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-07-05
 */
@Mapper
public interface UserLoginLogDao extends BaseDao<UserLoginLogEntity> {
	
}