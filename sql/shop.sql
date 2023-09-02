/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 02/09/2023 10:09:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(0) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e');

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `collection_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '收藏品ID',
  `user_id` bigint(0) NULL DEFAULT NULL COMMENT '用户ID',
  `goods_id` bigint(0) NULL DEFAULT NULL COMMENT '商品ID ',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` int(0) NULL DEFAULT 0 COMMENT '状态',
  PRIMARY KEY (`collection_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES (22, 1556169985301184514, 12, '2022-12-14 17:57:25', 0);
INSERT INTO `collection` VALUES (23, 1556169985301184514, 12, '2023-01-27 20:17:15', 0);
INSERT INTO `collection` VALUES (24, 1556169985301184514, 13, '2023-01-27 20:18:49', 0);
INSERT INTO `collection` VALUES (25, 1556169985301184514, 13, '2023-01-27 20:18:52', 0);
INSERT INTO `collection` VALUES (26, 1556169985301184514, 12, '2023-01-30 20:43:57', 0);
INSERT INTO `collection` VALUES (27, 1556169985301184514, 12, '2023-01-30 20:44:16', 0);
INSERT INTO `collection` VALUES (28, 1556169985301184514, 14, '2023-01-30 20:44:29', 0);
INSERT INTO `collection` VALUES (29, 1556169985301184514, 12, '2023-02-21 16:01:54', 0);
INSERT INTO `collection` VALUES (30, 1556169985301184514, 12, '2023-02-21 16:02:27', 0);
INSERT INTO `collection` VALUES (31, 1556169985301184514, 15, '2023-02-21 16:05:06', 0);
INSERT INTO `collection` VALUES (32, 1556169985301184514, 12, '2023-02-22 11:07:21', 0);
INSERT INTO `collection` VALUES (33, 1556169985301184514, 13, '2023-02-22 11:11:26', 0);
INSERT INTO `collection` VALUES (34, 1556169985301184514, 14, '2023-02-22 11:13:25', 0);
INSERT INTO `collection` VALUES (35, 1556169985301184514, 12, '2023-02-22 11:14:58', 0);
INSERT INTO `collection` VALUES (36, 1556169985301184514, 12, '2023-02-22 11:15:44', 0);
INSERT INTO `collection` VALUES (37, 1556169985301184514, 12, '2023-02-22 11:16:19', 0);
INSERT INTO `collection` VALUES (38, 1556169985301184514, 14, '2023-02-22 11:17:19', 0);
INSERT INTO `collection` VALUES (39, NULL, 12, '2023-02-22 17:07:08', 0);
INSERT INTO `collection` VALUES (40, NULL, 12, '2023-02-22 17:08:09', 0);
INSERT INTO `collection` VALUES (41, NULL, 12, '2023-02-22 17:08:25', 0);
INSERT INTO `collection` VALUES (42, NULL, 12, '2023-02-22 17:10:40', 0);
INSERT INTO `collection` VALUES (43, NULL, 12, '2023-02-23 15:47:46', 0);
INSERT INTO `collection` VALUES (44, NULL, 12, '2023-02-23 15:47:57', 0);
INSERT INTO `collection` VALUES (45, NULL, 12, '2023-02-23 15:48:42', 0);
INSERT INTO `collection` VALUES (46, NULL, 12, '2023-02-23 15:50:47', 0);
INSERT INTO `collection` VALUES (47, NULL, 12, '2023-02-23 15:52:04', 0);
INSERT INTO `collection` VALUES (48, NULL, 12, '2023-02-23 15:52:27', 0);
INSERT INTO `collection` VALUES (49, NULL, 12, '2023-02-23 15:52:38', 0);
INSERT INTO `collection` VALUES (50, NULL, 12, '2023-02-23 15:52:39', 0);
INSERT INTO `collection` VALUES (51, NULL, 12, '2023-03-02 15:09:36', 0);
INSERT INTO `collection` VALUES (52, NULL, 13, '2023-03-02 15:09:49', 0);

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon`  (
  `coupon_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '优惠券ID',
  `coupon_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '优惠券名称',
  `coupon_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '优惠券类型   1 满减 2立减 3折扣券 4优惠码',
  `coupon_count` int(0) NULL DEFAULT NULL COMMENT '优惠券总数',
  `coupon_status` int(0) NULL DEFAULT NULL COMMENT '优惠券状态   -2 异常 -1失效   0创建未发行 1发行 2抢完',
  `coupon_get_channel` int(0) NULL DEFAULT NULL COMMENT '获取途径',
  `quota` int(0) NULL DEFAULT NULL COMMENT '限领张数',
  `shop_id` bigint(0) NULL DEFAULT NULL COMMENT '店铺ID,发行者',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述信息',
  `coupon_stop_time` datetime(0) NULL DEFAULT NULL COMMENT '优惠券发放截止时间',
  `effective_periods` datetime(0) NULL DEFAULT NULL COMMENT '有效时长',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`coupon_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coupon
-- ----------------------------
INSERT INTO `coupon` VALUES (20, '测试优惠券', '1', 0, 1, 1, 1, 1, '满50-3', '2022-09-12 19:04:14', '2022-09-12 19:04:14', '2022-09-04 19:22:06', 0);
INSERT INTO `coupon` VALUES (21, '测试优惠券', '1', 100, 1, 1, 1, 1, '满50-3', '2022-09-12 19:04:14', '2022-09-12 19:04:14', '2022-09-05 11:40:56', 0);
INSERT INTO `coupon` VALUES (22, '测试优惠券', '1', 9999, 1, 1, 1, 1, '满50-3', '2022-09-12 19:04:14', '2022-09-12 19:04:14', '2022-09-05 12:08:34', 0);
INSERT INTO `coupon` VALUES (23, '测试优惠券', '1', 9999, 1, 1, 1, 1, '满50-3', '2022-09-12 19:04:14', '2022-09-12 19:04:14', '2022-09-05 12:19:07', 0);
INSERT INTO `coupon` VALUES (24, '测试优惠券', '1', 9999, 1, 1, 1, 1, '满50-3', '2022-09-12 19:04:14', '2022-09-12 19:04:14', '2022-09-06 11:34:32', 0);

-- ----------------------------
-- Table structure for coupon_personal
-- ----------------------------
DROP TABLE IF EXISTS `coupon_personal`;
CREATE TABLE `coupon_personal`  (
  `coupon_personal_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '个人优惠券ID',
  `coupon_id` bigint(0) NULL DEFAULT NULL COMMENT '优惠券ID',
  `user_id` bigint(0) NULL DEFAULT NULL COMMENT '用户ID',
  `coupon_per_status` int(0) NULL DEFAULT 2 COMMENT '个人优惠券状态  -1过期 2可用 3禁用',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '获取时间',
  `expiration_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`coupon_personal_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 102 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coupon_personal
-- ----------------------------
INSERT INTO `coupon_personal` VALUES (1, 18, 1556169985301184514, 2, '2022-09-04 19:16:20', '2022-09-05 14:20:34');
INSERT INTO `coupon_personal` VALUES (2, 19, 1556169985301184514, 2, '2022-09-04 19:16:31', '2022-09-05 14:20:45');
INSERT INTO `coupon_personal` VALUES (3, 20, 1556169985301184514, 2, '2022-09-04 19:22:11', '2022-09-05 14:26:25');
INSERT INTO `coupon_personal` VALUES (4, 21, 1566637105760788480, 2, '2022-09-05 11:59:29', '2022-09-06 07:03:43');
INSERT INTO `coupon_personal` VALUES (5, 21, 1566637272392097792, 2, '2022-09-05 12:00:07', '2022-09-06 07:04:21');
INSERT INTO `coupon_personal` VALUES (6, 21, 1566637272434040832, 2, '2022-09-05 12:00:07', '2022-09-06 07:04:21');
INSERT INTO `coupon_personal` VALUES (7, 21, 1566637272551481344, 2, '2022-09-05 12:00:07', '2022-09-06 07:04:21');
INSERT INTO `coupon_personal` VALUES (8, 21, 1566637272505344000, 2, '2022-09-05 12:00:07', '2022-09-06 07:04:21');
INSERT INTO `coupon_personal` VALUES (9, 21, 1566637272463400960, 2, '2022-09-05 12:00:07', '2022-09-06 07:04:21');
INSERT INTO `coupon_personal` VALUES (10, 21, 1566637272585035776, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (11, 21, 1566637272664727552, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (12, 21, 1566637272622784512, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (13, 21, 1566637272710864896, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (14, 21, 1566637272752807936, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (15, 21, 1566637272928968704, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (16, 21, 1566637272798945280, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (17, 21, 1566637272845082624, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (18, 21, 1566637272891219968, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (19, 21, 1566637272987688960, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (20, 21, 1566637273348399104, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (21, 21, 1566637273004466176, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (22, 21, 1566637273042214912, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (23, 21, 1566637273390342144, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (24, 21, 1566637273855909888, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (25, 21, 1566637274015293440, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (26, 21, 1566637273105129472, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (27, 21, 1566637273268707328, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (28, 21, 1566637273314844672, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (29, 21, 1566637274308894720, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (30, 21, 1566637273809772544, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (31, 21, 1566637273587474432, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (32, 21, 1566637274069819392, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (33, 21, 1566637273511976960, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (34, 21, 1566637274145316864, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (35, 21, 1566637274250174464, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (36, 21, 1566637273423896576, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (37, 21, 1566637273180626944, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (38, 21, 1566637273142878208, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (39, 21, 1566637273683943424, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (40, 21, 1566637273650388992, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (41, 21, 1566637273981739009, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (42, 21, 1566637273734275072, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (43, 21, 1566637273943990272, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (44, 21, 1566637273218375680, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (45, 21, 1566637273478422528, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (46, 21, 1566637273776218112, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (47, 21, 1566637274195648512, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (48, 21, 1566637273558114304, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (49, 21, 1566637274329866240, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (50, 21, 1566637274363420672, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (51, 21, 1566637274392780800, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (52, 21, 1566637274434723840, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (53, 21, 1566637274115956736, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (54, 21, 1566637274468278272, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (55, 21, 1566637274518609920, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (56, 21, 1566637274568941568, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (57, 21, 1566637274694770688, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (58, 21, 1566637274828988416, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (59, 21, 1566637274975789056, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (60, 21, 1566637274657021952, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (61, 21, 1566637274602496000, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (62, 21, 1566637274749296640, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (63, 21, 1566637274782851072, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (64, 21, 1566637275420385280, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (65, 21, 1566637275235835904, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (66, 21, 1566637275604934656, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (67, 21, 1566637275902730241, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (68, 21, 1566637275281973248, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (69, 21, 1566637275432968192, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (70, 21, 1566637275688820736, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (71, 21, 1566637275533631488, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (72, 21, 1566637275223252992, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (73, 21, 1566637275739152384, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (74, 21, 1566637275290361856, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (75, 21, 1566637275265196032, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (76, 21, 1566637276175360000, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (77, 21, 1566637275902730240, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (78, 21, 1566637275256807424, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (79, 21, 1566637276221497344, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (80, 21, 1566637275395219456, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (81, 21, 1566637276435406848, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (82, 21, 1566637275898535936, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (83, 21, 1566637276255051776, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (84, 21, 1566637276221497346, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (85, 21, 1566637275294556160, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (86, 21, 1566637275508465664, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (87, 21, 1566637275932090368, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (88, 21, 1566637275667849216, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (89, 21, 1566637276372492288, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (90, 21, 1566637275361665024, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (91, 21, 1566637275537825792, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (92, 21, 1566637276041142272, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (93, 21, 1566637276208914432, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (94, 21, 1566637276485738496, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (95, 21, 1566637275688820737, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (96, 21, 1566637275445551104, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (97, 21, 1566637276053725184, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (98, 21, 1566637276221497345, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (99, 21, 1566637276376686592, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (100, 21, 1566637276397658112, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (101, 21, 1566637276921946112, 2, '2022-09-05 12:00:08', '2022-09-06 07:04:22');
INSERT INTO `coupon_personal` VALUES (102, 24, NULL, 2, '2022-09-07 19:40:25', '2022-09-08 14:44:39');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goods_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `price_old` decimal(10, 2) UNSIGNED NULL DEFAULT NULL COMMENT '原价',
  `price_new` decimal(10, 2) UNSIGNED NULL DEFAULT NULL COMMENT '现价',
  `store` int(0) NULL DEFAULT NULL COMMENT '库存',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细信息',
  `goods_cate_id` bigint(0) NULL DEFAULT NULL COMMENT '商品类型ID',
  `shop_id` bigint(0) NULL DEFAULT NULL COMMENT '店铺ID',
  `is_shelf` int(0) NULL DEFAULT NULL COMMENT '是否上架',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 63 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, 'ThinkPad T-550P', 7999.00, 5999.00, 2988, '20220321170515427.jpg', 'ThinkPad T-550P', 14, 1, 0, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (11, 'iphone13', 6999.00, 5999.00, 4999, '20220320164729188.jpg', 'iphone13', 17, 1, 0, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (12, 'iphone11', 5699.00, 5199.00, 1000, '20220329135739126.jpg', 'iphone12', 17, 1, 1, '2022-08-12 09:04:14', '2022-12-14 17:58:25', 0);
INSERT INTO `goods` VALUES (13, '华为笔记本电脑MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 4899.00, 4699.00, 10000, '20220329141034131.jpg', 'MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 14, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (14, '耐克 腰包 NIKE TECH BA5751-072 F', 299.00, 279.00, 10000, '20220329143518022.jpg', 'NIKE TECH BA5751-072 F', 18, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (15, '罗蒙（ROMON）两件装 男士纯棉短袖t恤夏季圆领黑白棉', 199.00, 99.00, 86, '20220329143614902.jpg', '男士纯棉短袖t恤夏季圆领黑白棉', 15, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (17, 'iphone12', 5799.00, 5199.00, 10000, '20220329135739126.jpg', 'iphone12', 17, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (18, 'iphone12', 5799.00, 5199.00, 10000, '20220329135739126.jpg', 'iphone12', 17, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (19, 'iphone12', 5799.00, 5199.00, 1000, '20220329135739126.jpg', 'iphone12', 17, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (20, 'iphone12', 5799.00, 5199.00, 10000, '20220329135739126.jpg', 'iphone12', 17, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (21, 'iphone12', 5799.00, 5199.00, 1000, '20220329135739126.jpg', 'iphone12', 17, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (22, 'iphone12', 5799.00, 5199.00, 1000, '20220329135739126.jpg', 'iphone12', 17, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (23, 'iphone12', 5799.00, 5199.00, 1000, '20220329135739126.jpg', 'iphone12', 17, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (24, 'iphone12', 5799.00, 5199.00, 1000, '20220329135739126.jpg', 'iphone12', 17, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (25, 'iphone12', 5799.00, 5199.00, 1000, '20220329135739126.jpg', 'iphone12', 17, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (26, 'iphone12', 5799.00, 5199.00, 1000, '20220329135739126.jpg', 'iphone12', 17, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (27, 'iphone12', 5799.00, 5199.00, 1000, '20220329135739126.jpg', 'iphone12', 17, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (28, 'iphone12', 5799.00, 5199.00, 1000, '20220329135739126.jpg', 'iphone12', 17, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (29, 'iphone12', 5799.00, 5199.00, 1000, '20220329135739126.jpg', 'iphone12', 17, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (30, 'iphone12', 5799.00, 5199.00, 1000, '20220329135739126.jpg', 'iphone12', 17, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (31, '华为笔记本电脑MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 4899.00, 4699.00, 1000, '20220329141034131.jpg', 'MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 14, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (32, '华为笔记本电脑MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 4899.00, 4699.00, 1000, '20220329141034131.jpg', 'MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 14, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (33, '华为笔记本电脑MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 4899.00, 4699.00, 1000, '20220329141034131.jpg', 'MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 14, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (34, '华为笔记本电脑MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 4899.00, 4699.00, 1000, '20220329141034131.jpg', 'MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 14, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (35, '华为笔记本电脑MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 4899.00, 4699.00, 1000, '20220329141034131.jpg', 'MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 14, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (36, '华为笔记本电脑MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 4899.00, 4699.00, 1000, '20220329141034131.jpg', 'MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 14, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (37, '华为笔记本电脑MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 4899.00, 4699.00, 1000, '20220329141034131.jpg', 'MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 14, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (38, '华为笔记本电脑MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 4899.00, 4699.00, 1000, '20220329141034131.jpg', 'MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 14, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (39, '华为笔记本电脑MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 4899.00, 4699.00, 1000, '20220329141034131.jpg', 'MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 14, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (40, '华为笔记本电脑MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 4899.00, 4699.00, 1000, '20220329141034131.jpg', 'MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 14, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (41, '华为笔记本电脑MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 4899.00, 4699.00, 1000, '20220329141034131.jpg', 'MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', 14, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (42, '耐克 腰包 NIKE TECH BA5751-072 F', 299.00, 279.00, 1000, '20220329143518022.jpg', 'NIKE TECH BA5751-072 F', 18, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (43, '耐克 腰包 NIKE TECH BA5751-072 F', 299.00, 279.00, 1000, '20220329143518022.jpg', 'NIKE TECH BA5751-072 F', 18, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (44, '耐克 腰包 NIKE TECH BA5751-072 F', 299.00, 279.00, 1000, '20220329143518022.jpg', 'NIKE TECH BA5751-072 F', 18, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (45, '耐克 腰包 NIKE TECH BA5751-072 F', 299.00, 279.00, 1000, '20220329143518022.jpg', 'NIKE TECH BA5751-072 F', 18, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (46, '耐克 腰包 NIKE TECH BA5751-072 F', 299.00, 279.00, 1000, '20220329143518022.jpg', 'NIKE TECH BA5751-072 F', 18, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (47, '耐克 腰包 NIKE TECH BA5751-072 F', 299.00, 279.00, 1000, '20220329143518022.jpg', 'NIKE TECH BA5751-072 F', 18, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (48, '耐克 腰包 NIKE TECH BA5751-072 F', 299.00, 279.00, 1000, '20220329143518022.jpg', 'NIKE TECH BA5751-072 F', 18, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (49, '耐克 腰包 NIKE TECH BA5751-072 F', 299.00, 279.00, 1000, '20220329143518022.jpg', 'NIKE TECH BA5751-072 F', 18, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (50, '耐克 腰包 NIKE TECH BA5751-072 F', 299.00, 279.00, 1000, '20220329143518022.jpg', 'NIKE TECH BA5751-072 F', 18, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 1);
INSERT INTO `goods` VALUES (51, '耐克 腰包 NIKE TECH BA5751-072 F', 299.00, 279.00, 1000, '20220329143518022.jpg', 'NIKE TECH BA5751-072 F', 18, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 1);
INSERT INTO `goods` VALUES (59, '书包', 199.00, 99.00, 5000, '4301dd9d-2c3c-4698-8199-2677a16afe82.jpg', '大书包', 18, 1, 1, '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);
INSERT INTO `goods` VALUES (60, 'iphone13', 5399.00, 4399.00, 1000, '48a22e77-c228-46ad-ae0a-f3c80c5d699b.webp', 'zuixn', NULL, NULL, 1, '2022-12-05 20:52:37', '2022-12-05 20:52:37', 0);

-- ----------------------------
-- Table structure for goods_cate
-- ----------------------------
DROP TABLE IF EXISTS `goods_cate`;
CREATE TABLE `goods_cate`  (
  `goods_cate_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '商品分类ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品分类名称',
  PRIMARY KEY (`goods_cate_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_cate
-- ----------------------------
INSERT INTO `goods_cate` VALUES (2, '食品');
INSERT INTO `goods_cate` VALUES (13, '玩具');
INSERT INTO `goods_cate` VALUES (14, '电脑');
INSERT INTO `goods_cate` VALUES (15, '衣服');
INSERT INTO `goods_cate` VALUES (16, '裤子');
INSERT INTO `goods_cate` VALUES (17, '手机');

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details`  (
  `client_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `resource_ids` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `client_secret` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `scope` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `authorized_grant_types` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `authorities` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `access_token_validity` int(0) NULL DEFAULT NULL,
  `refresh_token_validity` int(0) NULL DEFAULT NULL,
  `additional_information` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `autoapprove` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('order-client', NULL, '$2a$10$GoIOhjqFKVyrabUNcie8d.ADX.qZSxpYbO6YK4L2gsNzlCIxEUDlW', 'all', 'authorization_code,refresh_token,password', NULL, NULL, 3600, 36000, NULL, '1');
INSERT INTO `oauth_client_details` VALUES ('user-client', NULL, '$2a$10$o2l5kA7z.Caekp72h5kU7uqdTDrlamLq.57M1F6ulJln9tRtOJufq', 'all', 'authorization_code,refresh_token,password', NULL, NULL, 3600, 36000, NULL, '1');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `order_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `order_no` bigint(0) NULL DEFAULT NULL COMMENT '订单号',
  `user_id` bigint(0) NULL DEFAULT NULL COMMENT '用户ID',
  `shop_id` bigint(0) NULL DEFAULT NULL COMMENT '商铺ID',
  `order_status` int(0) NULL DEFAULT 1 COMMENT '订单状态',
  `goods_count` bigint(0) NULL DEFAULT NULL COMMENT '商品数量',
  `goods_amount_total` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品总价',
  `pay_channel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付渠道',
  `order_amount_total` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单实付金额',
  `logistics_fee` decimal(10, 2) NULL DEFAULT NULL COMMENT '运费',
  `order_logistics_id` bigint(0) NULL DEFAULT NULL COMMENT '订单物流ID',
  `out_trade_no` bigint(0) NULL DEFAULT NULL COMMENT '订单支付单号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '付款时间',
  `delivery_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `order_settlement_time` datetime(0) NULL DEFAULT NULL COMMENT '订单结算时间',
  `order_settlement_status` int(0) NULL DEFAULT NULL COMMENT '货到付款，分期付款',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (43, 1601247718553944064, 1556169985301184514, 1, 0, 1, 5199.00, NULL, NULL, NULL, NULL, NULL, '2022-12-10 00:09:41', NULL, NULL, NULL, NULL);
INSERT INTO `order` VALUES (44, 1601448720817311744, 1556169985301184514, 1, 1, 1, 4699.00, NULL, NULL, NULL, NULL, NULL, '2022-12-10 13:28:23', NULL, NULL, NULL, NULL);
INSERT INTO `order` VALUES (45, 1601823350237278208, 1556169985301184514, 1, 1, 1, 4699.00, NULL, NULL, NULL, NULL, NULL, '2022-12-11 14:17:02', NULL, NULL, NULL, NULL);
INSERT INTO `order` VALUES (46, 1620044191046578176, 1556169985301184514, 1, 1, 1, 279.00, NULL, NULL, NULL, NULL, NULL, '2023-01-30 21:00:09', NULL, NULL, NULL, NULL);
INSERT INTO `order` VALUES (47, NULL, 1556169985301184514, 0, 1, 1, 0.00, 'string', 0.00, 0.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `order` VALUES (48, NULL, 1556169985301184514, 0, 1, 1, 0.00, 'string', 0.00, 0.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `order` VALUES (49, NULL, 1556169985301184514, 0, 1, 1, 0.00, 'string', 0.00, 0.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for order_comment
-- ----------------------------
DROP TABLE IF EXISTS `order_comment`;
CREATE TABLE `order_comment`  (
  `order_com_id` bigint(0) NOT NULL COMMENT '评价ID',
  `order_id` bigint(0) NOT NULL COMMENT '订单ID',
  `score` float NULL DEFAULT NULL COMMENT '分数',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_comment
-- ----------------------------

-- ----------------------------
-- Table structure for order_details
-- ----------------------------
DROP TABLE IF EXISTS `order_details`;
CREATE TABLE `order_details`  (
  `order_details_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '订单明细表ID',
  `order_id` bigint(0) NULL DEFAULT NULL COMMENT '订单ID',
  `goods_id` bigint(0) NULL DEFAULT NULL COMMENT '商品ID',
  `order_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单金额',
  `order_count` bigint(0) NULL DEFAULT NULL COMMENT '物品数量',
  `goods_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '客户备注',
  PRIMARY KEY (`order_details_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_details
-- ----------------------------
INSERT INTO `order_details` VALUES (39, 43, 12, NULL, 1, 5199.00, 'iphone12', NULL);
INSERT INTO `order_details` VALUES (40, 44, 13, NULL, 1, 4699.00, '华为笔记本电脑MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', NULL);
INSERT INTO `order_details` VALUES (41, 45, 13, NULL, 1, 4699.00, '华为笔记本电脑MateBook D 14 SE版 14英寸 11代酷睿 i5 集显 8G+512G', NULL);
INSERT INTO `order_details` VALUES (42, 46, 14, NULL, 1, 279.00, '耐克 腰包 NIKE TECH BA5751-072 F', NULL);
INSERT INTO `order_details` VALUES (43, NULL, 1, NULL, NULL, NULL, 'ThinkPad T-550P', 'string');
INSERT INTO `order_details` VALUES (44, NULL, 1, NULL, NULL, NULL, 'ThinkPad T-550P', 'string');
INSERT INTO `order_details` VALUES (45, NULL, 11, NULL, NULL, NULL, 'ThinkPad T-550P', 'string');

-- ----------------------------
-- Table structure for order_logistics
-- ----------------------------
DROP TABLE IF EXISTS `order_logistics`;
CREATE TABLE `order_logistics`  (
  `order_logistics_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '物流表ID',
  `order_id` bigint(0) NULL DEFAULT NULL COMMENT '订单表ID',
  `express_no` bigint(0) NULL DEFAULT NULL COMMENT '物流单号',
  `consignee_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收货人姓名',
  `consignee_telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话',
  `consignee_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收货人地址',
  PRIMARY KEY (`order_logistics_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_logistics
-- ----------------------------
INSERT INTO `order_logistics` VALUES (6, 29, NULL, 'liujie', NULL, NULL);
INSERT INTO `order_logistics` VALUES (7, 30, NULL, 'liujie', NULL, NULL);
INSERT INTO `order_logistics` VALUES (8, 31, NULL, 'liujie', NULL, NULL);

-- ----------------------------
-- Table structure for permisson
-- ----------------------------
DROP TABLE IF EXISTS `permisson`;
CREATE TABLE `permisson`  (
  `permission_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '权限表ID',
  `permiss_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permisson
-- ----------------------------
INSERT INTO `permisson` VALUES (1, 'sys:goods:list', '商品展示');
INSERT INTO `permisson` VALUES (2, 'sys:goodsCate:add', '添加商品类别');
INSERT INTO `permisson` VALUES (3, 'sys:collection:selectAll', '显示收藏商品');
INSERT INTO `permisson` VALUES (4, 'sys:collection:delete', '删除收藏商品');
INSERT INTO `permisson` VALUES (5, 'sys:coupon:give', '发放优惠券');
INSERT INTO `permisson` VALUES (6, 'sys:coupon:grab', '获取优惠券');
INSERT INTO `permisson` VALUES (7, 'sys:goodsCate:selectall', '显示全部商品类别');
INSERT INTO `permisson` VALUES (8, 'sys:goodsCate:add', '添加商品类别');
INSERT INTO `permisson` VALUES (9, 'sys:goodsCate:delete', '删除某个商品类别');
INSERT INTO `permisson` VALUES (10, 'sys:goods:selectShelfed', '显示首页已上架商品');
INSERT INTO `permisson` VALUES (11, 'sys:goods:selectByCate', '显示类型搜索已上架商品');
INSERT INTO `permisson` VALUES (12, 'sys:goods:selectByWord', '显示关键词搜索已上架商品');
INSERT INTO `permisson` VALUES (13, 'sys:goods:changeStatus', '上下架操作');
INSERT INTO `permisson` VALUES (14, 'sys:goods:addGoods', '添加或修改商品');
INSERT INTO `permisson` VALUES (15, 'sys:goods:selectGoodsById', 'ID查询商品');
INSERT INTO `permisson` VALUES (16, 'sys:goods:deleteGoodsByIds', '删除商品');
INSERT INTO `permisson` VALUES (17, 'sys:order:confirmOrder', '显示订单确认');
INSERT INTO `permisson` VALUES (18, 'sys:order:generateOrder', '生成订单');
INSERT INTO `permisson` VALUES (19, 'sys:cart:selectAll', '显示购物车');
INSERT INTO `permisson` VALUES (20, 'sys:cart:addCart', '添加购物车');
INSERT INTO `permisson` VALUES (21, 'sys:cart:updateCount', '更新cart里商品数量');
INSERT INTO `permisson` VALUES (22, 'sys:cart:deleteCart', '删除购物车');
INSERT INTO `permisson` VALUES (23, 'sys:user:register', '用户注册');
INSERT INTO `permisson` VALUES (25, 'sys:user:checkUserName', '注册用户查重');
INSERT INTO `permisson` VALUES (26, 'sys:user:login', '用户登录实现');
INSERT INTO `permisson` VALUES (27, 'sys:user:logout', '用户退出登录');
INSERT INTO `permisson` VALUES (28, 'sys:collection:addAllCollection', '添加收藏');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `sys_role_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '角色表ID',
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`sys_role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '普通用户', '购买商品');
INSERT INTO `role` VALUES (2, '卖家', '出售商品');
INSERT INTO `role` VALUES (3, '管理员', NULL);

-- ----------------------------
-- Table structure for role_permisson
-- ----------------------------
DROP TABLE IF EXISTS `role_permisson`;
CREATE TABLE `role_permisson`  (
  `role_permission_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '角色权限表ID',
  `role_id` int(0) NULL DEFAULT NULL COMMENT '角色表ID',
  `permission_id` int(0) NULL DEFAULT NULL COMMENT '权限表ID',
  PRIMARY KEY (`role_permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permisson
-- ----------------------------
INSERT INTO `role_permisson` VALUES (1, 1, 1);
INSERT INTO `role_permisson` VALUES (2, 2, 2);
INSERT INTO `role_permisson` VALUES (3, 1, 3);
INSERT INTO `role_permisson` VALUES (4, 1, 4);
INSERT INTO `role_permisson` VALUES (5, 2, 5);
INSERT INTO `role_permisson` VALUES (6, 1, 6);
INSERT INTO `role_permisson` VALUES (12, 3, 7);
INSERT INTO `role_permisson` VALUES (13, 3, 8);
INSERT INTO `role_permisson` VALUES (14, 3, 9);
INSERT INTO `role_permisson` VALUES (15, 1, 10);
INSERT INTO `role_permisson` VALUES (16, 1, 11);
INSERT INTO `role_permisson` VALUES (17, 1, 12);
INSERT INTO `role_permisson` VALUES (18, 2, 13);
INSERT INTO `role_permisson` VALUES (19, 2, 14);
INSERT INTO `role_permisson` VALUES (20, 2, 15);
INSERT INTO `role_permisson` VALUES (21, 2, 16);
INSERT INTO `role_permisson` VALUES (22, 1, 17);
INSERT INTO `role_permisson` VALUES (23, 1, 18);
INSERT INTO `role_permisson` VALUES (24, 1, 19);
INSERT INTO `role_permisson` VALUES (25, 1, 20);
INSERT INTO `role_permisson` VALUES (26, 1, 21);
INSERT INTO `role_permisson` VALUES (27, 1, 22);
INSERT INTO `role_permisson` VALUES (28, 1, 23);
INSERT INTO `role_permisson` VALUES (29, 1, 25);
INSERT INTO `role_permisson` VALUES (30, 1, 26);
INSERT INTO `role_permisson` VALUES (31, 1, 27);
INSERT INTO `role_permisson` VALUES (32, 1, 28);

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop`  (
  `shop_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '店铺ID',
  `shop_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '店铺名称',
  `shop_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细信息',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`shop_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES (1, '枫叶', NULL, '20220321170515427.jpg', '枫叶的店铺', '2022-08-12 09:04:14', '2022-08-12 09:04:14', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` bigint(0) NOT NULL COMMENT '用户信息主键ID',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名/昵称',
  `user_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮件',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(0) NULL DEFAULT 1 COMMENT '版本',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1556169985301184514, 'liujie', '$2a$10$7I3cYbO3xpWBQOs32EmmLOAopQGM/mo3itGi1f0GfN5Q.pWFZTLDy', '123456789', '123456789', '2022-08-07 14:46:51', '2022-08-07 14:46:51', 1, 0);
INSERT INTO `user` VALUES (1566627981944811522, 'mayan', '$2a$10$J0ZgpSHpK6ijiskIiooPueQebejRQefTTCsnOMW5MexWVCuuaDh3q', '12345678910', '123456789', '2022-09-05 11:23:12', '2022-09-05 11:23:12', 1, 0);
INSERT INTO `user` VALUES (1584492528726491137, 'moyunbo', '$2a$10$Qper1Q456GeYBGAmMKI9WO7CgJHy/WEK5bRYRes2racHa2sGYMi22', NULL, NULL, '2022-10-24 18:30:32', '2022-10-24 18:30:32', 1, 0);
INSERT INTO `user` VALUES (1584492698650329089, 'liyixin', '$2a$10$UAEgWNQ72QDNbMbHpP6U/OJiZQ9fsxNZTARAgH/wA39fNf9/E9xnS', NULL, NULL, '2022-10-24 18:31:12', '2022-10-24 18:31:12', 1, 0);

-- ----------------------------
-- Table structure for user_address
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address`  (
  `address_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '地址表ID',
  `user_id` bigint(0) NULL DEFAULT NULL COMMENT '用户ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `telephone` int(0) NULL DEFAULT NULL COMMENT '联系方式',
  `province` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份',
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '城市',
  `area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地区',
  `detailed_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '详细地址',
  `is_default_address` int(0) NULL DEFAULT NULL COMMENT '是否设为默认地址',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`address_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '地址表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_address
-- ----------------------------
INSERT INTO `user_address` VALUES (1, 1556169985301184514, 'maple', 110, '浙江', '杭州', 'xx区', 'xx街道', 1, '2022-08-07 14:46:51', NULL);

-- ----------------------------
-- Table structure for user_cart
-- ----------------------------
DROP TABLE IF EXISTS `user_cart`;
CREATE TABLE `user_cart`  (
  `user_cart_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '购物车',
  `user_id` bigint(0) NULL DEFAULT NULL COMMENT '用户ID',
  `goods_id` bigint(0) NULL DEFAULT NULL COMMENT '商品ID',
  `goods_count` int(0) NULL DEFAULT NULL COMMENT '商品数量',
  `status` int(0) NULL DEFAULT 0 COMMENT '商品状态（已下架，已失效，已售罄）',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_cart_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_cart
-- ----------------------------
INSERT INTO `user_cart` VALUES (6, 1556169985301184514, 14, 18, 0, '2022-08-14 10:23:23', '2022-08-14 10:23:23');
INSERT INTO `user_cart` VALUES (15, 1556169985301184514, 14, 1, 0, '2022-12-03 11:54:25', '2022-12-03 11:54:25');
INSERT INTO `user_cart` VALUES (17, 1556169985301184514, 14, 1, 0, '2022-12-14 17:57:45', '2022-12-14 17:57:45');
INSERT INTO `user_cart` VALUES (18, 1556169985301184514, 13, 1, 0, '2023-01-27 20:18:47', '2023-01-27 20:18:47');
INSERT INTO `user_cart` VALUES (19, 1556169985301184514, 14, 1, 0, '2023-01-30 20:50:59', '2023-01-30 20:50:59');
INSERT INTO `user_cart` VALUES (22, NULL, 12, 1, 0, '2023-02-23 15:58:49', '2023-02-23 15:58:49');
INSERT INTO `user_cart` VALUES (23, NULL, 18, 18, 0, '2023-02-24 14:56:24', '2023-02-24 14:56:24');
INSERT INTO `user_cart` VALUES (24, NULL, 18, 18, 0, '2023-02-24 15:04:17', '2023-02-24 15:04:17');
INSERT INTO `user_cart` VALUES (25, NULL, 18, 18, 0, '2023-03-02 15:07:51', '2023-03-02 15:07:51');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_role_id` int(0) NOT NULL COMMENT '用户角色表ID',
  `user_id` bigint(0) NULL DEFAULT NULL COMMENT '用户表ID',
  `role_id` int(0) NULL DEFAULT NULL COMMENT '角色表ID',
  PRIMARY KEY (`user_role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1556169985301184514, 1);
INSERT INTO `user_role` VALUES (2, 1556169985301184514, 2);

SET FOREIGN_KEY_CHECKS = 1;
