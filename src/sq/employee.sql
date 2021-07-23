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
INSERT INTO `adm_department` VALUES (2, 'search_department');
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
INSERT INTO `adm_employee` VALUES (2, 'Leo', 2, 'Manager', 7);
INSERT INTO `adm_employee` VALUES (3, 'Claire', 2, 'Advanced Engineer', 6);
INSERT INTO `adm_employee` VALUES (4, 'AJ', 2, 'Engineer', 5);
INSERT INTO `adm_employee` VALUES (5, 'Mark', 2, 'Junior Engineer', 4);
INSERT INTO `adm_employee` VALUES (6, 'Ken', 3, 'Manager', 7);
INSERT INTO `adm_employee` VALUES (7, 'Gary', 3, 'Manager', 6);
INSERT INTO `adm_employee` VALUES (8, 'Alex', 3, 'Manager', 5);
INSERT INTO `adm_employee` VALUES (9, 'Steven', 3, 'Manager', 4);
INSERT INTO `adm_employee` VALUES (10, 'King', 3, 'junior Manager', 3);