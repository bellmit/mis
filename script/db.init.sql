CREATE USER 'mis-dev'@localhost
  IDENTIFIED BY 'sbyy-mis-dev';

DROP DATABASE IF EXISTS sbyymis;
CREATE DATABASE sbyymis
  CHAR SET utf8
  COLLATE utf8_general_ci;

GRANT ALL ON sbyymis.* TO 'mis-dev'@localhost;

CREATE TABLE user (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  username  CHAR(64)  NOT NULL UNIQUE,
  password  CHAR(128) NOT NULL,
  real_name VARCHAR(64),
  age       INT(3),
  phone     DECIMAL(32),
  sex       TINYINT(1),
  added     DATETIME        DEFAULT current_timestamp
);

CREATE TABLE admin (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  username  CHAR(64)  NOT NULL UNIQUE,
  password  CHAR(128) NOT NULL,
  real_name VARCHAR(64),
  age       INT(3),
  phone     DECIMAL(32),
  sex       TINYINT(1),
  added     DATETIME        DEFAULT current_timestamp
);
