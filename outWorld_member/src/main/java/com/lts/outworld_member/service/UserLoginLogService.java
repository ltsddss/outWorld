package com.lts.outworld_member.service;

import com.lts.outworld_member.dto.UserLoginLogDTO;
import com.lts.outworld_member.entity.UserLoginLogEntity;
import com.lts.service.CrudService;


/**
 * 登录记录表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-07-05
 */
public interface UserLoginLogService extends CrudService<UserLoginLogEntity, UserLoginLogDTO> {

}