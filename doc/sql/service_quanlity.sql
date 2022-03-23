/*
 SYSTEM NAME           : customer service quality evaluation system
 Source Schema         : service_quality_evaluation
 Target Server Type    : MySQL
 Date: 23/03/2022 13:33:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer_service_record
-- ----------------------------
DROP TABLE IF EXISTS `customer_service_record`;
CREATE TABLE `customer_service_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `event_type` int(11) NOT NULL COMMENT '事件类型',
  `session_id` bigint(20) NOT NULL COMMENT '会话ID',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `connection_begin_time` datetime(0) NOT NULL COMMENT '连接开始时间',
  `connetion_end_time` datetime(0) NOT NULL COMMENT '连接结束时间',
  `from` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '呼叫网',
  `to` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '接收方',
  `user` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '客户名称',
  `category` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '资讯分类',
  `staff_id` int(11) NOT NULL COMMENT '员工id',
  `staff_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '员工姓名',
  `status` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '会话状态',
  `duration` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '通话时长',
  `evaluation` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '满意度',
  `record_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '通话录音文件地址',
  `mobile_area` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '号码归属地',
  `wait_duration` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '排队等待时长',
  `ring_ruration` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '振铃时长',
  `sessionId_from` bigint(20) NOT NULL COMMENT '转接的上一通会话ID',
  `day` date NOT NULL COMMENT '日期(冗余 - 客服结束时间的日期)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '客户服务记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for keyword_check_record
-- ----------------------------
DROP TABLE IF EXISTS `keyword_check_record`;
CREATE TABLE `keyword_check_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `service_record_id` bigint(20) NOT NULL COMMENT '冗余客服记录的ID',
  `result_id` bigint(20) NOT NULL COMMENT '语句记录ID',
  `check_time` datetime(0) NOT NULL COMMENT '检查时间',
  `check_list` json NOT NULL COMMENT '检查列表（关键词，结果语句位置...）',
  `day` date NOT NULL COMMENT '日期(冗余 - 客服结束时间的日期)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `service_record_id`(`service_record_id`) USING BTREE,
  INDEX `result_id`(`result_id`) USING BTREE,
  CONSTRAINT `keyword_check_record_ibfk_1` FOREIGN KEY (`service_record_id`) REFERENCES `customer_service_record` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `keyword_check_record_ibfk_2` FOREIGN KEY (`result_id`) REFERENCES `sentence_result` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '关键词检查记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for keyword_map
-- ----------------------------
DROP TABLE IF EXISTS `keyword_map`;
CREATE TABLE `keyword_map`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典ID',
  `keyword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '关键词',
  `type` int(11) NOT NULL COMMENT '关键词分类（1. 敏感词 ）',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '关键词字典' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sentence_result
-- ----------------------------
DROP TABLE IF EXISTS `sentence_result`;
CREATE TABLE `sentence_result`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `service_record_id` bigint(20) NOT NULL COMMENT '冗余客服记录的ID',
  `task_id` bigint(20) NOT NULL COMMENT '任务ID',
  `request_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '请求ID',
  `sentences` json NOT NULL COMMENT '识别的结果数据',
  `words` json NULL COMMENT '词信息',
  `biz_duration` bigint(20) NOT NULL COMMENT '识别音频总时长（毫秒）',
  `day` date NOT NULL COMMENT '日期(冗余 - 客服结束时间的日期)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `service_record_id`(`service_record_id`) USING BTREE,
  INDEX `task_id`(`task_id`) USING BTREE,
  CONSTRAINT `sentence_result_ibfk_1` FOREIGN KEY (`service_record_id`) REFERENCES `customer_service_record` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sentence_result_ibfk_2` FOREIGN KEY (`task_id`) REFERENCES `sound_to_text_task` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '语句识别结果' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sound_to_text_task
-- ----------------------------
DROP TABLE IF EXISTS `sound_to_text_task`;
CREATE TABLE `sound_to_text_task`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `service_record_id` bigint(20) NOT NULL COMMENT '冗余客服记录的ID',
  `task_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务ID',
  `request_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '请求ID',
  `status_code` int(255) NOT NULL COMMENT '状态码',
  `status_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '状态说明',
  `day` date NOT NULL COMMENT '日期(冗余 - 客服结束时间的日期)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `service_record_id`(`service_record_id`) USING BTREE,
  CONSTRAINT `sound_to_text_task_ibfk_1` FOREIGN KEY (`service_record_id`) REFERENCES `customer_service_record` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '语音识别任务表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
