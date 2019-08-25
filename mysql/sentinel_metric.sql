/*
Navicat MySQL Data Transfer

Source Server         : bendi
Source Server Version : 50024
Source Host           : localhost:3306
Source Database       : metric

Target Server Type    : MYSQL
Target Server Version : 50024
File Encoding         : 65001

Date: 2019-06-11 14:44:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sentinel_metric
-- ----------------------------
DROP TABLE IF EXISTS `sentinel_metric`;
CREATE TABLE `sentinel_metric` (
  `rt` int(255) default NULL COMMENT '所有successQps的rt的和',
  `exception_qps` int(255) default NULL COMMENT '发送异常的次数',
  `block_qps` int(255) default NULL COMMENT '限流qps',
  `success_qps` int(255) default NULL COMMENT '成功qps',
  `pass_qps` int(255) default NULL COMMENT '通过qps',
  `resource` varchar(255) default NULL COMMENT '资源名称',
  `timestamp` datetime default NULL COMMENT '统计时间',
  `app` varchar(255) default NULL COMMENT '应用名称',
  `gmt_modified` datetime default NULL COMMENT '修改时间',
  `gmt_create` datetime default NULL COMMENT '创建时间',
  `id` int(255) NOT NULL auto_increment COMMENT '主键',
  `_count` int(255) default NULL COMMENT '本次聚合的总条数',
  `resource_code` int(255) default NULL COMMENT '资源的hashCode',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
