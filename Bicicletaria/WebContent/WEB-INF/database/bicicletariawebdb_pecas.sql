CREATE DATABASE  IF NOT EXISTS `bicicletariawebdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bicicletariawebdb`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: bicicletariawebdb
-- ------------------------------------------------------
-- Server version	5.6.12-log

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
-- Table structure for table `pecas`
--

DROP TABLE IF EXISTS `pecas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pecas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` longtext,
  `imagem` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `valor` double NOT NULL,
  `marca_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_kyxs8cywypd5fklfr04x42mgp` (`marca_id`),
  CONSTRAINT `FK_kyxs8cywypd5fklfr04x42mgp` FOREIGN KEY (`marca_id`) REFERENCES `marcas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pecas`
--

LOCK TABLES `pecas` WRITE;
/*!40000 ALTER TABLE `pecas` DISABLE KEYS */;
INSERT INTO `pecas` VALUES (1,'banco confortável, boa qualidade....','aa22934e-7246-47f9-a961-3af3593f3a58.jpg','Banco',40,3),(2,'Banco em promoçao, bicicletas de todo tipo','9a183eaf-f728-419c-a9b8-390213e11755.jpg','Banco Caloi',35,1),(3,'Banco confortável, boa aparência e de qualidade ','e5de005b-b497-45cd-88a4-9c9106eace36.jpg','Banco',45,3),(4,'uma baita','c76fb7f4-4b92-42c3-b059-507a415b6c53.jpg','Bicicleta Sundown',800,2),(5,'sem comentario','eacea2e4-14a5-49e3-bb6f-83abc900d38c.jpg','pedal cor preta',25,2),(6,'nada','454a94fc-6813-48d7-be38-61a0393c113d.jpg','Pedal',30,3);
/*!40000 ALTER TABLE `pecas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-07-01 19:42:13
