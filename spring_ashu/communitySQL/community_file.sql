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
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file` (
  `fi_num` int NOT NULL AUTO_INCREMENT,
  `fi_ori_name` varchar(255) DEFAULT NULL,
  `fi_name` varchar(255) DEFAULT NULL,
  `fi_bd_num` int NOT NULL,
  `fi_del` varchar(2) DEFAULT NULL,
  `fi_del_date` datetime DEFAULT NULL,
  PRIMARY KEY (`fi_num`),
  KEY `FK_board_TO_file_1` (`fi_bd_num`),
  CONSTRAINT `FK_board_TO_file_1` FOREIGN KEY (`fi_bd_num`) REFERENCES `board` (`bd_num`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (1,'balloon01.jpg','/2022/01/17/fd28084f-f3c4-4a3b-ac66-96cf43035e5f_balloon01.jpg',9,'Y','2022-01-18 09:28:51'),(2,'balloon02.jpg','/2022/01/17/b6fd6bbe-c739-4846-a758-289af71720a1_balloon02.jpg',9,NULL,NULL),(3,'balloon01.jpg','/2022/01/18/874f2058-82cc-43a5-b570-6c641534269f_balloon01.jpg',13,NULL,NULL),(4,'Samsung_wallpaper2.jpg','/2022/01/18/d5d908d0-8391-4cae-8a1c-f304c1989ad1_Samsung_wallpaper2.jpg',15,'Y','2022-01-19 10:39:14'),(5,'Samsung_wallpaper2.jpg','/2022/01/18/10eb4fa4-415e-4960-b4db-54b51725dd0c_Samsung_wallpaper2.jpg',17,NULL,NULL),(6,'Samsung_wallpaper_21.jpg','/2022/01/18/b0d48a45-d618-45f9-90b7-303a878f95e8_Samsung_wallpaper_21.jpg',18,NULL,NULL),(7,'Samsung_wallpaper2.jpg','/2022/01/19/2fd4b8ca-228d-4e0e-923f-62ecd282aede_Samsung_wallpaper2.jpg',22,NULL,NULL),(8,'Samsung_wallpaper11.jpg','/2022/01/21/b6960da3-95e6-4bf0-bf62-4a6eaca805cf_Samsung_wallpaper11.jpg',23,NULL,NULL);
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
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
