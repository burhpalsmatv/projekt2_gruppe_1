drop database if exists projekt2_gruppe_1_db;
create database projekt2_gruppe_1_db;
use projekt2_gruppe_1_db;

create table wishlist
(
    wishListId int auto_increment primary key,
    coverImg varchar(1000)

);

create table wish
(
    wishId int auto_increment primary key,
    title varchar(250) not null,
    price decimal not null,
    note varchar(500),
    link varchar(250),
    wishImg varchar(250),
    priority boolean,
    wishListId int not null,

    constraint fk_wishListId
        foreign key(wishListId)
            references wishlist(wishListId)

);



create table users
(
    userId int auto_increment primary key,
    userWishListId int,
    firstName varchar(250) not null,
    lastName varchar(250) not null,
    age int not null,
    email varchar(500) not null,
    phoneNum int not null,
    profilePicture varchar(1000),

    constraint fk_userWishListId
        foreign key(userWishListId)
            references wishlist(wishListId)
);


INSERT INTO wishlist (wishListId) VALUES (1), (2), (3);

INSERT INTO wish (title, price, wishListId) VALUES ('Cykel', 500, 1), ('Kingston 32GB DDR5 ram', 4999, 1), ('Mad (jeg er sulten)', 500, 1);




INSERT INTO users (userWishListId, firstName, lastName, age, email, phoneNum) VALUES (1, 'Mateusz', 'Filipowski', 26, 'mateuszfilipowski00@gmail.com', 50230646);



