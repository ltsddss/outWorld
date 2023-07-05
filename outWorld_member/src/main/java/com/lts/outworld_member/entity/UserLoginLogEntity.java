package com.lts.outworld_member.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 登录记录表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-07-05
 */
@Data
@TableName("sys_user_login_log")
public class UserLoginLogEntity {

    /**
     * id
     */
	private Long id;
    /**
     * 用户id
     */
	private Long userId;
    /**
     * 登录时间
     */
	private Date createTime;
    /**
     * 登录ip
     */
	private String ip;
    /**
     * 登录类型[1-web，2-app]
     */
	private Integer loginType;
}