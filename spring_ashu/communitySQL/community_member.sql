-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: community
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `me_id` varchar(20) NOT NULL,
  `me_pw` varchar(250) DEFAULT NULL,
  `me_name` varchar(30) DEFAULT NULL,
  `me_gender` varchar(6) DEFAULT NULL,
  `me_birth` date DEFAULT NULL,
  `me_address` varchar(100) DEFAULT NULL,
  `me_phone` varchar(13) DEFAULT NULL,
  `me_authority` varchar(10) NOT NULL DEFAULT '회원',
  PRIMARY KEY (`me_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('ashu12','$2a$10$EMgn3b.cHzfTriRUqCh9nuLPqW4RZ.IZoMPfQGmZemLTdQXIhMY9O','ashu','여성','2021-12-01','충북 청주시 서원구 신성화로 8 306동 601호','010-5688-6275','슈퍼 관리자 '),('Casey','$2a$10$0j5Icstc6jsPGrDYUmKzI.zz0/RALOgKTcqUUqA6Q3nFYsh/.MOn.','Casey','남성','1984-06-13','충북 청주시 서원구 신성화로 8 306동 601호','010-5688-6275','회원'),('Lami','$2a$10$9xQ.H61uqoRKZNSWTSQThu74x/Rf3hnOd8IoVYWGiLfP3RDapk70K','Hyma','여성','2021-06-18','충북 청주시 서원구 신성화로 8 306동 601호','010-5688-6275','관리자'),('Prax','$2a$10$5SXdBsC9Lh/yWERCcprdAe3hBNQY6IuHNULwfRFxv8rVFLBbENQde','Hyma','남성','2022-03-28','충북 청주시 서원구 신성화로 8 306동 601호','010-5688-6275','회원');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-21 17:23:32
