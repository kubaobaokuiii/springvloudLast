/*
Navicat MySQL Data Transfer

Source Server         : bendi
Source Server Version : 50024
Source Host           : localhost:3306
Source Database       : guoadmin

Target Server Type    : MYSQL
Target Server Version : 50024
File Encoding         : 65001

Date: 2019-04-18 15:03:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ad_user
-- ----------------------------
DROP TABLE IF EXISTS `ad_user`;
CREATE TABLE `ad_user` (
  `user_id` int(255) NOT NULL auto_increment,
  `update_time` date default NULL,
  `create_time` date default NULL,
  `user_status` int(255) default NULL,
  `token` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ad_user
-- ----------------------------
