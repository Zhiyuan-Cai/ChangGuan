/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : changguan

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 18/06/2022 13:40:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admininfo
-- ----------------------------
DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE `admininfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `jobNum` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `department` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `post` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role` int(0) NULL DEFAULT NULL,
  `isDel` bit(1) NULL DEFAULT b'0',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admininfo
-- ----------------------------
INSERT INTO `admininfo` VALUES (5, 'adminDZ', '100005', '男', '18712345678', '测试部门', '测试', 0, b'0', '12345678');
INSERT INTO `admininfo` VALUES (6, 'adminDZ4', '100006', '男', '187123456770', '测试部门', '测试4', 5, b'0', NULL);
INSERT INTO `admininfo` VALUES (7, 'adminDZ', '100007', '男', '18712345678', '测试部门', '测试', 6, b'0', NULL);
INSERT INTO `admininfo` VALUES (8, 'adminDZ5', '100008', '男', '18712345677', '测试部门', '测试5', 7, b'0', NULL);
INSERT INTO `admininfo` VALUES (9, 'adminDZ', '100009', '男', '18712345678', '测试部门', '测试', 8, b'0', NULL);
INSERT INTO `admininfo` VALUES (10, 'adminDZ6', '100010', '男', '18712345677', '测试部门', '测试6', 9, b'0', NULL);
INSERT INTO `admininfo` VALUES (11, 'adminDZ', '100011', '男', '18712345678', '测试部门', '测试', 10, b'0', NULL);
INSERT INTO `admininfo` VALUES (12, 'adminDZ7', '100012', '男', '18712345677', '测试部门', '测试7', 11, b'0', NULL);
INSERT INTO `admininfo` VALUES (13, 'adminDZ', '100013', '男', '18712345678', '测试部门', '测试', 12, b'0', NULL);
INSERT INTO `admininfo` VALUES (14, 'adminDZ8', '100014', '男', '18712345677', '测试部门', '测试8', 13, b'0', NULL);
INSERT INTO `admininfo` VALUES (15, 'adminDZ', '100015', '男', '18712345678', '测试部门', '测试', 14, b'0', NULL);
INSERT INTO `admininfo` VALUES (16, 'adminDZ9', '100016', '男', '18712345677', '测试部门', '测试9', 15, b'0', NULL);
INSERT INTO `admininfo` VALUES (17, 'adminDZ', '100017', '男', '18712345678', '测试部门', '测试', 16, b'0', NULL);
INSERT INTO `admininfo` VALUES (18, 'adminDZ10', '100018', '男', '18712345677', '测试部门', '测试10', 17, b'0', NULL);
INSERT INTO `admininfo` VALUES (19, 'adminDZ', '100019', '男', '18712345678', '测试部门', '测试', 18, b'0', NULL);
INSERT INTO `admininfo` VALUES (20, 'adminDZ11', '100020', '男', '18712345677', '测试部门', '测试11', 19, b'0', NULL);
INSERT INTO `admininfo` VALUES (21, 'adminDZ', '100021', '男', '18712345678', '测试部门', '测试', 20, b'0', NULL);
INSERT INTO `admininfo` VALUES (34, '管理员', '1000111', '男', '13100000002', '管理', '管理员', NULL, b'0', NULL);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `isDel` bit(1) NULL DEFAULT b'0',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '设备类别一', '', b'0', '');
INSERT INTO `category` VALUES (3, '设备类别二', '', b'0', '');
INSERT INTO `category` VALUES (4, '设备类别三', '', b'0', '设备类别三');
INSERT INTO `category` VALUES (5, '设备类别四', '', b'0', '');
INSERT INTO `category` VALUES (6, '设备类别五', '', b'0', '');

