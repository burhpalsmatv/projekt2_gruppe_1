drop database if exists projekt2_gruppe_1_db;
create database projekt2_gruppe_1_db;
use projekt2_gruppe_1_db;

create table wish
(
    wishId int auto_increment primary key,
    title varchar(250) not null,
    price decimal(2) not null,
    note varchar(500),
    link varchar(250),
    wishImg varchar(250),
    priority boolean

);

create table wishlist
(
    wishListId int auto_increment primary key,
    wishId int not null,
    amountOfWishes int not null,
    coverImg varchar(1000),

    constraint fk_wishId
        foreign key(wishId)
            references wish(wishId)
);

create table users
(
    userId int auto_increment primary key,
    wishListId int,
    firstName varchar(250) not null,
    lastName varchar(250) not null,
    age int not null,
    email varchar(500) not null,
    phoneNum int not null,
    profilePicture varchar(1000),

    constraint fk_wishListId
        foreign key(wishListId)
            references wishlist(wishListId)
);

INSERT INTO users (firstName, lastName, age, email, phoneNum) VALUES ( 'Mateusz', 'Filipowski', 26, 'mateuszfilipowski00@gmail.com', 50230646);



