package com.lts.outworld_system.dao;

import com.lts.outworld_system.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysMenuDao {
    /**
     * 查询菜单结构
     * @param sysMenu 要查询的菜单参数
     * @return 所有菜单结构
     */
    public List<SysMenu> selectMenu(SysMenu sysMenu);
}
