CREATE TABLE nation (
  id BIGINT NOT NULL AUTO_INCREMENT,
  codice VARCHAR(3) NOT NULL,
  nome VARCHAR(50) NOT NULL,
  population BIGINT NOT NULL,
  id_capitale BIGINT DEFAULT NULL,
  superficie DOUBLE DEFAULT NULL,
  government_type VARCHAR(50) DEFAULT NULL,
  middle_age SMALLINT DEFAULT NULL,
  path_flag VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT `nation_ibfk_1` FOREIGN KEY (`id_capitale`) REFERENCES `city` (`id`)
);
