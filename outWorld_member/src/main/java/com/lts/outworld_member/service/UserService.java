package com.lts.outworld_member.service;

import com.lts.outworld_member.dto.UserDTO;
import com.lts.outworld_member.entity.UserEntity;
import com.lts.service.CrudService;
import com.lts.utils.Result;


/**
 * 用户表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-07-05
 */
public interface UserService extends CrudService<UserEntity, UserDTO> {

    /**
     * 登录接口
     * @param userEntity 登录信息
     * @return 结果集
     */
    public Result<String> login(UserEntity userEntity);
}