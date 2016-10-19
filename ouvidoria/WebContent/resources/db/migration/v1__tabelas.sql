CREATE DATABASE pokemapa;

USE pokemapa;

CREATE TABLE `pokemapa`.`pais` (
  	`id` INT NOT NULL AUTO_INCREMENT,
  	`nome` VARCHAR(100) NOT NULL,
  	PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

ALTER TABLE `pokemapa`.`pais` 
	ADD COLUMN `sigla` VARCHAR(3) NOT NULL AFTER `nome`;

CREATE TABLE `pokemapa`.`estado` (
  	`id` INT NOT NULL AUTO_INCREMENT,
  	`nome` VARCHAR(60) NOT NULL,
  	`uf` VARCHAR(3) NOT NULL,
  	`pais_id` INT(11) NOT NULL,
  	PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
  
ALTER TABLE `pokemapa`.`estado` 
	ADD INDEX `estado_pais_idx` (`pais_id` ASC);
	
ALTER TABLE `pokemapa`.`estado` 
	ADD CONSTRAINT `estado_pais`
  	FOREIGN KEY (`pais_id`)
  	REFERENCES `pokemapa`.`pais` (`id`)
  	ON DELETE NO ACTION
  	ON UPDATE NO ACTION;

CREATE TABLE `pokemapa`.`cidade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(150) NOT NULL,
  `estado_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
  
ALTER TABLE `pokemapa`.`cidade` 
	ADD INDEX `cidade_estado_idx` (`estado_id` ASC);
	
ALTER TABLE `pokemapa`.`cidade` 
	ADD CONSTRAINT `cidade_estado`
  	FOREIGN KEY (`estado_id`)
  	REFERENCES `pokemapa`.`estado` (`id`)
  	ON DELETE NO ACTION
  	ON UPDATE NO ACTION;

CREATE TABLE `pokemapa`.`tipo` (
  	`id` INT NOT NULL AUTO_INCREMENT,
  	`nome` VARCHAR(45) NOT NULL,
  	PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
  
CREATE TABLE `pokemapa`.`pokeplace` (
  	`id` INT NOT NULL AUTO_INCREMENT,
  	`nome` VARCHAR(150) NOT NULL,
  	`latitude` DOUBLE NOT NULL,
  	`longitude` DOUBLE NOT NULL,
  	`imagem` BLOB NULL,
  	`cidade_id` INT NOT NULL,
  	`tipo_id` INT NOT NULL,
  	`nomeimagem` VARCHAR(15) NULL,
  	PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
  
ALTER TABLE `pokemapa`.`pokeplace` 
	ADD INDEX `pokeplacecidade_idx` (`cidade_id` ASC),
	ADD INDEX `pokeplacetipo_idx` (`tipo_id` ASC);
	
ALTER TABLE `pokemapa`.`pokeplace` 
	ADD CONSTRAINT `pokeplacecidade`
  	FOREIGN KEY (`cidade_id`)
  	REFERENCES `pokemapa`.`cidade` (`id`)
  	ON DELETE NO ACTION
  	ON UPDATE NO ACTION,
	ADD CONSTRAINT `localtipo`
  	FOREIGN KEY (`tipo_id`)
  	REFERENCES `pokemapa`.`tipo` (`id`)
  	ON DELETE NO ACTION
  	ON UPDATE NO ACTION;

ALTER TABLE `pokemapa`.`pokeplace` 
CHANGE COLUMN `imagem` `imagem` LONGBLOB NULL DEFAULT NULL ;

ALTER TABLE `pokemapa`.`pokeplace` 
CHANGE COLUMN `nomeimagem` `nomeimagem` VARCHAR(30) NULL DEFAULT NULL ;

CREATE TABLE `pokemapa`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `login` VARCHAR(40) NOT NULL,
  `senha` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC));
  
SET GLOBAL max_allowed_packet=1073741824;
	