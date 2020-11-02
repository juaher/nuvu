/*
SQLyog Community v12.4.1 (64 bit)
MySQL - 5.7.21-log : Database - nuvu
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`nuvu` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;

USE `nuvu`;

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `documento` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `nombres` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `celular` bigint(20) NOT NULL,
  `email` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `fechacreacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuariocreacion` bigint(20) NOT NULL,
  `fechamodificacion` timestamp NULL DEFAULT NULL,
  `usuariomodificacion` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `usuariocreacion` (`usuariocreacion`),
  KEY `usuariomodificacion` (`usuariomodificacion`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`usuariocreacion`) REFERENCES `usuario` (`id`),
  CONSTRAINT `cliente_ibfk_2` FOREIGN KEY (`usuariomodificacion`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Table structure for table `franquicia` */

DROP TABLE IF EXISTS `franquicia`;

CREATE TABLE `franquicia` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `franquicia` */

insert  into `franquicia`(`id`,`nombre`) values 
(1,'MasterCard'),
(2,'Visa'),
(3,'American Express'),
(4,'Diners Club');

/*Table structure for table `tarjetacredito` */

DROP TABLE IF EXISTS `tarjetacredito`;

CREATE TABLE `tarjetacredito` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `clienteid` bigint(20) NOT NULL,
  `numero` bigint(20) NOT NULL,
  `fechavencimiento` varchar(7) COLLATE utf8_spanish_ci NOT NULL,
  `cvv` int(3) NOT NULL,
  `franquiciaid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `franquiciaid` (`franquiciaid`),
  KEY `clienteid` (`clienteid`),
  CONSTRAINT `tarjetacredito_ibfk_1` FOREIGN KEY (`franquiciaid`) REFERENCES `franquicia` (`id`),
  CONSTRAINT `tarjetacredito_ibfk_2` FOREIGN KEY (`clienteid`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `usuario` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `usuario` */

insert  into `usuario`(`id`,`username`,`password`,`usuario`) values 
(1,'admin','827ccb0eea8a706c4c34a16891f84e7b','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
