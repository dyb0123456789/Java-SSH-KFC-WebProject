/*
 Navicat Premium Data Transfer

 Source Server         : dyb
 Source Server Type    : MySQL
 Source Server Version : 50540
 Source Host           : localhost:3306
 Source Schema         : kfc

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 12/07/2020 17:56:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lunchtype
-- ----------------------------
DROP TABLE IF EXISTS `lunchtype`;
CREATE TABLE `lunchtype`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mealtype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1004 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of lunchtype
-- ----------------------------
INSERT INTO `lunchtype` VALUES (1001, '当季主打');
INSERT INTO `lunchtype` VALUES (1002, '欢乐送下午茶');
INSERT INTO `lunchtype` VALUES (1003, '串串/卤味');

SET FOREIGN_KEY_CHECKS = 1;
