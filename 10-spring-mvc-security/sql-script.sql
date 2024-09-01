CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;
		
        DROP TABLE IF EXISTS `authorities`;
        DROP TABLE IF EXISTS `users`;
		DROP TABLE IF EXISTS `roles`;
		DROP TABLE IF EXISTS `members`;

		--
		-- Table structure for table `users`
		--

		CREATE TABLE `members` (
  		`user_id` varchar(50) NOT NULL,
  		`pw` char(68) NOT NULL,
  		`activated` tinyint NOT NULL,
  		PRIMARY KEY (`user_id`)
		) ENGINE=InnoDB DEFAULT CHARSET=latin1;

		--
		-- Inserting data for table `users`
		--

		INSERT INTO `members` 
		VALUES 
		('john','{bcrypt}$2a$10$D7ZvRk5jAU0WYb6vTdhIf.8KYShuw4zdZh2.yhtLM3sxbCT2cQnWq',1),
		('mary','{bcrypt}$2a$10$D7ZvRk5jAU0WYb6vTdhIf.8KYShuw4zdZh2.yhtLM3sxbCT2cQnWq',1),
		('susan','{bcrypt}$2a$10$D7ZvRk5jAU0WYb6vTdhIf.8KYShuw4zdZh2.yhtLM3sxbCT2cQnWq',1);

		-- INSERT INTO `users` 
		-- VALUES 
		-- ('john','{noop}test123',1),
		-- ('mary','{noop}test123',1),
		-- ('susan','{noop}test123',1);
        
		--
		-- Table structure for table `authorities`
		--

		CREATE TABLE `roles` (
  		`user_id` varchar(50) NOT NULL,
  		`role` varchar(50) NOT NULL,
  		UNIQUE KEY `roles_idx_1` (`user_id`,`role`),
  		CONSTRAINT `roles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
		) ENGINE=InnoDB DEFAULT CHARSET=latin1;

		--
		-- Inserting data for table `authorities`
		--

		INSERT INTO `roles` 
		VALUES 
		('john','ROLE_EMPLOYEE'),
		('mary','ROLE_EMPLOYEE'),
		('mary','ROLE_MANAGER'),
		('susan','ROLE_EMPLOYEE'),
		('susan','ROLE_MANAGER'),
		('susan','ROLE_ADMIN');