drop table if exists products;

create table products
(
    id          bigserial primary key,
    name        varchar,
    count       varchar,
    price       double precision,
    is_delivery boolean,
    is_removed  boolean
);