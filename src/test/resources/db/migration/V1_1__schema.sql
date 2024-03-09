-- V1_1__schema.sql

CREATE TABLE `publisher` (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `name` varchar(255) NOT NULL,
                             PRIMARY KEY (`id`)
);

CREATE TABLE `books` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `isbn` varchar(13) NOT NULL,
                         `title` varchar(255) NOT NULL,
                         `synopsis` text DEFAULT NULL,
                         `publisher_id` int(11) DEFAULT NULL,
                         `price` decimal(10,2) NOT NULL,
                         `cover` varchar(255) DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `isbn` (`isbn`),
                         KEY `publisher_id` (`publisher_id`),
                         CONSTRAINT `books_ibfk_1` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`)
);

CREATE TABLE `authors` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `name` varchar(255) NOT NULL,
                           `nationality` varchar(255) DEFAULT NULL,
                           `birth_year` int(11) DEFAULT NULL,
                           `death_year` int(11) DEFAULT NULL,
                           PRIMARY KEY (`id`)
);

CREATE TABLE `book_authors` (
                                `id` int(11) NOT NULL AUTO_INCREMENT,
                                `book_id` int(11) DEFAULT NULL,
                                `author_id` int(11) DEFAULT NULL,
                                PRIMARY KEY (`id`),
                                KEY `book_id` (`book_id`),
                                KEY `author_id` (`author_id`),
                                CONSTRAINT `book_authors_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`),
                                CONSTRAINT `book_authors_ibfk_2` FOREIGN KEY (`author_id`) REFERENCES `authors` (`id`)
);

CREATE TABLE `users` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `username` varchar(255) NOT NULL,
                         `email` varchar(255) NOT NULL,
                         `password` varchar(255) NOT NULL,
                         `admin` tinyint(1) NOT NULL DEFAULT 0,
                         `delivery_address_id` int(11) DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         KEY `delivery_address_id` (`delivery_address_id`),
                         CONSTRAINT `users_ibfk_1` FOREIGN KEY (`delivery_address_id`) REFERENCES `delivery_address` (`id`)
);

CREATE TABLE `delivery_address` (
                                    `id` int(11) NOT NULL AUTO_INCREMENT,
                                    `address` varchar(255) NOT NULL,
                                    `city` varchar(255) NOT NULL,
                                    `province` varchar(255) NOT NULL,
                                    `postal_code` int(11) NOT NULL,
                                    PRIMARY KEY (`id`)
);

CREATE TABLE `orders` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `order_date` date DEFAULT NULL,
                          `user_id` int(11) DEFAULT NULL,
                          `status` int(11) NOT NULL DEFAULT 0,
                          PRIMARY KEY (`id`),
                          KEY `user_id` (`user_id`),
                          CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

CREATE TABLE `order_details` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                 `order_id` int(11) DEFAULT NULL,
                                 `book_id` int(11) DEFAULT NULL,
                                 `quantity` int(11) NOT NULL,
                                 `price` decimal(10,2) NOT NULL,
                                 PRIMARY KEY (`id`),
                                 KEY `order_id` (`order_id`),
                                 KEY `book_id` (`book_id`),
                                 CONSTRAINT `order_details_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
                                 CONSTRAINT `order_details_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`)
);