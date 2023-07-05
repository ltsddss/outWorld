package com.lts.outworld_member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lts.outworld_member.dao.UserDao;
import com.lts.outworld_member.dto.UserDTO;
import com.lts.outworld_member.entity.UserEntity;
import com.lts.outworld_member.service.UserService;
import com.lts.service.impl.CrudServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 用户表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-07-05
 */
@Service
public class UserServiceImpl extends CrudServiceImpl<UserDao, UserEntity, UserDTO> implements UserService {

    @Override
    public QueryWrapper<UserEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}