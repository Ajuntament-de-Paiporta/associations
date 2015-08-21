/*
 mysql -u root -p < db.sql
*/


/*
  database
*/

drop database if exists associations;
create database associations;

use associations;

/*
  tables
*/

DROP TABLE IF EXISTS `association`;

CREATE TABLE `association` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `postalcode` varchar(7) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `longitude` varchar(30) DEFAULT NULL,
  `latitude` varchar(30) DEFAULT NULL,
  `webpage` varchar(100) DEFAULT NULL,
  `facebook` varchar(30) DEFAULT NULL,
  `twitter` varchar(30) DEFAULT NULL,
  `presidentName` varchar(100) DEFAULT NULL,
  `presidentEmail` varchar(20) DEFAULT NULL,
  `presidentPhone` varchar(15) DEFAULT NULL,
  `secretaryName` varchar(100) DEFAULT NULL,
  `secretaryEmail` varchar(20) DEFAULT NULL,
  `secretaryPhone` varchar(15) DEFAULT NULL,
  `active` INT DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  id int auto_increment,
  email varchar(256),
  password varchar(100),
  rol int,
  token_id varchar(100),
  token_creation_time timestamp,
  primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
*/


/*
  DB users
*/

drop user 'admin_assoc'@'localhost';
create user 'admin_assoc'@'localhost' identified by 'assoc2015';
grant all privileges on associations.* to 'admin_assoc'@'localhost';

drop user 'user_assoc'@'localhost';
create user 'user_assoc'@'localhost';
grant select on associations.association to 'user_assoc'@'localhost';

