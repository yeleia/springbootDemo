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
-- Table structure for table `menitor`
--

DROP TABLE IF EXISTS `menitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menitor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginName` char(45) NOT NULL,
  `loginPass` char(45) NOT NULL,
  `menitorName` char(45) DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `campus` char(45) DEFAULT NULL COMMENT '校区',
  `department` char(45) DEFAULT NULL COMMENT '所在部门',
  `education` char(45) DEFAULT NULL COMMENT '学位',
  `officePhone` char(11) DEFAULT NULL COMMENT '办公电话',
  `priovatePhone` char(11) DEFAULT NULL COMMENT '移动电话',
  `officeAdress` char(45) DEFAULT NULL COMMENT '办公地址',
  `qq` char(45) DEFAULT NULL COMMENT 'qq',
  `email` char(45) DEFAULT NULL COMMENT 'email',
  `course` char(255) DEFAULT NULL COMMENT '承担课程',
  `research` char(255) DEFAULT NULL COMMENT '研究方向',
  `menitorimage` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menitor`
--

LOCK TABLES `menitor` WRITE;
/*!40000 ALTER TABLE `menitor` DISABLE KEYS */;
INSERT INTO `menitor` VALUES (1,'yl','Pr6rUWf+PF8=','test','女','','','本科','','','','2123412','45646','网络','test1','1513650475227.jpg');
/*!40000 ALTER TABLE `menitor` ENABLE KEYS */;
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
