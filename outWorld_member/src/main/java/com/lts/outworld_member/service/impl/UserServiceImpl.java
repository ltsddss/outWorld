package com.lts.outworld_member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lts.contant.ExceptionContant;
import com.lts.outworld_member.dao.UserDao;
import com.lts.outworld_member.dto.UserDTO;
import com.lts.outworld_member.entity.UserEntity;
import com.lts.outworld_member.service.UserService;
import com.lts.service.impl.CrudServiceImpl;
import com.lts.utils.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public UserDao userDao;

    @Override
    public QueryWrapper<UserEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


    @Override
    public Result<String> login(UserEntity userEntity) {
        UserEntity userInfo = userDao.login(userEntity);
//        当用户名为空时
        if(null==userInfo){
            return new Result<String>().error(404).error(ExceptionContant.LoginError404);
        }
        else {
//            可以查到改用户，但该用户已被锁定
            if("0".equals(userInfo.getUserStatus())){
                return new Result<String>().error(405).error(ExceptionContant.LoginError405);
            }else if("2".equals(userInfo.getUserStatus())){
//                可以查到改用户，但该用户已被注销
                return new Result<String>().error(406).error(ExceptionContant.LoginError406);
            }else {
//                用户状态正常，但密码错误
                if(!userEntity.getUserPassword().equals(userInfo.getUserPassword())){
//                    判断用户输入密码错误次数，若等于4，则将账号禁用，需要管理员解锁，小于四次，则提醒用户
                    QueryWrapper<UserEntity> queryWrapper=new QueryWrapper<>();
                    queryWrapper.eq("user_name", userEntity.getUserName());
                    UserEntity entity = new UserEntity();
                    entity.setUserName(userEntity.getUserName());
                    entity.setUserErrorTime(userInfo.getUserErrorTime()+1);
                    if(4==userInfo.getUserErrorTime()){
                        entity.setUserStatus("0");
                        userDao.update(entity,queryWrapper);
                        return new Result<String>().error(407).error(ExceptionContant.LoginError407);
                    }
                    userDao.update(entity,queryWrapper);
                    return new Result<String>().error(408).error(ExceptionContant.LoginError408+(4-userInfo.getUserErrorTime()));
                }
                else {
//                    密码正确，制作用户的token，访问时需携带token进行文件访问

                }
            }

        }
        return null;
    }
}