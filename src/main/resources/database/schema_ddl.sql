drop table if exists addresses;
drop table if exists customers;


create table addresses
(
    id           int          not null auto_increment,
    city_name    varchar(120) not null,
    street_name  varchar(120) not null,
    house_number varchar(20)  not null,
    primary key (id)
);


create table customers
(
    id               int          not null auto_increment,
    customer_name    varchar(120) not null,
    customer_surname varchar(120) not null,
    customer_age     int          not null,
    primary key (id)
);

create table customer_address
(
    customer_id int not null,
    address_id  int not null,
    primary key (customer_id, address_id),
    foreign key (address_id) references addresses (id),
    foreign key (customer_id) references customers (id)
);

insert into addresses (city_name, street_name, house_number)
VALUES ('Minsk', 'Kirova', '3a'),
       ('Moskow', 'Volinca', '28'),
       ('Grodno', 'Kozlova', '5');

insert into customers (customer_name, customer_surname, customer_age)
VALUES ('Vlad', 'Petrov', '26'),
       ('Igor', 'Ivanov', '40'),
       ('Maria', 'Popova', '22'),
       ('Olga', 'Smirnova', '35');

insert into customer_address (customer_id, address_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 1);



