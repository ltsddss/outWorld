package com.lts.outworld_member.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-07-05
 */
@Data
@ApiModel(value = "用户表")
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户主键")
	private Long userId;

	@ApiModelProperty(value = "用户名")
	private String userName;

	@ApiModelProperty(value = "用户昵称")
	private String nickName;

	@ApiModelProperty(value = "等级")
	private Integer level;

	@ApiModelProperty(value = "用户类型")
	private String userType;

	@ApiModelProperty(value = "邮箱")
	private String email;

	@ApiModelProperty(value = "电话")
	private String phoneNumber;

	@ApiModelProperty(value = "性别")
	private Integer gender;

	@ApiModelProperty(value = "")
	private Date birth;

	@ApiModelProperty(value = "简介")
	private String introduce;

	@ApiModelProperty(value = "头像地址")
	private String avatar;

	@ApiModelProperty(value = "成长值")
	private Integer growth;

	@ApiModelProperty(value = "密码")
	private String userPassword;

	@ApiModelProperty(value = "登录状态[1-在线，2-离线]")
	private String userLoginStatus;

	@ApiModelProperty(value = "用户状态[0-禁用，1-正常，2-删除]")
	private String userStatus;

	@ApiModelProperty(value = "用户密码输入错误次数(大于5次时禁用)")
	private Integer userErrorTime;

	@ApiModelProperty(value = "最后登录ip")
	private String userLoginIp;

	@ApiModelProperty(value = "最后登录时间")
	private Date loginDate;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "更新时间")
	private Date updateTime;

	@ApiModelProperty(value = "备注")
	private String remark;


}