-- ----------------------------
-- Table structure for contentinfo
-- ----------------------------
DROP TABLE IF EXISTS `contentinfo`;
CREATE TABLE `contentinfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `pid` int(0) NOT NULL,
  `name` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `image` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of contentinfo
-- ----------------------------
INSERT INTO `contentinfo` VALUES (1, 10001, 'OPPO Watch', 'https://pro.jd.com/mall/active/tG3nBBhghqhfM69HoJw9ZoDaT7d/index.html?extension_id=eyJhZCI6IiIsImNoIjoiIiwic2hvcCI6IiIsInNrdSI6IiIsInRzIjoiIiwidW5pcWlkIjoie1wiY2xpY2tfaWRcIjpcIjg5YzRjMTUyLWUwZjktNGQ0OC05NDI4LTJhODQ4NWJjNTc1N1wiLFwibWF0ZXJpYWxfaWRcIjpcIjE4NTAxMDcyMjlcIixcInBvc19pZFwiOlwiNDI3MlwiLFwic2lkXCI6XCJmODcwZmM2MS1jYjc3LTQwN2UtOTM1ZC1jYzhlZTc0MTYyZTdcIn0ifQ==&jd_pop=89c4c152-e0f9-4d48-9428-2a8485bc5757&abt=1', '//img14.360buyimg.com/pop/s1180x940_jfs/t1/110562/14/10737/42247/5e81bb76E6fffa006/b3f703f750bd37ea.jpg.webp');
INSERT INTO `contentinfo` VALUES (3, 90410, '椅子', 'https://channel-m.jd.com/pc/psp/10979325649?imup=CgwKBnd3dGxpdRIAGAASEAjR7azzKBDmZhoAIJpNKAEYsRsgACoUaWwsdWEseGdiLGdhLGNpYSxiYWEyAmlsOioKCWpkX2hiZHl5MRDnYRgCIJL50ty1x-S1dyjCo6Q3MMGjpDc4E0CAgCA&extension_id=eyJhZCI6IiIsImNoIjoiIiwic2hvcCI6IiIsInNrdSI6IiIsInRzIjoiIiwidW5pcWlkIjoie1wiY2xpY2tfaWRcIjpcIjJiNmEyNjE5LWE4MmItNGMyNi1iYzYwLWI3ZGE1NzljOWRkZVwiLFwibWF0ZXJpYWxfaWRcIjpcIjg2MDUxMzIyOTY2NTg2NjQ1OTRcIixcInBvc19pZFwiOlwiMzUwNVwiLFwic2lkXCI6XCJmN2Y5ODM2ZS0yZTViLTQyMTUtYWNiMi04NDdmZmI2N2U2ZDdcIn0ifQ==&jd_pop=2b6a2619-a82b-4c26-bc60-b7da579c9dde&abt=0', 'https://img12.360buyimg.com/pop/s1180x940_jfs/t1/117573/18/9029/83238/5ed7c92aE789977c2/b11a288a7284cdfe.jpg.webp');
INSERT INTO `contentinfo` VALUES (5, 10002, 'fggh', 'dffg', 'dfdf');
INSERT INTO `contentinfo` VALUES (6, 10002, 'hhh', 'hh', 'hh');
INSERT INTO `contentinfo` VALUES (7, 10002, 'hhh', 'hh', 'hhh');
INSERT INTO `contentinfo` VALUES (8, 10002, 'hhh', 'hh', 'hh');
INSERT INTO `contentinfo` VALUES (9, 10002, 'aaa', 'aa', 'aaa');
INSERT INTO `contentinfo` VALUES (11, 10001, '轮播图', 'http://www.baidu.com', 'http://www.baidu.com/banner.jpg');
INSERT INTO `contentinfo` VALUES (12, 10001, '轮播图', 'http://www.baidu.com', 'http://www.baidu.com/banner.jpg');
INSERT INTO `contentinfo` VALUES (13, 10001, 'hjh', '6666', '666');

-- ----------------------------
-- Table structure for controlinfo
-- ----------------------------
DROP TABLE IF EXISTS `controlinfo`;
CREATE TABLE `controlinfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `controlNum` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `controlName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gridNum` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gridName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `isDel` bit(1) NULL DEFAULT b'0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of controlinfo
-- ----------------------------
INSERT INTO `controlinfo` VALUES (1, 'A101', '控制室一', 'A1', '网格一', NULL, NULL, b'0');
INSERT INTO `controlinfo` VALUES (3, 'A102', '控制室二', 'A1', '网格一', '控制室二', '', b'0');
INSERT INTO `controlinfo` VALUES (5, 'A203', '控制室三', 'A2', '网格二', '', '', b'0');
INSERT INTO `controlinfo` VALUES (6, 'B104', '控制室四', 'B1', '网格三', '', '', b'0');
INSERT INTO `controlinfo` VALUES (7, 'B205', '控制室五', 'B2', '网格四', '', '', b'0');

