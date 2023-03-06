package com.lts.outworld_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMenu {
    /**
     * id
     */
    private Long id;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 父菜单id
     */
    private Long parentId;
    /**
     * 排序
     */
    private Integer orderNum;
    /**
     * 路径
     */
    private String path;
    /**
     * 菜单类型
     */
    private Integer type;
    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 子菜单集合
     */
    private List<SysMenu> children=new ArrayList<>();
}
