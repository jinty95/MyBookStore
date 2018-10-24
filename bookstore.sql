/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.5.61 : Database - bookstore
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookstore` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookstore`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `aid` int(11) NOT NULL,
  `aname` char(20) NOT NULL,
  `password` char(20) NOT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`aid`,`aname`,`password`) values 
(1,'jinty','123');

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `bid` char(32) NOT NULL,
  `bname` char(32) NOT NULL,
  `price` decimal(5,1) NOT NULL,
  `image` varchar(200) DEFAULT NULL,
  `cid` char(32) NOT NULL,
  `author` char(20) NOT NULL,
  `version` char(10) NOT NULL,
  `publish` char(20) NOT NULL,
  `del` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`bid`,`bname`,`price`,`image`,`cid`,`author`,`version`,`publish`,`del`) values 
('1','JavaSE入门',20.0,'/Image/16105.jpg','1','张三','1.0','清华出版社',0),
('10','JavaWeb技术',55.5,'/Image/16106.jpg','2','陆一','4.0','商务出版社',0),
('11','JavaWeb入门',36.9,'/Image/16106.jpg','2','牛牛','5.5','人民出版社',0),
('12','SSH三大框架',88.8,'/Image/16107.jpg','3','陈陈','6.0','教育出版社',0),
('2','Java核心技术',58.0,'/Image/16105.jpg','1','李四','2.0','人民出版社',0),
('3','JavaEE入门',48.0,'/Image/16106.jpg','2','王五','3.0','教育出版社',0),
('4','JavaEE开发',78.0,'/Image/16106.jpg','2','赵六','4.0','新华出版社',0),
('5','3天精通Spring',50.0,'/Image/16107.jpg','3','周七','5.0','北大出版社',0),
('6','Struts2深入解析',45.0,'/Image/16107.jpg','3','钱八','6.0','广工出版社',0),
('7','HeadFirstJava',49.4,'/Image/16105.jpg','1','陈九','1.0','电力出版社',0),
('8','Java技术手册',39.9,'/Image/16105.jpg','1','史十','2.0','广东出版社',0),
('9','Hibernate入门',45.5,'/Image/16107.jpg','3','刘二','3.0','上海出版社',0);

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `cid` char(32) NOT NULL,
  `cname` char(32) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`cid`,`cname`) values 
('1','JavaSE'),
('2','JavaEE'),
('3','JavaFW');

/*Table structure for table `orderitem` */

DROP TABLE IF EXISTS `orderitem`;

