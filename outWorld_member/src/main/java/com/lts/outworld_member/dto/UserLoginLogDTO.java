package com.lts.outworld_member.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 登录记录表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-07-05
 */
@Data
@ApiModel(value = "登录记录表")
public class UserLoginLogDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "用户id")
	private Long userId;

	@ApiModelProperty(value = "登录时间")
	private Date createTime;

	@ApiModelProperty(value = "登录ip")
	private String ip;

	@ApiModelProperty(value = "登录类型[1-web，2-app]")
	private Integer loginType;


}