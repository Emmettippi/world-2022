CREATE TABLE `city` (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  population BIGINT NOT NULL,
  area DOUBLE DEFAULT NULL,
  id_nation BIGINT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_nation) REFERENCES nation (id) ON DELETE CASCADE
);