CREATE TABLE `orderitem` (
  `iid` char(32) NOT NULL,
  `count` int(11) DEFAULT NULL,
  `subtotal` decimal(10,2) DEFAULT NULL,
  `oid` char(32) NOT NULL,
  `bid` char(32) NOT NULL,
  PRIMARY KEY (`iid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orderitem` */

insert  into `orderitem`(`iid`,`count`,`subtotal`,`oid`,`bid`) values 
('03D548ECD4FD44608991F97517DC0615',5,250.00,'D395F71EEF0749AB97C6CE46A05500E6','5'),
('09A81EF34A21435CB083908BAA1D6BC6',1,20.00,'D395F71EEF0749AB97C6CE46A05500E6','1'),
('11378E5E2A09433B851932259E3AC851',1,36.00,'554BDD73314A4077846308F0C310FE22','11'),
('11EC6DBE7BBC4BD289E7E2EAB78610E8',12,240.00,'77674BBC87BE4CD49D71DA9E2707719F','1'),
('3106C9AA51814D2A8DB5C9A86852DC9C',1,39.00,'D22E11B4CE9F433BB864EA95692677CA','8'),
('44411E5EA5BE4C5192D975464C3FB927',1,45.00,'D4E3BCF484164DE89D25E3B30E23C787','6'),
('4526A895038841B0975C16CAF3292B9C',1,45.00,'D22E11B4CE9F433BB864EA95692677CA','6'),
('48953A01FC8243419199831CEE2DE007',1,48.00,'D22E11B4CE9F433BB864EA95692677CA','3'),
('4C48523AC4C74BAEB401ACCD81516BA1',1,45.00,'BFCD02EB64544D6DBB7018B20AA6B349','9'),
('6DCD46F6601F405A99EA1B73E1F2561E',1,36.00,'7B92111D1B4E4A4F9A58C64BA584D8B3','11'),
('8753D35449CE4414A2CB8DAF1E06C624',1,45.00,'77674BBC87BE4CD49D71DA9E2707719F','9'),
('9A335997F1194517B4361A15C8D105B9',1,45.00,'554BDD73314A4077846308F0C310FE22','6'),
('9FAC230BBA604D5D84D4F9B32AA0359E',1,20.00,'554BDD73314A4077846308F0C310FE22','1'),
('AC0F70B4E89C4CCB902757BE13354BD6',1,78.00,'BFCD02EB64544D6DBB7018B20AA6B349','4'),
('B179D1943A07414FA83D9C90475D56A7',1,36.00,'D4E3BCF484164DE89D25E3B30E23C787','11'),
('B8234354E4EB474A8211EE6B17ACDF88',1,45.00,'35B1766F2B9C4299885CBEB5D0BCF57F','9'),
('F53F7F07530E4B3988DCFB3FEAD248A3',1,49.00,'35B1766F2B9C4299885CBEB5D0BCF57F','7'),
('F83D8A78ADC94A8DAED6EFBB70B1CCA9',3,108.00,'77674BBC87BE4CD49D71DA9E2707719F','11'),
('FA8DDACAF5A04715985FE2E45A5AA1D1',1,58.00,'BFCD02EB64544D6DBB7018B20AA6B349','2');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `oid` char(32) NOT NULL,
  `ordertime` datetime DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `ostate` smallint(1) DEFAULT NULL,
  `uid` char(32) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`oid`,`ordertime`,`total`,`ostate`,`uid`,`address`) values 
('35B1766F2B9C4299885CBEB5D0BCF57F','2018-08-28 14:31:11',94.00,1,'BFD83751E2BA4245A29585EB6990C04A',NULL),
('554BDD73314A4077846308F0C310FE22','2018-09-02 15:09:23',101.00,1,'BFD83751E2BA4245A29585EB6990C04A',NULL),
('77674BBC87BE4CD49D71DA9E2707719F','2018-09-03 13:39:37',393.00,1,'260AC843FFF9410CB26EAEE6E3C3D4A4',NULL),
('7B92111D1B4E4A4F9A58C64BA584D8B3','2018-08-28 14:30:40',36.00,2,'260AC843FFF9410CB26EAEE6E3C3D4A4',NULL),
('BFCD02EB64544D6DBB7018B20AA6B349','2018-08-28 13:37:51',181.00,4,'BFD83751E2BA4245A29585EB6990C04A',NULL),
('D22E11B4CE9F433BB864EA95692677CA','2018-08-28 13:37:24',132.00,4,'260AC843FFF9410CB26EAEE6E3C3D4A4',NULL),
('D395F71EEF0749AB97C6CE46A05500E6','2018-08-28 15:04:27',270.00,1,'260AC843FFF9410CB26EAEE6E3C3D4A4',NULL),
('D4E3BCF484164DE89D25E3B30E23C787','2018-08-28 14:30:52',81.00,1,'260AC843FFF9410CB26EAEE6E3C3D4A4',NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uid` char(32) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `code` char(64) NOT NULL,
  `state` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`uid`,`username`,`password`,`email`,`code`,`state`) values 
('BFD83751E2BA4245A29585EB6990C04A','jinty','123','1812154599@qq.com','D60B74ADB3894507B40CD48AA530F784646E540B949F4E81A8BD11AC3398BB97',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
