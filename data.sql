-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: internshipmanagement
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `audit_entity`
--

DROP TABLE IF EXISTS `audit_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `audit_entity` (
  `audit_id` varchar(255) NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  `evaluation_period` tinyint DEFAULT NULL,
  `mentor_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`audit_id`),
  CONSTRAINT `audit_entity_chk_1` CHECK ((`evaluation_period` between 0 and 2))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit_entity`
--

LOCK TABLES `audit_entity` WRITE;
/*!40000 ALTER TABLE `audit_entity` DISABLE KEYS */;
INSERT INTO `audit_entity` VALUES ('20241119duyvd4','2024-11-19 10:24:27.414042',1,'duyvd4');
/*!40000 ALTER TABLE `audit_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audit_intern_entity`
--

DROP TABLE IF EXISTS `audit_intern_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `audit_intern_entity` (
  `audit_intern_id` varchar(255) NOT NULL,
  `auditid` varchar(255) DEFAULT NULL,
  `ave_grade` float NOT NULL,
  `created_time` datetime(6) DEFAULT NULL,
  `intern_id` varchar(255) DEFAULT NULL,
  `result_id` varchar(255) DEFAULT NULL,
  `updated_time` datetime(6) DEFAULT NULL,
  `mentor_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`audit_intern_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit_intern_entity`
--

LOCK TABLES `audit_intern_entity` WRITE;
/*!40000 ALTER TABLE `audit_intern_entity` DISABLE KEYS */;
INSERT INTO `audit_intern_entity` VALUES ('20241119quyen','20241119duyvd4',0,'2024-11-19 10:24:34.587274','quyen','202411quyen','2024-11-19 10:24:34.587274','duyvd4'),('20241119so','20241119duyvd4',0,'2024-11-19 10:24:27.397087','so','202411so','2024-11-19 10:24:27.398090','duyvd4'),('20241119sos','20241119duyvd4',0,'2024-11-19 10:24:27.368165','sos','202411sos','2024-11-19 10:24:27.368165','duyvd4');
/*!40000 ALTER TABLE `audit_intern_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audit_participants`
--

DROP TABLE IF EXISTS `audit_participants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `audit_participants` (
  `audit_intern_id` varchar(255) NOT NULL,
  `role` tinyint DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`audit_intern_id`),
  CONSTRAINT `audit_participants_chk_1` CHECK ((`role` between 0 and 1))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit_participants`
--

LOCK TABLES `audit_participants` WRITE;
/*!40000 ALTER TABLE `audit_participants` DISABLE KEYS */;
/*!40000 ALTER TABLE `audit_participants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audit_result_entity`
--

DROP TABLE IF EXISTS `audit_result_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `audit_result_entity` (
  `result_id` varchar(255) NOT NULL,
  `ave_result` float NOT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `feedback_id` int NOT NULL,
  `intern_id` varchar(255) DEFAULT NULL,
  `mentor_id` varchar(255) DEFAULT NULL,
  `is_qualify` bit(1) NOT NULL,
  PRIMARY KEY (`result_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit_result_entity`
--

LOCK TABLES `audit_result_entity` WRITE;
/*!40000 ALTER TABLE `audit_result_entity` DISABLE KEYS */;
INSERT INTO `audit_result_entity` VALUES ('202411a1',0,'2024-11-18 13:58:00.132089',0,'a1','duyvd4',_binary '\0'),('202411aaa',0,'2024-11-18 13:58:00.151465',0,'aaa','duyvd4',_binary '\0'),('202411quyen',0,'2024-11-18 13:58:00.159045',0,'quyen','duyvd4',_binary '\0'),('202411sa',0,'2024-11-18 13:58:00.165802',0,'sa','duyvd4',_binary '\0'),('202411sa1',0,'2024-11-18 13:58:00.171423',0,'sa1','duyvd4',_binary '\0'),('202411so',0,'2024-11-18 13:58:00.178013',0,'so','duyvd4',_binary '\0'),('202411sos',0,'2024-11-18 13:58:00.184095',0,'sos','duyvd4',_binary '\0');
/*!40000 ALTER TABLE `audit_result_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `daily_report_entity`
--

DROP TABLE IF EXISTS `daily_report_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `daily_report_entity` (
  `report_id` int NOT NULL,
  `created_time` datetime(6) DEFAULT NULL,
  `intern_id` varchar(255) DEFAULT NULL,
  `is_reviewed` bit(1) NOT NULL,
  `mentor_id` varchar(255) DEFAULT NULL,
  `today` datetime(6) DEFAULT NULL,
  `todo_list` varchar(255) DEFAULT NULL,
  `updated_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`report_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `daily_report_entity`
--

LOCK TABLES `daily_report_entity` WRITE;
/*!40000 ALTER TABLE `daily_report_entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `daily_report_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback_entity`
--

DROP TABLE IF EXISTS `feedback_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback_entity` (
  `feedback_id` int NOT NULL,
  `created_time` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `intern_id` int NOT NULL,
  `mentor_id` int NOT NULL,
  `value` float NOT NULL,
  PRIMARY KEY (`feedback_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback_entity`
--

LOCK TABLES `feedback_entity` WRITE;
/*!40000 ALTER TABLE `feedback_entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade_entity`
--

DROP TABLE IF EXISTS `grade_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grade_entity` (
  `grade_id` int NOT NULL,
  `audit_intern_id` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` tinyint DEFAULT NULL,
  `value` float NOT NULL,
  PRIMARY KEY (`grade_id`),
  CONSTRAINT `grade_entity_chk_1` CHECK ((`name` between 0 and 2))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade_entity`
--

LOCK TABLES `grade_entity` WRITE;
/*!40000 ALTER TABLE `grade_entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `grade_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade_entity_seq`
--

DROP TABLE IF EXISTS `grade_entity_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grade_entity_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade_entity_seq`
--

LOCK TABLES `grade_entity_seq` WRITE;
/*!40000 ALTER TABLE `grade_entity_seq` DISABLE KEYS */;
INSERT INTO `grade_entity_seq` VALUES (1);
/*!40000 ALTER TABLE `grade_entity_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `intern_entity`
--

DROP TABLE IF EXISTS `intern_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `intern_entity` (
  `avatar` varchar(255) DEFAULT NULL,
  `join_date` date DEFAULT NULL,
  `mentor_id` varchar(255) DEFAULT NULL,
  `status` tinyint DEFAULT NULL,
  `user_id` varchar(255) NOT NULL,
  `first_pass` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `intern_entity_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_entity` (`user_id`),
  CONSTRAINT `intern_entity_chk_1` CHECK ((`status` between 0 and 2))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `intern_entity`
--

LOCK TABLES `intern_entity` WRITE;
/*!40000 ALTER TABLE `intern_entity` DISABLE KEYS */;
INSERT INTO `intern_entity` VALUES (NULL,'2024-11-18','duyvd4',NULL,'a1','6cmYE!&C'),(NULL,'2024-11-15','duyvd4',1,'aaa',NULL),(NULL,'2024-11-18','duyvd4',0,'hang','QRu6u3Tk'),(NULL,'2024-11-19','duyvd4',0,'ooo','thcqlcMb'),(NULL,'2024-11-14','duyvd4',0,'quyen','z_2@#(K%'),(NULL,'2024-11-14','duyvd4',0,'sa','sjb-NL*2'),(NULL,'2024-11-14','duyvd4',0,'sa1','fKCL4n2@'),(NULL,'2024-11-18','duyvd4',0,'so','Bztslhyr'),(NULL,'2024-11-18','duyvd4',0,'sos','l(%N+ynd');
/*!40000 ALTER TABLE `intern_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issue_entity`
--

DROP TABLE IF EXISTS `issue_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `issue_entity` (
  `issue_id` int NOT NULL,
  `issue_content` varchar(255) DEFAULT NULL,
  `report_id` int NOT NULL,
  PRIMARY KEY (`issue_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issue_entity`
--

LOCK TABLES `issue_entity` WRITE;
/*!40000 ALTER TABLE `issue_entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `issue_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issue_receiver_entity`
--

DROP TABLE IF EXISTS `issue_receiver_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `issue_receiver_entity` (
  `receiver_id` int NOT NULL,
  `issue_id` varchar(255) DEFAULT NULL,
  `reply` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`receiver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issue_receiver_entity`
--

LOCK TABLES `issue_receiver_entity` WRITE;
/*!40000 ALTER TABLE `issue_receiver_entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `issue_receiver_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mentor_entity`
--

DROP TABLE IF EXISTS `mentor_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mentor_entity` (
  `bu` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `mentor_entity_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_entity` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mentor_entity`
--

LOCK TABLES `mentor_entity` WRITE;
/*!40000 ALTER TABLE `mentor_entity` DISABLE KEYS */;
INSERT INTO `mentor_entity` VALUES ('FNH.DNA','duyvd4'),('FHN.DNA','thinhtn8');
/*!40000 ALTER TABLE `mentor_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_entity`
--

DROP TABLE IF EXISTS `role_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_entity` (
  `role_id` int NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_entity`
--

LOCK TABLES `role_entity` WRITE;
/*!40000 ALTER TABLE `role_entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_entity`
--

DROP TABLE IF EXISTS `task_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_entity` (
  `task_id` int NOT NULL,
  `completed_time` datetime(6) DEFAULT NULL,
  `created_time` datetime(6) DEFAULT NULL,
  `is_completed` bit(1) NOT NULL,
  `report_id` int NOT NULL,
  `task_content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_entity`
--

LOCK TABLES `task_entity` WRITE;
/*!40000 ALTER TABLE `task_entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_entity`
--

DROP TABLE IF EXISTS `user_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_entity` (
  `user_id` varchar(255) NOT NULL,
  `account` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `gender` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` tinyint DEFAULT NULL,
  `social_num` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `account` (`account`),
  CONSTRAINT `user_entity_chk_1` CHECK ((`role` between 0 and 1))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_entity`
--

LOCK TABLES `user_entity` WRITE;
/*!40000 ALTER TABLE `user_entity` DISABLE KEYS */;
INSERT INTO `user_entity` VALUES ('a1','a1@fpt.com',NULL,NULL,'a1',_binary '\0',NULL,NULL,1,'000001111110'),('aaa','aaa@fpt.com','Ha Noi, VN','2004-11-11','aaa',_binary '',NULL,'0123454321',1,'083773000'),('duyvd4','duyvd4@fpt.com','Ha Noi, VN','2000-01-01','Vu Duc Duy',_binary '\0','$2a$10$zxVGvaM4ZEE5xp6zRkiCFewQ2xCWxQkK3pkuTIU5zYQ.Ef7hRK8M6','0123456789',0,NULL),('hang','hang@fpt.com',NULL,NULL,'hang',_binary '\0','$2a$10$C19fHmMz/fUA//VWnllR0.fOztMbzYDCYLsMS9iFEvVOrFbV1w.vq',NULL,1,'000000000000'),('ooo','ooo@fpt.com',NULL,NULL,'ooo',_binary '\0','$2a$10$nfTZX3Z.Rc3NuQiT.VcH1O.cYOySPoQ/jLIzTJa7pj/lcuIH80UOq',NULL,1,'000000000000'),('quyen','quyen@fpt.com',NULL,NULL,'quyen',_binary '\0','$2a$10$KDIuhfYo6KCzEKMGOTL7f.LY.V0vDgkC.KlZMQSubvKqOd/J59nYS',NULL,1,'000000000000'),('sa','sa@fpt.com',NULL,NULL,'sa',_binary '',NULL,NULL,1,'000000000000'),('sa1','sa1@fpt.com','Ha Noi, VN','2003-03-03','sa',_binary '',NULL,'0123451234',1,'000000000000'),('so','so@fpt.com',NULL,NULL,'so',_binary '',NULL,NULL,1,'000001011110'),('sos','sos@fpt.com',NULL,NULL,'sos',_binary '\0','$2a$10$lT6iSNyMrXvKFOdy0BHKBuyWeVrVhCt0IpA6rCVfWQk1N7/RZe5Jm',NULL,1,'000001011110'),('thinhtn8','thinhtn8@fpt.com','Ha Noi, VN','2000-01-01','Vu Duc Duy',_binary '','$2a$10$lC79TNWhaPt0Laadxo6wkeFJHfEyKwoNvyeE54djmBMnMa9Ppf/te','1234567890',0,'000000000000');
/*!40000 ALTER TABLE `user_entity` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-20 11:23:22
