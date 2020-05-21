CREATE DATABASE  IF NOT EXISTS `zona_mysql` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `zona_mysql`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: zona_mysql
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrador` (
  `idadministrador` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  `anombre` varchar(65) NOT NULL,
  `cedula` int NOT NULL,
  `telefono` int NOT NULL,
  `rol` varchar(45) NOT NULL,
  PRIMARY KEY (`idadministrador`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (1,'admin','admin','felipe',123456,987632,'SAdmin'),(2,'admin','admin','ermes',10869547,7921152,'Administrador');
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuota`
--

DROP TABLE IF EXISTS `cuota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuota` (
  `idcuota` int NOT NULL,
  `porcentage` double DEFAULT NULL,
  `precio` varchar(45) DEFAULT NULL,
  `persona_idpersona` int DEFAULT NULL,
  PRIMARY KEY (`idcuota`),
  KEY `fk_cuota_persona_idx` (`persona_idpersona`),
  CONSTRAINT `fk_cuota_persona` FOREIGN KEY (`persona_idpersona`) REFERENCES `persona` (`idpersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuota`
--

LOCK TABLES `cuota` WRITE;
/*!40000 ALTER TABLE `cuota` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fecha_visita`
--

DROP TABLE IF EXISTS `fecha_visita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fecha_visita` (
  `idfecha_visita` int DEFAULT NULL,
  `fecha_inicio` varchar(45) DEFAULT NULL,
  `fecha_final` varchar(45) DEFAULT NULL,
  `persona_idpersona` int DEFAULT NULL,
  UNIQUE KEY `cuota_UNIQUE` (`idfecha_visita`),
  KEY `fk_fecha_visita_persona1_idx` (`persona_idpersona`),
  CONSTRAINT `fk_fecha_visita_persona1` FOREIGN KEY (`persona_idpersona`) REFERENCES `persona` (`idpersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fecha_visita`
--

LOCK TABLES `fecha_visita` WRITE;
/*!40000 ALTER TABLE `fecha_visita` DISABLE KEYS */;
/*!40000 ALTER TABLE `fecha_visita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parqueadero`
--

DROP TABLE IF EXISTS `parqueadero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parqueadero` (
  `idparqueadero` int NOT NULL AUTO_INCREMENT,
  `referencia` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idparqueadero`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parqueadero`
--

LOCK TABLES `parqueadero` WRITE;
/*!40000 ALTER TABLE `parqueadero` DISABLE KEYS */;
INSERT INTO `parqueadero` VALUES (1,'12'),(2,'1'),(3,'1a');
/*!40000 ALTER TABLE `parqueadero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `idpersona` int NOT NULL AUTO_INCREMENT,
  `pnombre` varchar(65) DEFAULT NULL,
  `pcedula` varchar(45) DEFAULT NULL,
  `ptelefono` varchar(45) DEFAULT NULL,
  `prol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpersona`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'daniela','8888','77777','residente');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vivienda`
--

DROP TABLE IF EXISTS `vivienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vivienda` (
  `idvivienda` int NOT NULL AUTO_INCREMENT,
  `vrol` varchar(45) DEFAULT NULL,
  `vnombre` varchar(45) DEFAULT NULL,
  `vpiso` int DEFAULT NULL,
  `vbloque` varchar(45) DEFAULT NULL,
  `persona_idpersona` int DEFAULT NULL,
  `parqueadero_idparqueadero` int DEFAULT NULL,
  `zonaresidencial_idzonaresidencial` int DEFAULT NULL,
  PRIMARY KEY (`idvivienda`),
  KEY `fk_vivienda_persona1_idx` (`persona_idpersona`),
  KEY `fk_vivienda_parqueadero1_idx` (`parqueadero_idparqueadero`),
  KEY `fk_vivienda_zonaresidencial1_idx` (`zonaresidencial_idzonaresidencial`),
  CONSTRAINT `fk_vivienda_parqueadero1` FOREIGN KEY (`parqueadero_idparqueadero`) REFERENCES `parqueadero` (`idparqueadero`),
  CONSTRAINT `fk_vivienda_persona1` FOREIGN KEY (`persona_idpersona`) REFERENCES `persona` (`idpersona`),
  CONSTRAINT `fk_vivienda_zonaresidencial1` FOREIGN KEY (`zonaresidencial_idzonaresidencial`) REFERENCES `zonaresidencial` (`idzonaresidencial`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vivienda`
--

LOCK TABLES `vivienda` WRITE;
/*!40000 ALTER TABLE `vivienda` DISABLE KEYS */;
INSERT INTO `vivienda` VALUES (1,'casa','405',NULL,NULL,NULL,NULL,NULL),(2,'apartamento',NULL,3,'2',NULL,NULL,NULL),(3,'apartamento',NULL,3,'08',NULL,NULL,NULL),(4,'apartamento',NULL,3,'202',NULL,NULL,NULL),(5,'apartamento','505',3,'12',NULL,NULL,NULL),(6,'casa','102',0,'null',NULL,NULL,NULL);
/*!40000 ALTER TABLE `vivienda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zonaresidencial`
--

DROP TABLE IF EXISTS `zonaresidencial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zonaresidencial` (
  `idzonaresidencial` int NOT NULL AUTO_INCREMENT,
  `direccion` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idzonaresidencial`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zonaresidencial`
--

LOCK TABLES `zonaresidencial` WRITE;
/*!40000 ALTER TABLE `zonaresidencial` DISABLE KEYS */;
INSERT INTO `zonaresidencial` VALUES (1,'@donnovan','mi zona resisdencial');
/*!40000 ALTER TABLE `zonaresidencial` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-21 16:14:59
