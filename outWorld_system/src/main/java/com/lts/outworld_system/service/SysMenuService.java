package com.lts.outworld_system.service;


import com.lts.outworld_system.entity.SysMenu;

import java.util.List;

public interface SysMenuService {
    /**
     * 查询菜单结构
     * @param sysMenu 要查询的菜单参数
     * @return 所有菜单结构
     */
    public List<SysMenu> selectMenu(SysMenu sysMenu);
}
