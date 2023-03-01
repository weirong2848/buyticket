/*
 Navicat Premium Data Transfer

 Source Server         : 新建连接
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : buyticket

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 01/03/2023 22:14:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_buyuser
-- ----------------------------
DROP TABLE IF EXISTS `tb_buyuser`;
CREATE TABLE `tb_buyuser`  (
  `idnumber` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`idnumber`, `username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_buyuser
-- ----------------------------
INSERT INTO `tb_buyuser` VALUES ('220402199708095671', '李荣浩', '13166738263', 'weirong');

-- ----------------------------
-- Table structure for tb_notice
-- ----------------------------
DROP TABLE IF EXISTS `tb_notice`;
CREATE TABLE `tb_notice`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_notice
-- ----------------------------
INSERT INTO `tb_notice` VALUES (1, '04-09', '吉林市公路客运总站关于雾凇路客运站暂停服务的公告', '疫情期间，吉林市雾凇路客运站从即日起暂停服务。请广大旅客统一到火车站西广场客运换乘中心站乘车出行。');
INSERT INTO `tb_notice` VALUES (7, '05-11', '吉林市相关车票已停售', '吉林市的相关车票停止售票，具体恢复时间请留意公告，给您带来的不便敬请谅解。');

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order`  (
  `orderid` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `username` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `idnumber` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `orderTime` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flightNumber` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `departureStation` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `arrivalStation` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `seatNumber` int NULL DEFAULT NULL,
  `price` double(8, 0) NULL DEFAULT NULL,
  `money` double(8, 0) NULL DEFAULT NULL,
  `state` int NULL DEFAULT NULL,
  PRIMARY KEY (`orderid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES ('122174823', 'weirong', '220402199708095671', '李荣浩', '13166738263', '2022-07-21 23:19:46', '1080', '2022-07-22 14:10', '长春高速公路客运站', '辽源市', 1, 36, 39, 1);
INSERT INTO `tb_order` VALUES ('1258400328', 'weirong', '220402199708095671', '李荣浩', '13166738263', '2022-05-19 11:08:44', '1080', '2022-05-20 14:10', '长春高速公路客运站', '辽源市', 1, 36, 39, 1);
INSERT INTO `tb_order` VALUES ('1479599755', 'weirong', '220402199708095671', '李荣浩', '13166738263', '2022-04-23 00:00:01', '1009', '2022-04-23 08:00', '通化客运站(老站)', '长春市', 1, 98, 101, 1);
INSERT INTO `tb_order` VALUES ('506299895', 'weirong', '220402199708095671', '李荣浩', '13166738263', '2022-04-23 00:04:21', '1808', '2022-4-23 08:50', '通化客运站(老站)', '长春市', 1, 98, 101, 1);
INSERT INTO `tb_order` VALUES ('634129377', 'weirong', '220402199708095671', '李荣浩', '13166738263', '2021-03-02 01:18:44', '1020', '2021-3-2 07:00', '通化客运站(老站)', '长春市', 1, 98, 101, 1);
INSERT INTO `tb_order` VALUES ('892113086', 'weirong', '220402199708095671', '李荣浩', '13166738263', '2021-03-02 01:25:13', '80010', '2021-3-2 06:30', '通化客运站(老站)', '白山市', 1, 12, 15, 0);
INSERT INTO `tb_order` VALUES ('936401430', 'weirong', '220402199708095671', '李荣浩', '13166738263', '2021-06-24 20:46:29', '1074', '2021-06-25 12:10', '长春高速公路客运站', '辽源市', 1, 36, 39, 0);

-- ----------------------------
-- Table structure for tb_route
-- ----------------------------
DROP TABLE IF EXISTS `tb_route`;
CREATE TABLE `tb_route`  (
  `routeNum` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `departurePlace` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `arrivalPlace` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `minPrice` double(7, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`routeNum`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_route
-- ----------------------------
INSERT INTO `tb_route` VALUES ('0103', '长春市', '四平市', 30);
INSERT INTO `tb_route` VALUES ('0104', '长春市', '辽源市', 36);
INSERT INTO `tb_route` VALUES ('0105', '长春市', '通化市', 97);
INSERT INTO `tb_route` VALUES ('0106', '长春市', '白山市', 84);
INSERT INTO `tb_route` VALUES ('0107', '长春市', '白城市', 101);
INSERT INTO `tb_route` VALUES ('0304', '四平市', '辽源市', 21);
INSERT INTO `tb_route` VALUES ('0309', '四平市', '松原市', 69);
INSERT INTO `tb_route` VALUES ('0401', '辽源市', '长春市', 36);
INSERT INTO `tb_route` VALUES ('0405', '辽源市', '通化市', 49);
INSERT INTO `tb_route` VALUES ('0501', '通化市', '长春市', 97);
INSERT INTO `tb_route` VALUES ('0506', '通化市', '白山市', 12);
INSERT INTO `tb_route` VALUES ('0509', '通化市', '松原市', 136);
INSERT INTO `tb_route` VALUES ('0601', '白山市', '长春市', 65);
INSERT INTO `tb_route` VALUES ('0605', '白山市', '通化市', 12);
INSERT INTO `tb_route` VALUES ('0608', '白山市', '延吉市', 105);
INSERT INTO `tb_route` VALUES ('0701', '白城市', '长春市', 80);
INSERT INTO `tb_route` VALUES ('0709', '白城市', '松原市', 36);
INSERT INTO `tb_route` VALUES ('0806', '延吉市', '白山市', 103);
INSERT INTO `tb_route` VALUES ('0907', '松原市', '白城市', 36);
INSERT INTO `tb_route` VALUES ('0908', '松原市', '延吉市', 106);

-- ----------------------------
-- Table structure for tb_ticket
-- ----------------------------
DROP TABLE IF EXISTS `tb_ticket`;
CREATE TABLE `tb_ticket`  (
  `flightNumber` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `routeNum` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `departureStation` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `arrivalStation` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vehicleType` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `duration` varchar(7) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double(8, 0) NULL DEFAULT NULL,
  `mileage` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`flightNumber`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_ticket
-- ----------------------------
INSERT INTO `tb_ticket` VALUES ('0341', '0106', '11:30', '长春高速公路客运站', '白山市', '大型高二级座', '约4小时', 89, '213KM');
INSERT INTO `tb_ticket` VALUES ('1009', '0501', '08:00', '通化客运站(老站)', '长春市', '大型高二级座', '约3.5小时', 98, '310KM');
INSERT INTO `tb_ticket` VALUES ('1020', '0501', '07:00', '通化客运站(老站)', '长春市', '大型高二级座', '约3.5小时', 98, '310kM');
INSERT INTO `tb_ticket` VALUES ('1074', '0104', '12:10', '长春高速公路客运站', '辽源市', '大型高二级座', '约2小时', 36, '146KM');
INSERT INTO `tb_ticket` VALUES ('1078', '0104', '13:30', '长春高速公路客运站', '辽源市', '大型高二级座', '约2小时', 36, '146KM');
INSERT INTO `tb_ticket` VALUES ('1080', '0104', '14:10', '长春高速公路客运站', '辽源市', '大型高二级座', '约2小时', 36, '146KM');
INSERT INTO `tb_ticket` VALUES ('1085', '0104', '15:40', '长春高速公路客运站', '辽源市', '大型高二级座', '约2小时', 36, '146KM');
INSERT INTO `tb_ticket` VALUES ('1162', '0709', '08:00', '白城市客运中心总站', '松原市', '大型高二级座', '约2小时', 36, '197KM');
INSERT INTO `tb_ticket` VALUES ('1163', '0709', '09:30', '白城市客运中心总站', '松原市', '大型高二级座', '约2小时', 36, '197KM');
INSERT INTO `tb_ticket` VALUES ('1164', '0709', '12:30', '白城市客运中心总站', '松原', '大型高二级座', '约2小时', 49, '197KM');
INSERT INTO `tb_ticket` VALUES ('1201', '0501', '10:00', '通化客运站(老站)', '长春市', '大型高二级座', '约3.5小时', 98, '310KM');
INSERT INTO `tb_ticket` VALUES ('1203', '0401', '06:10', '辽源市高速客运站', '长春市', '大型高二级座', '约2小时', 36, '159KM');
INSERT INTO `tb_ticket` VALUES ('1220', '0401', '09:25', '辽源市高速客运站', '长春市', '大型高二级座', '约2小时', 36, '159KM');
INSERT INTO `tb_ticket` VALUES ('1244', '0401', '13:40', '辽源市高速客运站', '长春市', '大型普通级座', '约2小时', 43, '159KM');
INSERT INTO `tb_ticket` VALUES ('1258', '0401', '16:00', '辽源市高速客运站', '长春市', '大型高二级座', '约2小时', 36, '159KM');
INSERT INTO `tb_ticket` VALUES ('1295', '0104', '17:00', '长春高速公路客运站', '辽源市', '大型高二级座', '约2小时', 36, '146KM');
INSERT INTO `tb_ticket` VALUES ('1302', '0309', '08:00', '四平市公路客运总站', '松原市', '大型高二级座', '约4小时', 69, '281KM');
INSERT INTO `tb_ticket` VALUES ('1808', '0501', '08:50', '通化客运站(老站)', '长春市', '大型高二级座', '约4小时', 98, '310KM');
INSERT INTO `tb_ticket` VALUES ('2020', '0501', '12:45', '通化客运站(老站)', '长春市', '大型高二级座', '约3.5小时', 98, '310KM');
INSERT INTO `tb_ticket` VALUES ('2049', '0501', '14:15', '通化客运站(老站)', '长春市', '大型高二级座', '约3.5小时', 97, '310KM');
INSERT INTO `tb_ticket` VALUES ('20490', '0509', '13:45', '通化客运站(老站)', '松原', '大型高二级座', '约6小时', 136, '479KM');
INSERT INTO `tb_ticket` VALUES ('2205', '0908', '09:00', '松原公路客运站', '延吉市', '大型高二级座', '约3小时', 106, '578KM');
INSERT INTO `tb_ticket` VALUES ('2645', '0103', '13:30', '凯旋路客运站', '四平市', '大型高二级座', '--', 30, '122KM');
INSERT INTO `tb_ticket` VALUES ('3402', '0405', '10:30', '辽源市客运总站', '通化市', '大型高二级座', '约3小时', 49, '102KM');
INSERT INTO `tb_ticket` VALUES ('3403', '0405', '14:45', '辽源市客运总站', '通化市', '大型高二级座', '约3小时', 49, '102KM');
INSERT INTO `tb_ticket` VALUES ('4112', '0304', '11:20', '四平市公路客运总站', '辽源市', '大型高二级座', '约2小时', 22, '87KM');
INSERT INTO `tb_ticket` VALUES ('4121', '0304', '15:50', '四平市公路客运总站', '辽源市', '大型高一级座', '约2小时', 22, '87KM');
INSERT INTO `tb_ticket` VALUES ('4123', '0304', '16:50', '四平市公路客运总站', '辽源市', '大型高一级座', '约2小时', 22, '87KM');
INSERT INTO `tb_ticket` VALUES ('4127', '0304', '07:40', '四平市公路客运总站', '辽源市', '大型高二级座', '约3小时', 22, '135KM');
INSERT INTO `tb_ticket` VALUES ('4130', '0304', '09:10', '四平市公路客运总站', '辽源市', '大型高二级座', '约2小时', 22, '87KM');
INSERT INTO `tb_ticket` VALUES ('4202', '0304', '12:10', '四平市公路客运总站', '辽源市', '大型高二级座', '约3小时', 21, '163KM');
INSERT INTO `tb_ticket` VALUES ('4220', '0105', '14:50', '长春高速公路客运站', '通化市', '大型高一级座', '--', 98, '317KM');
INSERT INTO `tb_ticket` VALUES ('4402', '0304', '13:30', '四平市公路客运总站', '辽源市', '大型高二级座', '约3小时', 23, '135KM');
INSERT INTO `tb_ticket` VALUES ('4611', '0106', '14:50', '长春高速公路客运站', '白山市', '大型高二级座', '约4小时', 89, '213KM');
INSERT INTO `tb_ticket` VALUES ('5015', '0907', '08:00', '松原公路客运站', '白城市', '大型高二级座', '约3小时', 37, '160KM');
INSERT INTO `tb_ticket` VALUES ('5018', '0907', '14:30', '松原公路客运站', '白城市', '大型高二级座', '约3小时', 36, '160KM');
INSERT INTO `tb_ticket` VALUES ('5019', '0907', '15:30', '松原公路客运站', '白城市', '大型高二级座', '约3小时', 36, '160KM');
INSERT INTO `tb_ticket` VALUES ('5701', '0106', '16:40', '长春高速公路客运站', '白山市', '大型高二级座', '约4小时', 89, '213KM');
INSERT INTO `tb_ticket` VALUES ('6001', '0701', '06:00', '白城市客运中心总站', '长春市', '大型高二级座', '约5小时', 101, '377KM');
INSERT INTO `tb_ticket` VALUES ('6021', '0608', '07:25', '白山市公路客运总站', '延吉市', '大型普通级座', '约5小时', 105, '478KM');
INSERT INTO `tb_ticket` VALUES ('6141', '0106', '06:40', '长春高速公路客运站', '白山市', '大型高二级座', '约4小时', 84, '213KM');
INSERT INTO `tb_ticket` VALUES ('7200', '0105', '07:20', '长春高速公路客运站', '通化市', '大型高二级座', '--', 98, '317KM');
INSERT INTO `tb_ticket` VALUES ('7550', '0107', '17:00', '凯旋路客运站', '白城市', '大型高一级座', '约5小时', 101, '362KM');
INSERT INTO `tb_ticket` VALUES ('7580', '0107', '17:50', '凯旋路客运站', '白城市', '大型高二级座', '约4小时', 101, '362KM');
INSERT INTO `tb_ticket` VALUES ('8000', '0601', '06:30', '白山市公路客运总站', '长春市', '大型高一级座', '约3.5小时', 70, '268KM');
INSERT INTO `tb_ticket` VALUES ('8001', '0601', '08:30', '白山市公路客运西站', '长春市', '大型高二级座', '约3.5小时', 65, '268KM');
INSERT INTO `tb_ticket` VALUES ('80010', '0506', '06:30', '通化客运站(老站)', '白山市', '大型高二级座', '约1小时', 12, '58KM');
INSERT INTO `tb_ticket` VALUES ('8004', '0701', '12:30', '白城市客运中心总站', '长春市', '大型高二级座', '约5小时', 80, '377KM');
INSERT INTO `tb_ticket` VALUES ('80040', '0506', '07:50', '通化客运站(老站)', '白山市', '大型高二级座', '约1小时', 12, '58KM');
INSERT INTO `tb_ticket` VALUES ('8006', '0601', '10:40', '白山市公路客运总站', '长春市', '大型高二级座', '约3.5小时', 89, '268KM');
INSERT INTO `tb_ticket` VALUES ('80070', '0506', '08:40', '通化客运站(老站)', '白山市', '大型高二级座', '约1小时', 12, '58KM');
INSERT INTO `tb_ticket` VALUES ('8011', '0601', '14:00', '白山市公路客运总站', '长春市', '大型高二级座', '约3.5小时', 89, '268KM');
INSERT INTO `tb_ticket` VALUES ('80110', '0506', '10:40', '通化客运站(老站)', '白山市', '大型高二级座', '约1小时', 12, '58KM');
INSERT INTO `tb_ticket` VALUES ('80150', '0506', '12:40', '通化客运站(老站)', '白山市', '大型高二级座', '约1小时', 12, '58KM');
INSERT INTO `tb_ticket` VALUES ('80200', '0506', '15:10', '通化客运站(老站)', '白山市', '大型高二级座', '约1小时', 12, '58KM');
INSERT INTO `tb_ticket` VALUES ('8040', '0105', '08:20', '长春高速公路客运站', '通化市', '大型高二级座', '--', 97, '317KM');
INSERT INTO `tb_ticket` VALUES ('8330', '0106', '08:10', '长春高速公路客运站', '白山市', '大型高二级座', '约4小时', 89, '213KM');
INSERT INTO `tb_ticket` VALUES ('9001', '0605', '06:30', '白山市公路客运西站', '通化市', '大型普通级座', '约1小时', 12, '59KM');
INSERT INTO `tb_ticket` VALUES ('9040', '0105', '09:35', '长春高速公路客运站', '通化市', '大型高二级座', '--', 98, '317KM');
INSERT INTO `tb_ticket` VALUES ('9109', '0605', '09:40', '白山市公路客运总站', '通化市', '大型高一级座', '约1小时', 12, '59KM');
INSERT INTO `tb_ticket` VALUES ('9219', '0806', '07:00', '延吉市公铁分流站', '白山市', '大型高一级座', '约7小时', 103, '507KM');
INSERT INTO `tb_ticket` VALUES ('9234', '0806', '08:20', '延吉市公铁分流站', '白山市', '大型高一级座', '约6小时', 105, '478KM');
INSERT INTO `tb_ticket` VALUES ('9300', '0106', '09:40', '长春高速公路客运站', '白山市', '大型高二级座', '约4小时', 89, '213KM');

-- ----------------------------
-- Table structure for tb_ticketnum
-- ----------------------------
DROP TABLE IF EXISTS `tb_ticketnum`;
CREATE TABLE `tb_ticketnum`  (
  `flightNumber` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `routeNum` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `day` date NOT NULL,
  `ticketNumber` int NULL DEFAULT NULL,
  `state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`flightNumber`, `day`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_ticketnum
-- ----------------------------
INSERT INTO `tb_ticketnum` VALUES ('0341', '0106', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('0341', '0106', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('0341', '0106', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('0341', '0106', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('0341', '0106', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1009', '0501', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1009', '0501', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1009', '0501', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1009', '0501', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1009', '0501', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1020', '0501', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1020', '0501', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1020', '0501', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1020', '0501', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1020', '0501', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1074', '0104', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1074', '0104', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1074', '0104', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1074', '0104', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1074', '0104', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1078', '0104', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1078', '0104', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1078', '0104', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1078', '0104', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1078', '0104', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1080', '0104', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1080', '0104', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1080', '0104', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1080', '0104', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1080', '0104', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1085', '0104', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1085', '0104', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1085', '0104', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1085', '0104', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1085', '0104', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1162', '0709', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1162', '0709', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1162', '0709', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1162', '0709', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1162', '0709', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1163', '0709', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1163', '0709', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1163', '0709', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1163', '0709', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1163', '0709', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1164', '0709', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1164', '0709', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1164', '0709', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1164', '0709', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1164', '0709', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1201', '0501', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1201', '0501', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1201', '0501', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1201', '0501', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1201', '0501', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1203', '0401', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1203', '0401', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1203', '0401', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1203', '0401', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1203', '0401', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1220', '0401', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1220', '0401', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1220', '0401', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1220', '0401', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1220', '0401', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1244', '0401', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1244', '0401', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1244', '0401', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1244', '0401', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1244', '0401', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1258', '0401', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1258', '0401', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1258', '0401', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1258', '0401', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1258', '0401', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1295', '0104', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1295', '0104', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1295', '0104', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1295', '0104', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1295', '0104', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1302', '0309', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1302', '0309', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1302', '0309', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1302', '0309', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1302', '0309', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1808', '0501', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1808', '0501', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1808', '0501', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1808', '0501', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('1808', '0501', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('2020', '0501', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('2020', '0501', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('2020', '0501', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('2020', '0501', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('2020', '0501', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('2049', '0501', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('2049', '0501', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('2049', '0501', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('2049', '0501', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('2049', '0501', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('20490', '0509', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('20490', '0509', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('20490', '0509', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('20490', '0509', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('20490', '0509', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('2205', '0908', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('2205', '0908', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('2205', '0908', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('2205', '0908', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('2205', '0908', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('2645', '0103', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('2645', '0103', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('2645', '0103', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('2645', '0103', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('2645', '0103', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('3402', '0405', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('3402', '0405', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('3402', '0405', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('3402', '0405', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('3402', '0405', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('3403', '0405', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('3403', '0405', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('3403', '0405', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('3403', '0405', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('3403', '0405', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4112', '0304', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4112', '0304', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4112', '0304', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4112', '0304', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4112', '0304', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4121', '0304', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4121', '0304', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4121', '0304', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4121', '0304', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4121', '0304', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4123', '0304', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4123', '0304', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4123', '0304', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4123', '0304', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4123', '0304', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4127', '0304', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4127', '0304', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4127', '0304', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4127', '0304', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4127', '0304', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4130', '0304', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4130', '0304', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4130', '0304', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4130', '0304', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4130', '0304', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4202', '0304', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4202', '0304', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4202', '0304', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4202', '0304', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4202', '0304', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4220', '0105', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4220', '0105', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4220', '0105', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4220', '0105', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4220', '0105', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4402', '0304', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4402', '0304', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4402', '0304', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4402', '0304', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4402', '0304', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4611', '0106', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4611', '0106', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4611', '0106', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4611', '0106', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('4611', '0106', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('5015', '0907', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('5015', '0907', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('5015', '0907', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('5015', '0907', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('5015', '0907', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('5018', '0907', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('5018', '0907', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('5018', '0907', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('5018', '0907', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('5018', '0907', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('5019', '0907', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('5019', '0907', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('5019', '0907', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('5019', '0907', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('5019', '0907', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('5701', '0106', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('5701', '0106', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('5701', '0106', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('5701', '0106', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('5701', '0106', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('6001', '0701', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('6001', '0701', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('6001', '0701', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('6001', '0701', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('6001', '0701', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('6021', '0608', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('6021', '0608', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('6021', '0608', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('6021', '0608', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('6021', '0608', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('6141', '0106', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('6141', '0106', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('6141', '0106', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('6141', '0106', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('6141', '0106', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('7200', '0105', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('7200', '0105', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('7200', '0105', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('7200', '0105', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('7200', '0105', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('7550', '0107', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('7550', '0107', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('7550', '0107', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('7550', '0107', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('7550', '0107', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('7580', '0107', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('7580', '0107', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('7580', '0107', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('7580', '0107', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('7580', '0107', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8000', '0601', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8000', '0601', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8000', '0601', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8000', '0601', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8000', '0601', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8001', '0601', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8001', '0601', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8001', '0601', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8001', '0601', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8001', '0601', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80010', '0506', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80010', '0506', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80010', '0506', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80010', '0506', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80010', '0506', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8004', '0701', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8004', '0701', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8004', '0701', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8004', '0701', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8004', '0701', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80040', '0506', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80040', '0506', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80040', '0506', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80040', '0506', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80040', '0506', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8006', '0601', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8006', '0601', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8006', '0601', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8006', '0601', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8006', '0601', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80070', '0506', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80070', '0506', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80070', '0506', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80070', '0506', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80070', '0506', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8011', '0601', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8011', '0601', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8011', '0601', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8011', '0601', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8011', '0601', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80110', '0506', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80110', '0506', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80110', '0506', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80110', '0506', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80110', '0506', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80150', '0506', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80150', '0506', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80150', '0506', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80150', '0506', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80150', '0506', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80200', '0506', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80200', '0506', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80200', '0506', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80200', '0506', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('80200', '0506', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8040', '0105', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8040', '0105', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8040', '0105', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8040', '0105', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8040', '0105', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8330', '0106', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8330', '0106', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8330', '0106', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8330', '0106', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('8330', '0106', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9001', '0605', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9001', '0605', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9001', '0605', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9001', '0605', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9001', '0605', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9040', '0105', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9040', '0105', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9040', '0105', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9040', '0105', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9040', '0105', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9109', '0605', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9109', '0605', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9109', '0605', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9109', '0605', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9109', '0605', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9219', '0806', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9219', '0806', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9219', '0806', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9219', '0806', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9219', '0806', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9234', '0806', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9234', '0806', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9234', '0806', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9234', '0806', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9234', '0806', '2022-08-01', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9300', '0106', '2021-06-26', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9300', '0106', '2021-06-27', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9300', '0106', '2021-06-28', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9300', '0106', '2022-05-25', 46, '-');
INSERT INTO `tb_ticketnum` VALUES ('9300', '0106', '2022-08-01', 46, '-');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `email` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `username` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `idnumber` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `integral` double(20, 0) NULL DEFAULT NULL,
  `isadmin` int NOT NULL,
  PRIMARY KEY (`email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('2848710422@qq.com', 'weirong', '123456', '220402199708095639', '李荣潇', '13145677890', 100, 0);
INSERT INTO `tb_user` VALUES ('weirong2848@163.com', 'root', '123456', NULL, NULL, NULL, NULL, 1);

-- ----------------------------
-- Procedure structure for updateTicketNum
-- ----------------------------
DROP PROCEDURE IF EXISTS `updateTicketNum`;
delimiter ;;
CREATE PROCEDURE `updateTicketNum`()
  SQL SECURITY INVOKER
BEGIN
	#Routine body goes here...
UPDATE tb_ticketnum SET `day` = date_add(`day`,interval 5 day),ticketNumber=46,state='-' WHERE `day` = date_format(now(), '%Y-%m-%d');

END
;;
delimiter ;

-- ----------------------------
-- Event structure for updateEveryDay
-- ----------------------------
DROP EVENT IF EXISTS `updateEveryDay`;
delimiter ;;
CREATE EVENT `updateEveryDay`
ON SCHEDULE
EVERY '1' DAY STARTS '2020-06-19 22:30:00'
DO CALL updateTicketNum()
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
