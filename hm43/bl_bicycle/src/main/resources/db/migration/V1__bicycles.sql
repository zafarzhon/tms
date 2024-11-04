create table bicycles
(
    id     uuid primary key,
    added  timestamp,
    price  double precision,
    brand  varchar,
    type   varchar,
    status varchar
)