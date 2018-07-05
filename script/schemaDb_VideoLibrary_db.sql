--
-- Database: `VideoLibrary_db`
--

CREATE DATABASE `VideoLibrary_db`;
-- ENTITIES

--
-- Struttura della tabella `Actor`
--

    CREATE TABLE `VideoLibrary_db`.`Actor` (	        -- RELAZIONI
        `FilmObj` DECIMAL(38, 0), 
        
        `_id` DECIMAL(38,0)
    );
    
    
    CREATE UNIQUE INDEX `Actor_PK` ON `VideoLibrary_db`.`Actor` (`_id`);
    ALTER TABLE `VideoLibrary_db`.`Actor` ADD CONSTRAINT `Actor_PK` PRIMARY KEY (`_id`);
    ALTER TABLE `VideoLibrary_db`.`Actor` MODIFY `_id` DECIMAL(38,0) NOT NULL;

--
-- Struttura della tabella `Film`
--

    CREATE TABLE `VideoLibrary_db`.`Film` (	
        
        `Title` varchar(40),

        
        `Year` date,
        -- RELAZIONI
        
        `_id` DECIMAL(38,0)
    );
    
    
    CREATE UNIQUE INDEX `Film_PK` ON `VideoLibrary_db`.`Film` (`_id`);
    ALTER TABLE `VideoLibrary_db`.`Film` ADD CONSTRAINT `Film_PK` PRIMARY KEY (`_id`);
    ALTER TABLE `VideoLibrary_db`.`Film` MODIFY `_id` DECIMAL(38,0) NOT NULL;


-- RELATIONS

    -- RELATIONS TABLE Actor
    
        
        -- foreign key FilmObj
        ALTER TABLE `VideoLibrary_db`.`Actor` ADD CONSTRAINT `Actor_FilmObj` FOREIGN KEY (`FilmObj`)
        	  REFERENCES `Film` (`_id`) ON DELETE SET NULL;
        
        
        
        



    -- RELATIONS TABLE Film
    
        
        
        
        



INSERT INTO user (`_id`, `username`, `password`, `mail`, `name`, `surname`) VALUES (1, 'admin', '1a1dc91c907325c69271ddf0c944bc72', '', '', '');

CREATE TABLE `VideoLibrary_db`.`roles` (	
    `role` VARCHAR(30), 
    `_user` DECIMAL(38, 0), 
    `_id` DECIMAL(38,0)
);

CREATE UNIQUE INDEX `ROLES_PK` ON `VideoLibrary_db`.`roles` (`_id`);
ALTER TABLE `VideoLibrary_db`.`roles` ADD CONSTRAINT `ROLES_PK` PRIMARY KEY (`_id`);
ALTER TABLE `VideoLibrary_db`.`roles` MODIFY `_id` DECIMAL(38,0) NOT NULL;
ALTER TABLE `VideoLibrary_db`.`roles` ADD CONSTRAINT `ROLES_FK1` FOREIGN KEY (`_user`)
	  REFERENCES `VideoLibrary_db`.`user` (`_id`);

INSERT INTO roles (`role`, `_user`, `_id`) VALUES ('ADMIN', '1', 1);

