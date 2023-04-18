package com.lts.outworld_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lts.exception.RRException;
import com.lts.outworld_system.dao.SysUserDao;
import com.lts.outworld_system.entity.SysUserEntity;
import com.lts.outworld_system.service.SysUserService;
import com.lts.utils.PageUtils;
import com.lts.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Autowired
    public SysUserDao sysUserDao;

    @Autowired
    public RedisTemplate<String,String> redisTemplate;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysUserEntity> page = this.page(
                new Query<SysUserEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

    @Override
    public String login(SysUserEntity sysUserEntity) {
//        先查询redis是否存在该用户的信息
        String userInfo = redisTemplate.opsForValue().get(sysUserEntity.getUsername());

//        redis中不存在，查询数据库是否存在
        QueryWrapper<SysUserEntity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",sysUserEntity.getUsername());
        List<SysUserEntity> sysUserEntities = sysUserDao.selectList(queryWrapper);

        if(sysUserEntities.size()==1){
//            说明数据库中存在一条该用户的信息，正常登录（将用户的信息存入redis）
        }
        else if(sysUserEntities.size()==0){
//            用户不存在(设置redis的用户的键值，防止redis被穿透)
        }
        else {
//            数据库错误（可能存在两条以上的用户数据）
            throw new RRException("系统错误，数据库中存在多条用户信息");
        }
        return null;
    }


}