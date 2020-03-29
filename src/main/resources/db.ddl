CREATE TABLE `users` (
  `idusers` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`idusers`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `emp` (
  `eid` int NOT NULL AUTO_INCREMENT,
  `ename` varchar(255) DEFAULT NULL,
  `esal` int DEFAULT NULL,
  `empType` varchar(255) DEFAULT NULL,
  `designation` varchar(45) DEFAULT NULL,
  `dob` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `userRole` varchar(45) DEFAULT NULL,
  `techStack` varchar(255) DEFAULT NULL,
  `created_by` int NOT NULL,
  PRIMARY KEY (`eid`),
  KEY `empFromUser_idx` (`created_by`),
  CONSTRAINT `empFrmUsr` FOREIGN KEY (`created_by`) REFERENCES `users` (`idusers`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO `employee`.`users` (`username`, `password`, `role`) VALUES ('admin', 'admin', 'hr');
