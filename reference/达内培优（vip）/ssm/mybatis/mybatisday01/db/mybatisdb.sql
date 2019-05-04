/*
Navicat MySQL Data Transfer

Source Server         : mysql5.7
Source Server Version : 50721
Source Host           : localhost:3308
Source Database       : mybatisdb

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-04-27 23:26:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `User_id` int(11) DEFAULT NULL,
  `Order_no` int(11) DEFAULT NULL,
  `Order_desc` varchar(100) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '1', '100', '好评', '1000');
INSERT INTO `orders` VALUES ('2', '2', '200', '优秀', '100');
INSERT INTO `orders` VALUES ('3', '1', '300', '优秀', '100');
INSERT INTO `orders` VALUES ('4', '1', '400', '优秀', '100');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'guangtouqiang', '北京', '28');
INSERT INTO `user` VALUES ('2', 'xiongda', '上海', '30');
INSERT INTO `user` VALUES ('3', 'xiaonger', '上海', '19');
INSERT INTO `user` VALUES ('4', '张慎政', '河南', '84');
INSERT INTO `user` VALUES ('5', '张慎政', '河南', '38');
INSERT INTO `user` VALUES ('6', '唐丰', '地狱', '48');

-- ----------------------------
-- Table structure for `user_extra`
-- ----------------------------
DROP TABLE IF EXISTS `user_extra`;
CREATE TABLE `user_extra` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `User_id` int(11) DEFAULT NULL,
  `Work` varchar(100) DEFAULT NULL,
  `Salary` double DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_extra
-- ----------------------------
INSERT INTO `user_extra` VALUES ('1', '1', '程序员', '100000');
INSERT INTO `user_extra` VALUES ('2', '2', '教师', '1000');
INSERT INTO `user_extra` VALUES ('3', '3', 'CTO', '100000');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) DEFAULT NULL,
  `user_addr` varchar(200) DEFAULT NULL,
  `user_age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '韩梅梅', '上海', '20');
INSERT INTO `user_info` VALUES ('2', '王海涛', '北京', '30');
INSERT INTO `user_info` VALUES ('3', '张慎政', '河南', '10');
