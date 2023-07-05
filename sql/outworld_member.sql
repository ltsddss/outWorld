DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `user_id`           bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '用户主键',
    `user_name`         varchar(30)  NOT NULL COMMENT '用户名',
    `nick_name`         varchar(30)  DEFAULT NULL COMMENT '用户昵称',
    `level`             int(1)       DEFAULT NULL COMMENT '等级',
    `user_type`         varchar(2)   DEFAULT NULL COMMENT '用户类型',
    `email`             varchar(20)  DEFAULT NULL COMMENT '邮箱',
    `phone_number`      varchar(20)  DEFAULT NULL COMMENT '电话',
    `gender`            int(1)       DEFAULT NULL COMMENT '性别',
    `birth`             datetime     DEFAULT NULL,
    `introduce`         varchar(20)  DEFAULT NULL COMMENT '简介',
    `avatar`            varchar(100) DEFAULT NULL COMMENT '头像地址',
    `growth`            int(10)      DEFAULT NULL COMMENT '成长值',
    `user_password`     varchar(100) NOT NULL COMMENT '密码',
    `user_login_status` varchar(1)   DEFAULT NULL COMMENT '登录状态[1-在线，2-离线]',
    `user_status`       varchar(1)   DEFAULT NULL COMMENT '用户状态[0-禁用，1-正常，2-删除]',
    `user_error_time`   int(1)       DEFAULT '0' COMMENT '用户密码输入错误次数(大于5次时禁用)',
    `user_login_ip`     varchar(255) DEFAULT NULL COMMENT '最后登录ip',
    `login_date`        datetime     DEFAULT NULL COMMENT '最后登录时间',
    `create_time`       datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`       datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`            varchar(100) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='用户表';

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user_login_log`
(
    `id`          BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_id`     BIGINT(20) NOT NULL COMMENT '用户id',
    `create_time` datetime    DEFAULT NULL COMMENT '登录时间',
    `ip`          varchar(64) DEFAULT NULL COMMENT '登录ip',
    `login_type`  tinyint(1)  DEFAULT NULL COMMENT '登录类型[1-web，2-app]',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='登录记录表';