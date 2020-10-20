-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: openlibrary
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `argitaletxea`
--

DROP TABLE IF EXISTS `argitaletxea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `argitaletxea` (
  `izena` varchar(80) NOT NULL,
  PRIMARY KEY (`izena`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `argitaletxea`
--

LOCK TABLES `argitaletxea` WRITE;
/*!40000 ALTER TABLE `argitaletxea` DISABLE KEYS */;
/*!40000 ALTER TABLE `argitaletxea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libargitaletxe`
--

DROP TABLE IF EXISTS `libargitaletxe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libargitaletxe` (
  `argitaletxea` varchar(80) NOT NULL,
  `liburua` bigint NOT NULL,
  PRIMARY KEY (`liburua`,`argitaletxea`),
  KEY `fk_argitaletxea_idx` (`argitaletxea`),
  CONSTRAINT `fk_argitaletxea` FOREIGN KEY (`argitaletxea`) REFERENCES `argitaletxea` (`izena`),
  CONSTRAINT `fk_liburua` FOREIGN KEY (`liburua`) REFERENCES `liburua` (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libargitaletxe`
--

LOCK TABLES `libargitaletxe` WRITE;
/*!40000 ALTER TABLE `libargitaletxe` DISABLE KEYS */;
/*!40000 ALTER TABLE `libargitaletxe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `liburua`
--

DROP TABLE IF EXISTS `liburua`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `liburua` (
  `isbn` bigint NOT NULL,
  `izenburua` varchar(45) DEFAULT NULL,
  `subtitulua` varchar(45) DEFAULT NULL,
  `orrikop` int DEFAULT NULL,
  `irudiIzena` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `liburua`
--

LOCK TABLES `liburua` WRITE;
/*!40000 ALTER TABLE `liburua` DISABLE KEYS */;
INSERT INTO `liburua` VALUES (1491910399,'R for Data Science',NULL,NULL,NULL),(1491946008,'Fluent Python',NULL,NULL,NULL),(1491978236,'Natural Language Processing with PyTorch',NULL,NULL,NULL),(9781491906187,'Data Algorithms',NULL,NULL,NULL),(9781491920497,'Blockchain: Blueprint for a New Economy',NULL,NULL,NULL);
/*!40000 ALTER TABLE `liburua` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'openlibrary'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-19 22:48:31
