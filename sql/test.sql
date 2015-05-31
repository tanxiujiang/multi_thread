/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2015-05-29 18:05:50
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `sex` varchar(3) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'harry', '男', '1');
INSERT INTO `student` VALUES ('2', 'harry', '男', '50001');
INSERT INTO `student` VALUES ('3', 'harry', '男', '75001');
INSERT INTO `student` VALUES ('4', 'harry', '男', '25001');
INSERT INTO `student` VALUES ('5', 'harry', '女', '2');
INSERT INTO `student` VALUES ('6', 'harry', '女', '25002');
INSERT INTO `student` VALUES ('7', 'harry', '女', '75002');
INSERT INTO `student` VALUES ('8', 'harry', '女', '50002');
INSERT INTO `student` VALUES ('9', 'harry', '男', '3');
INSERT INTO `student` VALUES ('10', 'harry', '男', '75003');
INSERT INTO `student` VALUES ('11', 'harry', '男', '50003');
INSERT INTO `student` VALUES ('12', 'harry', '男', '25003');
INSERT INTO `student` VALUES ('13', 'harry', '女', '4');
INSERT INTO `student` VALUES ('14', 'harry', '女', '75004');
INSERT INTO `student` VALUES ('15', 'harry', '女', '25004');
INSERT INTO `student` VALUES ('16', 'harry', '女', '50004');
INSERT INTO `student` VALUES ('17', 'harry', '男', '5');
INSERT INTO `student` VALUES ('18', 'harry', '男', '50005');
INSERT INTO `student` VALUES ('19', 'harry', '男', '75005');
INSERT INTO `student` VALUES ('20', 'harry', '男', '25005');
INSERT INTO `student` VALUES ('21', 'harry', '女', '6');
INSERT INTO `student` VALUES ('22', 'harry', '女', '50006');
INSERT INTO `student` VALUES ('23', 'harry', '女', '75006');
INSERT INTO `student` VALUES ('24', 'harry', '女', '25006');
INSERT INTO `student` VALUES ('25', 'harry', '男', '7');
INSERT INTO `student` VALUES ('26', 'harry', '男', '50007');
INSERT INTO `student` VALUES ('27', 'harry', '男', '25007');
INSERT INTO `student` VALUES ('28', 'harry', '男', '75007');
INSERT INTO `student` VALUES ('29', 'harry', '女', '8');
INSERT INTO `student` VALUES ('30', 'harry', '女', '25008');
INSERT INTO `student` VALUES ('31', 'harry', '女', '50008');
INSERT INTO `student` VALUES ('32', 'harry', '女', '75008');
INSERT INTO `student` VALUES ('33', 'harry', '男', '9');
INSERT INTO `student` VALUES ('34', 'harry', '男', '25009');
INSERT INTO `student` VALUES ('35', 'harry', '男', '50009');
INSERT INTO `student` VALUES ('36', 'harry', '女', '10');
INSERT INTO `student` VALUES ('37', 'harry', '男', '75009');
INSERT INTO `student` VALUES ('38', 'harry', '女', '25010');
INSERT INTO `student` VALUES ('39', 'harry', '女', '50010');
INSERT INTO `student` VALUES ('40', 'harry', '男', '11');
INSERT INTO `student` VALUES ('41', 'harry', '男', '50001');
INSERT INTO `student` VALUES ('42', 'harry', '男', '75001');
INSERT INTO `student` VALUES ('43', 'harry', '男', '1');
INSERT INTO `student` VALUES ('44', 'harry', '男', '25001');
INSERT INTO `student` VALUES ('45', 'harry', '女', '50002');
INSERT INTO `student` VALUES ('46', 'harry', '女', '25002');
INSERT INTO `student` VALUES ('47', 'harry', '女', '75002');
INSERT INTO `student` VALUES ('48', 'harry', '女', '2');
INSERT INTO `student` VALUES ('49', 'harry', '男', '50003');
INSERT INTO `student` VALUES ('50', 'harry', '男', '75003');
INSERT INTO `student` VALUES ('51', 'harry', '男', '25003');
INSERT INTO `student` VALUES ('52', 'harry', '男', '3');
INSERT INTO `student` VALUES ('53', 'harry', '女', '50004');
INSERT INTO `student` VALUES ('54', 'harry', '女', '25004');
INSERT INTO `student` VALUES ('55', 'harry', '女', '75004');
INSERT INTO `student` VALUES ('56', 'harry', '女', '4');
INSERT INTO `student` VALUES ('57', 'harry', '男', '50005');
INSERT INTO `student` VALUES ('58', 'harry', '男', '25005');
INSERT INTO `student` VALUES ('59', 'harry', '男', '75005');
INSERT INTO `student` VALUES ('60', 'harry', '男', '5');
INSERT INTO `student` VALUES ('61', 'harry', '女', '50006');
INSERT INTO `student` VALUES ('62', 'harry', '女', '25006');
INSERT INTO `student` VALUES ('63', 'harry', '女', '75006');
INSERT INTO `student` VALUES ('64', 'harry', '女', '6');
INSERT INTO `student` VALUES ('65', 'harry', '男', '50007');
INSERT INTO `student` VALUES ('66', 'harry', '男', '75007');
INSERT INTO `student` VALUES ('67', 'harry', '男', '25007');
INSERT INTO `student` VALUES ('68', 'harry', '男', '7');
INSERT INTO `student` VALUES ('69', 'harry', '女', '50008');
INSERT INTO `student` VALUES ('70', 'harry', '女', '75008');
INSERT INTO `student` VALUES ('71', 'harry', '女', '25008');
INSERT INTO `student` VALUES ('72', 'harry', '女', '8');
INSERT INTO `student` VALUES ('73', 'harry', '男', '50009');
INSERT INTO `student` VALUES ('74', 'harry', '男', '75009');
INSERT INTO `student` VALUES ('75', 'harry', '男', '25009');
INSERT INTO `student` VALUES ('76', 'harry', '男', '9');
INSERT INTO `student` VALUES ('77', 'harry', '女', '50010');
INSERT INTO `student` VALUES ('78', 'harry', '女', '75010');
INSERT INTO `student` VALUES ('79', 'harry', '女', '25010');
INSERT INTO `student` VALUES ('80', 'harry', '女', '10');
