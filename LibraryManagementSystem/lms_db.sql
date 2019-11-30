/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.1.10-MariaDB : Database - library_management_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`library_management_system` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `library_management_system`;

/*Table structure for table `book_details` */

DROP TABLE IF EXISTS `book_details`;

CREATE TABLE `book_details` (
  `isbn` int(11) NOT NULL AUTO_INCREMENT,
  `book_title` varchar(255) DEFAULT NULL,
  `publication year` date DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `actual no of copies` int(11) DEFAULT NULL,
  `issue_time` int(11) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `barcode` varchar(255) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`isbn`),
  CONSTRAINT `book_details_ibfk_1` FOREIGN KEY (`isbn`) REFERENCES `book_issue_details` (`issue_id`),
  CONSTRAINT `book_details_ibfk_2` FOREIGN KEY (`isbn`) REFERENCES `challan_details` (`challan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `book_details` */

/*Table structure for table `book_issue_details` */

DROP TABLE IF EXISTS `book_issue_details`;

CREATE TABLE `book_issue_details` (
  `issue_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  `issued_by` varchar(255) DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  CONSTRAINT `book_issue_details_ibfk_1` FOREIGN KEY (`issue_id`) REFERENCES `student_details` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `book_issue_details` */

/*Table structure for table `category_details` */

DROP TABLE IF EXISTS `category_details`;

CREATE TABLE `category_details` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `cateogory_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`),
  CONSTRAINT `category_details_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `book_details` (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `category_details` */

/*Table structure for table `challan_details` */

DROP TABLE IF EXISTS `challan_details`;

CREATE TABLE `challan_details` (
  `challan_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `isbn` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `price` double(8,4) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `fees_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`challan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `challan_details` */

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `department` */

/*Table structure for table `fees` */

DROP TABLE IF EXISTS `fees`;

CREATE TABLE `fees` (
  `fees_id` int(11) NOT NULL AUTO_INCREMENT,
  `per_day` decimal(16,4) DEFAULT NULL,
  `base_day` decimal(16,4) DEFAULT NULL,
  PRIMARY KEY (`fees_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `fees` */

/*Table structure for table `staff_details` */

DROP TABLE IF EXISTS `staff_details`;

CREATE TABLE `staff_details` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `is_admin` enum('1') DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `staff_details_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `challan_details` (`challan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `staff_details` */

/*Table structure for table `student_details` */

DROP TABLE IF EXISTS `student_details`;

CREATE TABLE `student_details` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(255) DEFAULT NULL,
  `gender` enum('male') DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `issue_id` int(11) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `contact_no` int(15) DEFAULT NULL,
  `cnic` int(15) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `roll_no` varchar(255) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  CONSTRAINT `student_details_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `challan_details` (`challan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `student_details` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
