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

 Date: 12/07/2020 17:56:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for breakfasttype
-- ----------------------------
DROP TABLE IF EXISTS `breakfasttype`;
CREATE TABLE `breakfasttype`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mealtype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of breakfasttype
-- ----------------------------
INSERT INTO `breakfasttype` VALUES (1, '早餐1元');
INSERT INTO `breakfasttype` VALUES (2, '早餐特惠');
INSERT INTO `breakfasttype` VALUES (3, '早餐全餐');
INSERT INTO `breakfasttype` VALUES (4, '大饼卷万物');

SET FOREIGN_KEY_CHECKS = 1;
