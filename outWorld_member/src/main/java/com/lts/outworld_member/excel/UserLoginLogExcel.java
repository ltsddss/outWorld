package com.lts.outworld_member.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 登录记录表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-07-05
 */
@Data
public class UserLoginLogExcel {
    @Excel(name = "id")
    private Long id;
    @Excel(name = "用户id")
    private Long userId;
    @Excel(name = "登录时间")
    private Date createTime;
    @Excel(name = "登录ip")
    private String ip;
    @Excel(name = "登录类型[1-web，2-app]")
    private Integer loginType;

}