/*
Navicat MySQL Data Transfer

Source Server         : bendi
Source Server Version : 50024
Source Host           : localhost:3306
Source Database       : guoadmin

Target Server Type    : MYSQL
Target Server Version : 50024
File Encoding         : 65001

Date: 2019-04-18 15:03:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ad_plan
-- ----------------------------
DROP TABLE IF EXISTS `ad_plan`;
CREATE TABLE `ad_plan` (
  `update_time` varchar(255) default NULL COMMENT '更新时间',
  `create_time` varchar(255) default NULL COMMENT '创建时间',
  `end_date` varchar(255) default NULL COMMENT '推广计划结束时间',
  `start_date` varchar(255) default NULL COMMENT '推广计划开始时间',
  `plan_status` varchar(255) default NULL COMMENT '推广计划状态',
  `plan_name` varchar(255) default NULL COMMENT '推广计划名称',
  `plan_id` int(255) NOT NULL auto_increment,
  `user_id` int(255) default NULL,
  PRIMARY KEY  (`plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ad_plan
-- ----------------------------
