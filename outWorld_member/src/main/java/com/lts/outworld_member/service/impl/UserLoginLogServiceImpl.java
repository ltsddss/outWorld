package com.lts.outworld_member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lts.outworld_member.entity.UserLoginLogEntity;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.demo.dao.UserLoginLogDao;
import io.renren.modules.demo.dto.UserLoginLogDTO;
import io.renren.modules.demo.entity.UserLoginLogEntity;
import io.renren.modules.demo.service.UserLoginLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 登录记录表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-07-05
 */
@Service
public class UserLoginLogServiceImpl extends CrudServiceImpl<UserLoginLogDao, UserLoginLogEntity, UserLoginLogDTO> implements UserLoginLogService {

    @Override
    public QueryWrapper<UserLoginLogEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<UserLoginLogEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}