/*
Navicat MySQL Data Transfer

Source Server         : bendi
Source Server Version : 50024
Source Host           : localhost:3306
Source Database       : guoadmin

Target Server Type    : MYSQL
Target Server Version : 50024
File Encoding         : 65001

Date: 2019-04-18 15:03:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ad_unit_district
-- ----------------------------
DROP TABLE IF EXISTS `ad_unit_district`;
CREATE TABLE `ad_unit_district` (
  `district_id` int(255) NOT NULL auto_increment,
  `city` varchar(255) default NULL,
  `province` varchar(255) default NULL,
  `unit_id` int(255) default NULL,
  PRIMARY KEY  (`district_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ad_unit_district
-- ----------------------------
