create table addresses
(
    address_id   int          not null auto_increment,
    city_name    varchar(120) not null,
    street_name  varchar(120) not null,
    house_number varchar(20)  not null,
    primary key (address_id)
);

create table customers
(
    customer_id      int          not null auto_increment,
    customer_name    varchar(120) not null,
    customer_surname varchar(120) not null,
    customer_age     int          not null,
    customer_gender  varchar(120) not null,
    id_address       int          not null,
    primary key (customer_id),
    foreign key (id_address) references addresses (address_id)
);

insert into addresses (city_name, street_name, house_number)
VALUES ('Minsk', 'Kirova', '3a'),
       ('Moskow', 'Volinca', '28'),
       ('Grodno', 'Kozlova', '5');

insert into customers (customer_name, customer_surname, customer_age, customer_gender, id_address)
VALUES ('Vlad', 'Petrov', '26', 'man', 1),
       ('Igor', 'Ivanov', '40', 'man', 2),
       ('Maria', 'Popova', '22', 'woman', 1),
       ('Olga', 'Smirnova', '35', 'woman', 3);

