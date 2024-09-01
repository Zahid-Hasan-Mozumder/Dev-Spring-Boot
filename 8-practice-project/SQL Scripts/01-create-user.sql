-- Drop user first if they exist
DROP USER if exists 'zahid_2.0'@'localhost' ;

-- Now create user with prop privileges
CREATE USER 'zahid_2.0'@'localhost' IDENTIFIED BY 'zhm8951';

GRANT ALL PRIVILEGES ON * . * TO 'zahid_2.0'@'localhost';