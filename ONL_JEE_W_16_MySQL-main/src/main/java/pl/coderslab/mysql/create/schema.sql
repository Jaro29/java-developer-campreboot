CREATE SCHEMA IF NOT EXISTS bookstore_db
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;
SET time_zone = '+02:00';

USE bookstore_db;

DROP TABLE IF EXISTS customers;

CREATE TABLE customers
(
    customer_id         INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(100)  NOT NULL,
    email VARCHAR(100)  NOT NULL,
    CONSTRAINT UQ_Customers_Email UNIQUE (email)
);

DROP TABLE IF EXISTS addresses;

CREATE TABLE addresses
(
    customer_id         INT UNSIGNED NOT NULL PRIMARY KEY,
    city VARCHAR(100)   NOT NULL ,
    street VARCHAR(255) NOT NULL ,
    FOREIGN KEY(customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS books;

CREATE TABLE books
(
    book_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    price DECIMAL(7,2) NOT NULL
);

DROP TABLE IF EXISTS borrowings;

CREATE TABLE borrowings
(
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    customer_id INT UNSIGNED NOT NULL ,
    book_id INT UNSIGNED NOT NULL ,
    borrow_date DATE NOT NULL DEFAULT CURRENT_DATE,
    FOREIGN KEY(customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(book_id) REFERENCES books(book_id) ON DELETE CASCADE ON UPDATE CASCADE
);
