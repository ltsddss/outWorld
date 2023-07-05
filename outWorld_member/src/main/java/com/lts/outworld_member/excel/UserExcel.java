package com.lts.outworld_member.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 用户表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-07-05
 */
@Data
public class UserExcel {
    @Excel(name = "用户主键")
    private Long userId;
    @Excel(name = "用户名")
    private String userName;
    @Excel(name = "用户昵称")
    private String nickName;
    @Excel(name = "等级")
    private Integer level;
    @Excel(name = "用户类型")
    private String userType;
    @Excel(name = "邮箱")
    private String email;
    @Excel(name = "电话")
    private String phoneNumber;
    @Excel(name = "性别")
    private Integer gender;
    @Excel(name = "")
    private Date birth;
    @Excel(name = "简介")
    private String introduce;
    @Excel(name = "头像地址")
    private String avatar;
    @Excel(name = "成长值")
    private Integer growth;
    @Excel(name = "密码")
    private String userPassword;
    @Excel(name = "登录状态[1-在线，2-离线]")
    private String userLoginStatus;
    @Excel(name = "用户状态[0-禁用，1-正常，2-删除]")
    private String userStatus;
    @Excel(name = "用户密码输入错误次数(大于5次时禁用)")
    private Integer userErrorTime;
    @Excel(name = "最后登录ip")
    private String userLoginIp;
    @Excel(name = "最后登录时间")
    private Date loginDate;
    @Excel(name = "创建时间")
    private Date createTime;
    @Excel(name = "更新时间")
    private Date updateTime;
    @Excel(name = "备注")
    private String remark;

}