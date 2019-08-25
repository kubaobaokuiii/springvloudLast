/*
Navicat MySQL Data Transfer

Source Server         : bendi
Source Server Version : 50024
Source Host           : localhost:3306
Source Database       : guoadmin

Target Server Type    : MYSQL
Target Server Version : 50024
File Encoding         : 65001

Date: 2019-04-18 15:03:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ad_creative
-- ----------------------------
DROP TABLE IF EXISTS `ad_creative`;
CREATE TABLE `ad_creative` (
  `type` varchar(255) default NULL,
  `name` varchar(255) default NULL COMMENT '创意名称',
  `creative_id` int(255) NOT NULL auto_increment,
  `update_time` varchar(255) default NULL,
  `create_time` varchar(255) default NULL,
  `url` varchar(255) default NULL COMMENT '物料地址',
  `user_id` int(255) default NULL,
  `audit_status` varchar(255) default NULL,
  `duration` varchar(255) default NULL COMMENT '持续时间，视频不为0',
  `size` varchar(255) default NULL,
  `material_type` varchar(255) default NULL COMMENT '物料子类型(bmp avi)',
  `width` varchar(255) default NULL,
  `height` varchar(255) default NULL,
  PRIMARY KEY  (`creative_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ad_creative
-- ----------------------------
