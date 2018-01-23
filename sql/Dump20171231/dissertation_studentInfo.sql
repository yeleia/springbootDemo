-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: dissertation
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.17.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `studentInfo`
--

DROP TABLE IF EXISTS `studentInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studentInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menitorId` int(11) NOT NULL,
  `studentLogin` char(45) NOT NULL,
  `loginPass` char(45) NOT NULL,
  `studentName` char(45) DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `campus` char(45) DEFAULT NULL COMMENT '校区',
  `departmentRoom` char(45) DEFAULT NULL COMMENT '系室',
  `major` char(45) DEFAULT NULL COMMENT '专业',
  `qq` char(11) DEFAULT NULL COMMENT 'qq',
  `email` char(45) DEFAULT NULL COMMENT 'email',
  `tele` char(45) DEFAULT NULL COMMENT '联系号码',
  `studentImage` varchar(45) DEFAULT NULL,
  `paperId` int(11) DEFAULT NULL,
  `projectId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentInfo`
--

LOCK TABLES `studentInfo` WRITE;
/*!40000 ALTER TABLE `studentInfo` DISABLE KEYS */;
INSERT INTO `studentInfo` VALUES (1,1,'test','w4n7H18im8oMba0K881Jmg==','叶磊','女','雅安','信息工程学院','计算机科学与技术（教育）','2406865312','2406865312@qq.com','909090900','1513650452882.png',NULL,9),(2,1,'20158617','uXdt2Xjrue4Mba0K881Jmg==','周丹',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1513650452882.png',NULL,10),(3,1,'yyy','Pyvns4fkn+M=','yyy',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'222.jpg',NULL,NULL);
/*!40000 ALTER TABLE `studentInfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-31 19:20:18
