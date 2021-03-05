-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 26, 2014 at 10:10 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dashboard`
--

-- --------------------------------------------------------

--
-- Table structure for table `colleges`
--

CREATE TABLE IF NOT EXISTS `colleges` (
  `college_id` int(11) NOT NULL AUTO_INCREMENT,
  `college` varchar(255) NOT NULL,
  `college_code` varchar(255) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`college_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `colleges`
--

INSERT INTO `colleges` (`college_id`, `college`, `college_code`, `created`) VALUES
(1, 'College of Agricultural Science', 'coasc', '2014-09-22 19:32:42'),
(2, 'College of Business', 'cobus', '2014-09-22 19:32:42'),
(3, 'CEOAS', 'ceoas', '2014-09-22 19:33:01'),
(4, 'College of Education', 'coedu', '2014-09-22 19:33:01'),
(5, 'College of Engineering', 'coeng', '2014-09-22 19:33:24'),
(6, 'College of Forestry ', 'cofor', '2014-09-22 19:33:24'),
(7, 'College of Liberal Arts', 'colar', '2014-09-22 19:33:47'),
(8, 'College of Pharmacy', 'copha', '2014-09-22 19:33:47'),
(9, 'College of Public Health & Human Science', 'cophh', '2014-09-22 19:34:09'),
(10, 'College of Science', 'cosci', '2014-09-22 19:34:09'),
(11, 'College of Veterinary Medicine', 'covme', '2014-09-22 19:34:29'),
(12, 'Graduate School', 'gssho', '2014-09-22 19:34:29'),
(13, 'University Exploratory Study', 'uestu', '2014-09-22 19:34:39');

-- --------------------------------------------------------

--
-- Table structure for table `liason_connection`
--

CREATE TABLE IF NOT EXISTS `liason_connection` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_name` varchar(255) NOT NULL,
  `contact_name` varchar(255) NOT NULL,
  `contact_title` varchar(255) NOT NULL,
  `contact_college` varchar(255) NOT NULL,
  `college_code` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `year` int(11) NOT NULL,
  `purpose` text NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` datetime NOT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=39 ;

--
-- Dumping data for table `liason_connection`
--

