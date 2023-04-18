package com.lts.outworld_system.controller;

import java.util.Arrays;
import java.util.Map;

import com.lts.outworld_system.entity.SysUserEntity;
import com.lts.outworld_system.service.SysUserService;
import com.lts.utils.PageUtils;
import com.lts.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 系统用户
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-04-18 15:12:33
 */
@RestController
@RequestMapping("outworld_system/sysuser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 登录接口
     * @param sysUserEntity 登录实体类
     * @return 结果
     */
    @GetMapping("/login")
    public R login(@RequestParam SysUserEntity sysUserEntity){
        String login = sysUserService.login(sysUserEntity);
        return R.ok().put("msg",login);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysUserService.queryPage(params);
        return R.ok().put("page", page);
    }




    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    public R info(@PathVariable("userId") Long userId){
		SysUserEntity sysUser = sysUserService.getById(userId);

        return R.ok().put("sysUser", sysUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SysUserEntity sysUser){
		sysUserService.save(sysUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SysUserEntity sysUser){
		sysUserService.updateById(sysUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] userIds){
		sysUserService.removeByIds(Arrays.asList(userIds));

        return R.ok();
    }

}
