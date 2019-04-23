/*
Navicat MySQL Data Transfer

Source Server         : mysql8.3
Source Server Version : 80003
Source Host           : localhost:3306
Source Database       : mybatisdb

Target Server Type    : MYSQL
Target Server Version : 80003
File Encoding         : 65001

Date: 2019-04-14 11:16:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(30) DEFAULT NULL,
  `BIRTHDAY` datetime DEFAULT NULL,
  `ADDRESS` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '夏言', '1573-01-01 00:00:00', '桂州村');
INSERT INTO `user` VALUES ('2', '严嵩', '1587-01-01 00:00:00', '分宜县城介桥村');
INSERT INTO `user` VALUES ('3', '徐阶', '1580-01-01 00:00:00', '明松江府华亭县');
INSERT INTO `user` VALUES ('4', '高拱', '1566-01-01 00:00:00', '河南省新郑市高老庄村');
INSERT INTO `user` VALUES ('5', '张居正', '1558-01-01 00:00:00', '江陵');
