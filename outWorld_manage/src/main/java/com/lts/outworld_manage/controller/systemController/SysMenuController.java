package com.lts.outworld_manage.controller.systemController;

import com.lts.outworld_manage.entity.system.SysMenu;
import com.lts.outworld_manage.service.system.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 获取菜单信息
     *
     * @return 菜单树结构
     */
    @GetMapping("/info")
    public String getMenuInfo(SysMenu sysMenu, Model model) {
        sysMenu.setId(0L);
        List<SysMenu> sysMenus = sysMenuService.selectMenu(sysMenu);
        model.addAttribute("menu", sysMenus);
        return "index";
    }

    /**
     * 新增菜单信息
     * @param sysMenu 菜单信息
     * @return 0、1
     */
    @PostMapping("/insert")
    public String addMenu(SysMenu sysMenu, Model model) {
        model.addAttribute("msg",sysMenuService.insertMenu(sysMenu));
        return "index";
    }
}
