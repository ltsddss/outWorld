package com.lts.outworld_manage.service.system.impl;

import com.lts.outworld_manage.entity.system.SysMenu;
import com.lts.outworld_manage.mapper.systemMapper.SysMenuMapper;
import com.lts.outworld_manage.service.system.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuDao;

    /**
     * 递归显示子菜单
     * @param sysMenu 要查询的菜单参数
     * @return 显示子菜单
     */
    @Override
    public List<SysMenu> selectMenu(SysMenu sysMenu) {

        List<SysMenu> sysMenus = sysMenuDao.selectMenu(sysMenu);

       return sysMenus.stream()
               .filter((menuEntity)-> Objects.equals(sysMenu.getId(), menuEntity.getParentId()))
               .map((menu)->{
            menu.setChildren(getchildren(menu,sysMenus));
            return menu;
        }).collect(Collectors.toList());
    }

    @Override
    public int insertMenu(SysMenu sysMenu) {
        return sysMenuDao.insertMenu(sysMenu);
    }

    /**
     * 递归显示所有的子菜单
     * @return 子菜单
     */
    private List<SysMenu> getchildren(SysMenu root,List<SysMenu> all){

        return all.stream().filter(sysMenuEntity -> {
            return sysMenuEntity.getParentId().equals(root.getId());
        }).map((sysMenuEntity)->{
            /**
             * 递归寻找子菜单
             */
            sysMenuEntity.setChildren(getchildren(sysMenuEntity,all));
            return sysMenuEntity;
        }).collect(Collectors.toList());
    }
}
