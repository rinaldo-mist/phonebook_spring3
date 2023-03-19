CREATE DATABASE phonebookdb;

USE phonebookdb;

drop table users;
drop table status;
drop table historyuser;
drop table roles;

CREATE TABLE `users` (
  `id` varchar(36) NOT NULL,
  `name` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `pass` varchar(100) NOT NULL,
  `phone` varchar(16),
  `status` varchar(36) NOT NULL,
  `date_created` datetime NOT NULL,
  `created_by` varchar(36) NOT NULL,
  `date_updated` datetime NOT NULL,
  `updated_by` varchar(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `status` (
  `id` varchar(36) NOT NULL,
  `status` varchar(100) NOT NULL,
  `code` int NOT NULL,
  `date_created` datetime NOT NULL,
  `created_by` varchar(36) NOT NULL,
  `date_updated` datetime NOT NULL,
  `updated_by` varchar(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `historyuser` (
  `id` varchar(36) NOT NULL ,
  `user_id` varchar(36) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` varchar(16) NOT NULL,
  `date_created` datetime NOT NULL,
  `created_by` varchar(36) NOT NULL,
  `date_updated` datetime NOT NULL,
  `updated_by` varchar(36) NOT NULL,
  `status` varchar(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `roles` (
  `id` varchar(36) NOT NULL ,
  `role` varchar(20) NOT NULL,
  `date_created` datetime NOT NULL,
  `created_by` varchar(36) NOT NULL,
  `date_updated` datetime NOT NULL,
  `updated_by` varchar(36) NOT NULL,
  `status` varchar(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO 
	users (id, name, username, pass, phone, status, date_created , created_by, date_updated, updated_by)
VALUES
	('756207ff-c61b-11ed-89a3-50ebf6e6bf42', 'Admin', 'uadmin01pb', 'admin01pb', '+62000999888', 'd966970f-c61b-11ed-89a3-50ebf6e6bf42', NOW(), '756207ff-c61b-11ed-89a3-50ebf6e6bf42', NOW(),'756207ff-c61b-11ed-89a3-50ebf6e6bf42');
	
INSERT INTO 
	status (id, status, code, date_created , created_by , date_updated, updated_by)
VALUES
	('d966970f-c61b-11ed-89a3-50ebf6e6bf42','Active',1, NOW(),'756207ff-c61b-11ed-89a3-50ebf6e6bf42' , NOW(),'756207ff-c61b-11ed-89a3-50ebf6e6bf42'),
	('c083d8f0-c65b-11ed-89a3-50ebf6e6bf42','Inactive',2, NOW(),'756207ff-c61b-11ed-89a3-50ebf6e6bf42' , NOW(),'756207ff-c61b-11ed-89a3-50ebf6e6bf42');