-- ----------------------------
-- Table structure for deviceinfo
-- ----------------------------
DROP TABLE IF EXISTS `deviceinfo`;
CREATE TABLE `deviceinfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `deviceNum` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `deviceName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `deviceIP` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sceneNum` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sceneName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `controlNum` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `controlName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gridNum` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gridName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `isDel` bit(1) NULL DEFAULT b'0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of deviceinfo
-- ----------------------------
INSERT INTO `deviceinfo` VALUES (1, '000001', '大屏', '10.10.0.1', '设备类别二', 'A10202', '场景二', 'A102', '控制室二', 'A1', '网格一', '', '', b'0');
INSERT INTO `deviceinfo` VALUES (2, '000002', '摄像机', '101.1.1.1', '设备类别四', 'A20303', '场景三', 'A203', '控制室三', 'A2', '网格二', '', '', b'0');

-- ----------------------------
-- Table structure for gridinfo
-- ----------------------------
DROP TABLE IF EXISTS `gridinfo`;
CREATE TABLE `gridinfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `gridNum` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `isDel` bit(1) NULL DEFAULT b'0',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gridinfo
-- ----------------------------
INSERT INTO `gridinfo` VALUES (12, 'A1', '网格一', '', b'0', '');
INSERT INTO `gridinfo` VALUES (13, 'A2', '网格二', '', b'0', '');
INSERT INTO `gridinfo` VALUES (14, 'B3', '网格三', '', b'0', '');
INSERT INTO `gridinfo` VALUES (15, 'B4', '网格四', '', b'0', '');

-- ----------------------------
-- Table structure for sceneinfo
-- ----------------------------
DROP TABLE IF EXISTS `sceneinfo`;
CREATE TABLE `sceneinfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `sceneNum` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sceneName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `controlNum` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `controlName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gridNum` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gridName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `isDel` bit(1) NULL DEFAULT b'0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sceneinfo
-- ----------------------------
INSERT INTO `sceneinfo` VALUES (1, 'A10101', '场景一', 'A101', '控制室一', 'A1', '网格一', '', '', b'0');
INSERT INTO `sceneinfo` VALUES (2, 'A10202', '场景二', 'A102', '控制室二', 'A1', '网格一', '', '', b'0');
INSERT INTO `sceneinfo` VALUES (3, 'A20303', '场景三', 'A203', '控制室三', 'A2', '网格二', '', '', b'0');
INSERT INTO `sceneinfo` VALUES (4, 'A20304', '场景四', 'A203', '控制室三', 'A2', '网格二', '', '', b'0');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (1, 'admin', '123');
INSERT INTO `userinfo` VALUES (2, 'ime', '123');
INSERT INTO `userinfo` VALUES (3, 'jack', '123');
INSERT INTO `userinfo` VALUES (4, 'sakura', '123');
INSERT INTO `userinfo` VALUES (5, '张三', '123');
INSERT INTO `userinfo` VALUES (6, '李四', '123');
INSERT INTO `userinfo` VALUES (7, 'hello1', '123123');
INSERT INTO `userinfo` VALUES (8, 'hello2', '123');
INSERT INTO `userinfo` VALUES (9, 'qq', '123');
INSERT INTO `userinfo` VALUES (10, 'QQ', '123');
INSERT INTO `userinfo` VALUES (11, 'QQ', '123');
INSERT INTO `userinfo` VALUES (12, 'ww', '123');
INSERT INTO `userinfo` VALUES (13, 'www', '123');
INSERT INTO `userinfo` VALUES (14, 'eee', 'eee');

SET FOREIGN_KEY_CHECKS = 1;
