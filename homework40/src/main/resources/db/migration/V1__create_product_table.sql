drop table if exists products;

create table products
(
    id          bigserial primary key,
    name        varchar,
    count int,
    price       double precision,
    is_delivery boolean,
    is_removed  boolean
);