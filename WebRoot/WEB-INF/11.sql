/*
SQLyog Ultimate v8.32 
MySQL - 5.6.15 : Database - e-health
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`e-health` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `e-health`;

/*Table structure for table `medicinal` */

DROP TABLE IF EXISTS `medicinal`;

CREATE TABLE `medicinal` (
  `id` char(36) NOT NULL,
  `name` varchar(32) NOT NULL,
  `type` varchar(32) DEFAULT NULL,
  `manufacturer` varchar(32) DEFAULT NULL COMMENT '生产厂商',
  `introduction` varchar(128) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `detail` varchar(512) DEFAULT NULL,
  `pubdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `image` varchar(128) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL COMMENT '库存',
  `sales` int(11) DEFAULT NULL COMMENT '销量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `medicinal` */

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` char(36) NOT NULL,
  `order_id` char(36) NOT NULL,
  `price` decimal(10,0) NOT NULL DEFAULT '0',
  `detail` varchar(255) NOT NULL,
  `pubdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` char(36) NOT NULL,
  `is_valid` tinyint(1) DEFAULT '0',
  `is_deal` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order` */

/*Table structure for table `order_detail` */

DROP TABLE IF EXISTS `order_detail`;

CREATE TABLE `order_detail` (
  `id` char(36) NOT NULL,
  `order_id` char(36) NOT NULL,
  `order_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `medicinal_id` char(36) DEFAULT NULL,
  `user_id` char(36) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `amount` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order_detail` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` char(36) NOT NULL,
  `username` varchar(32) DEFAULT NULL,
  `nickname` varchar(32) DEFAULT NULL,
  `truename` varchar(32) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `regdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `comptence` varchar(16) NOT NULL DEFAULT 'user',
  `ip` varchar(30) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`nickname`,`truename`,`email`,`phone`,`password`,`regdate`,`comptence`,`ip`,`address`) values ('41ac5418-203d-4ce2-a150-1c98a4cf70cf','jason','123',NULL,'123','123','ea25932f8f88e9f39f9845d9d706fa8a','2015-04-19 16:13:27','user',NULL,'123'),('f9b79385-6a4a-485a-a159-df97275d55fe','jason,123',NULL,NULL,'13','123','ea25932f8f88e9f39f9845d9d706fa8a','2015-04-19 15:36:59','user',NULL,'2');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
