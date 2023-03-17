/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : outworld_sys

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2023-03-17 09:04:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for live_borast
-- ----------------------------
DROP TABLE IF EXISTS `live_borast`;
CREATE TABLE `live_borast` (
  `borast_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '直播id',
  `borast_img` varchar(100) DEFAULT NULL COMMENT '直播间显示图片',
  `borast_introduce` varchar(2000) DEFAULT '这个博主很懒什么也没有写~~~~' COMMENT '直播间简介',
  `borast_title` varchar(200) NOT NULL COMMENT '直播间标题',
  `borast_name` varchar(30) NOT NULL COMMENT '直播间名称(一般是开直播的用户的用户名)',
  `borast_partition` int(1) DEFAULT NULL COMMENT '直播间分区(0 学习区，1游戏区)',
  `borast_type` int(1) DEFAULT '0' COMMENT '直播间标识(0 公共直播间，1 一对一直播间)',
  `borast_password` varchar(30) DEFAULT NULL COMMENT '直播间密码',
  `borast_status` int(1) DEFAULT '0' COMMENT '直播间状态(0 开始直播，1直播结束，2 直播间封禁中)',
  `borast_chat` int(1) DEFAULT '0' COMMENT '直播间是否禁言(0 不禁言，1禁言)',
  PRIMARY KEY (`borast_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='直播间表';

-- ----------------------------
-- Records of live_borast
-- ----------------------------
INSERT INTO `live_borast` VALUES ('1', null, '0', '0', '0', null, '1', null, '1', '1');
INSERT INTO `live_borast` VALUES ('2', '/test', '测试', '测试', 'admin', '0', '0', '123456', '0', '0');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `MENUNAME` varchar(200) DEFAULT NULL COMMENT '菜单名称',
  `PARENTID` bigint(20) DEFAULT NULL COMMENT '父菜单id',
  `ORDERNUM` int(3) DEFAULT NULL COMMENT '显示顺序',
  `PATH` varchar(200) DEFAULT NULL COMMENT '路由地址',
  `TYPE` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `ICON` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '0', '0', 'system', '0', null);
INSERT INTO `sys_menu` VALUES ('2', '用户管理', '1', '0', 'user', '0', null);
INSERT INTO `sys_menu` VALUES ('3', '角色管理', '1', '1', 'role', '0', null);
INSERT INTO `sys_menu` VALUES ('4', '菜单管理', '1', '2', 'menu', '0', null);
INSERT INTO `sys_menu` VALUES ('5', '直播间管理', '0', '1', 'liveborast', '0', null);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `ID` bigint(20) NOT NULL COMMENT 'ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` varchar(60) NOT NULL COMMENT '用户主键',
  `user_name` varchar(30) NOT NULL COMMENT '用户名',
  `nick_name` varchar(30) DEFAULT NULL COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT NULL COMMENT '用户类型',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `phone_number` varchar(20) DEFAULT NULL COMMENT '电话',
  `gender` int(1) DEFAULT NULL COMMENT '性别',
  `avatar` varchar(100) DEFAULT NULL COMMENT '头像地址',
  `user_password` varchar(100) NOT NULL COMMENT '密码',
  `user_login_status` varchar(1) DEFAULT NULL,
  `user_status` varchar(1) DEFAULT NULL COMMENT '用户状态（0禁用），（1正常），（2删除）',
  `user_login_ip` varchar(255) DEFAULT NULL COMMENT '最后登录ip',
  `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(30) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('0', 'admin', '超级管理员', '0', null, null, null, null, 'c4ca4238a0b923820dcc509a6f75849b', null, '1', null, null, null, '2022-11-14 09:57:36', '2022-11-14 09:57:39', '超级管理员');
INSERT INTO `sys_user` VALUES ('6f55489d-f9cf-4ab2-979d-05cd6bd60938', '123', '会员49611000', null, null, null, null, null, '202cb962ac59075b964b07152d234b70', null, '1', null, null, null, '2023-03-16 14:32:44', null, null);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `USERID` bigint(20) DEFAULT NULL COMMENT '用户id',
  `ROLEID` bigint(20) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
