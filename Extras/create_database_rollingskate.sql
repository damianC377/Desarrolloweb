CREATE DATABASE rollingskate 

    DEFAULT CHARACTER SET = 'utf8mb4'; 

 

     

CREATE USER 'mono_user_test'@'localhost' IDENTIFIED BY '123456'; 

 

GRANT ALL PRIVILEGES ON rollingskate.* TO 'mono_user_test'@'localhost'; 

FLUSH PRIVILEGES; 

 

SHOW GRANTS FOR 'mono_user_test'@'localhost'; 

 