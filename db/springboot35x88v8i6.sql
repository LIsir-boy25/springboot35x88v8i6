-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: springboot35x88v8i6
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `springboot35x88v8i6`
--

/*!40000 DROP DATABASE IF EXISTS `springboot35x88v8i6`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `springboot35x88v8i6` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `springboot35x88v8i6`;

--
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `adminid` bigint(20) DEFAULT NULL COMMENT '管理员id',
  `ask` longtext COLLATE utf8mb4_unicode_ci COMMENT '提问',
  `reply` longtext COLLATE utf8mb4_unicode_ci COMMENT '回复',
  `isreply` int(11) DEFAULT NULL COMMENT '是否回复',
  `isread` int(11) DEFAULT '0' COMMENT '已读/未读(1:已读,0:未读)',
  `uname` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `uimage` longtext COLLATE utf8mb4_unicode_ci COMMENT '用户头像',
  `type` int(11) DEFAULT '1' COMMENT '内容类型(1:文本,2:图片,3:视频,4:文件,5:表情)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='智能客服';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` VALUES (1,'2026-01-10 12:50:52',1,1,'提问1','回复1',1,1,'用户名1','upload/chat_uimage1.jpg,upload/chat_uimage2.jpg,upload/chat_uimage3.jpg',1),(2,'2026-01-10 12:50:52',2,2,'提问2','回复2',2,2,'用户名2','upload/chat_uimage2.jpg,upload/chat_uimage3.jpg,upload/chat_uimage4.jpg',2),(3,'2026-01-10 12:50:52',3,3,'提问3','回复3',3,3,'用户名3','upload/chat_uimage3.jpg,upload/chat_uimage4.jpg,upload/chat_uimage5.jpg',3),(4,'2026-01-10 12:50:52',4,4,'提问4','回复4',4,4,'用户名4','upload/chat_uimage4.jpg,upload/chat_uimage5.jpg,upload/chat_uimage6.jpg',4),(5,'2026-01-10 12:50:52',5,5,'提问5','回复5',5,5,'用户名5','upload/chat_uimage5.jpg,upload/chat_uimage6.jpg,upload/chat_uimage7.jpg',5),(6,'2026-01-10 12:50:52',6,6,'提问6','回复6',6,6,'用户名6','upload/chat_uimage6.jpg,upload/chat_uimage7.jpg,upload/chat_uimage8.jpg',6),(7,'2026-01-10 12:50:52',7,7,'提问7','回复7',7,7,'用户名7','upload/chat_uimage7.jpg,upload/chat_uimage8.jpg,upload/chat_uimage1.jpg',7),(8,'2026-01-10 12:50:52',8,8,'提问8','回复8',8,8,'用户名8','upload/chat_uimage8.jpg,upload/chat_uimage1.jpg,upload/chat_uimage2.jpg',8);
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chatmessage`
--

DROP TABLE IF EXISTS `chatmessage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chatmessage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `fid` bigint(20) NOT NULL COMMENT '好友用户ID',
  `content` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '内容',
  `format` int(11) DEFAULT NULL COMMENT '格式(1:文字，2:图片)',
  `isread` int(11) DEFAULT '0' COMMENT '消息已读(0:未读，1:已读)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='消息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chatmessage`
--

LOCK TABLES `chatmessage` WRITE;
/*!40000 ALTER TABLE `chatmessage` DISABLE KEYS */;
/*!40000 ALTER TABLE `chatmessage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chexing`
--

DROP TABLE IF EXISTS `chexing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chexing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `chexing` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '车型',
  `jiage` double DEFAULT NULL COMMENT '每公里价格(元)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `chexing` (`chexing`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='车型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chexing`
--

LOCK TABLES `chexing` WRITE;
/*!40000 ALTER TABLE `chexing` DISABLE KEYS */;
INSERT INTO `chexing` VALUES (1,'2026-01-10 12:50:51','9.6米厢式车',1),(2,'2026-01-10 12:50:51','7.8米高栏车',2),(3,'2026-01-10 12:50:51','9.6米平板车',3),(4,'2026-01-10 12:50:51','10米平板车',4),(5,'2026-01-10 12:50:51','12米集装箱车',5),(6,'2026-01-10 12:50:51','13米高栏车',6),(7,'2026-01-10 12:50:51','车型7',7),(8,'2026-01-10 12:50:51','车型8',8);
/*!40000 ALTER TABLE `chexing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chufaxinxi`
--

DROP TABLE IF EXISTS `chufaxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chufaxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `quyu` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区域',
  `huowuleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货物类型',
  `zhongliang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '重量(kg)',
  `tiji` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '体积(m³)',
  `huowutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '货物图片',
  `zhuanghuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '装货地址',
  `songhuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '送货地址',
  `qiwangzhuanghuoshijian` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '期望装货时间',
  `shifouxuyaohuidan` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否需要回单',
  `licheng` double DEFAULT NULL COMMENT '里程',
  `chexing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车型',
  `jiage` double DEFAULT NULL COMMENT '每公里价格(元)',
  `yue` double DEFAULT NULL COMMENT '运费',
  `chufashijian` datetime DEFAULT NULL COMMENT '出发时间',
  `huozhuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主账号',
  `huozhuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主姓名',
  `lianxifangshi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系方式',
  `sijizhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机账号',
  `sijixingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机姓名',
  `chepai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车牌',
  `chexiangchicun` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车厢尺寸',
  `shoujihao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='出发信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chufaxinxi`
--

LOCK TABLES `chufaxinxi` WRITE;
/*!40000 ALTER TABLE `chufaxinxi` DISABLE KEYS */;
INSERT INTO `chufaxinxi` VALUES (1,'2026-01-10 12:50:51','订单编号1','安徽石台','普通货物','重量(kg)1','体积(m³)1','upload/chufaxinxi_huowutupian1.jpg,upload/chufaxinxi_huowutupian2.jpg,upload/chufaxinxi_huowutupian3.jpg','装货地址1','送货地址1','期望装货时间1','是否需要回单1',1,'9.6米厢式车',1,1,'2026-01-10 20:50:51','006','赵静','13466667776','26','马子轩','京A12345','车厢尺寸1','13567890123'),(2,'2026-01-10 12:50:51','订单编号2','河北高阳','普通货物','重量(kg)2','体积(m³)2','upload/chufaxinxi_huowutupian2.jpg,upload/chufaxinxi_huowutupian3.jpg,upload/chufaxinxi_huowutupian4.jpg','装货地址2','送货地址2','期望装货时间2','是否需要回单2',2,'7.8米高栏车',2,2,'2026-01-10 20:50:51','003','张伟','13733334443','28','周宇恒','鲁G45678','车厢尺寸2','13023456789'),(3,'2026-01-10 12:50:51','订单编号3','山东烟台','普通货物','重量(kg)3','体积(m³)3','upload/chufaxinxi_huowutupian3.jpg,upload/chufaxinxi_huowutupian4.jpg,upload/chufaxinxi_huowutupian5.jpg','装货地址3','送货地址3','期望装货时间3','是否需要回单3',3,'9.6米平板车',3,3,'2026-01-10 20:50:51','007','孙浩','13377778887','22','陈浩然','云T45678','车厢尺寸3','13290123456'),(4,'2026-01-10 12:50:51','订单编号4','河北南宫','冷链货物','重量(kg)4','体积(m³)4','upload/chufaxinxi_huowutupian4.jpg,upload/chufaxinxi_huowutupian5.jpg,upload/chufaxinxi_huowutupian6.jpg','装货地址4','送货地址4','期望装货时间4','是否需要回单4',4,'10米平板车',4,4,'2026-01-10 20:50:51','016','梁艳','15477788886','24','林文博','粤C23456','车厢尺寸4','13012345678'),(5,'2026-01-10 12:50:51','订单编号5','山东济南','普通货物','重量(kg)5','体积(m³)5','upload/chufaxinxi_huowutupian5.jpg,upload/chufaxinxi_huowutupian6.jpg,upload/chufaxinxi_huowutupian7.jpg','装货地址5','送货地址5','期望装货时间5','是否需要回单5',5,'12米集装箱车',5,5,'2026-01-10 20:50:51','013','林达','15744455553','25','徐梦琪','黑Q89012','车厢尺寸5','15187654321'),(6,'2026-01-10 12:50:51','订单编号6','湖北江夏','冷链货物','重量(kg)6','体积(m³)6','upload/chufaxinxi_huowutupian6.jpg,upload/chufaxinxi_huowutupian7.jpg,upload/chufaxinxi_huowutupian8.jpg','装货地址6','送货地址6','期望装货时间6','是否需要回单6',6,'13米高栏车',6,6,'2026-01-10 20:50:51','002','刘芳','13922223332','27','高雨欣','川F89012','车厢尺寸6','13890123456'),(7,'2026-01-10 12:50:51','订单编号7','泰州','普通货物','重量(kg)7','体积(m³)7','upload/chufaxinxi_huowutupian7.jpg,upload/chufaxinxi_huowutupian8.jpg,upload/chufaxinxi_huowutupian1.jpg','装货地址7','送货地址7','期望装货时间7','是否需要回单7',7,'12米集装箱车',7,7,'2026-01-10 20:50:51','009','郑明','13199990009','23','赵思雨','冀N78901','车厢尺寸7','13187654321'),(8,'2026-01-10 12:50:51','订单编号8','江苏苏州','危险品','重量(kg)8','体积(m³)8','upload/chufaxinxi_huowutupian8.jpg,upload/chufaxinxi_huowutupian1.jpg,upload/chufaxinxi_huowutupian2.jpg','装货地址8','送货地址8','期望装货时间8','是否需要回单8',8,'10米平板车',8,8,'2026-01-10 20:50:51','018','邓琪','15299900008','21','梁行高','陕J56789','车厢尺寸8','15012345678');
/*!40000 ALTER TABLE `chufaxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(200) DEFAULT NULL COMMENT '配置参数值',
  `url` varchar(500) DEFAULT NULL COMMENT 'url',
  `type` int(11) DEFAULT NULL COMMENT '参数类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','upload/picture1.jpg',NULL,1),(2,'picture2','upload/picture2.jpg',NULL,1),(3,'picture3','upload/picture3.jpg',NULL,1),(7,'APIKey','ihML0NfEM0jokUAuBD9tbYtW',NULL,2),(8,'SecretKey','WK2bRUFf2uNe3oEoQXULpi8Y37aCvFdD',NULL,2),(10,'gaode','{\"key\":\"7a7b5d185ffd9ca30f582ff9349716ea\",\"code\":\"8848c1c64023c00cf192ce109b97243c\"}',NULL,2),(11,'baidu','{\"appId\":\"49214550\",\"apiKey\":\"7Otjpv2kn0ljQk45qXOXh5MO\",\"secretKey\":\"BMfbXRbTIVaB4C3SbRTtGqDv1wHDvyXS\"}',NULL,2),(21,'bLoginBackgroundImg','',NULL,3),(22,'bRegisterBackgroundImg','',NULL,3),(23,'bIndexBackgroundImg','',NULL,3),(24,'bTopLogo','',NULL,3),(25,'bHomeLogo','',NULL,3),(26,'fLoginBackgroundImg','',NULL,3),(27,'fRegisterBackgroudImg','',NULL,3),(28,'fTopLogo','',NULL,3);
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `daodazhuanghuodi`
--

DROP TABLE IF EXISTS `daodazhuanghuodi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `daodazhuanghuodi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `quyu` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区域',
  `huowuleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货物类型',
  `zhongliang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '重量(kg)',
  `tiji` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '体积(m³)',
  `huowutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '货物图片',
  `zhuanghuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '装货地址',
  `songhuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '送货地址',
  `qiwangzhuanghuoshijian` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '期望装货时间',
  `shifouxuyaohuidan` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否需要回单',
  `licheng` double DEFAULT NULL COMMENT '里程',
  `chexing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车型',
  `jiage` double DEFAULT NULL COMMENT '每公里价格(元)',
  `yue` double DEFAULT NULL COMMENT '运费',
  `daodashijian` datetime DEFAULT NULL COMMENT '到达时间',
  `huozhuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主账号',
  `huozhuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主姓名',
  `lianxifangshi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系方式',
  `sijizhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机账号',
  `sijixingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机姓名',
  `chepai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车牌',
  `chexiangchicun` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车厢尺寸',
  `shoujihao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='到达装货地';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `daodazhuanghuodi`
--

LOCK TABLES `daodazhuanghuodi` WRITE;
/*!40000 ALTER TABLE `daodazhuanghuodi` DISABLE KEYS */;
INSERT INTO `daodazhuanghuodi` VALUES (1,'2026-01-10 12:50:51','订单编号1','安徽石台','普通货物','重量(kg)1','体积(m³)1','upload/daodazhuanghuodi_huowutupian1.jpg,upload/daodazhuanghuodi_huowutupian2.jpg,upload/daodazhuanghuodi_huowutupian3.jpg','装货地址1','送货地址1','期望装货时间1','是否需要回单1',1,'9.6米厢式车',1,1,'2026-01-10 20:50:51','006','赵静','13466667776','26','马子轩','京A12345','车厢尺寸1','13567890123'),(2,'2026-01-10 12:50:51','订单编号2','河北高阳','普通货物','重量(kg)2','体积(m³)2','upload/daodazhuanghuodi_huowutupian2.jpg,upload/daodazhuanghuodi_huowutupian3.jpg,upload/daodazhuanghuodi_huowutupian4.jpg','装货地址2','送货地址2','期望装货时间2','是否需要回单2',2,'7.8米高栏车',2,2,'2026-01-10 20:50:51','003','张伟','13733334443','28','周宇恒','鲁G45678','车厢尺寸2','13023456789'),(3,'2026-01-10 12:50:51','订单编号3','山东烟台','普通货物','重量(kg)3','体积(m³)3','upload/daodazhuanghuodi_huowutupian3.jpg,upload/daodazhuanghuodi_huowutupian4.jpg,upload/daodazhuanghuodi_huowutupian5.jpg','装货地址3','送货地址3','期望装货时间3','是否需要回单3',3,'9.6米平板车',3,3,'2026-01-10 20:50:51','007','孙浩','13377778887','22','陈浩然','云T45678','车厢尺寸3','13290123456'),(4,'2026-01-10 12:50:51','订单编号4','河北南宫','冷链货物','重量(kg)4','体积(m³)4','upload/daodazhuanghuodi_huowutupian4.jpg,upload/daodazhuanghuodi_huowutupian5.jpg,upload/daodazhuanghuodi_huowutupian6.jpg','装货地址4','送货地址4','期望装货时间4','是否需要回单4',4,'10米平板车',4,4,'2026-01-10 20:50:51','016','梁艳','15477788886','24','林文博','粤C23456','车厢尺寸4','13012345678'),(5,'2026-01-10 12:50:51','订单编号5','山东济南','普通货物','重量(kg)5','体积(m³)5','upload/daodazhuanghuodi_huowutupian5.jpg,upload/daodazhuanghuodi_huowutupian6.jpg,upload/daodazhuanghuodi_huowutupian7.jpg','装货地址5','送货地址5','期望装货时间5','是否需要回单5',5,'12米集装箱车',5,5,'2026-01-10 20:50:51','013','林达','15744455553','25','徐梦琪','黑Q89012','车厢尺寸5','15187654321'),(6,'2026-01-10 12:50:51','订单编号6','湖北江夏','冷链货物','重量(kg)6','体积(m³)6','upload/daodazhuanghuodi_huowutupian6.jpg,upload/daodazhuanghuodi_huowutupian7.jpg,upload/daodazhuanghuodi_huowutupian8.jpg','装货地址6','送货地址6','期望装货时间6','是否需要回单6',6,'13米高栏车',6,6,'2026-01-10 20:50:51','002','刘芳','13922223332','27','高雨欣','川F89012','车厢尺寸6','13890123456'),(7,'2026-01-10 12:50:51','订单编号7','泰州','普通货物','重量(kg)7','体积(m³)7','upload/daodazhuanghuodi_huowutupian7.jpg,upload/daodazhuanghuodi_huowutupian8.jpg,upload/daodazhuanghuodi_huowutupian1.jpg','装货地址7','送货地址7','期望装货时间7','是否需要回单7',7,'12米集装箱车',7,7,'2026-01-10 20:50:51','009','郑明','13199990009','23','赵思雨','冀N78901','车厢尺寸7','13187654321'),(8,'2026-01-10 12:50:51','订单编号8','江苏苏州','危险品','重量(kg)8','体积(m³)8','upload/daodazhuanghuodi_huowutupian8.jpg,upload/daodazhuanghuodi_huowutupian1.jpg,upload/daodazhuanghuodi_huowutupian2.jpg','装货地址8','送货地址8','期望装货时间8','是否需要回单8',8,'10米平板车',8,8,'2026-01-10 20:50:51','018','邓琪','15299900008','21','梁行高','陕J56789','车厢尺寸8','15012345678');
/*!40000 ALTER TABLE `daodazhuanghuodi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diaoduyuan`
--

DROP TABLE IF EXISTS `diaoduyuan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diaoduyuan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `diaoduzhanghao` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '调度账号',
  `diaoduxingming` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '调度姓名',
  `mima` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `xingbie` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `shouji` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机',
  `touxiang` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `pquestion` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密保问题',
  `panswer` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密保答案',
  `status` int(11) DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `diaoduzhanghao` (`diaoduzhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='调度员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diaoduyuan`
--

LOCK TABLES `diaoduyuan` WRITE;
/*!40000 ALTER TABLE `diaoduyuan` DISABLE KEYS */;
INSERT INTO `diaoduyuan` VALUES (31,'2026-01-10 12:50:51','32','陈宇恒','e10adc3949ba59abbe56e057f20f883e','男','13589012345','upload/diaoduyuan_touxiang1.jpg','密保问题1','密保答案1',0),(32,'2026-01-10 12:50:51','37','韩皓轩','e10adc3949ba59abbe56e057f20f883e','男','13467890123','upload/diaoduyuan_touxiang2.jpg','密保问题2','密保答案2',0),(33,'2026-01-10 12:50:51','36','谢雨桐','e10adc3949ba59abbe56e057f20f883e','女','13545678901','upload/diaoduyuan_touxiang3.jpg','密保问题3','密保答案3',0),(34,'2026-01-10 12:50:51','34','何佳怡','e10adc3949ba59abbe56e057f20f883e','女','13445678901','upload/diaoduyuan_touxiang4.jpg','密保问题4','密保答案4',0),(35,'2026-01-10 12:50:51','38','冯梦琪','e10adc3949ba59abbe56e057f20f883e','女','13412345678','upload/diaoduyuan_touxiang5.jpg','密保问题5','密保答案5',0),(36,'2026-01-10 12:50:51','33','赵雨桐','e10adc3949ba59abbe56e057f20f883e','女','13512345678','upload/diaoduyuan_touxiang6.jpg','密保问题6','密保答案6',0),(37,'2026-01-10 12:50:51','31','梁美','e10adc3949ba59abbe56e057f20f883e','女','13423456789','upload/diaoduyuan_touxiang7.jpg','密保问题7','密保答案7',0),(38,'2026-01-10 12:50:51','35','罗子墨','e10adc3949ba59abbe56e057f20f883e','男','13490123456','upload/diaoduyuan_touxiang8.jpg','密保问题8','密保答案8',0);
/*!40000 ALTER TABLE `diaoduyuan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussyunlixinxi`
--

DROP TABLE IF EXISTS `discussyunlixinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussyunlixinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `avatarurl` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `nickname` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `content` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '评论内容',
  `reply` longtext COLLATE utf8mb4_unicode_ci COMMENT '回复内容',
  `thumbsupnum` int(11) DEFAULT '0' COMMENT '赞',
  `crazilynum` int(11) DEFAULT '0' COMMENT '踩',
  `istop` int(11) DEFAULT '0' COMMENT '置顶(1:置顶,0:非置顶)',
  `tuserids` longtext COLLATE utf8mb4_unicode_ci COMMENT '赞用户ids',
  `cuserids` longtext COLLATE utf8mb4_unicode_ci COMMENT '踩用户ids',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='运力信息评论';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussyunlixinxi`
--

LOCK TABLES `discussyunlixinxi` WRITE;
/*!40000 ALTER TABLE `discussyunlixinxi` DISABLE KEYS */;
/*!40000 ALTER TABLE `discussyunlixinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forum`
--

DROP TABLE IF EXISTS `forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forum` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '帖子标题',
  `content` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '帖子内容',
  `parentid` bigint(20) DEFAULT NULL COMMENT '父节点id',
  `username` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `avatarurl` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `isdone` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '状态',
  `istop` int(11) DEFAULT '0' COMMENT '是否置顶',
  `toptime` datetime DEFAULT NULL COMMENT '置顶时间',
  `cover` longtext COLLATE utf8mb4_unicode_ci COMMENT '封面',
  `isanon` int(11) DEFAULT '0' COMMENT '是否匿名(1:是,0:否)',
  `delflag` int(11) DEFAULT '0' COMMENT '是否删除(1:是,0:否)',
  `thumbsupnum` int(11) DEFAULT '0' COMMENT '赞',
  `crazilynum` int(11) DEFAULT '0' COMMENT '踩',
  `userid` bigint(20) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='留言板';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum`
--

LOCK TABLES `forum` WRITE;
/*!40000 ALTER TABLE `forum` DISABLE KEYS */;
INSERT INTO `forum` VALUES (1,'2026-01-10 12:50:52','帖子标题1','帖子内容1',0,'用户名1','upload/forum_avatarurl1.jpg,upload/forum_avatarurl2.jpg,upload/forum_avatarurl3.jpg','开放',0,'2026-01-10 20:50:52','upload/forum_cover1.jpg,upload/forum_cover2.jpg,upload/forum_cover3.jpg',1,0,1,1,1),(2,'2026-01-10 12:50:52','帖子标题2','帖子内容2',0,'用户名2','upload/forum_avatarurl2.jpg,upload/forum_avatarurl3.jpg,upload/forum_avatarurl4.jpg','开放',0,'2026-01-10 20:50:52','upload/forum_cover2.jpg,upload/forum_cover3.jpg,upload/forum_cover4.jpg',2,0,2,2,2),(3,'2026-01-10 12:50:52','帖子标题3','帖子内容3',0,'用户名3','upload/forum_avatarurl3.jpg,upload/forum_avatarurl4.jpg,upload/forum_avatarurl5.jpg','开放',0,'2026-01-10 20:50:52','upload/forum_cover3.jpg,upload/forum_cover4.jpg,upload/forum_cover5.jpg',3,0,3,3,3),(4,'2026-01-10 12:50:52','帖子标题4','帖子内容4',0,'用户名4','upload/forum_avatarurl4.jpg,upload/forum_avatarurl5.jpg,upload/forum_avatarurl6.jpg','开放',0,'2026-01-10 20:50:52','upload/forum_cover4.jpg,upload/forum_cover5.jpg,upload/forum_cover6.jpg',4,0,4,4,4),(5,'2026-01-10 12:50:52','帖子标题5','帖子内容5',0,'用户名5','upload/forum_avatarurl5.jpg,upload/forum_avatarurl6.jpg,upload/forum_avatarurl7.jpg','开放',0,'2026-01-10 20:50:52','upload/forum_cover5.jpg,upload/forum_cover6.jpg,upload/forum_cover7.jpg',5,0,5,5,5),(6,'2026-01-10 12:50:52','帖子标题6','帖子内容6',0,'用户名6','upload/forum_avatarurl6.jpg,upload/forum_avatarurl7.jpg,upload/forum_avatarurl8.jpg','开放',0,'2026-01-10 20:50:52','upload/forum_cover6.jpg,upload/forum_cover7.jpg,upload/forum_cover8.jpg',6,0,6,6,6),(7,'2026-01-10 12:50:52','帖子标题7','帖子内容7',0,'用户名7','upload/forum_avatarurl7.jpg,upload/forum_avatarurl8.jpg,upload/forum_avatarurl1.jpg','开放',0,'2026-01-10 20:50:52','upload/forum_cover7.jpg,upload/forum_cover8.jpg,upload/forum_cover1.jpg',7,0,7,7,7),(8,'2026-01-10 12:50:52','帖子标题8','帖子内容8',0,'用户名8','upload/forum_avatarurl8.jpg,upload/forum_avatarurl1.jpg,upload/forum_avatarurl2.jpg','开放',0,'2026-01-10 20:50:52','upload/forum_cover8.jpg,upload/forum_cover1.jpg,upload/forum_cover2.jpg',8,0,8,8,8);
/*!40000 ALTER TABLE `forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friend`
--

DROP TABLE IF EXISTS `friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `fid` bigint(20) NOT NULL COMMENT '好友用户ID',
  `name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `picture` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片',
  `role` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色',
  `tablename` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '表名',
  `alias` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '别名',
  `type` int(11) DEFAULT '0' COMMENT '类型(0:好友申请，1:好友，2:消息)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='好友表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend`
--

LOCK TABLES `friend` WRITE;
/*!40000 ALTER TABLE `friend` DISABLE KEYS */;
/*!40000 ALTER TABLE `friend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fuwupingjia`
--

DROP TABLE IF EXISTS `fuwupingjia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fuwupingjia` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `quyu` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区域',
  `huowuleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货物类型',
  `zhongliang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '重量(kg)',
  `tiji` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '体积(m³)',
  `zhuanghuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '装货地址',
  `songhuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '送货地址',
  `qiwangzhuanghuoshijian` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '期望装货时间',
  `shifouxuyaohuidan` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否需要回单',
  `licheng` double DEFAULT NULL COMMENT '里程',
  `chexing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车型',
  `jiage` double DEFAULT NULL COMMENT '每公里价格(元)',
  `yue` double DEFAULT NULL COMMENT '运费',
  `xiehuotupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '卸货图片',
  `xingjipingfen` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '星级评分',
  `fuwupingjia` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '服务评价',
  `pingjiashijian` datetime DEFAULT NULL COMMENT '评价时间',
  `huozhuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主账号',
  `huozhuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主姓名',
  `lianxifangshi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系方式',
  `sijizhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机账号',
  `sijixingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机姓名',
  `chepai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车牌',
  `chexiangchicun` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车厢尺寸',
  `shoujihao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='服务评价';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fuwupingjia`
--

LOCK TABLES `fuwupingjia` WRITE;
/*!40000 ALTER TABLE `fuwupingjia` DISABLE KEYS */;
INSERT INTO `fuwupingjia` VALUES (1,'2026-01-10 12:50:52','订单编号1','安徽石台','普通货物','重量(kg)1','体积(m³)1','装货地址1','送货地址1','期望装货时间1','是否需要回单1',1,'9.6米厢式车',1,1,'upload/fuwupingjia_儿童绘本1.jpg,upload/fuwupingjia_儿童绘本2.jpg,upload/fuwupingjia_儿童绘本3.jpg','★','服务评价1','2026-01-10 20:50:52','006','赵静','13466667776','26','马子轩','京A12345','车厢尺寸1','13567890123'),(2,'2026-01-10 12:50:52','订单编号2','河北高阳','普通货物','重量(kg)2','体积(m³)2','装货地址2','送货地址2','期望装货时间2','是否需要回单2',2,'7.8米高栏车',2,2,'upload/fuwupingjia_五金工具1.jpg,upload/fuwupingjia_五金工具2.jpg,upload/fuwupingjia_五金工具3.jpg','★','服务评价2','2026-01-10 20:50:52','003','张伟','13733334443','28','周宇恒','鲁G45678','车厢尺寸2','13023456789'),(3,'2026-01-10 12:50:52','订单编号3','山东烟台','普通货物','重量(kg)3','体积(m³)3','装货地址3','送货地址3','期望装货时间3','是否需要回单3',3,'9.6米平板车',3,3,'upload/fuwupingjia_办公电脑1.jpg,upload/fuwupingjia_办公电脑2.jpg,upload/fuwupingjia_办公电脑3.jpg','★','服务评价3','2026-01-10 20:50:52','007','孙浩','13377778887','22','陈浩然','云T45678','车厢尺寸3','13290123456'),(4,'2026-01-10 12:50:52','订单编号4','河北南宫','冷链货物','重量(kg)4','体积(m³)4','装货地址4','送货地址4','期望装货时间4','是否需要回单4',4,'10米平板车',4,4,'upload/fuwupingjia_海鲜大礼包1.jpg,upload/fuwupingjia_海鲜大礼包2.jpg,upload/fuwupingjia_海鲜大礼包3.jpg','★','服务评价4','2026-01-10 20:50:52','016','梁艳','15477788886','24','林文博','粤C23456','车厢尺寸4','13012345678'),(5,'2026-01-10 12:50:52','订单编号5','山东济南','普通货物','重量(kg)5','体积(m³)5','装货地址5','送货地址5','期望装货时间5','是否需要回单5',5,'12米集装箱车',5,5,'upload/fuwupingjia_钢筋1.jpg,upload/fuwupingjia_钢筋2.jpg,upload/fuwupingjia_钢筋3.jpg','★','服务评价5','2026-01-10 20:50:52','013','林达','15744455553','25','徐梦琪','黑Q89012','车厢尺寸5','15187654321'),(6,'2026-01-10 12:50:52','订单编号6','湖北江夏','冷链货物','重量(kg)6','体积(m³)6','装货地址6','送货地址6','期望装货时间6','是否需要回单6',6,'13米高栏车',6,6,'upload/fuwupingjia_草莓1.jpg,upload/fuwupingjia_草莓2.jpg,upload/fuwupingjia_草莓3.jpg','★','服务评价6','2026-01-10 20:50:52','002','刘芳','13922223332','27','高雨欣','川F89012','车厢尺寸6','13890123456'),(7,'2026-01-10 12:50:52','订单编号7','泰州','普通货物','重量(kg)7','体积(m³)7','装货地址7','送货地址7','期望装货时间7','是否需要回单7',7,'12米集装箱车',7,7,'upload/fuwupingjia_电线电缆1.jpg,upload/fuwupingjia_电线电缆2.jpg,upload/fuwupingjia_电线电缆3.jpg','★','服务评价7','2026-01-10 20:50:52','009','郑明','13199990009','23','赵思雨','冀N78901','车厢尺寸7','13187654321'),(8,'2026-01-10 12:50:52','订单编号8','江苏苏州','危险品','重量(kg)8','体积(m³)8','装货地址8','送货地址8','期望装货时间8','是否需要回单8',8,'10米平板车',8,8,'upload/fuwupingjia_农药1.jpg,upload/fuwupingjia_农药2.jpg,upload/fuwupingjia_农药3.jpg','★','服务评价8','2026-01-10 20:50:52','018','邓琪','15299900008','21','梁行高','陕J56789','车厢尺寸8','15012345678');
/*!40000 ALTER TABLE `fuwupingjia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `huowuleixing`
--

DROP TABLE IF EXISTS `huowuleixing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `huowuleixing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `huowuleixing` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '货物类型',
  PRIMARY KEY (`id`),
  UNIQUE KEY `huowuleixing` (`huowuleixing`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='货物类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `huowuleixing`
--

LOCK TABLES `huowuleixing` WRITE;
/*!40000 ALTER TABLE `huowuleixing` DISABLE KEYS */;
INSERT INTO `huowuleixing` VALUES (1,'2026-01-10 12:50:51','普通货物'),(2,'2026-01-10 12:50:51','冷链货物'),(3,'2026-01-10 12:50:51','危险品'),(4,'2026-01-10 12:50:51','货物类型4'),(5,'2026-01-10 12:50:51','货物类型5'),(6,'2026-01-10 12:50:51','货物类型6'),(7,'2026-01-10 12:50:51','货物类型7'),(8,'2026-01-10 12:50:51','货物类型8');
/*!40000 ALTER TABLE `huowuleixing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `huozhu`
--

DROP TABLE IF EXISTS `huozhu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `huozhu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `huozhuzhanghao` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '货主账号',
  `huozhuxingming` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '货主姓名',
  `mima` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `xingbie` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `lianxifangshi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系方式',
  `touxiang` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `pquestion` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密保问题',
  `panswer` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密保答案',
  `status` int(11) DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `huozhuzhanghao` (`huozhuzhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='货主';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `huozhu`
--

LOCK TABLES `huozhu` WRITE;
/*!40000 ALTER TABLE `huozhu` DISABLE KEYS */;
INSERT INTO `huozhu` VALUES (11,'2026-01-10 12:50:51','006','赵静','e10adc3949ba59abbe56e057f20f883e','女','13466667776','upload/huozhu_touxiang1.jpg','密保问题1','密保答案1',0),(12,'2026-01-10 12:50:51','003','张伟','e10adc3949ba59abbe56e057f20f883e','男','13733334443','upload/huozhu_touxiang2.jpg','密保问题2','密保答案2',0),(13,'2026-01-10 12:50:51','007','孙浩','e10adc3949ba59abbe56e057f20f883e','男','13377778887','upload/huozhu_touxiang3.jpg','密保问题3','密保答案3',0),(14,'2026-01-10 12:50:51','016','梁艳','e10adc3949ba59abbe56e057f20f883e','女','15477788886','upload/huozhu_touxiang4.jpg','密保问题4','密保答案4',0),(15,'2026-01-10 12:50:51','013','林达','e10adc3949ba59abbe56e057f20f883e','男','15744455553','upload/huozhu_touxiang5.jpg','密保问题5','密保答案5',0),(16,'2026-01-10 12:50:51','002','刘芳','e10adc3949ba59abbe56e057f20f883e','女','13922223332','upload/huozhu_touxiang6.jpg','密保问题6','密保答案6',0),(17,'2026-01-10 12:50:51','009','郑明','e10adc3949ba59abbe56e057f20f883e','男','13199990009','upload/huozhu_touxiang7.jpg','密保问题7','密保答案7',0),(18,'2026-01-10 12:50:51','018','邓琪','e10adc3949ba59abbe56e057f20f883e','女','15299900008','upload/huozhu_touxiang8.jpg','密保问题8','密保答案8',0);
/*!40000 ALTER TABLE `huozhu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jiedanxinxi`
--

DROP TABLE IF EXISTS `jiedanxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jiedanxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `quyu` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区域',
  `huowuleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货物类型',
  `zhongliang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '重量(kg)',
  `tiji` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '体积(m³)',
  `huowutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '货物图片',
  `zhuanghuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '装货地址',
  `songhuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '送货地址',
  `qiwangzhuanghuoshijian` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '期望装货时间',
  `shifouxuyaohuidan` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否需要回单',
  `licheng` double DEFAULT NULL COMMENT '里程',
  `chexing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车型',
  `jiage` double DEFAULT NULL COMMENT '每公里价格(元)',
  `yue` double DEFAULT NULL COMMENT '运费',
  `cheliangzhuangtai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车辆状态',
  `jiedanshijian` datetime DEFAULT NULL COMMENT '接单时间',
  `huozhuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主账号',
  `huozhuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主姓名',
  `lianxifangshi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系方式',
  `sijizhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机账号',
  `sijixingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机姓名',
  `chepai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车牌',
  `chexiangchicun` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车厢尺寸',
  `shoujihao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='接单信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jiedanxinxi`
--

LOCK TABLES `jiedanxinxi` WRITE;
/*!40000 ALTER TABLE `jiedanxinxi` DISABLE KEYS */;
INSERT INTO `jiedanxinxi` VALUES (1,'2026-01-10 12:50:51','订单编号1','安徽石台','普通货物','重量(kg)1','体积(m³)1','upload/jiedanxinxi_huowutupian1.jpg,upload/jiedanxinxi_huowutupian2.jpg,upload/jiedanxinxi_huowutupian3.jpg','装货地址1','送货地址1','期望装货时间1','是否需要回单1',1,'9.6米厢式车',1,1,'未出发','2026-01-10 20:50:51','006','赵静','13466667776','26','马子轩','京A12345','车厢尺寸1','13567890123'),(2,'2026-01-10 12:50:51','订单编号2','河北高阳','普通货物','重量(kg)2','体积(m³)2','upload/jiedanxinxi_huowutupian2.jpg,upload/jiedanxinxi_huowutupian3.jpg,upload/jiedanxinxi_huowutupian4.jpg','装货地址2','送货地址2','期望装货时间2','是否需要回单2',2,'7.8米高栏车',2,2,'未出发','2026-01-10 20:50:51','003','张伟','13733334443','28','周宇恒','鲁G45678','车厢尺寸2','13023456789'),(3,'2026-01-10 12:50:51','订单编号3','山东烟台','普通货物','重量(kg)3','体积(m³)3','upload/jiedanxinxi_huowutupian3.jpg,upload/jiedanxinxi_huowutupian4.jpg,upload/jiedanxinxi_huowutupian5.jpg','装货地址3','送货地址3','期望装货时间3','是否需要回单3',3,'9.6米平板车',3,3,'未出发','2026-01-10 20:50:51','007','孙浩','13377778887','22','陈浩然','云T45678','车厢尺寸3','13290123456'),(4,'2026-01-10 12:50:51','订单编号4','河北南宫','冷链货物','重量(kg)4','体积(m³)4','upload/jiedanxinxi_huowutupian4.jpg,upload/jiedanxinxi_huowutupian5.jpg,upload/jiedanxinxi_huowutupian6.jpg','装货地址4','送货地址4','期望装货时间4','是否需要回单4',4,'10米平板车',4,4,'未出发','2026-01-10 20:50:51','016','梁艳','15477788886','24','林文博','粤C23456','车厢尺寸4','13012345678'),(5,'2026-01-10 12:50:51','订单编号5','山东济南','普通货物','重量(kg)5','体积(m³)5','upload/jiedanxinxi_huowutupian5.jpg,upload/jiedanxinxi_huowutupian6.jpg,upload/jiedanxinxi_huowutupian7.jpg','装货地址5','送货地址5','期望装货时间5','是否需要回单5',5,'12米集装箱车',5,5,'未出发','2026-01-10 20:50:51','013','林达','15744455553','25','徐梦琪','黑Q89012','车厢尺寸5','15187654321'),(6,'2026-01-10 12:50:51','订单编号6','湖北江夏','冷链货物','重量(kg)6','体积(m³)6','upload/jiedanxinxi_huowutupian6.jpg,upload/jiedanxinxi_huowutupian7.jpg,upload/jiedanxinxi_huowutupian8.jpg','装货地址6','送货地址6','期望装货时间6','是否需要回单6',6,'13米高栏车',6,6,'未出发','2026-01-10 20:50:51','002','刘芳','13922223332','27','高雨欣','川F89012','车厢尺寸6','13890123456'),(7,'2026-01-10 12:50:51','订单编号7','泰州','普通货物','重量(kg)7','体积(m³)7','upload/jiedanxinxi_huowutupian7.jpg,upload/jiedanxinxi_huowutupian8.jpg,upload/jiedanxinxi_huowutupian1.jpg','装货地址7','送货地址7','期望装货时间7','是否需要回单7',7,'12米集装箱车',7,7,'未出发','2026-01-10 20:50:51','009','郑明','13199990009','23','赵思雨','冀N78901','车厢尺寸7','13187654321'),(8,'2026-01-10 12:50:51','订单编号8','江苏苏州','危险品','重量(kg)8','体积(m³)8','upload/jiedanxinxi_huowutupian8.jpg,upload/jiedanxinxi_huowutupian1.jpg,upload/jiedanxinxi_huowutupian2.jpg','装货地址8','送货地址8','期望装货时间8','是否需要回单8',8,'10米平板车',8,8,'未出发','2026-01-10 20:50:51','018','邓琪','15299900008','21','梁行高','陕J56789','车厢尺寸8','15012345678');
/*!40000 ALTER TABLE `jiedanxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quxiaodingdan`
--

DROP TABLE IF EXISTS `quxiaodingdan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quxiaodingdan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `quyu` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区域',
  `huowuleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货物类型',
  `zhongliang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '重量(kg)',
  `tiji` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '体积(m³)',
  `huowutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '货物图片',
  `zhuanghuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '装货地址',
  `songhuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '送货地址',
  `qiwangzhuanghuoshijian` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '期望装货时间',
  `shifouxuyaohuidan` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否需要回单',
  `licheng` double DEFAULT NULL COMMENT '里程',
  `chexing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车型',
  `jiage` double DEFAULT NULL COMMENT '每公里价格(元)',
  `yue` double DEFAULT NULL COMMENT '运费',
  `quxiaoyuanyin` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '取消原因',
  `quxiaoshijian` datetime DEFAULT NULL COMMENT '取消时间',
  `huozhuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主账号',
  `huozhuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主姓名',
  `lianxifangshi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='取消订单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quxiaodingdan`
--

LOCK TABLES `quxiaodingdan` WRITE;
/*!40000 ALTER TABLE `quxiaodingdan` DISABLE KEYS */;
INSERT INTO `quxiaodingdan` VALUES (1,'2026-01-10 12:50:51','订单编号1','安徽石台','普通货物','重量(kg)1','体积(m³)1','upload/quxiaodingdan_huowutupian1.jpg,upload/quxiaodingdan_huowutupian2.jpg,upload/quxiaodingdan_huowutupian3.jpg','装货地址1','送货地址1','期望装货时间1','是否需要回单1',1,'9.6米厢式车',1,1,'取消原因1','2026-01-10 20:50:51','006','赵静','13466667776'),(2,'2026-01-10 12:50:51','订单编号2','河北高阳','普通货物','重量(kg)2','体积(m³)2','upload/quxiaodingdan_huowutupian2.jpg,upload/quxiaodingdan_huowutupian3.jpg,upload/quxiaodingdan_huowutupian4.jpg','装货地址2','送货地址2','期望装货时间2','是否需要回单2',2,'7.8米高栏车',2,2,'取消原因2','2026-01-10 20:50:51','003','张伟','13733334443'),(3,'2026-01-10 12:50:51','订单编号3','山东烟台','普通货物','重量(kg)3','体积(m³)3','upload/quxiaodingdan_huowutupian3.jpg,upload/quxiaodingdan_huowutupian4.jpg,upload/quxiaodingdan_huowutupian5.jpg','装货地址3','送货地址3','期望装货时间3','是否需要回单3',3,'9.6米平板车',3,3,'取消原因3','2026-01-10 20:50:51','007','孙浩','13377778887'),(4,'2026-01-10 12:50:51','订单编号4','河北南宫','冷链货物','重量(kg)4','体积(m³)4','upload/quxiaodingdan_huowutupian4.jpg,upload/quxiaodingdan_huowutupian5.jpg,upload/quxiaodingdan_huowutupian6.jpg','装货地址4','送货地址4','期望装货时间4','是否需要回单4',4,'10米平板车',4,4,'取消原因4','2026-01-10 20:50:51','016','梁艳','15477788886'),(5,'2026-01-10 12:50:51','订单编号5','山东济南','普通货物','重量(kg)5','体积(m³)5','upload/quxiaodingdan_huowutupian5.jpg,upload/quxiaodingdan_huowutupian6.jpg,upload/quxiaodingdan_huowutupian7.jpg','装货地址5','送货地址5','期望装货时间5','是否需要回单5',5,'12米集装箱车',5,5,'取消原因5','2026-01-10 20:50:51','013','林达','15744455553'),(6,'2026-01-10 12:50:51','订单编号6','湖北江夏','冷链货物','重量(kg)6','体积(m³)6','upload/quxiaodingdan_huowutupian6.jpg,upload/quxiaodingdan_huowutupian7.jpg,upload/quxiaodingdan_huowutupian8.jpg','装货地址6','送货地址6','期望装货时间6','是否需要回单6',6,'13米高栏车',6,6,'取消原因6','2026-01-10 20:50:51','002','刘芳','13922223332'),(7,'2026-01-10 12:50:51','订单编号7','泰州','普通货物','重量(kg)7','体积(m³)7','upload/quxiaodingdan_huowutupian7.jpg,upload/quxiaodingdan_huowutupian8.jpg,upload/quxiaodingdan_huowutupian1.jpg','装货地址7','送货地址7','期望装货时间7','是否需要回单7',7,'12米集装箱车',7,7,'取消原因7','2026-01-10 20:50:51','009','郑明','13199990009'),(8,'2026-01-10 12:50:51','订单编号8','江苏苏州','危险品','重量(kg)8','体积(m³)8','upload/quxiaodingdan_huowutupian8.jpg,upload/quxiaodingdan_huowutupian1.jpg,upload/quxiaodingdan_huowutupian2.jpg','装货地址8','送货地址8','期望装货时间8','是否需要回单8',8,'10米平板车',8,8,'取消原因8','2026-01-10 20:50:51','018','邓琪','15299900008');
/*!40000 ALTER TABLE `quxiaodingdan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quyu`
--

DROP TABLE IF EXISTS `quyu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quyu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `quyu` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '区域',
  PRIMARY KEY (`id`),
  UNIQUE KEY `quyu` (`quyu`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='区域';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quyu`
--

LOCK TABLES `quyu` WRITE;
/*!40000 ALTER TABLE `quyu` DISABLE KEYS */;
INSERT INTO `quyu` VALUES (1,'2026-01-10 12:50:51','安徽石台'),(2,'2026-01-10 12:50:51','河北高阳'),(3,'2026-01-10 12:50:51','山东烟台'),(4,'2026-01-10 12:50:51','河北南宫'),(5,'2026-01-10 12:50:51','山东济南'),(6,'2026-01-10 12:50:51','湖北江夏'),(7,'2026-01-10 12:50:51','泰州'),(8,'2026-01-10 12:50:51','江苏苏州');
/*!40000 ALTER TABLE `quyu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensitivewords`
--

DROP TABLE IF EXISTS `sensitivewords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sensitivewords` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `content` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '草,尼玛,你大爷' COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='敏感词';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensitivewords`
--

LOCK TABLES `sensitivewords` WRITE;
/*!40000 ALTER TABLE `sensitivewords` DISABLE KEYS */;
INSERT INTO `sensitivewords` VALUES (1,'2026-01-10 12:50:52','草,尼玛,你大爷');
/*!40000 ALTER TABLE `sensitivewords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shouhuoxinxi`
--

DROP TABLE IF EXISTS `shouhuoxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shouhuoxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `quyu` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区域',
  `huowuleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货物类型',
  `zhongliang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '重量(kg)',
  `tiji` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '体积(m³)',
  `zhuanghuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '装货地址',
  `songhuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '送货地址',
  `qiwangzhuanghuoshijian` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '期望装货时间',
  `shifouxuyaohuidan` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否需要回单',
  `licheng` double DEFAULT NULL COMMENT '里程',
  `chexing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车型',
  `jiage` double DEFAULT NULL COMMENT '每公里价格(元)',
  `yue` double DEFAULT NULL COMMENT '运费',
  `xiehuotupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '卸货图片',
  `querenshijian` datetime DEFAULT NULL COMMENT '确认时间',
  `huozhuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主账号',
  `huozhuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主姓名',
  `lianxifangshi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系方式',
  `sijizhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机账号',
  `sijixingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机姓名',
  `chepai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车牌',
  `chexiangchicun` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车厢尺寸',
  `shoujihao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='收货信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shouhuoxinxi`
--

LOCK TABLES `shouhuoxinxi` WRITE;
/*!40000 ALTER TABLE `shouhuoxinxi` DISABLE KEYS */;
INSERT INTO `shouhuoxinxi` VALUES (1,'2026-01-10 12:50:52','订单编号1','安徽石台','普通货物','重量(kg)1','体积(m³)1','装货地址1','送货地址1','期望装货时间1','是否需要回单1',1,'9.6米厢式车',1,1,'upload/shouhuoxinxi_儿童绘本1.jpg,upload/shouhuoxinxi_儿童绘本2.jpg,upload/shouhuoxinxi_儿童绘本3.jpg','2026-01-10 20:50:52','006','赵静','13466667776','26','马子轩','京A12345','车厢尺寸1','13567890123'),(2,'2026-01-10 12:50:52','订单编号2','河北高阳','普通货物','重量(kg)2','体积(m³)2','装货地址2','送货地址2','期望装货时间2','是否需要回单2',2,'7.8米高栏车',2,2,'upload/shouhuoxinxi_五金工具1.jpg,upload/shouhuoxinxi_五金工具2.jpg,upload/shouhuoxinxi_五金工具3.jpg','2026-01-10 20:50:52','003','张伟','13733334443','28','周宇恒','鲁G45678','车厢尺寸2','13023456789'),(3,'2026-01-10 12:50:52','订单编号3','山东烟台','普通货物','重量(kg)3','体积(m³)3','装货地址3','送货地址3','期望装货时间3','是否需要回单3',3,'9.6米平板车',3,3,'upload/shouhuoxinxi_办公电脑1.jpg,upload/shouhuoxinxi_办公电脑2.jpg,upload/shouhuoxinxi_办公电脑3.jpg','2026-01-10 20:50:52','007','孙浩','13377778887','22','陈浩然','云T45678','车厢尺寸3','13290123456'),(4,'2026-01-10 12:50:52','订单编号4','河北南宫','冷链货物','重量(kg)4','体积(m³)4','装货地址4','送货地址4','期望装货时间4','是否需要回单4',4,'10米平板车',4,4,'upload/shouhuoxinxi_海鲜大礼包1.jpg,upload/shouhuoxinxi_海鲜大礼包2.jpg,upload/shouhuoxinxi_海鲜大礼包3.jpg','2026-01-10 20:50:52','016','梁艳','15477788886','24','林文博','粤C23456','车厢尺寸4','13012345678'),(5,'2026-01-10 12:50:52','订单编号5','山东济南','普通货物','重量(kg)5','体积(m³)5','装货地址5','送货地址5','期望装货时间5','是否需要回单5',5,'12米集装箱车',5,5,'upload/shouhuoxinxi_钢筋1.jpg,upload/shouhuoxinxi_钢筋2.jpg,upload/shouhuoxinxi_钢筋3.jpg','2026-01-10 20:50:52','013','林达','15744455553','25','徐梦琪','黑Q89012','车厢尺寸5','15187654321'),(6,'2026-01-10 12:50:52','订单编号6','湖北江夏','冷链货物','重量(kg)6','体积(m³)6','装货地址6','送货地址6','期望装货时间6','是否需要回单6',6,'13米高栏车',6,6,'upload/shouhuoxinxi_草莓1.jpg,upload/shouhuoxinxi_草莓2.jpg,upload/shouhuoxinxi_草莓3.jpg','2026-01-10 20:50:52','002','刘芳','13922223332','27','高雨欣','川F89012','车厢尺寸6','13890123456'),(7,'2026-01-10 12:50:52','订单编号7','泰州','普通货物','重量(kg)7','体积(m³)7','装货地址7','送货地址7','期望装货时间7','是否需要回单7',7,'12米集装箱车',7,7,'upload/shouhuoxinxi_电线电缆1.jpg,upload/shouhuoxinxi_电线电缆2.jpg,upload/shouhuoxinxi_电线电缆3.jpg','2026-01-10 20:50:52','009','郑明','13199990009','23','赵思雨','冀N78901','车厢尺寸7','13187654321'),(8,'2026-01-10 12:50:52','订单编号8','江苏苏州','危险品','重量(kg)8','体积(m³)8','装货地址8','送货地址8','期望装货时间8','是否需要回单8',8,'10米平板车',8,8,'upload/shouhuoxinxi_农药1.jpg,upload/shouhuoxinxi_农药2.jpg,upload/shouhuoxinxi_农药3.jpg','2026-01-10 20:50:52','018','邓琪','15299900008','21','梁行高','陕J56789','车厢尺寸8','15012345678');
/*!40000 ALTER TABLE `shouhuoxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `siji`
--

DROP TABLE IF EXISTS `siji`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `siji` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `sijizhanghao` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '司机账号',
  `sijixingming` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '司机姓名',
  `mima` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `xingbie` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `jiashizheng` longtext COLLATE utf8mb4_unicode_ci COMMENT '驾驶证',
  `xingshizheng` longtext COLLATE utf8mb4_unicode_ci COMMENT '行驶证',
  `chepai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车牌',
  `chexing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车型',
  `zaizhong` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '载重',
  `chexiangchicun` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车厢尺寸',
  `shoujihao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `touxiang` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `yue` double DEFAULT NULL COMMENT '余额',
  `sfsh` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COLLATE utf8mb4_unicode_ci COMMENT '审核回复',
  `pquestion` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密保问题',
  `panswer` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密保答案',
  `status` int(11) DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sijizhanghao` (`sijizhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='司机';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `siji`
--

LOCK TABLES `siji` WRITE;
/*!40000 ALTER TABLE `siji` DISABLE KEYS */;
INSERT INTO `siji` VALUES (21,'2026-01-10 12:50:51','26','马子轩','e10adc3949ba59abbe56e057f20f883e','男','','','京A12345','9.6米厢式车','载重1','车厢尺寸1','13567890123','upload/siji_touxiang1.jpg',1,'是','','密保问题1','密保答案1',0),(22,'2026-01-10 12:50:51','28','周宇恒','e10adc3949ba59abbe56e057f20f883e','男','','','鲁G45678','7.8米高栏车','载重2','车厢尺寸2','13023456789','upload/siji_touxiang2.jpg',2,'是','','密保问题2','密保答案2',0),(23,'2026-01-10 12:50:51','22','陈浩然','e10adc3949ba59abbe56e057f20f883e','男','','','云T45678','9.6米平板车','载重3','车厢尺寸3','13290123456','upload/siji_touxiang3.jpg',3,'是','','密保问题3','密保答案3',0),(24,'2026-01-10 12:50:51','24','林文博','e10adc3949ba59abbe56e057f20f883e','男','','','粤C23456','10米平板车','载重4','车厢尺寸4','13012345678','upload/siji_touxiang4.jpg',4,'是','','密保问题4','密保答案4',0),(25,'2026-01-10 12:50:51','25','徐梦琪','e10adc3949ba59abbe56e057f20f883e','女','','','黑Q89012','12米集装箱车','载重5','车厢尺寸5','15187654321','upload/siji_touxiang5.jpg',5,'是','','密保问题5','密保答案5',0),(26,'2026-01-10 12:50:51','27','高雨欣','e10adc3949ba59abbe56e057f20f883e','女','','','川F89012','13米高栏车','载重6','车厢尺寸6','13890123456','upload/siji_touxiang6.jpg',6,'是','','密保问题6','密保答案6',0),(27,'2026-01-10 12:50:51','23','赵思雨','e10adc3949ba59abbe56e057f20f883e','女','','','冀N78901','12米集装箱车','载重7','车厢尺寸7','13187654321','upload/siji_touxiang7.jpg',7,'是','','密保问题7','密保答案7',0),(28,'2026-01-10 12:50:51','21','梁行高','e10adc3949ba59abbe56e057f20f883e','男','','','陕J56789','10米平板车','载重8','车厢尺寸8','15012345678','upload/siji_touxiang8.jpg',8,'是','','密保问题8','密保答案8',0);
/*!40000 ALTER TABLE `siji` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storeup`
--

DROP TABLE IF EXISTS `storeup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storeup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `refid` bigint(20) DEFAULT NULL COMMENT '商品id',
  `tablename` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '表名',
  `name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `picture` longtext COLLATE utf8mb4_unicode_ci COMMENT '图片',
  `type` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '1' COMMENT '类型',
  `inteltype` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '推荐类型',
  `remark` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='收藏表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storeup`
--

LOCK TABLES `storeup` WRITE;
/*!40000 ALTER TABLE `storeup` DISABLE KEYS */;
/*!40000 ALTER TABLE `storeup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `syslog`
--

DROP TABLE IF EXISTS `syslog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `syslog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `operation` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户操作',
  `method` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '请求方法',
  `params` longtext COLLATE utf8mb4_unicode_ci COMMENT '请求参数',
  `time` bigint(20) DEFAULT NULL COMMENT '请求时长(毫秒)',
  `ip` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'IP地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `syslog`
--

LOCK TABLES `syslog` WRITE;
/*!40000 ALTER TABLE `syslog` DISABLE KEYS */;
/*!40000 ALTER TABLE `syslog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tixianjilu`
--

DROP TABLE IF EXISTS `tixianjilu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tixianjilu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yue` double DEFAULT NULL COMMENT '提现金额',
  `tixianshijian` datetime DEFAULT NULL COMMENT '提现时间',
  `sijizhanghao` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机账号',
  `sijixingming` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机姓名',
  `shoujihao` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `touxiang` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `zhanghuyue` double DEFAULT NULL COMMENT '账户余额',
  `sfsh` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COLLATE utf8mb4_unicode_ci COMMENT '审核回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='提现记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tixianjilu`
--

LOCK TABLES `tixianjilu` WRITE;
/*!40000 ALTER TABLE `tixianjilu` DISABLE KEYS */;
INSERT INTO `tixianjilu` VALUES (1,'2026-01-10 12:50:52',1,'2026-01-10 20:50:52','26','马子轩','13567890123','upload/tixianjilu_touxiang1.jpg,upload/tixianjilu_touxiang2.jpg,upload/tixianjilu_touxiang3.jpg',1,'是',''),(2,'2026-01-10 12:50:52',2,'2026-01-10 20:50:52','28','周宇恒','13023456789','upload/tixianjilu_touxiang2.jpg,upload/tixianjilu_touxiang3.jpg,upload/tixianjilu_touxiang4.jpg',2,'是',''),(3,'2026-01-10 12:50:52',3,'2026-01-10 20:50:52','22','陈浩然','13290123456','upload/tixianjilu_touxiang3.jpg,upload/tixianjilu_touxiang4.jpg,upload/tixianjilu_touxiang5.jpg',3,'是',''),(4,'2026-01-10 12:50:52',4,'2026-01-10 20:50:52','24','林文博','13012345678','upload/tixianjilu_touxiang4.jpg,upload/tixianjilu_touxiang5.jpg,upload/tixianjilu_touxiang6.jpg',4,'是',''),(5,'2026-01-10 12:50:52',5,'2026-01-10 20:50:52','25','徐梦琪','15187654321','upload/tixianjilu_touxiang5.jpg,upload/tixianjilu_touxiang6.jpg,upload/tixianjilu_touxiang7.jpg',5,'是',''),(6,'2026-01-10 12:50:52',6,'2026-01-10 20:50:52','27','高雨欣','13890123456','upload/tixianjilu_touxiang6.jpg,upload/tixianjilu_touxiang7.jpg,upload/tixianjilu_touxiang8.jpg',6,'是',''),(7,'2026-01-10 12:50:52',7,'2026-01-10 20:50:52','23','赵思雨','13187654321','upload/tixianjilu_touxiang7.jpg,upload/tixianjilu_touxiang8.jpg,upload/tixianjilu_touxiang1.jpg',7,'是',''),(8,'2026-01-10 12:50:52',8,'2026-01-10 20:50:52','21','梁行高','15012345678','upload/tixianjilu_touxiang8.jpg,upload/tixianjilu_touxiang1.jpg,upload/tixianjilu_touxiang2.jpg',8,'是','');
/*!40000 ALTER TABLE `tixianjilu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(255) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `role` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '管理员' COMMENT '角色',
  `image` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2026-01-10 12:50:52','admin','admin','管理员','upload/image1.jpg');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xiehuoxinxi`
--

DROP TABLE IF EXISTS `xiehuoxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xiehuoxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `quyu` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区域',
  `huowuleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货物类型',
  `zhongliang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '重量(kg)',
  `tiji` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '体积(m³)',
  `zhuanghuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '装货地址',
  `songhuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '送货地址',
  `qiwangzhuanghuoshijian` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '期望装货时间',
  `shifouxuyaohuidan` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否需要回单',
  `licheng` double DEFAULT NULL COMMENT '里程',
  `chexing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车型',
  `jiage` double DEFAULT NULL COMMENT '每公里价格(元)',
  `yue` double DEFAULT NULL COMMENT '运费',
  `xiehuotupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '卸货图片',
  `xiehuoshijian` datetime DEFAULT NULL COMMENT '卸货时间',
  `shouhuoqueren` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货确认',
  `huozhuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主账号',
  `huozhuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主姓名',
  `lianxifangshi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系方式',
  `sijizhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机账号',
  `sijixingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机姓名',
  `chepai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车牌',
  `chexiangchicun` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车厢尺寸',
  `shoujihao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='卸货信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xiehuoxinxi`
--

LOCK TABLES `xiehuoxinxi` WRITE;
/*!40000 ALTER TABLE `xiehuoxinxi` DISABLE KEYS */;
INSERT INTO `xiehuoxinxi` VALUES (1,'2026-01-10 12:50:52','订单编号1','安徽石台','普通货物','重量(kg)1','体积(m³)1','装货地址1','送货地址1','期望装货时间1','是否需要回单1',1,'9.6米厢式车',1,1,'upload/xiehuoxinxi_儿童绘本1.jpg,upload/xiehuoxinxi_儿童绘本2.jpg,upload/xiehuoxinxi_儿童绘本3.jpg','2026-01-10 20:50:52','已确认','006','赵静','13466667776','26','马子轩','京A12345','车厢尺寸1','13567890123'),(2,'2026-01-10 12:50:52','订单编号2','河北高阳','普通货物','重量(kg)2','体积(m³)2','装货地址2','送货地址2','期望装货时间2','是否需要回单2',2,'7.8米高栏车',2,2,'upload/xiehuoxinxi_五金工具1.jpg,upload/xiehuoxinxi_五金工具2.jpg,upload/xiehuoxinxi_五金工具3.jpg','2026-01-10 20:50:52','已确认','003','张伟','13733334443','28','周宇恒','鲁G45678','车厢尺寸2','13023456789'),(3,'2026-01-10 12:50:52','订单编号3','山东烟台','普通货物','重量(kg)3','体积(m³)3','装货地址3','送货地址3','期望装货时间3','是否需要回单3',3,'9.6米平板车',3,3,'upload/xiehuoxinxi_办公电脑1.jpg,upload/xiehuoxinxi_办公电脑2.jpg,upload/xiehuoxinxi_办公电脑3.jpg','2026-01-10 20:50:52','已确认','007','孙浩','13377778887','22','陈浩然','云T45678','车厢尺寸3','13290123456'),(4,'2026-01-10 12:50:52','订单编号4','河北南宫','冷链货物','重量(kg)4','体积(m³)4','装货地址4','送货地址4','期望装货时间4','是否需要回单4',4,'10米平板车',4,4,'upload/xiehuoxinxi_海鲜大礼包1.jpg,upload/xiehuoxinxi_海鲜大礼包2.jpg,upload/xiehuoxinxi_海鲜大礼包3.jpg','2026-01-10 20:50:52','已确认','016','梁艳','15477788886','24','林文博','粤C23456','车厢尺寸4','13012345678'),(5,'2026-01-10 12:50:52','订单编号5','山东济南','普通货物','重量(kg)5','体积(m³)5','装货地址5','送货地址5','期望装货时间5','是否需要回单5',5,'12米集装箱车',5,5,'upload/xiehuoxinxi_钢筋1.jpg,upload/xiehuoxinxi_钢筋2.jpg,upload/xiehuoxinxi_钢筋3.jpg','2026-01-10 20:50:52','已确认','013','林达','15744455553','25','徐梦琪','黑Q89012','车厢尺寸5','15187654321'),(6,'2026-01-10 12:50:52','订单编号6','湖北江夏','冷链货物','重量(kg)6','体积(m³)6','装货地址6','送货地址6','期望装货时间6','是否需要回单6',6,'13米高栏车',6,6,'upload/xiehuoxinxi_草莓1.jpg,upload/xiehuoxinxi_草莓2.jpg,upload/xiehuoxinxi_草莓3.jpg','2026-01-10 20:50:52','已确认','002','刘芳','13922223332','27','高雨欣','川F89012','车厢尺寸6','13890123456'),(7,'2026-01-10 12:50:52','订单编号7','泰州','普通货物','重量(kg)7','体积(m³)7','装货地址7','送货地址7','期望装货时间7','是否需要回单7',7,'12米集装箱车',7,7,'upload/xiehuoxinxi_电线电缆1.jpg,upload/xiehuoxinxi_电线电缆2.jpg,upload/xiehuoxinxi_电线电缆3.jpg','2026-01-10 20:50:52','已确认','009','郑明','13199990009','23','赵思雨','冀N78901','车厢尺寸7','13187654321'),(8,'2026-01-10 12:50:52','订单编号8','江苏苏州','危险品','重量(kg)8','体积(m³)8','装货地址8','送货地址8','期望装货时间8','是否需要回单8',8,'10米平板车',8,8,'upload/xiehuoxinxi_农药1.jpg,upload/xiehuoxinxi_农药2.jpg,upload/xiehuoxinxi_农药3.jpg','2026-01-10 20:50:52','已确认','018','邓琪','15299900008','21','梁行高','陕J56789','车厢尺寸8','15012345678');
/*!40000 ALTER TABLE `xiehuoxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yichangchuli`
--

DROP TABLE IF EXISTS `yichangchuli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yichangchuli` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `quyu` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区域',
  `huowuleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货物类型',
  `zhongliang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '重量(kg)',
  `tiji` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '体积(m³)',
  `huowutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '货物图片',
  `zhuanghuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '装货地址',
  `songhuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '送货地址',
  `qiwangzhuanghuoshijian` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '期望装货时间',
  `shifouxuyaohuidan` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否需要回单',
  `licheng` double DEFAULT NULL COMMENT '里程',
  `chexing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车型',
  `jiage` double DEFAULT NULL COMMENT '每公里价格(元)',
  `yue` double DEFAULT NULL COMMENT '运费',
  `yichangleixing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '异常类型',
  `yichangfankui` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '异常反馈',
  `chulifangan` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '处理方案',
  `chulishijian` datetime DEFAULT NULL COMMENT '处理时间',
  `huozhuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主账号',
  `huozhuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主姓名',
  `lianxifangshi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系方式',
  `sijizhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机账号',
  `sijixingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机姓名',
  `chepai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车牌',
  `chexiangchicun` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车厢尺寸',
  `shoujihao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='异常处理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yichangchuli`
--

LOCK TABLES `yichangchuli` WRITE;
/*!40000 ALTER TABLE `yichangchuli` DISABLE KEYS */;
INSERT INTO `yichangchuli` VALUES (1,'2026-01-10 12:50:52','订单编号1','安徽石台','普通货物','重量(kg)1','体积(m³)1','upload/yichangchuli_huowutupian1.jpg,upload/yichangchuli_huowutupian2.jpg,upload/yichangchuli_huowutupian3.jpg','装货地址1','送货地址1','期望装货时间1','是否需要回单1',1,'9.6米厢式车',1,1,'异常类型1','异常反馈1','处理方案1','2026-01-10 20:50:52','006','赵静','13466667776','26','马子轩','京A12345','车厢尺寸1','13567890123'),(2,'2026-01-10 12:50:52','订单编号2','河北高阳','普通货物','重量(kg)2','体积(m³)2','upload/yichangchuli_huowutupian2.jpg,upload/yichangchuli_huowutupian3.jpg,upload/yichangchuli_huowutupian4.jpg','装货地址2','送货地址2','期望装货时间2','是否需要回单2',2,'7.8米高栏车',2,2,'异常类型2','异常反馈2','处理方案2','2026-01-10 20:50:52','003','张伟','13733334443','28','周宇恒','鲁G45678','车厢尺寸2','13023456789'),(3,'2026-01-10 12:50:52','订单编号3','山东烟台','普通货物','重量(kg)3','体积(m³)3','upload/yichangchuli_huowutupian3.jpg,upload/yichangchuli_huowutupian4.jpg,upload/yichangchuli_huowutupian5.jpg','装货地址3','送货地址3','期望装货时间3','是否需要回单3',3,'9.6米平板车',3,3,'异常类型3','异常反馈3','处理方案3','2026-01-10 20:50:52','007','孙浩','13377778887','22','陈浩然','云T45678','车厢尺寸3','13290123456'),(4,'2026-01-10 12:50:52','订单编号4','河北南宫','冷链货物','重量(kg)4','体积(m³)4','upload/yichangchuli_huowutupian4.jpg,upload/yichangchuli_huowutupian5.jpg,upload/yichangchuli_huowutupian6.jpg','装货地址4','送货地址4','期望装货时间4','是否需要回单4',4,'10米平板车',4,4,'异常类型4','异常反馈4','处理方案4','2026-01-10 20:50:52','016','梁艳','15477788886','24','林文博','粤C23456','车厢尺寸4','13012345678'),(5,'2026-01-10 12:50:52','订单编号5','山东济南','普通货物','重量(kg)5','体积(m³)5','upload/yichangchuli_huowutupian5.jpg,upload/yichangchuli_huowutupian6.jpg,upload/yichangchuli_huowutupian7.jpg','装货地址5','送货地址5','期望装货时间5','是否需要回单5',5,'12米集装箱车',5,5,'异常类型5','异常反馈5','处理方案5','2026-01-10 20:50:52','013','林达','15744455553','25','徐梦琪','黑Q89012','车厢尺寸5','15187654321'),(6,'2026-01-10 12:50:52','订单编号6','湖北江夏','冷链货物','重量(kg)6','体积(m³)6','upload/yichangchuli_huowutupian6.jpg,upload/yichangchuli_huowutupian7.jpg,upload/yichangchuli_huowutupian8.jpg','装货地址6','送货地址6','期望装货时间6','是否需要回单6',6,'13米高栏车',6,6,'异常类型6','异常反馈6','处理方案6','2026-01-10 20:50:52','002','刘芳','13922223332','27','高雨欣','川F89012','车厢尺寸6','13890123456'),(7,'2026-01-10 12:50:52','订单编号7','泰州','普通货物','重量(kg)7','体积(m³)7','upload/yichangchuli_huowutupian7.jpg,upload/yichangchuli_huowutupian8.jpg,upload/yichangchuli_huowutupian1.jpg','装货地址7','送货地址7','期望装货时间7','是否需要回单7',7,'12米集装箱车',7,7,'异常类型7','异常反馈7','处理方案7','2026-01-10 20:50:52','009','郑明','13199990009','23','赵思雨','冀N78901','车厢尺寸7','13187654321'),(8,'2026-01-10 12:50:52','订单编号8','江苏苏州','危险品','重量(kg)8','体积(m³)8','upload/yichangchuli_huowutupian8.jpg,upload/yichangchuli_huowutupian1.jpg,upload/yichangchuli_huowutupian2.jpg','装货地址8','送货地址8','期望装货时间8','是否需要回单8',8,'10米平板车',8,8,'异常类型8','异常反馈8','处理方案8','2026-01-10 20:50:52','018','邓琪','15299900008','21','梁行高','陕J56789','车厢尺寸8','15012345678');
/*!40000 ALTER TABLE `yichangchuli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yichangfankui`
--

DROP TABLE IF EXISTS `yichangfankui`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yichangfankui` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `quyu` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区域',
  `huowuleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货物类型',
  `zhongliang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '重量(kg)',
  `tiji` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '体积(m³)',
  `huowutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '货物图片',
  `zhuanghuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '装货地址',
  `songhuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '送货地址',
  `qiwangzhuanghuoshijian` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '期望装货时间',
  `shifouxuyaohuidan` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否需要回单',
  `licheng` double DEFAULT NULL COMMENT '里程',
  `chexing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车型',
  `jiage` double DEFAULT NULL COMMENT '每公里价格(元)',
  `yue` double DEFAULT NULL COMMENT '运费',
  `yichangleixing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '异常类型',
  `yichangfankui` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '异常反馈',
  `fankuishijian` datetime DEFAULT NULL COMMENT '反馈时间',
  `chulizhuangtai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '处理状态',
  `huozhuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主账号',
  `huozhuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主姓名',
  `lianxifangshi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系方式',
  `sijizhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机账号',
  `sijixingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机姓名',
  `chepai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车牌',
  `chexiangchicun` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车厢尺寸',
  `shoujihao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='异常反馈';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yichangfankui`
--

LOCK TABLES `yichangfankui` WRITE;
/*!40000 ALTER TABLE `yichangfankui` DISABLE KEYS */;
INSERT INTO `yichangfankui` VALUES (1,'2026-01-10 12:50:51','订单编号1','安徽石台','普通货物','重量(kg)1','体积(m³)1','upload/yichangfankui_huowutupian1.jpg,upload/yichangfankui_huowutupian2.jpg,upload/yichangfankui_huowutupian3.jpg','装货地址1','送货地址1','期望装货时间1','是否需要回单1',1,'9.6米厢式车',1,1,'装货延迟','异常反馈1','2026-01-10 20:50:51','已处理','006','赵静','13466667776','26','马子轩','京A12345','车厢尺寸1','13567890123'),(2,'2026-01-10 12:50:51','订单编号2','河北高阳','普通货物','重量(kg)2','体积(m³)2','upload/yichangfankui_huowutupian2.jpg,upload/yichangfankui_huowutupian3.jpg,upload/yichangfankui_huowutupian4.jpg','装货地址2','送货地址2','期望装货时间2','是否需要回单2',2,'7.8米高栏车',2,2,'装货延迟','异常反馈2','2026-01-10 20:50:51','已处理','003','张伟','13733334443','28','周宇恒','鲁G45678','车厢尺寸2','13023456789'),(3,'2026-01-10 12:50:51','订单编号3','山东烟台','普通货物','重量(kg)3','体积(m³)3','upload/yichangfankui_huowutupian3.jpg,upload/yichangfankui_huowutupian4.jpg,upload/yichangfankui_huowutupian5.jpg','装货地址3','送货地址3','期望装货时间3','是否需要回单3',3,'9.6米平板车',3,3,'装货延迟','异常反馈3','2026-01-10 20:50:51','已处理','007','孙浩','13377778887','22','陈浩然','云T45678','车厢尺寸3','13290123456'),(4,'2026-01-10 12:50:51','订单编号4','河北南宫','冷链货物','重量(kg)4','体积(m³)4','upload/yichangfankui_huowutupian4.jpg,upload/yichangfankui_huowutupian5.jpg,upload/yichangfankui_huowutupian6.jpg','装货地址4','送货地址4','期望装货时间4','是否需要回单4',4,'10米平板车',4,4,'装货延迟','异常反馈4','2026-01-10 20:50:51','已处理','016','梁艳','15477788886','24','林文博','粤C23456','车厢尺寸4','13012345678'),(5,'2026-01-10 12:50:51','订单编号5','山东济南','普通货物','重量(kg)5','体积(m³)5','upload/yichangfankui_huowutupian5.jpg,upload/yichangfankui_huowutupian6.jpg,upload/yichangfankui_huowutupian7.jpg','装货地址5','送货地址5','期望装货时间5','是否需要回单5',5,'12米集装箱车',5,5,'装货延迟','异常反馈5','2026-01-10 20:50:51','已处理','013','林达','15744455553','25','徐梦琪','黑Q89012','车厢尺寸5','15187654321'),(6,'2026-01-10 12:50:51','订单编号6','湖北江夏','冷链货物','重量(kg)6','体积(m³)6','upload/yichangfankui_huowutupian6.jpg,upload/yichangfankui_huowutupian7.jpg,upload/yichangfankui_huowutupian8.jpg','装货地址6','送货地址6','期望装货时间6','是否需要回单6',6,'13米高栏车',6,6,'装货延迟','异常反馈6','2026-01-10 20:50:51','已处理','002','刘芳','13922223332','27','高雨欣','川F89012','车厢尺寸6','13890123456'),(7,'2026-01-10 12:50:51','订单编号7','泰州','普通货物','重量(kg)7','体积(m³)7','upload/yichangfankui_huowutupian7.jpg,upload/yichangfankui_huowutupian8.jpg,upload/yichangfankui_huowutupian1.jpg','装货地址7','送货地址7','期望装货时间7','是否需要回单7',7,'12米集装箱车',7,7,'装货延迟','异常反馈7','2026-01-10 20:50:51','已处理','009','郑明','13199990009','23','赵思雨','冀N78901','车厢尺寸7','13187654321'),(8,'2026-01-10 12:50:51','订单编号8','江苏苏州','危险品','重量(kg)8','体积(m³)8','upload/yichangfankui_huowutupian8.jpg,upload/yichangfankui_huowutupian1.jpg,upload/yichangfankui_huowutupian2.jpg','装货地址8','送货地址8','期望装货时间8','是否需要回单8',8,'10米平板车',8,8,'装货延迟','异常反馈8','2026-01-10 20:50:51','已处理','018','邓琪','15299900008','21','梁行高','陕J56789','车厢尺寸8','15012345678');
/*!40000 ALTER TABLE `yichangfankui` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yichangshangbao`
--

DROP TABLE IF EXISTS `yichangshangbao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yichangshangbao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `quyu` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区域',
  `huowuleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货物类型',
  `zhongliang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '重量(kg)',
  `tiji` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '体积(m³)',
  `huowutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '货物图片',
  `zhuanghuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '装货地址',
  `songhuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '送货地址',
  `qiwangzhuanghuoshijian` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '期望装货时间',
  `shifouxuyaohuidan` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否需要回单',
  `licheng` double DEFAULT NULL COMMENT '里程',
  `chexing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车型',
  `jiage` double DEFAULT NULL COMMENT '每公里价格(元)',
  `yue` double DEFAULT NULL COMMENT '运费',
  `yichangleixing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '异常类型',
  `yichangfankui` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '异常反馈',
  `shangbaoshijian` datetime DEFAULT NULL COMMENT '上报时间',
  `shangbaozhuangtai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '上报状态',
  `huozhuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主账号',
  `huozhuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主姓名',
  `lianxifangshi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系方式',
  `sijizhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机账号',
  `sijixingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机姓名',
  `chepai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车牌',
  `chexiangchicun` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车厢尺寸',
  `shoujihao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='异常上报';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yichangshangbao`
--

LOCK TABLES `yichangshangbao` WRITE;
/*!40000 ALTER TABLE `yichangshangbao` DISABLE KEYS */;
INSERT INTO `yichangshangbao` VALUES (1,'2026-01-10 12:50:51','订单编号1','安徽石台','普通货物','重量(kg)1','体积(m³)1','upload/yichangshangbao_huowutupian1.jpg,upload/yichangshangbao_huowutupian2.jpg,upload/yichangshangbao_huowutupian3.jpg','装货地址1','送货地址1','期望装货时间1','是否需要回单1',1,'9.6米厢式车',1,1,'交通堵塞','异常反馈1','2026-01-10 20:50:51','已处理','006','赵静','13466667776','26','马子轩','京A12345','车厢尺寸1','13567890123'),(2,'2026-01-10 12:50:51','订单编号2','河北高阳','普通货物','重量(kg)2','体积(m³)2','upload/yichangshangbao_huowutupian2.jpg,upload/yichangshangbao_huowutupian3.jpg,upload/yichangshangbao_huowutupian4.jpg','装货地址2','送货地址2','期望装货时间2','是否需要回单2',2,'7.8米高栏车',2,2,'交通堵塞','异常反馈2','2026-01-10 20:50:51','已处理','003','张伟','13733334443','28','周宇恒','鲁G45678','车厢尺寸2','13023456789'),(3,'2026-01-10 12:50:51','订单编号3','山东烟台','普通货物','重量(kg)3','体积(m³)3','upload/yichangshangbao_huowutupian3.jpg,upload/yichangshangbao_huowutupian4.jpg,upload/yichangshangbao_huowutupian5.jpg','装货地址3','送货地址3','期望装货时间3','是否需要回单3',3,'9.6米平板车',3,3,'交通堵塞','异常反馈3','2026-01-10 20:50:51','已处理','007','孙浩','13377778887','22','陈浩然','云T45678','车厢尺寸3','13290123456'),(4,'2026-01-10 12:50:51','订单编号4','河北南宫','冷链货物','重量(kg)4','体积(m³)4','upload/yichangshangbao_huowutupian4.jpg,upload/yichangshangbao_huowutupian5.jpg,upload/yichangshangbao_huowutupian6.jpg','装货地址4','送货地址4','期望装货时间4','是否需要回单4',4,'10米平板车',4,4,'交通堵塞','异常反馈4','2026-01-10 20:50:51','已处理','016','梁艳','15477788886','24','林文博','粤C23456','车厢尺寸4','13012345678'),(5,'2026-01-10 12:50:51','订单编号5','山东济南','普通货物','重量(kg)5','体积(m³)5','upload/yichangshangbao_huowutupian5.jpg,upload/yichangshangbao_huowutupian6.jpg,upload/yichangshangbao_huowutupian7.jpg','装货地址5','送货地址5','期望装货时间5','是否需要回单5',5,'12米集装箱车',5,5,'交通堵塞','异常反馈5','2026-01-10 20:50:51','已处理','013','林达','15744455553','25','徐梦琪','黑Q89012','车厢尺寸5','15187654321'),(6,'2026-01-10 12:50:51','订单编号6','湖北江夏','冷链货物','重量(kg)6','体积(m³)6','upload/yichangshangbao_huowutupian6.jpg,upload/yichangshangbao_huowutupian7.jpg,upload/yichangshangbao_huowutupian8.jpg','装货地址6','送货地址6','期望装货时间6','是否需要回单6',6,'13米高栏车',6,6,'交通堵塞','异常反馈6','2026-01-10 20:50:51','已处理','002','刘芳','13922223332','27','高雨欣','川F89012','车厢尺寸6','13890123456'),(7,'2026-01-10 12:50:51','订单编号7','泰州','普通货物','重量(kg)7','体积(m³)7','upload/yichangshangbao_huowutupian7.jpg,upload/yichangshangbao_huowutupian8.jpg,upload/yichangshangbao_huowutupian1.jpg','装货地址7','送货地址7','期望装货时间7','是否需要回单7',7,'12米集装箱车',7,7,'交通堵塞','异常反馈7','2026-01-10 20:50:51','已处理','009','郑明','13199990009','23','赵思雨','冀N78901','车厢尺寸7','13187654321'),(8,'2026-01-10 12:50:51','订单编号8','江苏苏州','危险品','重量(kg)8','体积(m³)8','upload/yichangshangbao_huowutupian8.jpg,upload/yichangshangbao_huowutupian1.jpg,upload/yichangshangbao_huowutupian2.jpg','装货地址8','送货地址8','期望装货时间8','是否需要回单8',8,'10米平板车',8,8,'交通堵塞','异常反馈8','2026-01-10 20:50:51','已处理','018','邓琪','15299900008','21','梁行高','陕J56789','车厢尺寸8','15012345678');
/*!40000 ALTER TABLE `yichangshangbao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yunlixinxi`
--

DROP TABLE IF EXISTS `yunlixinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yunlixinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `changpaoxianlu` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '常跑线路',
  `huowuleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货物类型',
  `qiwangyunjiafanwei` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '期望运价范围',
  `zhuangtai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '状态',
  `cheliangtupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '车辆图片',
  `sijizhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机账号',
  `sijixingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机姓名',
  `chepai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车牌',
  `chexing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车型',
  `zaizhong` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '载重',
  `chexiangchicun` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车厢尺寸',
  `shoujihao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `discussnum` int(11) DEFAULT '0' COMMENT '评论数',
  `storeupnum` int(11) DEFAULT '0' COMMENT '收藏数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='运力信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yunlixinxi`
--

LOCK TABLES `yunlixinxi` WRITE;
/*!40000 ALTER TABLE `yunlixinxi` DISABLE KEYS */;
INSERT INTO `yunlixinxi` VALUES (1,'2026-01-10 12:50:51','常跑线路1','普通货物','期望运价范围1','空闲','upload/yunlixinxi_cheliangtupian1.jpg,upload/yunlixinxi_cheliangtupian2.jpg,upload/yunlixinxi_cheliangtupian3.jpg','26','马子轩','京A12345','9.6米厢式车','载重1','车厢尺寸1','13567890123','2026-01-10 20:50:51',0,1),(2,'2026-01-10 12:50:51','常跑线路2','普通货物','期望运价范围2','空闲','upload/yunlixinxi_cheliangtupian2.jpg,upload/yunlixinxi_cheliangtupian3.jpg,upload/yunlixinxi_cheliangtupian4.jpg','28','周宇恒','鲁G45678','7.8米高栏车','载重2','车厢尺寸2','13023456789','2026-01-10 20:50:51',0,2),(3,'2026-01-10 12:50:51','常跑线路3','普通货物','期望运价范围3','空闲','upload/yunlixinxi_cheliangtupian3.jpg,upload/yunlixinxi_cheliangtupian4.jpg,upload/yunlixinxi_cheliangtupian5.jpg','22','陈浩然','云T45678','9.6米平板车','载重3','车厢尺寸3','13290123456','2026-01-10 20:50:51',0,3),(4,'2026-01-10 12:50:51','常跑线路4','冷链货物','期望运价范围4','空闲','upload/yunlixinxi_cheliangtupian4.jpg,upload/yunlixinxi_cheliangtupian5.jpg,upload/yunlixinxi_cheliangtupian6.jpg','24','林文博','粤C23456','10米平板车','载重4','车厢尺寸4','13012345678','2026-01-10 20:50:51',0,4),(5,'2026-01-10 12:50:51','常跑线路5','普通货物','期望运价范围5','空闲','upload/yunlixinxi_cheliangtupian5.jpg,upload/yunlixinxi_cheliangtupian6.jpg,upload/yunlixinxi_cheliangtupian7.jpg','25','徐梦琪','黑Q89012','12米集装箱车','载重5','车厢尺寸5','15187654321','2026-01-10 20:50:51',0,5),(6,'2026-01-10 12:50:51','常跑线路6','冷链货物','期望运价范围6','空闲','upload/yunlixinxi_cheliangtupian6.jpg,upload/yunlixinxi_cheliangtupian7.jpg,upload/yunlixinxi_cheliangtupian8.jpg','27','高雨欣','川F89012','13米高栏车','载重6','车厢尺寸6','13890123456','2026-01-10 20:50:51',0,6),(7,'2026-01-10 12:50:51','常跑线路7','普通货物','期望运价范围7','空闲','upload/yunlixinxi_cheliangtupian7.jpg,upload/yunlixinxi_cheliangtupian8.jpg,upload/yunlixinxi_cheliangtupian1.jpg','23','赵思雨','冀N78901','12米集装箱车','载重7','车厢尺寸7','13187654321','2026-01-10 20:50:51',0,7),(8,'2026-01-10 12:50:51','常跑线路8','危险品','期望运价范围8','空闲','upload/yunlixinxi_cheliangtupian8.jpg,upload/yunlixinxi_cheliangtupian1.jpg,upload/yunlixinxi_cheliangtupian2.jpg','21','梁行高','陕J56789','10米平板车','载重8','车厢尺寸8','15012345678','2026-01-10 20:50:51',0,8);
/*!40000 ALTER TABLE `yunlixinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yunshudingdan`
--

DROP TABLE IF EXISTS `yunshudingdan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yunshudingdan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `quyu` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区域',
  `huowuleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货物类型',
  `zhongliang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '重量(kg)',
  `tiji` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '体积(m³)',
  `huowutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '货物图片',
  `zhuanghuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '装货地址',
  `songhuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '送货地址',
  `qiwangzhuanghuoshijian` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '期望装货时间',
  `shifouxuyaohuidan` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否需要回单',
  `licheng` double DEFAULT NULL COMMENT '里程',
  `chexing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车型',
  `jiage` double DEFAULT NULL COMMENT '每公里价格(元)',
  `yue` double DEFAULT NULL COMMENT '运费',
  `dingdanzhuangtai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单状态',
  `fabushijian` datetime DEFAULT NULL COMMENT '发布时间',
  `huozhuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主账号',
  `huozhuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主姓名',
  `lianxifangshi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系方式',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `storeupnum` int(11) DEFAULT '0' COMMENT '收藏数',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dingdanbianhao` (`dingdanbianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='运输订单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yunshudingdan`
--

LOCK TABLES `yunshudingdan` WRITE;
/*!40000 ALTER TABLE `yunshudingdan` DISABLE KEYS */;
INSERT INTO `yunshudingdan` VALUES (1,'2026-01-10 12:50:51','1111111111','安徽石台','普通货物','重量(kg)1','体积(m³)1','upload/yunshudingdan_huowutupian1.jpg,upload/yunshudingdan_huowutupian2.jpg,upload/yunshudingdan_huowutupian3.jpg','装货地址1','送货地址1','期望装货时间1','是',1,'9.6米厢式车',1,1,'已接单','2026-01-10 20:50:51','006','赵静','13466667776','2026-01-10 20:50:51',1),(2,'2026-01-10 12:50:51','2222222222','河北高阳','普通货物','重量(kg)2','体积(m³)2','upload/yunshudingdan_huowutupian2.jpg,upload/yunshudingdan_huowutupian3.jpg,upload/yunshudingdan_huowutupian4.jpg','装货地址2','送货地址2','期望装货时间2','是',2,'7.8米高栏车',2,2,'已接单','2026-01-10 20:50:51','003','张伟','13733334443','2026-01-10 20:50:51',2),(3,'2026-01-10 12:50:51','3333333333','山东烟台','普通货物','重量(kg)3','体积(m³)3','upload/yunshudingdan_huowutupian3.jpg,upload/yunshudingdan_huowutupian4.jpg,upload/yunshudingdan_huowutupian5.jpg','装货地址3','送货地址3','期望装货时间3','是',3,'9.6米平板车',3,3,'已接单','2026-01-10 20:50:51','007','孙浩','13377778887','2026-01-10 20:50:51',3),(4,'2026-01-10 12:50:51','4444444444','河北南宫','冷链货物','重量(kg)4','体积(m³)4','upload/yunshudingdan_huowutupian4.jpg,upload/yunshudingdan_huowutupian5.jpg,upload/yunshudingdan_huowutupian6.jpg','装货地址4','送货地址4','期望装货时间4','是',4,'10米平板车',4,4,'已接单','2026-01-10 20:50:51','016','梁艳','15477788886','2026-01-10 20:50:51',4),(5,'2026-01-10 12:50:51','5555555555','山东济南','普通货物','重量(kg)5','体积(m³)5','upload/yunshudingdan_huowutupian5.jpg,upload/yunshudingdan_huowutupian6.jpg,upload/yunshudingdan_huowutupian7.jpg','装货地址5','送货地址5','期望装货时间5','是',5,'12米集装箱车',5,5,'已接单','2026-01-10 20:50:51','013','林达','15744455553','2026-01-10 20:50:51',5),(6,'2026-01-10 12:50:51','6666666666','湖北江夏','冷链货物','重量(kg)6','体积(m³)6','upload/yunshudingdan_huowutupian6.jpg,upload/yunshudingdan_huowutupian7.jpg,upload/yunshudingdan_huowutupian8.jpg','装货地址6','送货地址6','期望装货时间6','是',6,'13米高栏车',6,6,'已接单','2026-01-10 20:50:51','002','刘芳','13922223332','2026-01-10 20:50:51',6),(7,'2026-01-10 12:50:51','7777777777','泰州','普通货物','重量(kg)7','体积(m³)7','upload/yunshudingdan_huowutupian7.jpg,upload/yunshudingdan_huowutupian8.jpg,upload/yunshudingdan_huowutupian1.jpg','装货地址7','送货地址7','期望装货时间7','是',7,'12米集装箱车',7,7,'已接单','2026-01-10 20:50:51','009','郑明','13199990009','2026-01-10 20:50:51',7),(8,'2026-01-10 12:50:51','8888888888','江苏苏州','危险品','重量(kg)8','体积(m³)8','upload/yunshudingdan_huowutupian8.jpg,upload/yunshudingdan_huowutupian1.jpg,upload/yunshudingdan_huowutupian2.jpg','装货地址8','送货地址8','期望装货时间8','是',8,'10米平板车',8,8,'已接单','2026-01-10 20:50:51','018','邓琪','15299900008','2026-01-10 20:50:51',8);
/*!40000 ALTER TABLE `yunshudingdan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zhuanghuoxinxi`
--

DROP TABLE IF EXISTS `zhuanghuoxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zhuanghuoxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `quyu` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区域',
  `huowuleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货物类型',
  `zhongliang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '重量(kg)',
  `tiji` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '体积(m³)',
  `zhuanghuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '装货地址',
  `songhuodizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '送货地址',
  `qiwangzhuanghuoshijian` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '期望装货时间',
  `shifouxuyaohuidan` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否需要回单',
  `licheng` double DEFAULT NULL COMMENT '里程',
  `chexing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车型',
  `jiage` double DEFAULT NULL COMMENT '每公里价格(元)',
  `yue` double DEFAULT NULL COMMENT '运费',
  `zhuanghuotupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '装货图片',
  `zhuanghuoshijian` datetime DEFAULT NULL COMMENT '装货时间',
  `yunshuzhuangtai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运输状态',
  `huozhuzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主账号',
  `huozhuxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '货主姓名',
  `lianxifangshi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系方式',
  `sijizhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机账号',
  `sijixingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '司机姓名',
  `chepai` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车牌',
  `chexiangchicun` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车厢尺寸',
  `shoujihao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='装货信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zhuanghuoxinxi`
--

LOCK TABLES `zhuanghuoxinxi` WRITE;
/*!40000 ALTER TABLE `zhuanghuoxinxi` DISABLE KEYS */;
INSERT INTO `zhuanghuoxinxi` VALUES (1,'2026-01-10 12:50:51','订单编号1','安徽石台','普通货物','重量(kg)1','体积(m³)1','装货地址1','送货地址1','期望装货时间1','是否需要回单1',1,'9.6米厢式车',1,1,'upload/zhuanghuoxinxi_儿童绘本1.jpg,upload/zhuanghuoxinxi_儿童绘本2.jpg,upload/zhuanghuoxinxi_儿童绘本3.jpg','2026-01-10 20:50:51','已卸货','006','赵静','13466667776','26','马子轩','京A12345','车厢尺寸1','13567890123'),(2,'2026-01-10 12:50:51','订单编号2','河北高阳','普通货物','重量(kg)2','体积(m³)2','装货地址2','送货地址2','期望装货时间2','是否需要回单2',2,'7.8米高栏车',2,2,'upload/zhuanghuoxinxi_五金工具1.jpg,upload/zhuanghuoxinxi_五金工具2.jpg,upload/zhuanghuoxinxi_五金工具3.jpg','2026-01-10 20:50:51','已卸货','003','张伟','13733334443','28','周宇恒','鲁G45678','车厢尺寸2','13023456789'),(3,'2026-01-10 12:50:51','订单编号3','山东烟台','普通货物','重量(kg)3','体积(m³)3','装货地址3','送货地址3','期望装货时间3','是否需要回单3',3,'9.6米平板车',3,3,'upload/zhuanghuoxinxi_办公电脑1.jpg,upload/zhuanghuoxinxi_办公电脑2.jpg,upload/zhuanghuoxinxi_办公电脑3.jpg','2026-01-10 20:50:51','已卸货','007','孙浩','13377778887','22','陈浩然','云T45678','车厢尺寸3','13290123456'),(4,'2026-01-10 12:50:51','订单编号4','河北南宫','冷链货物','重量(kg)4','体积(m³)4','装货地址4','送货地址4','期望装货时间4','是否需要回单4',4,'10米平板车',4,4,'upload/zhuanghuoxinxi_海鲜大礼包1.jpg,upload/zhuanghuoxinxi_海鲜大礼包2.jpg,upload/zhuanghuoxinxi_海鲜大礼包3.jpg','2026-01-10 20:50:51','已卸货','016','梁艳','15477788886','24','林文博','粤C23456','车厢尺寸4','13012345678'),(5,'2026-01-10 12:50:51','订单编号5','山东济南','普通货物','重量(kg)5','体积(m³)5','装货地址5','送货地址5','期望装货时间5','是否需要回单5',5,'12米集装箱车',5,5,'upload/zhuanghuoxinxi_钢筋1.jpg,upload/zhuanghuoxinxi_钢筋2.jpg,upload/zhuanghuoxinxi_钢筋3.jpg','2026-01-10 20:50:51','已卸货','013','林达','15744455553','25','徐梦琪','黑Q89012','车厢尺寸5','15187654321'),(6,'2026-01-10 12:50:51','订单编号6','湖北江夏','冷链货物','重量(kg)6','体积(m³)6','装货地址6','送货地址6','期望装货时间6','是否需要回单6',6,'13米高栏车',6,6,'upload/zhuanghuoxinxi_草莓1.jpg,upload/zhuanghuoxinxi_草莓2.jpg,upload/zhuanghuoxinxi_草莓3.jpg','2026-01-10 20:50:51','已卸货','002','刘芳','13922223332','27','高雨欣','川F89012','车厢尺寸6','13890123456'),(7,'2026-01-10 12:50:51','订单编号7','泰州','普通货物','重量(kg)7','体积(m³)7','装货地址7','送货地址7','期望装货时间7','是否需要回单7',7,'12米集装箱车',7,7,'upload/zhuanghuoxinxi_电线电缆1.jpg,upload/zhuanghuoxinxi_电线电缆2.jpg,upload/zhuanghuoxinxi_电线电缆3.jpg','2026-01-10 20:50:51','已卸货','009','郑明','13199990009','23','赵思雨','冀N78901','车厢尺寸7','13187654321'),(8,'2026-01-10 12:50:51','订单编号8','江苏苏州','危险品','重量(kg)8','体积(m³)8','装货地址8','送货地址8','期望装货时间8','是否需要回单8',8,'10米平板车',8,8,'upload/zhuanghuoxinxi_农药1.jpg,upload/zhuanghuoxinxi_农药2.jpg,upload/zhuanghuoxinxi_农药3.jpg','2026-01-10 20:50:51','已卸货','018','邓琪','15299900008','21','梁行高','陕J56789','车厢尺寸8','15012345678');
/*!40000 ALTER TABLE `zhuanghuoxinxi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-01-12 13:59:17
