/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.100.1-mysql
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : shoppingweb

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 05/09/2021 22:24:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `realName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '1', 'xiaoyang', 21, '188888888888');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `gname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bid` double(5, 2) NULL DEFAULT NULL,
  `price` double(5, 2) NULL DEFAULT NULL,
  `stock` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '可乐', 1.55, 3.50, 172);
INSERT INTO `goods` VALUES (2, '雪碧', 1.50, 5.00, 339);
INSERT INTO `goods` VALUES (3, '芬达', 2.00, 4.00, 69);
INSERT INTO `goods` VALUES (4, '冰红茶', 2.00, 4.00, 99);
INSERT INTO `goods` VALUES (5, '瓜子', 2.00, 5.50, 100);
INSERT INTO `goods` VALUES (11, '青岛啤酒', 3.00, 3.50, 55);
INSERT INTO `goods` VALUES (14, '花生', 1.00, 1.00, 55);
INSERT INTO `goods` VALUES (33, '1', 1.00, 1.00, 1);

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `rid` int NOT NULL AUTO_INCREMENT,
  `gid` int NOT NULL,
  `uid` int NOT NULL,
  `num` int NULL DEFAULT NULL,
  `datetime` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`rid`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `gid`(`gid`) USING BTREE,
  CONSTRAINT `record_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `record_ibfk_2` FOREIGN KEY (`gid`) REFERENCES `goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES (17, 2, 18, 5, '2021-05-07 15:31:01');
INSERT INTO `record` VALUES (18, 2, 18, 5, '2021-05-07 15:33:09');
INSERT INTO `record` VALUES (19, 2, 18, 5, '2021-05-07 15:33:27');
INSERT INTO `record` VALUES (20, 2, 18, 5, '2021-05-07 15:33:39');
INSERT INTO `record` VALUES (21, 2, 18, 5, '2021-05-07 15:34:02');
INSERT INTO `record` VALUES (22, 2, 18, 5, '2021-05-07 15:37:05');
INSERT INTO `record` VALUES (25, 2, 18, 5, '2021-05-07 15:38:33');

-- ----------------------------
-- Table structure for record_user
-- ----------------------------
DROP TABLE IF EXISTS `record_user`;
CREATE TABLE `record_user`  (
  `uid` int NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `upd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `usex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `uage` int NULL DEFAULT NULL,
  `uphone` bigint NULL DEFAULT NULL,
  `ubalance` double(10, 2) NULL DEFAULT NULL,
  `udate` datetime NULL DEFAULT NULL,
  `deleteTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `uname`(`uname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of record_user
-- ----------------------------
INSERT INTO `record_user` VALUES (66, 'wqweqeq', '111111', '男', 11, 11, 11111111.00, '2021-08-20 16:05:17', '2021-08-27 08:56:03');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `upd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `usex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `uage` int NULL DEFAULT NULL,
  `uphone` bigint NULL DEFAULT NULL,
  `ubalance` double(10, 2) NULL DEFAULT NULL,
  `udate` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `uname`(`uname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 84 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (17, '168@qq.commm', 'yang123', '男', 12, 11111111111, 11.00, '2021-05-07 15:30:58');
INSERT INTO `user` VALUES (18, '1111111@qq.com', 'yang123', '女', 4546, 213142141, 1343134.00, '2021-05-07 15:30:58');
INSERT INTO `user` VALUES (27, 'wuyifan@qq.com', 'yang52199', '男', 16, 12222222222, 12313.00, '2021-08-19 18:05:41');
INSERT INTO `user` VALUES (40, '1347458@qq.com', '111111', '女', 16, 18436002417, 1111.00, '2021-08-20 15:14:04');
INSERT INTO `user` VALUES (58, '111111111111@qq.com', 'yang11111', '男', 11, 18436002417, 1158989.20, '2021-08-20 14:52:09');
INSERT INTO `user` VALUES (68, 'qwe@qq.com', 'yang521', '女', 20, 17633505913, 60000.00, '2021-05-07 15:30:58');
INSERT INTO `user` VALUES (71, 'sadadada', '111111', '男', 11, 15, 11.00, '2021-08-20 16:05:02');
INSERT INTO `user` VALUES (78, 'iPhone 12 Pro Max', '111111', '女', 15, 17777777777, 1454.48, '2021-08-27 16:55:29');
INSERT INTO `user` VALUES (79, 'wqweqeq12321', '111111', '男', 11, 1777777, 11111111.00, '2021-08-20 16:05:17');
INSERT INTO `user` VALUES (80, 'adasda', '111111', '女', 11, 11, 11.00, '2021-09-02 10:02:47');
INSERT INTO `user` VALUES (81, 'wqweqeq11', '111111', '男', 11, 11, 11111111.00, '2021-08-20 16:05:17');
INSERT INTO `user` VALUES (82, '华晨宇', '111111', '男', 1, 1, 1.00, '2021-08-27 08:53:14');
INSERT INTO `user` VALUES (83, '阳', '111111', '女', 1, 1, 1.00, '2021-08-27 08:52:30');

-- ----------------------------
-- Triggers structure for table user
-- ----------------------------
DROP TRIGGER IF EXISTS `record`;
delimiter ;;
CREATE TRIGGER `record` AFTER DELETE ON `user` FOR EACH ROW begin
insert into record_user(uid,uname,upd,usex,uage,uphone,ubalance,udate) VALUES(old.uid,old.uname,old.upd,old.usex,old.uage,old.uphone,old.ubalance,old.udate);
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
