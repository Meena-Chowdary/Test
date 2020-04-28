CREATE DATABASE productmanagement; 
USE productmanagement;
CREATE TABLE PRODUCTS(
    ID INT PRIMARY KEY AUTO_INCREMENT,
    VID INT REFERENCES VENDORS(VID),
    NAME VARCHAR(200) NOT NULL,
    PRICE NUMERIC NOT NULL,
    description VARCHAR(600) NOT NULL
); CREATE TABLE VENDORS(
    VID INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(150) NOT NULL,
    EMAIL VARCHAR(200) NOT NULL,
    phone CHAR(10) NOT NULL
); CREATE TABLE Address(
    line1 VARCHAR(200),
    line2 VARCHAR(200),
    city VARCHAR(200),
    state VARCHAR(200)
); INSERT INTO vendors
VALUES(
    200,
    "mahesh",
    "mahesh@gmail.com",
    "7416565389"
);
INSERT INTO vendors
VALUES(
    201,
    "meena",
    "meena@gmail.com",
    "8888865389"
);
INSERT INTO vendors
VALUES(
    203,
    "bindhu",
    "bimdhu@gmail.com",
    "9916565389"
);
INSERT INTO products
VALUES(1, 200, "tv", 50000);
INSERT INTO products
VALUES(2, 201, "friz", 60000);
INSERT INTO products
VALUES(1, 200, "cooler", 50000);