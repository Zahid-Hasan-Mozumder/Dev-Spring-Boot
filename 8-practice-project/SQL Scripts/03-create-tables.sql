USE `personalProject`;

DROP TABLE IF EXISTS `student`;

--
-- Table structure for table `members`
--

CREATE TABLE `student` (
	`id` int NOT NULL AUTO_INCREMENT,
	`first_name` varchar(50) NOT NULL,
	`last_name` varchar(50) NOT NULL,
	`email` varchar(50) NOT NULL,
    `nationality` varchar(50) NOT NULL,
    `major` text NOT NULL,
    `semester` int NOT NULL,
    `section` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=203002001 DEFAULT CHARSET=latin1;
