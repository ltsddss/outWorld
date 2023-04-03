package com.lts.outworld_manage;

import com.lts.outworld_manage.entity.system.SysMenu;
import com.lts.outworld_manage.service.system.SysMenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OutWorldManageApplicationTests {

    @Autowired
    private SysMenuService sysMenuService;
    @Test
    void contextLoads() {
        SysMenu menu = new SysMenu();
        menu.setId(0L);
        List<SysMenu> sysMenus = sysMenuService.selectMenu(menu);
        for (SysMenu sysMenu : sysMenus) {
            System.out.println(sysMenu.toString());
        }

    }

}
