/*
Navicat MySQL Data Transfer

Source Server         : mysql5.7
Source Server Version : 50721
Source Host           : localhost:3308
Source Database       : mybatisdb

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-04-27 21:15:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `addr` varchar(100) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'guangtouqiang', '北京', '28');
INSERT INTO `user` VALUES ('2', 'xiongda', '上海', '30');
INSERT INTO `user` VALUES ('3', 'xiaonger', '上海', '19');
