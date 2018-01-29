-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: pwi
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `attribute_details`
--

DROP TABLE IF EXISTS `attribute_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attribute_details` (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `attr_id` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`detail_id`),
  KEY `attr_id_idx` (`attr_id`),
  CONSTRAINT `attr_id` FOREIGN KEY (`attr_id`) REFERENCES `attributes` (`attr_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attribute_details`
--

LOCK TABLES `attribute_details` WRITE;
/*!40000 ALTER TABLE `attribute_details` DISABLE KEYS */;
INSERT INTO `attribute_details` VALUES (1,1,'small'),(2,1,'Medium'),(3,1,'Large');
/*!40000 ALTER TABLE `attribute_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attributes`
--

DROP TABLE IF EXISTS `attributes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attributes` (
  `attr_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`attr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attributes`
--

LOCK TABLES `attributes` WRITE;
/*!40000 ALTER TABLE `attributes` DISABLE KEYS */;
INSERT INTO `attributes` VALUES (1,'Size');
/*!40000 ALTER TABLE `attributes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(45) NOT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'USA'),(2,'Ireland'),(3,'Netherlands'),(4,'UAE'),(5,'Australia'),(6,'Pakistan');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `family_of_brands`
--

DROP TABLE IF EXISTS `family_of_brands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `family_of_brands` (
  `brand_id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(45) DEFAULT NULL,
  `brand_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `family_of_brands`
--

LOCK TABLES `family_of_brands` WRITE;
/*!40000 ALTER TABLE `family_of_brands` DISABLE KEYS */;
INSERT INTO `family_of_brands` VALUES (1,'Brand1','FOB1'),(2,'Brand2','FOB2');
/*!40000 ALTER TABLE `family_of_brands` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `minimum_order_quantity` int(11) DEFAULT NULL,
  `quantity_per_box` int(11) DEFAULT NULL,
  `reorder_point` int(11) DEFAULT NULL,
  `is_deleted` int(11) DEFAULT '0',
  PRIMARY KEY (`product_id`),
  KEY `brand_id_idx` (`brand_id`),
  KEY `type_id_idx` (`type_id`),
  CONSTRAINT `brand_id` FOREIGN KEY (`brand_id`) REFERENCES `family_of_brands` (`brand_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `type_id` FOREIGN KEY (`type_id`) REFERENCES `product_type` (`type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,1,1,'Nike shoes',100,2,30,0),(2,1,1,'Shirt',100,2,30,0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_attributes`
--

DROP TABLE IF EXISTS `product_attributes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_attributes` (
  `product_attr_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `detail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_attr_id`),
  KEY `product_id_idx` (`product_id`),
  KEY `detail_id_idx` (`detail_id`),
  CONSTRAINT `detail_id` FOREIGN KEY (`detail_id`) REFERENCES `attribute_details` (`detail_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_attributes`
--

LOCK TABLES `product_attributes` WRITE;
/*!40000 ALTER TABLE `product_attributes` DISABLE KEYS */;
INSERT INTO `product_attributes` VALUES (1,1,1),(2,1,2),(3,1,3);
/*!40000 ALTER TABLE `product_attributes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_type`
--

DROP TABLE IF EXISTS `product_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_type`
--

LOCK TABLES `product_type` WRITE;
/*!40000 ALTER TABLE `product_type` DISABLE KEYS */;
INSERT INTO `product_type` VALUES (1,'Finished Product'),(2,'Component'),(3,'Packaging Material');
/*!40000 ALTER TABLE `product_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_warehouses`
--

DROP TABLE IF EXISTS `product_warehouses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_warehouses` (
  `product_warehouse_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_attr_id` int(11) DEFAULT NULL,
  `warehouse_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_warehouse_id`),
  KEY `product_attr_id_idx` (`product_attr_id`),
  KEY `warehouse_id_idx` (`warehouse_id`),
  CONSTRAINT `product_attr_id` FOREIGN KEY (`product_attr_id`) REFERENCES `product_attributes` (`product_attr_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `warehouse_id` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`warehouse_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_warehouses`
--

LOCK TABLES `product_warehouses` WRITE;
/*!40000 ALTER TABLE `product_warehouses` DISABLE KEYS */;
INSERT INTO `product_warehouses` VALUES (1,1,1),(2,2,1),(3,3,1),(4,1,2),(5,2,2),(6,3,2),(7,1,3),(8,2,3),(9,3,3),(10,1,6),(11,2,6),(12,3,6),(13,1,8),(14,2,8),(15,3,8);
/*!40000 ALTER TABLE `product_warehouses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_summary`
--

DROP TABLE IF EXISTS `stock_summary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock_summary` (
  `summary_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_warehouse_id` int(11) DEFAULT NULL,
  `in_stock` int(11) DEFAULT NULL,
  `available_quantity` int(11) DEFAULT NULL,
  `in_transit` int(11) DEFAULT NULL,
  PRIMARY KEY (`summary_id`),
  KEY `product_warehouse_id_idx` (`product_warehouse_id`),
  CONSTRAINT `product_warehouse_id` FOREIGN KEY (`product_warehouse_id`) REFERENCES `product_warehouses` (`product_warehouse_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_summary`
--

LOCK TABLES `stock_summary` WRITE;
/*!40000 ALTER TABLE `stock_summary` DISABLE KEYS */;
INSERT INTO `stock_summary` VALUES (1,1,50,120,20),(2,2,45,125,15),(3,3,65,130,25),(4,13,75,50,20),(5,14,35,45,20),(6,15,70,65,35);
/*!40000 ALTER TABLE `stock_summary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouse`
--

DROP TABLE IF EXISTS `warehouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `warehouse` (
  `warehouse_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_id` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `is_deleted` int(11) DEFAULT '0',
  PRIMARY KEY (`warehouse_id`),
  KEY `country_id_idx` (`country_id`),
  CONSTRAINT `country_id` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouse`
--

LOCK TABLES `warehouse` WRITE;
/*!40000 ALTER TABLE `warehouse` DISABLE KEYS */;
INSERT INTO `warehouse` VALUES (1,1,'USA1','Log Angles, USA',1),(2,1,'USA2','Dallas, USA',0),(3,1,'USA3','Houston, USA',0),(4,2,'IRL1','Dublin,Ireland',0),(5,2,'IRL2','Cork,Ireland',0),(6,4,'UAE1','Dubai, UAE',0),(7,4,'UAE2','Abu Dhabi, UAE',0),(8,6,'PAK1','Karachi, Pakistan',0),(9,6,'PAK2','Islamabad, Pakistan',0),(10,6,'PAK3','Lahore, Pakistan',1),(16,1,'USA1','Los Angeles 2, USA',0);
/*!40000 ALTER TABLE `warehouse` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-29 20:54:14
