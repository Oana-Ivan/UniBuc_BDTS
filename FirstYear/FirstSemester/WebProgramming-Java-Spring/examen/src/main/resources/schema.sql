-- create database examen;

use examen;

create table if not exists payments (
    id int not null auto_increment primary key,
    type varchar(100) not null,
    customer varchar(100) not null,
    amount int not null,
    status varchar(200) not null
    );