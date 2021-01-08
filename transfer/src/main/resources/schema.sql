DROP TABLE IF EXISTS users;

CREATE TABLE users (
                              id INT AUTO_INCREMENT  PRIMARY KEY,
                              name VARCHAR(250) NOT NULL,
                              middlename VARCHAR(250) NOT NULL,
                              surname VARCHAR(250) NOT NULL
);