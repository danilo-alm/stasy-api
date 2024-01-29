CREATE TABLE product (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(150) NOT NULL,
    manufacturer varchar(150) NOT NULL,
    category varchar(50) NOT NULL,
    price decimal(7, 2),
    quantity int NOT NULL,
    PRIMARY KEY (id)
);