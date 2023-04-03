package com.lts.outworld_manage.service.system;


import com.lts.outworld_manage.entity.system.SysMenu;

import java.util.List;

public interface SysMenuService {
    /**
     * 查询菜单结构
     * @param sysMenu 要查询的菜单参数
     * @return 所有菜单结构
     */
    public List<SysMenu> selectMenu(SysMenu sysMenu);

    /**
     * 新增菜单结构
     * @param sysMenu 要新增菜单的信息
     * @return 0、1
     */
    public int insertMenu(SysMenu sysMenu);
}
