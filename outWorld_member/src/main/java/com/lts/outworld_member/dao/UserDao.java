package com.lts.outworld_member.dao;

import com.lts.dao.BaseDao;
import com.lts.outworld_member.entity.UserEntity;
import com.lts.utils.Result;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-07-05
 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {
    /**
     * 登录接口
     * @param userEntity 登录信息
     * @return 结果集
     */
	public UserEntity login(UserEntity userEntity);

    /**
     * 注册接口
     * @param userEntity 注册信息
     * @return 结果集
     */
	public UserEntity register(UserEntity userEntity);
}