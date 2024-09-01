USE `library`;

DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `members`;
DROP TABLE IF EXISTS `librarians`;
DROP TABLE IF EXISTS `admins`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
	`id` int NOT NULL AUTO_INCREMENT,
	`first_name` varchar(50) NOT NULL,
	`last_name` varchar(50) NOT NULL,
	`email` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=latin1;

--
-- Table structure for table `librarians`
--

CREATE TABLE `librarians` (
	`id` int NOT NULL AUTO_INCREMENT,
	`first_name` varchar(50) NOT NULL,
	`last_name` varchar(50) NOT NULL,
	`email` varchar(50) NOT NULL,
    `username` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2000000 DEFAULT CHARSET=latin1;

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
	`id` int NOT NULL AUTO_INCREMENT,
	`first_name` varchar(50) NOT NULL,
	`last_name` varchar(50) NOT NULL,
	`email` varchar(50) NOT NULL,
    `username` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3000000 DEFAULT CHARSET=latin1;

--
-- Table structure for table `users`
--
-- Default password : pass@1234

CREATE TABLE `users` (
	`username` varchar(50) NOT NULL,
	`password` char(68) NOT NULL DEFAULT '{bcrypt}$2a$10$Q8YxK.CZ3Q.iutBYT1rAV.LTWLi98xSpJ.LMhQakJxdTyGqe7YeFy',
	`enabled` tinyint NOT NULL DEFAULT 1,
    PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `username` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `authorities5_idx_1` (`username`,`role`),
  CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Triggers for updating users table when librarians and admins table is updated
--

DELIMITER $$

CREATE TRIGGER `after_librarian_insert`
AFTER INSERT ON `librarians`
FOR EACH ROW
BEGIN
    INSERT INTO `users` (`username`) 
    VALUES (NEW.`username`)
    ON DUPLICATE KEY UPDATE `username` = `username`;

    INSERT INTO `roles` (`username`, `role`)
    VALUES (NEW.`username`, 'ROLE_LIBRARIAN')
    ON DUPLICATE KEY UPDATE `role` = 'ROLE_LIBRARIAN';
END$$

CREATE TRIGGER `after_librarian_update`
AFTER UPDATE ON `librarians`
FOR EACH ROW
BEGIN
    UPDATE `users` SET `username` = NEW.`username`
    WHERE `username` = OLD.`username`;

    UPDATE `roles` SET `role` = 'ROLE_LIBRARIAN'
    WHERE `username` = NEW.`username`;
END$$

CREATE TRIGGER `after_librarian_delete`
AFTER DELETE ON `librarians`
FOR EACH ROW
BEGIN
    DELETE FROM `users` WHERE `username` = OLD.`username`;
    DELETE FROM `roles` WHERE `username` = OLD.`username`;
END$$

CREATE TRIGGER `after_admin_insert`
AFTER INSERT ON `admins`
FOR EACH ROW
BEGIN
    INSERT INTO `users` (`username`) 
    VALUES (NEW.`username`)
    ON DUPLICATE KEY UPDATE `username` = `username`;

    INSERT INTO `roles` (`username`, `role`)
    VALUES (NEW.`username`, 'ROLE_ADMIN')
    ON DUPLICATE KEY UPDATE `role` = 'ROLE_ADMIN';
END$$

CREATE TRIGGER `after_admin_update`
AFTER UPDATE ON `admins`
FOR EACH ROW
BEGIN
    UPDATE `users` SET `username` = NEW.`username`
    WHERE `username` = OLD.`username`;

    UPDATE `roles` SET `role` = 'ROLE_ADMIN'
    WHERE `username` = NEW.`username`;
END$$

CREATE TRIGGER `after_admin_delete`
AFTER DELETE ON `admins`
FOR EACH ROW
BEGIN
    DELETE FROM `users` WHERE `username` = OLD.`username`;
    DELETE FROM `roles` WHERE `username` = OLD.`username`;
END$$

DELIMITER ;

--
-- Inserting first ever admin's data into the admin table
--

INSERT INTO `admins`
VALUES
(3000001, 'Zahid Hasan', 'Mozumder', 'jahidhasanmozumder@gmail.com', 'zhm');