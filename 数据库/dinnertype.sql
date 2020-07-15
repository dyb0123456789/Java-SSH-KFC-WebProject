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

 Date: 12/07/2020 17:56:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dinnertype
-- ----------------------------
DROP TABLE IF EXISTS `dinnertype`;
CREATE TABLE `dinnertype`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mealtype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2004 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dinnertype
-- ----------------------------
INSERT INTO `dinnertype` VALUES (2001, '夜宵1元');
INSERT INTO `dinnertype` VALUES (2002, '炸鸡啤酒');
INSERT INTO `dinnertype` VALUES (2003, '美味汉堡/卷');

SET FOREIGN_KEY_CHECKS = 1;
