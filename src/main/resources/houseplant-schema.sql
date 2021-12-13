DROP TABLE IF EXISTS `houseplants` CASCADE;

CREATE TABLE `houseplants` (
	`id` INTEGER PRIMARY KEY AUTO_INCREMENT,
	`plant_name` VARCHAR(255),
	`water` VARCHAR(255),
	`sunlight` VARCHAR(255),
	`humidity` VARCHAR(255),
	`quantity` INTEGER
);