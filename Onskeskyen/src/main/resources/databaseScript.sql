drop database if exists projekt2_gruppe_1_db;
create database projekt2_gruppe_1_db;
use projekt2_gruppe_1_db;

create table wishlist
(
    wishlistId    int auto_increment primary key,
    wishlistTitle varchar(500),
    coverImg      varchar(1000)

);

create table wish
(
    wishId     int auto_increment primary key,
    title      varchar(250) not null,
    price      decimal      not null,
    note       varchar(500),
    link       varchar(250),
    wishImg    varchar(250),
    priority   boolean,
    wishlistId int          not null,

    constraint fk_wishListId
        foreign key (wishlistId)
            references wishlist (wishlistId)

);



create table users
(
    userId         int auto_increment primary key,
    userWishlistId int,
    firstName      varchar(250) not null,
    lastName       varchar(250) not null,
    age            int          not null,
    email          varchar(500) not null,
    phoneNum       int          not null,
    password       varchar(250) not null,
    profilePicture varchar(1000),

    constraint fk_userWishlistId
        foreign key (userWishlistId)
            references wishlist (wishlistId)
);

INSERT INTO wishlist (wishlistId)
VALUES (1),
       (2),
       (3);
INSERT INTO wish (title, price, wishlistId)
VALUES ('Cykel', 500, 1),
       ('Kingston 32GB DDR5 ram', 4999, 1),
       ('Mad (jeg er sulten)', 500, 1);

INSERT INTO users (userWishlistId, firstName, lastName, age, email, phoneNum, password)
VALUES (1, 'Mateusz', 'Filipowski', 26, 'mateuszfilipowski00@gmail.com', 50230646, 'Poul');

insert into wishlist (wishlistTitle)
values ('første ønskeliste');



