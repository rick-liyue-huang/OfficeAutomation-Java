/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.0.66
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : rick_oa

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 20/07/2021 10:10:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_node
-- ----------------------------
DROP TABLE IF EXISTS `sys_node`;
CREATE TABLE `sys_node`  (
  `node_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'node id',
  `node_type` int(255) NOT NULL COMMENT 'node type 1-mode 2-func',
  `node_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'node name',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'func address',
  `node_code` int(255) NOT NULL COMMENT 'node code, sort',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT 'parent id',
  PRIMARY KEY (`node_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_node
-- ----------------------------
INSERT INTO `sys_node` VALUES (1, 1, 'administrative_approval', NULL, 1000000, NULL);
INSERT INTO `sys_node` VALUES (2, 2, 'info_notice', '/notice.html', 1000001, 1);
INSERT INTO `sys_node` VALUES (3, 2, 'leave_form', '/leave_form.html', 1000002, 1);
INSERT INTO `sys_node` VALUES (4, 2, 'vacation_audit', '/audit.html', 1000003, 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'role id',
  `role_description` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'role desc',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'business_role');
INSERT INTO `sys_role` VALUES (2, 'admin_role');

-- ----------------------------
-- Table structure for sys_role_node
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_node`;
CREATE TABLE `sys_role_node`  (
  `rn_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `node_id` bigint(20) NOT NULL,
  PRIMARY KEY (`rn_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_node
-- ----------------------------
INSERT INTO `sys_role_node` VALUES (1, 1, 1);
INSERT INTO `sys_role_node` VALUES (2, 1, 2);
INSERT INTO `sys_role_node` VALUES (3, 1, 3);
INSERT INTO `sys_role_node` VALUES (4, 2, 1);
INSERT INTO `sys_role_node` VALUES (5, 2, 2);
INSERT INTO `sys_role_node` VALUES (6, 2, 3);
INSERT INTO `sys_role_node` VALUES (7, 2, 4);

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user`  (
  `ru_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`ru_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES (1, 2, 1);
INSERT INTO `sys_role_user` VALUES (2, 2, 2);
INSERT INTO `sys_role_user` VALUES (3, 1, 3);
INSERT INTO `sys_role_user` VALUES (4, 1, 4);
INSERT INTO `sys_role_user` VALUES (5, 1, 5);
INSERT INTO `sys_role_user` VALUES (6, 2, 6);
INSERT INTO `sys_role_user` VALUES (7, 1, 7);
INSERT INTO `sys_role_user` VALUES (8, 1, 8);
INSERT INTO `sys_role_user` VALUES (9, 1, 9);
INSERT INTO `sys_role_user` VALUES (10, 1, 10);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'user id',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'username',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'password',
  `employee_id` bigint(20) NOT NULL COMMENT 'employee id',
  `salt` int(255) NOT NULL COMMENT 'salt value',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'm8', 'f57e762e3fb7e1e3ec8ec4db6a1248e1', 1, 188);
INSERT INTO `sys_user` VALUES (2, 't7', 'dcfa022748271dccf5532c834e98ad08', 2, 189);
INSERT INTO `sys_user` VALUES (3, 't6', '76ce11f8b004e8bdc8b0976b177c620d', 3, 190);
INSERT INTO `sys_user` VALUES (4, 't5', '11f04f04054772bc1a8fdc41e70c7977', 4, 191);
INSERT INTO `sys_user` VALUES (5, 't4', '8d7713848189a8d5c224f94f65d18b06', 5, 192);
INSERT INTO `sys_user` VALUES (6, 's7', '044214e86e07d96c97de79a2222188cd', 6, 193);
INSERT INTO `sys_user` VALUES (7, 's6', 'ecbd2f592ee65838328236d06ce35252', 7, 194);
INSERT INTO `sys_user` VALUES (8, 's5', '846ecc83bba8fe420adc38b39f897201', 8, 195);
INSERT INTO `sys_user` VALUES (9, 's4', 'c1e523cd2daa02f6cf4b98b2f26585fd', 9, 196);
INSERT INTO `sys_user` VALUES (10, 's3', '89e89f369e07634fbb2286efffb9492b', 10, 197);

SET FOREIGN_KEY_CHECKS = 1;
