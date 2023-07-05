package com.lts.outworld_member.service;

import io.renren.common.service.CrudService;
import io.renren.modules.demo.dto.UserDTO;
import io.renren.modules.demo.entity.UserEntity;

/**
 * 用户表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-07-05
 */
public interface UserService extends CrudService<UserEntity, UserDTO> {

}