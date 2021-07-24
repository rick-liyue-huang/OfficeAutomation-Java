-- ----------------------------
-- Table structure for adm_leave_form
-- ----------------------------
DROP TABLE IF EXISTS `adm_vacation_form`;
CREATE TABLE `adm_vacation_form`  (
                                   `form_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'form id',
                                   `employee_id` bigint(20) NOT NULL COMMENT 'employee id',
                                   `form_type` int(255) NOT NULL COMMENT 'vacation type including: 1-6 types',
                                   `start_time` datetime(0) NOT NULL COMMENT 'vacation start time',
                                   `end_time` datetime(0) NOT NULL COMMENT 'vacation end time',
                                   `reason` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'vacation reason',
                                   `create_time` datetime(0) NOT NULL COMMENT 'form create time',
                                   `state` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'vacation audition condition: processing, approved, refused',
                                   PRIMARY KEY (`form_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for adm_process_flow
-- ----------------------------
DROP TABLE IF EXISTS `adm_process_flow`;
CREATE TABLE `adm_process_flow`  (
                                     `process_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'vacation task id',
                                     `form_id` bigint(20) NOT NULL COMMENT 'form id',
                                     `operator_id` bigint(20) NOT NULL COMMENT 'operator id',
                                     `action` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'action type: apply, audit',
                                     `result` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'result type: approved, refused',
                                     `reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'result comments',
                                     `create_time` datetime(0) NOT NULL COMMENT 'form create time',
                                     `audit_time` datetime(0) NULL DEFAULT NULL COMMENT 'audit time',
                                     `order_no` int(11) NOT NULL COMMENT 'order number',
                                     `state` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'vacation audition state: ready, process, complete, cancel',
                                     `is_last` int(255) NOT NULL COMMENT 'audit to last: 0-no 1-yes',
                                     PRIMARY KEY (`process_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 96 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
                               `notice_id` bigint(20) NOT NULL AUTO_INCREMENT,
                               `receiver_id` bigint(20) NOT NULL,
                               `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                               `create_time` datetime(0) NOT NULL,
                               PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;