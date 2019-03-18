-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: san_bong
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `banner_pair`
--

DROP TABLE IF EXISTS `banner_pair`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `banner_pair` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_customer` int(10) unsigned DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `banner_pair_id_customer_index` (`id_customer`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banner_pair`
--

LOCK TABLES `banner_pair` WRITE;
/*!40000 ALTER TABLE `banner_pair` DISABLE KEYS */;
INSERT INTO `banner_pair` VALUES (1,1,'2019-01-01 01:01:00','2020-07-05 12:00:00','NO','2018-12-31 18:01:00','2018-12-31 18:01:00'),(2,2,'2018-07-09 22:32:00','2020-07-09 22:32:00','NO','2018-07-09 15:32:00','2018-07-09 15:32:00'),(3,3,'2017-09-09 12:35:00','2019-09-09 12:35:00','NO','2017-09-09 05:35:00','2017-09-09 05:35:00'),(4,4,'2019-01-01 01:01:00','2021-01-01 01:01:00','NO','2018-12-31 18:01:00','2018-12-31 18:01:00'),(5,5,'2018-11-05 23:38:24','2020-11-05 23:38:24','NO','2018-11-05 16:38:24','2018-11-05 16:38:24'),(6,6,'2018-03-04 23:12:00','2020-03-04 23:12:00','NO','2018-03-04 16:12:00','2018-03-04 16:12:00'),(7,7,'2019-01-01 01:01:00','2021-01-01 01:01:00','NO','2018-12-31 18:01:00','2018-12-31 18:01:00'),(8,8,'2017-05-06 23:00:00','2019-05-06 23:00:00','NO','2017-05-06 16:00:00','2017-05-06 16:00:00'),(9,9,'2017-06-05 16:34:03','2019-06-05 16:34:03',NULL,'2017-06-05 09:34:03','2017-06-05 09:34:03'),(10,10,'2017-05-06 23:00:00','2019-05-06 23:00:00',NULL,'2017-05-06 16:00:00','2017-05-06 16:00:00');
/*!40000 ALTER TABLE `banner_pair` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banner_reserve`
--

DROP TABLE IF EXISTS `banner_reserve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `banner_reserve` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_owner` int(10) unsigned DEFAULT NULL,
  `id_customer` int(10) unsigned DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `banner_reserve_id_owner_index` (`id_owner`),
  KEY `banner_reserve_id_customer_index` (`id_customer`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banner_reserve`
--

LOCK TABLES `banner_reserve` WRITE;
/*!40000 ALTER TABLE `banner_reserve` DISABLE KEYS */;
INSERT INTO `banner_reserve` VALUES (1,1,1,'Hủy kèo đột ngột','2018-02-20 10:00:00','2018-02-20 10:00:00'),(2,2,2,'phát gôn bậy','2018-02-20 10:00:00','2018-02-20 10:00:00'),(3,3,3,'Xúc phạm người khác','2018-02-20 10:00:00','2018-02-20 10:00:00'),(4,3,2,'Spam','2018-02-20 10:00:00','2018-02-20 10:00:00'),(5,4,5,'Nói bậy','2018-02-20 10:00:00','2018-02-20 10:00:00'),(6,7,6,'Không Fairplay','2018-02-20 10:00:00','2018-02-20 10:00:00'),(7,1,8,'Lăng mạ người khác','2019-01-20 12:00:00','2019-01-20 12:00:00'),(8,5,9,'Thiếu chuyên nghiệp','2019-01-20 12:00:00','2019-01-20 12:00:00');
/*!40000 ALTER TABLE `banner_reserve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `team_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `star` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `is_block` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'NO',
  `is_delete` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'NO',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `count_reserve` double DEFAULT NULL,
  `count_cancel` double DEFAULT NULL,
  `verify` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `remember_token` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Đức Trung','0919027444','QTPRO','1','3','0','0','tuananh123',3,0,'OK',NULL,'2018-12-31 18:01:00','2018-12-31 18:01:00'),(2,'Anh Minh','0932222333','Hung FC','3','3','0','0','hungdung',5,1,'OK',NULL,'2018-07-09 15:32:00','2018-07-09 15:32:00'),(3,'Đức anh','0988888888','Đức Anh FC','6','7','0','0','ducanh123',12,0,'OK',NULL,'2017-09-09 05:35:00','2017-09-09 05:35:00'),(4,'Thanh Tú','0979000000','Hoàng Thám FC','2','7','1','0','thanhviet123',2,0,'OK',NULL,'2018-12-31 18:01:00','2018-12-31 18:01:00'),(5,'Anh Đức','097958585','Đức FC','1','1','1','0','anhduc',4,1,'OK',NULL,'2018-11-05 16:38:24','2018-11-05 16:38:24'),(6,'Hoàng Dũng','0932685988','TSN FC','3','2','1','0','hoangdung',7,2,'OK',NULL,'2018-03-04 16:12:00','2018-03-04 16:12:00'),(7,'Tuấn Hưng','09333333','HAT FC','5','5','0','0','tuanhungfc',10,0,'OK',NULL,'2018-12-31 18:01:00','2018-12-31 18:01:00'),(8,'Tiến Dũng','09797979','TSB FC','4','3','1','0','tiendung123',8,1,'OK',NULL,'2017-05-06 16:00:00','2017-05-06 16:00:00'),(9,'Đức Mẫn','0985265985','MU FC','3','3','1','0','ducman123',6,0,'OK',NULL,'2017-06-05 09:34:03','2017-06-05 09:34:03'),(10,'Khắc Hưng','0347009685','SG FC','1','2','0','0','khachung123',2,0,'OK',NULL,'2017-05-06 16:00:00','2017-05-06 16:00:00');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `district`
--

DROP TABLE IF EXISTS `district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `district` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district`
--

LOCK TABLES `district` WRITE;
/*!40000 ALTER TABLE `district` DISABLE KEYS */;
INSERT INTO `district` VALUES (1,'Hữu Hùng',1,1,'2018-12-31 18:01:00','2018-12-31 18:01:00'),(2,'Cẩm Lệ',1,1,'2018-12-31 18:01:00','2018-12-31 18:01:00'),(3,'Hòa khánh',1,1,'2018-12-31 18:01:00','2018-12-31 18:01:00'),(4,'Ngũ Hành sơn',1,1,'2016-12-31 18:01:00','2018-12-31 18:01:00'),(5,'Sơn Trà',1,1,'2016-12-31 18:01:00','2018-12-31 18:01:00'),(6,'Hải Châu',1,1,'2016-12-31 18:01:00','2018-12-31 18:01:00'),(7,'Liên Chiểu',1,1,'2016-12-31 18:01:00','2018-12-31 18:01:00');
/*!40000 ALTER TABLE `district` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorite_address`
--

DROP TABLE IF EXISTS `favorite_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `favorite_address` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_owner` int(10) unsigned DEFAULT NULL,
  `id_customer` int(10) unsigned DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `favorite_address_id_owner_index` (`id_owner`),
  KEY `favorite_address_id_customer_index` (`id_customer`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorite_address`
--

LOCK TABLES `favorite_address` WRITE;
/*!40000 ALTER TABLE `favorite_address` DISABLE KEYS */;
INSERT INTO `favorite_address` VALUES (1,1,1,'2018-12-31 18:01:00','2018-12-31 18:01:00'),(2,2,2,'2018-07-09 15:32:00','2018-07-09 15:32:00'),(3,3,2,'2017-09-09 05:35:00','2017-09-09 05:35:00'),(4,4,4,'2018-12-31 18:01:00','2018-12-31 18:01:00'),(5,5,5,'2018-11-05 16:38:24','2018-11-05 16:38:24'),(6,6,6,'2018-03-04 16:12:00','2018-03-04 16:12:00'),(7,7,7,'2018-08-30 02:00:00','2018-08-30 02:00:00'),(8,8,3,'2017-11-20 00:00:00','2017-11-20 00:00:00'),(9,9,9,'2018-02-20 10:00:00','2018-02-20 10:00:00'),(10,10,10,'2017-12-20 10:00:00','2017-12-20 10:00:00'),(11,1,3,'2017-05-20 10:00:00','2017-05-20 10:00:00');
/*!40000 ALTER TABLE `favorite_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_reserve`
--

DROP TABLE IF EXISTS `log_reserve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `log_reserve` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_price` int(10) unsigned DEFAULT NULL,
  `id_pitch` int(10) unsigned DEFAULT NULL,
  `id_time` int(10) unsigned DEFAULT NULL,
  `id_customer` int(10) unsigned DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'UNSTABLE',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `log_reserve_id_price_index` (`id_price`),
  KEY `log_reserve_id_pitch_index` (`id_pitch`),
  KEY `log_reserve_id_time_index` (`id_time`),
  KEY `log_reserve_id_customer_index` (`id_customer`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_reserve`
--

LOCK TABLES `log_reserve` WRITE;
/*!40000 ALTER TABLE `log_reserve` DISABLE KEYS */;
INSERT INTO `log_reserve` VALUES (1,1,1,1,1,'UNSTABLE','OK','2019-07-09 22:32:00','2018-07-09 15:32:00','2018-07-09 15:32:00'),(2,2,2,2,2,'UNSTABLE','OK','2019-11-05 23:38:24','2018-11-05 16:38:24','2018-11-05 16:38:24'),(3,3,3,3,1,'UNSTABLE','OK','2019-01-01 01:01:00','2018-12-31 18:01:00','2018-12-31 18:01:00'),(4,4,4,4,2,'UNSTABLE','OK','2019-07-09 22:32:00','2018-07-09 15:32:00','2018-07-09 15:32:00'),(5,5,5,5,3,'UNSTABLE','OK','2019-11-05 23:38:24','2018-11-05 16:38:24','2018-11-05 16:38:24'),(6,6,6,6,4,'UNSTABLE','OK','2018-11-05 23:38:24','2018-11-05 16:38:24','2018-11-05 16:38:24'),(7,7,7,7,5,'UNSTABLE','OK','2018-07-09 22:32:00','2018-07-09 15:32:00','2018-07-09 15:32:00'),(8,8,8,8,6,'UNSTABLE','OK','2020-01-01 01:01:00','2018-12-31 18:01:00','2018-12-31 18:01:00'),(9,9,9,9,7,'UNSTABLE','OK','2017-05-06 23:00:00','2017-05-06 16:00:00','2017-05-06 16:00:00'),(10,10,10,10,8,'UNSTABLE','OK','2020-01-01 01:01:00','2018-12-31 18:01:00','2018-12-31 18:01:00'),(11,6,6,11,9,'UNSTABLE','OK','2019-07-09 22:32:00','2018-07-09 15:32:00','2018-07-09 15:32:00'),(12,5,4,12,10,'UNSTABLE','OK','2018-07-09 22:32:00','2018-07-09 15:32:00','2018-07-09 15:32:00'),(13,2,2,13,9,'UNSTABLE','OK','2019-03-04 23:12:00','2018-03-04 16:12:00','2018-03-04 16:12:00'),(14,5,5,14,8,'UNSTABLE','OK','2019-05-06 23:00:00','2017-05-06 16:00:00','2017-05-06 16:00:00'),(15,6,6,15,7,'UNSTABLE','OK','2018-03-04 23:12:00','2018-03-04 16:12:00','2018-03-04 16:12:00');
/*!40000 ALTER TABLE `log_reserve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `migrations`
--

DROP TABLE IF EXISTS `migrations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `migrations` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `migration` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `migrations`
--

LOCK TABLES `migrations` WRITE;
/*!40000 ALTER TABLE `migrations` DISABLE KEYS */;
INSERT INTO `migrations` VALUES (3,'2019_02_25_105348_create__owner_table',1),(4,'2019_02_25_113653_create_owners_table',1),(7,'2014_10_12_000000_create_users_table',2),(8,'2014_10_12_100000_create_password_resets_table',2),(9,'2019_02_25_105348_create_owner_table',3),(10,'2019_02_26_045437_create_district_table',3),(11,'2019_02_26_045918_create_favorite_address_table',3),(12,'2019_02_26_050217_create_pitch_table',3),(13,'2019_02_26_054428_create_pitch_type_table',3),(14,'2019_02_26_054652_create_banner_reserve_table',3),(15,'2019_02_26_054951_create_pair_table',3),(16,'2019_02_26_055721_create_time_table',3),(17,'2019_02_26_060004_create_customer_table',3),(18,'2019_02_26_060646_create_banner_pair_table',3),(19,'2019_02_26_061403_create_price_table',3),(20,'2019_02_26_061735_creat_log_reserve_table',3);
/*!40000 ALTER TABLE `migrations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `owner`
--

DROP TABLE IF EXISTS `owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `owner` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `verify` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `is_block` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'NO',
  `is_delete` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'NO',
  `district` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `remember_token` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner`
--

LOCK TABLES `owner` WRITE;
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
INSERT INTO `owner` VALUES (1,'Huy Hùng','0979789789','Đà Nẵng','OK','2','1','Cẩm Lệ',1,1,'huyhung123',NULL,'2018-01-25 13:30:00','2018-01-25 13:30:00'),(2,'Đức Hoàng','0982222222','Đà Nẵng','OK','0','2','Hòa khánh',1,1,'duchoang123',NULL,'2018-01-25 13:30:00','2018-01-25 13:30:00'),(3,'Anh Đức','0999922222','Đà Nẵng','OK','0','0','Ngũ Hành sơn',1,1,'anhduc',NULL,'2019-07-25 03:30:00','2018-01-25 13:30:00'),(4,'Nam Thư','0968768768','Đà Nẵng','OK','0','1','Sơn Trà',1,1,'namthu123',NULL,'2017-06-30 08:30:00','2019-11-25 13:30:00'),(5,'Dũng CT','0972234234','Đà Nẵng','OK','0','1','Sơn Trà',1,1,'dungpro',NULL,'2018-08-30 02:00:00','2019-11-25 13:30:00'),(6,'Văn Đức','0972239999','Đà Nẵng','OK','0','1','Hải Châu',1,1,'duc123456',NULL,'2019-01-20 12:00:00','2018-10-05 13:30:00'),(7,'Hoàng Nam','0979658475','Đà Nẵng','OK','3','1','Hải Châu',1,1,'namdanang',NULL,'2017-11-20 00:00:00','2019-01-05 13:30:00'),(8,'Hoàng Hải','0905300926','Đà Nẵng','OK','3','1','Hải Châu',1,1,'hai12345',NULL,'2018-02-20 10:00:00','2018-11-05 13:30:00'),(9,'Sơn Hoàng','0935333333','Đà Nẵng','OK','2','0','Liên Chiểu',1,1,'123456',NULL,'2017-12-20 10:00:00','2018-10-25 12:00:00'),(10,'Tiến Lục','0347999999','Đà Nẵng','OK','5','7','Liêu Chiều',1,1,'luc123645',NULL,'2017-05-20 10:00:00','2019-08-13 12:00:00');
/*!40000 ALTER TABLE `owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pair`
--

DROP TABLE IF EXISTS `pair`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pair` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_customer` int(10) unsigned DEFAULT NULL,
  `id_time` int(10) unsigned DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `is_verify` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'NO',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pair_id_customer_index` (`id_customer`),
  KEY `pair_id_time_index` (`id_time`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pair`
--

LOCK TABLES `pair` WRITE;
/*!40000 ALTER TABLE `pair` DISABLE KEYS */;
INSERT INTO `pair` VALUES (1,1,1,'Cáp kèo đội yếu','OK','2019-02-20 17:00:00','YES','2018-02-20 10:00:00','2018-02-20 10:00:00'),(2,2,2,'cáp kèo','OK','2020-06-30 15:30:00','YES','2017-06-30 08:30:00','2017-06-30 08:30:00'),(3,3,3,'Cáp kèo đội yếu','OK','2019-02-20 17:00:00','YES','2018-08-30 02:00:00','2018-08-30 02:00:00'),(4,2,4,'Cáp keo trung bình','OK','2019-02-20 17:00:00','YES','2018-02-20 10:00:00','2018-02-20 10:00:00'),(7,3,5,'Cần đá','OK','2020-01-20 19:00:00','YES','2019-01-20 12:00:00','2019-01-20 12:00:00'),(8,4,6,'Cáp kèo đội yếu','OK','2019-02-20 17:00:00','YES','2018-02-20 10:00:00','2018-02-20 10:00:00'),(9,3,7,'Cáp keo trung bình','OK','2019-02-20 17:00:00','YES','2019-01-20 12:00:00','2019-01-20 12:00:00'),(10,4,8,'Cáp keo trung bình','OK','2020-01-20 19:00:00','YES','2019-01-20 12:00:00','2019-01-20 12:00:00'),(11,6,9,'Cáp kèo đội yếu','OK','2020-06-30 15:30:00','YES','2017-06-30 08:30:00','2017-06-30 08:30:00'),(12,5,10,'Cáp kèo','OK','2019-02-20 17:00:00','YES','2018-02-20 10:00:00','2018-02-20 10:00:00'),(13,7,11,'Cáp keo trung bình','OK','2020-06-30 15:30:00','YES','2017-06-30 08:30:00','2017-06-30 08:30:00'),(14,8,12,'Cáp kèo đội yếu','OK','2020-01-20 19:00:00','YES','2019-01-20 12:00:00','2019-01-20 12:00:00'),(15,9,13,'Cáp keo trung bình','OK','2020-01-20 19:00:00','YES','2019-01-20 12:00:00','2019-01-20 12:00:00'),(16,1,14,'Cáp keo trung bình','OK','2019-05-20 17:00:00','YES','2017-05-20 10:00:00','2017-05-20 10:00:00');
/*!40000 ALTER TABLE `pair` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password_resets`
--

DROP TABLE IF EXISTS `password_resets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `password_resets` (
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  KEY `password_resets_email_index` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password_resets`
--

LOCK TABLES `password_resets` WRITE;
/*!40000 ALTER TABLE `password_resets` DISABLE KEYS */;
/*!40000 ALTER TABLE `password_resets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pitch`
--

DROP TABLE IF EXISTS `pitch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pitch` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_type` int(10) unsigned DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `count` double DEFAULT NULL,
  `is_use` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'NO',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pitch_id_type_index` (`id_type`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pitch`
--

LOCK TABLES `pitch` WRITE;
/*!40000 ALTER TABLE `pitch` DISABLE KEYS */;
INSERT INTO `pitch` VALUES (1,1,'Sân A','Sân đá được 10 trận',NULL,10,'10 trận','2018-01-25 13:30:00','2018-01-25 13:30:00'),(2,2,'Sân B','Sân vừa cải tạo',NULL,NULL,'NO','2018-01-25 13:30:00','2018-01-25 13:30:00'),(3,3,'Sân C','Sân đá được 10 trận',NULL,10,'10 trận','2019-07-25 03:30:00','2019-07-25 03:30:00'),(4,4,'Sân D','Sân đá được 25 trận',NULL,25,'25 trận','2017-06-30 08:30:00','2017-06-30 08:30:00'),(5,5,'Sân A','sân đá đc 30 trận',NULL,30,'30 trận','2018-08-30 02:00:00','2018-08-30 02:00:00'),(6,6,'Sân F','sân đá đc 23 trận',NULL,23,'23 trận','2019-01-20 12:00:00','2019-01-20 12:00:00'),(7,7,'Sân A','sân đá đc 20 trận',NULL,20,'20 trận','2017-11-20 00:00:00','2017-11-20 00:00:00'),(8,8,'Sân B','sân đá đc 45 trận',NULL,45,'45 trận','2018-02-20 10:00:00','2018-02-20 10:00:00'),(9,9,'Sân A','sân đá đc 30 trận',NULL,30,'30 trận','2017-12-20 10:00:00','2017-12-20 10:00:00'),(10,10,'Sân C','sân đá đc 29 trận',NULL,29,'29 trận','2017-05-20 10:00:00','2017-05-20 10:00:00');
/*!40000 ALTER TABLE `pitch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pitch_type`
--

DROP TABLE IF EXISTS `pitch_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pitch_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_owner` int(10) unsigned DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pitch_type_id_owner_index` (`id_owner`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pitch_type`
--

LOCK TABLES `pitch_type` WRITE;
/*!40000 ALTER TABLE `pitch_type` DISABLE KEYS */;
INSERT INTO `pitch_type` VALUES (1,1,'Sân 5','2018-01-25 13:30:00','2018-01-25 13:30:00'),(2,2,'Sân 5','2018-01-25 13:30:00','2018-01-25 13:30:00'),(3,3,'Sân 7','2019-07-25 03:30:00','2019-07-25 03:30:00'),(4,4,'Sân 5','2017-06-30 08:30:00','2017-06-30 08:30:00'),(5,5,'Sân 7','2018-08-30 02:00:00','2018-08-30 02:00:00'),(6,6,'Sân 7','2019-01-20 12:00:00','2019-01-20 12:00:00'),(7,7,'Sân 11','2017-11-20 00:00:00','2017-11-20 00:00:00'),(8,8,'Sân 7','2018-02-20 10:00:00','2018-02-20 10:00:00'),(9,9,'Sân 5','2017-12-20 10:00:00','2017-12-20 10:00:00'),(10,10,'Sân 5','2017-05-20 10:00:00','2017-05-20 10:00:00');
/*!40000 ALTER TABLE `pitch_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price`
--

DROP TABLE IF EXISTS `price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `price` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_type` int(10) unsigned DEFAULT NULL,
  `id_time` int(10) unsigned DEFAULT NULL,
  `price` double DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `price_id_type_index` (`id_type`),
  KEY `price_id_time_index` (`id_time`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price`
--

LOCK TABLES `price` WRITE;
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
INSERT INTO `price` VALUES (1,1,1,300000,'2020-01-25 20:30:00','2018-01-25 13:30:00','2018-01-25 13:30:00'),(2,2,2,250000,'2020-01-25 20:30:00','2018-01-25 13:30:00','2018-01-25 13:30:00'),(3,3,3,300000,'2019-08-30 09:00:00','2018-08-30 02:00:00','2018-08-30 02:00:00'),(4,4,4,200000,'2019-07-25 10:30:00','2018-07-25 03:30:00','2018-07-25 03:30:00'),(5,5,5,250000,'2020-02-20 17:00:00','2018-02-20 10:00:00','2018-02-20 10:00:00'),(6,6,6,300000,'2020-02-20 17:00:00','2018-02-20 10:00:00','2018-02-20 10:00:00'),(7,7,7,300000,'2019-11-20 07:00:00','2017-11-20 00:00:00','2017-11-20 00:00:00'),(8,8,8,250000,'2020-07-25 10:30:00','2019-07-25 03:30:00','2019-07-25 03:30:00'),(9,9,9,300000,'2019-12-20 17:00:00','2017-12-20 10:00:00','2017-12-20 10:00:00'),(10,10,10,250000,'2019-05-20 17:00:00','2017-05-20 10:00:00','2017-05-20 10:00:00'),(11,8,11,300000,'2020-07-25 10:30:00','2019-07-25 03:30:00','2019-07-25 03:30:00'),(12,1,12,250000,'2020-02-20 17:00:00','2018-02-20 10:00:00','2018-02-20 10:00:00'),(13,9,13,300000,'2019-12-20 17:00:00','2017-12-20 10:00:00','2017-12-20 10:00:00'),(14,9,14,300000,'2019-12-20 17:00:00','2017-12-20 10:00:00','2017-12-20 10:00:00'),(15,8,15,300000,'2020-07-25 10:30:00','2019-07-25 03:30:00','2019-07-25 03:30:00'),(16,3,7,300000,'2020-07-25 10:30:00','2019-07-25 03:30:00','2019-07-25 03:30:00');
/*!40000 ALTER TABLE `price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time`
--

DROP TABLE IF EXISTS `time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `time` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time`
--

LOCK TABLES `time` WRITE;
/*!40000 ALTER TABLE `time` DISABLE KEYS */;
INSERT INTO `time` VALUES (1,'2018-01-25 06:30:00','2019-01-25 07:30:00','2018-12-31 18:01:00','2018-12-31 18:01:00'),(2,'2018-01-25 07:30:00','2019-01-25 08:30:00','2018-12-31 18:01:00','2018-12-31 18:01:00'),(3,'2018-01-25 08:30:00','2019-01-25 09:30:00','2018-12-31 18:01:00','2018-12-31 18:01:00'),(4,'2018-01-25 09:30:00','2019-01-25 10:30:00','2018-12-31 18:01:00','2018-12-31 18:01:00'),(5,'2018-01-25 10:30:00','2019-01-25 11:30:00','2018-12-31 18:01:00','2018-12-31 18:01:00'),(6,'2018-01-25 11:30:00','2019-01-25 12:30:00','2018-12-31 18:01:00','2018-12-31 18:01:00'),(7,'2018-01-25 12:30:00','2019-01-25 13:30:00','2018-12-31 18:01:00','2018-12-31 18:01:00'),(8,'2018-01-25 13:30:00','2019-01-25 14:30:00','2018-12-31 18:01:00','2018-12-31 18:01:00'),(9,'2018-01-25 14:30:00','2019-01-25 15:30:00','2018-12-31 18:01:00','2018-12-31 18:01:00'),(10,'2018-01-25 15:30:00','2019-01-25 16:30:00','2018-12-31 18:01:00','2018-12-31 18:01:00'),(11,'2018-01-25 16:30:00','2019-01-25 17:30:00','2018-12-31 18:01:00','2018-12-31 18:01:00'),(12,'2018-01-25 17:30:00','2019-01-25 18:30:00','2018-12-31 18:01:00','2018-12-31 18:01:00'),(13,'2018-01-25 18:30:00','2019-01-25 19:30:00','2018-12-31 18:01:00','2018-12-31 18:01:00'),(14,'2018-01-25 19:30:00','2019-01-25 20:30:00','2018-12-31 18:01:00','2018-12-31 18:01:00'),(15,'2018-01-25 20:30:00','2019-01-25 21:30:00','2018-12-31 18:01:00','2018-12-31 18:01:00');
/*!40000 ALTER TABLE `time` ENABLE KEYS */;
UNLOCK TABLES;