INSERT INTO `liason_connection` (`post_id`, `staff_name`, `contact_name`, `contact_title`, `contact_college`, `college_code`, `date`, `year`, `purpose`, `created`, `updated`) VALUES
(15, 'McDonaldM', 'David', 'IT coordinator', 'College of Liberal Arts', 'colar', '09/12/2014', 2014, 'Cool stuff', '2014-09-05 21:05:07', '0000-00-00 00:00:00'),
(16, 'cordesr', 'James', 'Worker', 'College of Business', 'cobus', '09/10/2014', 2014, 'Contacted about building an airship to sail across the Amazon jungle looking for dinosaurs and other palaeontological anomalies.', '2014-09-05 21:05:32', '0000-00-00 00:00:00'),
(17, 'finchr', 'Gilligan', 'First Mate', 'College of Liberal Arts', 'colar', '01/01/2014', 2014, 'S.S. Minnow', '2014-06-05 21:06:06', '0000-00-00 00:00:00'),
(18, 'vasquezd', 'Davey ', 'test ', 'College of Business', 'cobus', '09/07/2014', 2014, 'hello is this done ', '2014-09-07 23:43:12', '0000-00-00 00:00:00'),
(19, 'vasquezd', 'James', 'IT coordinator', 'College of Engineering', 'coeng', '03/02/2014', 2014, 'Well I did some stuff', '2014-09-07 23:46:21', '0000-00-00 00:00:00'),
(20, 'vasquezd', 'test', 'IT coordinator', 'College of Business', 'cobus', '03/08/2014', 2014, 'hi', '2014-09-07 23:46:50', '0000-00-00 00:00:00'),
(21, 'vasquezd', 'david', 'IT coordinator', 'College of Science', 'cosci', '04/01/2014', 2014, 'Please describe the contact.', '2014-09-07 23:50:01', '0000-00-00 00:00:00'),
(22, 'vasquezd', 'david', 'IT coordinator', 'College of Engineering', 'coeng', '07/01/2014', 2014, 'Please describe the contact.', '2014-09-08 23:31:18', '0000-00-00 00:00:00'),
(23, 'vasquezd', 'david', 'IT coordinator', 'College of Business', 'cobus', '09/04/2014', 2014, 'Please describe the contact.', '2014-09-09 23:01:33', '0000-00-00 00:00:00'),
(24, 'vasquezd', 'James', 'Mr Winky', 'College of Business', 'cobus', '09/01/2014', 2014, 'Well, I was hanging with Bill ya know!', '2014-09-10 22:42:08', '0000-00-00 00:00:00'),
(25, 'vasquezd', 'mr wiggles', 'head of things', 'CEOAS', 'ceoas', '08/04/2014', 2014, 'hi', '2014-09-11 20:55:10', '0000-00-00 00:00:00'),
(26, 'vasquezd', 'test', 'test', 'CEOAS', 'ceoas', '02/01/2014', 2015, 'Please describe the contact.', '2014-09-11 20:55:46', '0000-00-00 00:00:00'),
(27, 'vasquezd', 'david', 'IT coordinator', 'College of Engineering', 'coeng', '09/02/2014', 2016, 'tester', '2014-09-17 20:13:43', '0000-00-00 00:00:00'),
(28, 'vasquezd', 'hi', 'IT coordinator', 'College of Business', 'cobus', '09/01/2014', 2014, 'Please describe the contact.', '2014-09-17 21:04:06', '0000-00-00 00:00:00'),
(30, 'vasquezd', 'david', 'hi', 'College of Business', 'cobus', '09/02/2014', 2014, 'Please describe the contact.', '2014-09-17 21:08:48', '0000-00-00 00:00:00'),
(31, 'vasquezd', 'david', 'HOLA HOLA', 'College of Business', 'cobus', '09/01/2014', 2017, 'Please describe the contact.', '2014-09-17 21:12:25', '0000-00-00 00:00:00'),
(37, 'vasquezd', 'hi', 'IT coordinator', 'College of Agricultural Science', 'College of Agricultural Science', '09/10/2014', 2014, 'Please describe the contact.', '2014-09-24 23:12:36', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `user_login`
--

CREATE TABLE IF NOT EXISTS `user_login` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(15) NOT NULL,
  `salt` int(11) NOT NULL,
  `password` varchar(40) NOT NULL,
  UNIQUE KEY `user_id_2` (`user_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `user_login`
--

INSERT INTO `user_login` (`user_id`, `user_name`, `salt`, `password`) VALUES
(1, 'vasquezd', 1409868440, '28ee077e0324b4db2f201189c66204c30d554a5c'),
(3, 'finchr', 1409955731, '3e99e70003b8284d0c99d5c6b1b8416014932d88'),
(4, 'cordesr', 1409955766, '2da5cd39cc583dd2de1f0a696692fde808245f9f'),
(5, 'McDonaldM', 1409955784, '4217f1b404422bab603d9e34f694f179471b1967');

-- --------------------------------------------------------

--
-- Table structure for table `user_profile`
--

CREATE TABLE IF NOT EXISTS `user_profile` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `image_name` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `staff_name` varchar(255) NOT NULL,
  `root_folder` varchar(255) NOT NULL,
  `biography` text NOT NULL,
  `title` varchar(255) NOT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `user_profile`
--

INSERT INTO `user_profile` (`user_id`, `user_name`, `email`, `image_name`, `first_name`, `last_name`, `staff_name`, `root_folder`, `biography`, `title`, `updated`, `created`) VALUES
(1, 'vasquezd', 'vasquezd@onid.orst.edu', 'david.jpg', 'David ', 'Vasquez', '', '', 'Sometime in the early first century B.C., a ship went down in the Mediterranean Sea, just off a Greek island named Antikythera. The wreck itself wasnâ€™t unusual. The island was surrounded by jagged rocks, which likely caused many a boat to disappear back then. But there was something different about this one. The boat contained a trove of statues, jewelry, and â€” most notably â€” what some scholars believe to be the earliest computer known to man.', 'IT', '2014-09-26 20:09:33', '0000-00-00 00:00:00'),
(3, 'finchr', 'rache.finch@oregonstate.edu', 'rachelfinch.jpg', 'Rachel', 'Finch', '', '', '', 'OSU', '2014-09-05 22:23:19', '0000-00-00 00:00:00'),
(4, 'cordesr', 'whitney.cordes@oregonstate.edu', 'whitneycordes.jpg', 'Whitney', 'Cordes', '', '', '', 'OSU', '2014-09-05 22:23:25', '0000-00-00 00:00:00'),
(5, 'McDonaldM', 'Michael.McDonald@oregonstate.edu', 'michael.jpg', 'Michael', 'McDonald', '', '', '', 'OSU', '2014-09-05 22:23:32', '0000-00-00 00:00:00'),
(6, '', '', '', 'David ', 'Vasquez', '', '', 'IT ', 'IT Coordinator', '2014-09-20 20:30:36', '0000-00-00 00:00:00');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
