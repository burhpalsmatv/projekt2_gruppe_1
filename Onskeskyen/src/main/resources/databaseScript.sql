drop database if exists projekt2_gruppe_1_db;
create database projekt2_gruppe_1_db;
use projekt2_gruppe_1_db;

create table users
(
    userId         int auto_increment primary key,
    firstName      varchar(250) not null,
    lastName       varchar(250) not null,
    age            int          not null,
    email          varchar(500) not null,
    phoneNum       int          not null,
    password       varchar(250) not null,
    profilePicture varchar(1000)
);

create table wishlists
(
    wishlistId     int auto_increment primary key,
    userWishlistId int,
    wishlistTitle  varchar(500),
    coverImg       varchar(1000),

    constraint fk_userWishlistId
        foreign key (userWishlistId)
            references users (userId)

);

create table wishes
(
    wishId     int auto_increment primary key,
    title      varchar(250) not null,
    price      decimal      not null,
    note       varchar(500),
    link       varchar(250),
    wishImg    varchar(250),
    priority   boolean,
    wishlistId int          not null

);


INSERT INTO wishes (title, price, note, link, wishImg, priority, wishlistId)
VALUES ('Cykel', 500, 'Hurtig', 'https://www.kbhcykler.dk/shop/skovcykel-3-gear-med-kurv/', 'https://www.kbhcykler.dk/wp-content/uploads/2018/12/0565sortdani-1-scaled-1.png', true, 1),
       ('Kingston 32GB DDR5 ram', 4999, 'please', 'https://www.pricerunner.dk/pl/38-3280128297/RAM/Kingston-Fury-Beast-Black-DDR5-6000MHz-2x16GB-ECC-%28KF560C30BBEK2-32%29-Sammenlign-Priser', 'https://owp.klarna.com/product/3217867730/Kingston-Fury-Beast-Black-DDR5-6000MHz-2x16GB-ECC-%28KF560C30BBEK2-32%29.jpg', true, 1),
       ('Mad', 500, 'Jeg er sulten', 'https://madplan.ai/opskrift/dansk-koed-og-melbollesuppe/', 'https://madplan.ai/wp-content/uploads/2025/12/dansk-kod-og-melbollesuppe-5382.jpg', false, 1);

INSERT INTO users (firstName, lastName, age, email, phoneNum, password)
VALUES ('Admin', 'Admin', 30, 'admin@gmail.com', 12345678, 'Admin123');

insert into wishlists (wishlistTitle, userWishlistId)
values ('Min første ønskeliste', 1);