-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: db_tienda
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `roles_usuario`
--

DROP TABLE IF EXISTS `roles_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles_usuario` (
  `id_user` int NOT NULL,
  `id_rol` int NOT NULL,
  PRIMARY KEY (`id_user`,`id_rol`),
  KEY `FKiey8af0dameup76s9k9erv7xd` (`id_rol`),
  CONSTRAINT `FK6rlvyxwhpjcd8e0y65jy4bukl` FOREIGN KEY (`id_user`) REFERENCES `tab_usuarios` (`id_usuario`),
  CONSTRAINT `FKiey8af0dameup76s9k9erv7xd` FOREIGN KEY (`id_rol`) REFERENCES `tab_cargos` (`id_cargo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles_usuario`
--

LOCK TABLES `roles_usuario` WRITE;
/*!40000 ALTER TABLE `roles_usuario` DISABLE KEYS */;
INSERT INTO `roles_usuario` VALUES (1,1),(7,1),(1,2),(2,2),(7,2);
/*!40000 ALTER TABLE `roles_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_cargos`
--

DROP TABLE IF EXISTS `tab_cargos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_cargos` (
  `id_cargo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_cargos`
--

LOCK TABLES `tab_cargos` WRITE;
/*!40000 ALTER TABLE `tab_cargos` DISABLE KEYS */;
INSERT INTO `tab_cargos` VALUES (1,'ROLE_ADMIN',''),(2,'ROLE_USER','');
/*!40000 ALTER TABLE `tab_cargos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_factura`
--

DROP TABLE IF EXISTS `tab_factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_factura` (
  `id_factura` int NOT NULL AUTO_INCREMENT,
  `NumFactura` int DEFAULT NULL,
  `fk_usuario` int DEFAULT NULL,
  `CodProducto` varchar(45) NOT NULL,
  `cantidad` int DEFAULT NULL,
  `PrecioVenta` double NOT NULL,
  `NomProducto` varchar(45) NOT NULL,
  `IdVenta` int DEFAULT NULL,
  PRIMARY KEY (`id_factura`),
  KEY `IVenta_idx` (`IdVenta`),
  CONSTRAINT `IVenta` FOREIGN KEY (`IdVenta`) REFERENCES `tab_ventas` (`IdVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_factura`
--

LOCK TABLES `tab_factura` WRITE;
/*!40000 ALTER TABLE `tab_factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_productos`
--

DROP TABLE IF EXISTS `tab_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_productos` (
  `id_producto` int NOT NULL AUTO_INCREMENT,
  `Existencia` int NOT NULL,
  `fk_tipo_producto` int DEFAULT NULL,
  `cod_producto` varchar(255) DEFAULT NULL,
  `nombre_producto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `fk_tipo_producto` (`fk_tipo_producto`),
  CONSTRAINT `tab_productos_ibfk_1` FOREIGN KEY (`fk_tipo_producto`) REFERENCES `tab_tipoproducto` (`id_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_productos`
--

LOCK TABLES `tab_productos` WRITE;
/*!40000 ALTER TABLE `tab_productos` DISABLE KEYS */;
INSERT INTO `tab_productos` VALUES (1,2,1,'d31','Coca-Cola'),(4,10,1,'d32','Palomitas'),(7,10,1,'d32','Zambos'),(8,5,1,'d52','Cocopina'),(9,8,1,'d34','chiquipan');
/*!40000 ALTER TABLE `tab_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_tipoproducto`
--

DROP TABLE IF EXISTS `tab_tipoproducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_tipoproducto` (
  `id_tipo` int NOT NULL AUTO_INCREMENT,
  `tipo_producto` varchar(100) NOT NULL,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_tipoproducto`
--

LOCK TABLES `tab_tipoproducto` WRITE;
/*!40000 ALTER TABLE `tab_tipoproducto` DISABLE KEYS */;
INSERT INTO `tab_tipoproducto` VALUES (1,'Bebida');
/*!40000 ALTER TABLE `tab_tipoproducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_usuarios`
--

DROP TABLE IF EXISTS `tab_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_usuarios` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(100) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `fecha_creacion` varchar(255) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `fk_cargo` int DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_usuarios`
--

LOCK TABLES `tab_usuarios` WRITE;
/*!40000 ALTER TABLE `tab_usuarios` DISABLE KEYS */;
INSERT INTO `tab_usuarios` VALUES (1,'Marvin','Henriquez','ss',NULL,'s','admin','$2a$04$ad7M.uOCb/FMXBqCXNKtEuwUKM/Qzy90Cqy2dfusXgLb.D36FnN7m',1,NULL),(2,'Afedito','Torres','dd',NULL,'d','user','$2a$04$pwNABxxuWOPVqNhhUXjsRe/3rzm.P8XsYSGx.GiiUmyQv/ILJNtiK',1,NULL),(3,'Verito','Rodriguez','s','now()','s','js','$04$pwNABxxuWOPVqNhhUXjsRe/3rzm.P8XsYSGx.GiiUmyQv/ILJNtiK',1,NULL),(7,'Silvia','Lopez','SilviaLopez@tuOsita.soymia',NULL,'ss','OsitaLopez','$2a$04$z1vyAfYnRUAhAp6jeKVaVOh2INdJFLiifwB4Cpk9y5L.fhzFT8phG',0,NULL);
/*!40000 ALTER TABLE `tab_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_ventas`
--

DROP TABLE IF EXISTS `tab_ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_ventas` (
  `IdVenta` int NOT NULL AUTO_INCREMENT,
  `FechaVenta` datetime DEFAULT NULL,
  `CodigoProducto` double DEFAULT NULL,
  `fk_producto` int DEFAULT NULL,
  PRIMARY KEY (`IdVenta`),
  KEY `fk_producto` (`fk_producto`),
  CONSTRAINT `tab_ventas_ibfk_1` FOREIGN KEY (`fk_producto`) REFERENCES `tab_productos` (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_ventas`
--

LOCK TABLES `tab_ventas` WRITE;
/*!40000 ALTER TABLE `tab_ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-22 12:05:08
