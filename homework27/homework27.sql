

CREATE TABLE IF NOT EXISTS ORDERS(
id SERIAL PRIMARY KEY,
name VARCHAR(30),
date date,
count smallint,
cost NUMERIC(9,2),
is_delivery boolean not null
);

insert into orders (name,date,count,cost,is_delivery) 
values 
('Cola','2001-02-12',5,12.5,'true'),
('Fanta','2003-04-12',2,10.5,'true'),
('Ice-cream','2005-12-12',8,4,'on'),
('Pepsi','2024-07-09',1,10.3,'false');
update orders set is_delivery = false where name like '%cream';

select * from orders;
drop table orders;
delete from orders;

