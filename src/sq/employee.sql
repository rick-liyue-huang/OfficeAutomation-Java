use rick_oa;

-- ----------------------------
-- Table structure for adm_department
-- ----------------------------
DROP TABLE IF EXISTS `adm_department`;
CREATE TABLE `adm_department`  (
                                   `department_id` bigint(20) NOT NULL AUTO_INCREMENT,
                                   `department_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                   PRIMARY KEY (`department_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of adm_department
-- ----------------------------
INSERT INTO `adm_department` VALUES (1, 'president_office');
INSERT INTO `adm_department` VALUES (2, 'research_department');
INSERT INTO `adm_department` VALUES (3, 'market_department');

-- ----------------------------
-- Table structure for adm_employee
-- ----------------------------
DROP TABLE IF EXISTS `adm_employee`;
CREATE TABLE `adm_employee`  (
                                 `employee_id` bigint(20) NOT NULL AUTO_INCREMENT,
                                 `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                 `department_id` bigint(20) NOT NULL,
                                 `title` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                 `level` int(255) NOT NULL,
                                 PRIMARY KEY (`employee_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
-- ----------------------------
-- Records of adm_employee
-- ----------------------------
INSERT INTO `adm_employee` VALUES (1, 'Rick', 1, 'president', 8);
INSERT INTO `adm_employee` VALUES (2, 'Leo', 2, 'research_manager', 7);
INSERT INTO `adm_employee` VALUES (3, 'Claire', 2, 'advanced_research_engineer', 6);
INSERT INTO `adm_employee` VALUES (4, 'AJ', 2, 'research_engineer', 5);
INSERT INTO `adm_employee` VALUES (5, 'Mark', 2, 'junior_research_engineer', 4);
INSERT INTO `adm_employee` VALUES (6, 'Ken', 3, 'market_department_manager', 7);
INSERT INTO `adm_employee` VALUES (7, 'Gary', 3, 'customer_manager', 6);
INSERT INTO `adm_employee` VALUES (8, 'Alex', 3, 'customer_manager', 5);
INSERT INTO `adm_employee` VALUES (9, 'Steven', 3, 'customer_manager', 4);
INSERT INTO `adm_employee` VALUES (10, 'King', 3, 'junior_customer_manager', 3);