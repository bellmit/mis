CREATE USER 'mis-dev'@localhost
  IDENTIFIED BY 'sbyy-mis-dev';

DROP DATABASE IF EXISTS sbyymis;
CREATE DATABASE sbyymis
  CHAR SET utf8
  COLLATE utf8_general_ci;

GRANT ALL ON sbyymis.* TO 'mis-dev'@localhost;

DROP TABLE IF EXISTS ttttt;
