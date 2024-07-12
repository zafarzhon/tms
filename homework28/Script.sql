drop table person_hobby;
drop table persons;
drop table hobbies;
drop table hobby_types;


create table if not exists persons(
                                      id serial primary key,
                                      name varchar(30) not null,
    is_man boolean not null,
    birthday date
    );

create table hobby_types(
                            id serial primary key,
                            hobby_type varchar(30) not null
);

create table if not exists hobbies(
                                      id serial primary key,
                                      name varchar(30) not null,
    hobby_type int,
    foreign key (hobby_type) references hobby_types (id)
    );


create table if not exists person_hobby(
                                           person_id int,
                                           hobby_id int,
                                           foreign key (person_id) references persons (id),
    foreign key (hobby_id) references hobbies (id)
    );

insert into persons (name, is_man, birthday) values ('Ignacio', false, '2008-07-03');
insert into persons (name, is_man, birthday) values ('Alexandre', false, '2000-04-09');
insert into persons (name, is_man, birthday) values ('Roddy', false, '2023-07-04');
insert into persons (name, is_man, birthday) values ('Randy', true, '2024-01-05');
insert into persons (name, is_man, birthday) values ('Dilan', false, '2009-02-10');
insert into persons (name, is_man, birthday) values ('Hakeem', false, '2021-09-04');
insert into persons (name, is_man, birthday) values ('Kale', false, '1999-01-02');
insert into persons (name, is_man, birthday) values ('Micheline', false, '2015-02-16');
insert into persons (name, is_man, birthday) values ('Isadore', true, '2020-09-04');
insert into persons (name, is_man, birthday) values ('Beitris', false, '2021-01-05');


insert into hobby_types(hobby_type)
values
    ('active'),
    ('calm');


insert into hobbies (name,hobby_type)
values
    ('futbol',1),
    ('hockey',1),
    ('reading',2),
    ('painting',2),
    ('chess',2),
    ('running',1);


insert into person_hobby (person_id, hobby_id) values (7, 6);
insert into person_hobby (person_id, hobby_id) values (7, 4);
insert into person_hobby (person_id, hobby_id) values (4, 6);
insert into person_hobby (person_id, hobby_id) values (2, 5);
insert into person_hobby (person_id, hobby_id) values (8, 3);
insert into person_hobby (person_id, hobby_id) values (10, 5);
insert into person_hobby (person_id, hobby_id) values (2, 1);
insert into person_hobby (person_id, hobby_id) values (9, 1);
insert into person_hobby (person_id, hobby_id) values (9, 1);
insert into person_hobby (person_id, hobby_id) values (4, 4);
insert into person_hobby (person_id, hobby_id) values (6, 6);
insert into person_hobby (person_id, hobby_id) values (4, 4);
insert into person_hobby (person_id, hobby_id) values (6, 5);
insert into person_hobby (person_id, hobby_id) values (2, 3);
insert into person_hobby (person_id, hobby_id) values (3, 6);
insert into person_hobby (person_id, hobby_id) values (2, 3);
insert into person_hobby (person_id, hobby_id) values (6, 2);
insert into person_hobby (person_id, hobby_id) values (5, 3);
insert into person_hobby (person_id, hobby_id) values (1, 5);
insert into person_hobby (person_id, hobby_id) values (7, 1);
insert into person_hobby (person_id, hobby_id) values (5, 3);
insert into person_hobby (person_id, hobby_id) values (5, 2);
insert into person_hobby (person_id, hobby_id) values (3, 3);
insert into person_hobby (person_id, hobby_id) values (2, 4);
insert into person_hobby (person_id, hobby_id) values (3, 2);
insert into person_hobby (person_id, hobby_id) values (5, 2);
insert into person_hobby (person_id, hobby_id) values (4, 1);
insert into person_hobby (person_id, hobby_id) values (1, 3);
insert into person_hobby (person_id, hobby_id) values (2, 3);
insert into person_hobby (person_id, hobby_id) values (8, 4);

select * from persons;
select * from hobbies;
select * from hobby_types;
select * from person_hobby;

select * from persons where date_part('year',age(now(),birthday)) > 18;
select is_man, count(*) from persons group by is_man;
select p.id,p.name,h.name from persons p join person_hobby ph on p.id = ph.person_id join hobbies h on h.id=ph.hobby_id order by p.id;
select p.name, count(*) from persons p join person_hobby ph on p.id = ph.person_id group by p.name;
select p.name, count(*) from persons p join person_hobby ph on p.id = ph.person_id group by p.name having count(*)>1;
select t.hobby_type, count(t.hobby_type) from hobbies h join hobby_types t on h.hobby_type = t.id group by t.hobby_type;
select h.name,t.hobby_type from hobbies h join hobby_types t on h.hobby_type = t.id;

