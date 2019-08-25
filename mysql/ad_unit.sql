/*
Navicat MySQL Data Transfer

Source Server         : bendi
Source Server Version : 50024
Source Host           : localhost:3306
Source Database       : guoadmin

Target Server Type    : MYSQL
Target Server Version : 50024
File Encoding         : 65001

Date: 2019-04-18 15:03:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ad_unit
-- ----------------------------
DROP TABLE IF EXISTS `ad_unit`;
CREATE TABLE `ad_unit` (
  `unit_id` int(255) NOT NULL auto_increment,
  `update_time` varchar(255) default NULL COMMENT '更新时间',
  `create_time` varchar(255) default NULL COMMENT '创建时间',
  `budget` varchar(255) default NULL COMMENT '预算',
  `position_type` varchar(255) default NULL COMMENT '广告位的类型',
  `unit_status` varchar(255) default NULL COMMENT '推广单元状态',
  `unit_name` varchar(255) default NULL COMMENT '推广单元名称',
  `plan_id` int(255) default NULL,
  PRIMARY KEY  (`unit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ad_unit
-- ----------------------------
