package com.lts.outworld_member.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 用户表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-07-05
 */
@Data
@TableName("sys_user")
public class UserEntity {

    /**
     * 用户主键
     */
	private Long userId;
    /**
     * 用户名
     */
	private String userName;
    /**
     * 用户昵称
     */
	private String nickName;
    /**
     * 等级
     */
	private Integer level;
    /**
     * 用户类型
     */
	private String userType;
    /**
     * 邮箱
     */
	private String email;
    /**
     * 电话
     */
	private String phoneNumber;
    /**
     * 性别
     */
	private Integer gender;
    /**
     * 
     */
	private Date birth;
    /**
     * 简介
     */
	private String introduce;
    /**
     * 头像地址
     */
	private String avatar;
    /**
     * 成长值
     */
	private Integer growth;
    /**
     * 密码
     */
	private String userPassword;
    /**
     * 登录状态[1-在线，2-离线]
     */
	private String userLoginStatus;
    /**
     * 用户状态[0-禁用，1-正常，2-删除]
     */
	private String userStatus;
    /**
     * 用户密码输入错误次数(大于5次时禁用)
     */
	private Integer userErrorTime;
    /**
     * 最后登录ip
     */
	private String userLoginIp;
    /**
     * 最后登录时间
     */
	private Date loginDate;
    /**
     * 创建时间
     */
	private Date createTime;
    /**
     * 更新时间
     */
	private Date updateTime;
    /**
     * 备注
     */
	private String remark;
}