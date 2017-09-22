/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : pet

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-04-18 11:31:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for breed
-- ----------------------------
DROP TABLE IF EXISTS `breed`;
CREATE TABLE `breed` (
  `b_id` int(11) NOT NULL AUTO_INCREMENT,
  `b_breed` varchar(255) NOT NULL,
  `b_pid` int(11) NOT NULL,
  PRIMARY KEY (`b_id`),
  KEY `breed_pettype` (`b_pid`),
  CONSTRAINT `breed_pettype` FOREIGN KEY (`b_pid`) REFERENCES `pettype` (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of breed
-- ----------------------------

-- ----------------------------
-- Table structure for friends
-- ----------------------------
DROP TABLE IF EXISTS `friends`;
CREATE TABLE `friends` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_uid` int(11) NOT NULL,
  `f_fuid` int(11) NOT NULL,
  PRIMARY KEY (`f_id`),
  KEY `user_friead` (`f_uid`),
  CONSTRAINT `user_friead` FOREIGN KEY (`f_uid`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friends
-- ----------------------------

-- ----------------------------
-- Table structure for pet
-- ----------------------------
DROP TABLE IF EXISTS `pet`;
CREATE TABLE `pet` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(255) NOT NULL,
  `p_sex` varchar(255) DEFAULT '0',
  `p_age` float(100,1) DEFAULT NULL,
  `p_bid` int(11) NOT NULL,
  `p_longitude` float(255,11) DEFAULT NULL,
  `p_latitude` float(255,11) DEFAULT NULL,
  PRIMARY KEY (`p_id`),
  KEY `pet_breed` (`p_bid`),
  CONSTRAINT `pet_breed` FOREIGN KEY (`p_bid`) REFERENCES `breed` (`b_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pet
-- ----------------------------

-- ----------------------------
-- Table structure for pettype
-- ----------------------------
DROP TABLE IF EXISTS `pettype`;
CREATE TABLE `pettype` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_type` varchar(255) NOT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pettype
-- ----------------------------

-- ----------------------------
-- Table structure for platts
-- ----------------------------
DROP TABLE IF EXISTS `platts`;
CREATE TABLE `platts` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_title` varchar(255) NOT NULL,
  `p_url` varchar(255) NOT NULL,
  `p_info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of platts
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_phone` varchar(11) NOT NULL,
  `u_password` varchar(10) NOT NULL,
  `u_nick` varchar(10) DEFAULT NULL,
  `u_sign` varchar(255) DEFAULT NULL,
  `u_age` int(3) DEFAULT NULL,
  `u_sex` int(1) NOT NULL DEFAULT '0' COMMENT '1表示男，0表示女',
  `u_img` varchar(255) DEFAULT NULL COMMENT '头像',
  `u_pid` int(11) DEFAULT NULL COMMENT '宠物ID',
  PRIMARY KEY (`u_id`),
  KEY `user_pet` (`u_pid`),
  CONSTRAINT `user_pet` FOREIGN KEY (`u_pid`) REFERENCES `pet` (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '13723707851', '123456', 'chanlin', '欢迎来约', '26', '1', null, null);
INSERT INTO `user` VALUES ('2', '11111111111', '123456', 'haha', '新来的，多多关照', '20', '0', null, null);
INSERT INTO `user` VALUES ('3', '2222222', '111111', null, null, null, '0', null, null);

<<<<<<< HEAD
-- ----------------------------

=======
-- ---------------------------- 
>>>>>>> a0d2ab2b8176706f070a790117e8de8c41418a5b
