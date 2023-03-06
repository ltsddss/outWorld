package com.lts.outworld_system.controller;

import com.lts.outworld_system.entity.SysMenu;
import com.lts.outworld_system.service.SysMenuService;
import com.lts.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;
    /**
     * 获取菜单信息
     * @return 菜单树结构
     */
    @GetMapping("/info")
    public R<List<SysMenu>> getMenuInfo(SysMenu sysMenu){
        sysMenu.setId(0L);
        List<SysMenu> sysMenus = sysMenuService.selectMenu(sysMenu);
        return R.ok(sysMenus);
    }
}
