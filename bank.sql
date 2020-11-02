DROP DATABASE IF EXISTS bank_list;

CREATE DATABASE bank_list DEFAULT CHARACTER SET 'utf8';

USE bank_list;

create table user
(
  user_id int unsigned not null auto_increment,
  name varchar(45) not null,
  sur_name varchar(45) not null,
  primary key (user_id)
) engine=InnoDB;

create table account
(
  account_id int unsigned not null auto_increment,
  account int not null,
  user_id int not null,
  primary key (account_id)
) engine=InnoDB;

set names 'utf8';

insert into user (name, sur_name) 
values ('Иван', 'Петров');
insert into user (name, sur_name) 
values ('Мария', 'Путина');
insert into user (name, sur_name) 
values ('Дмитрий', 'Попов');
insert into user (name, sur_name) 
values ('Игнат', 'Домейко');
insert into user (name, sur_name) 
values ('Александр', 'Пушкин');
insert into user (name, sur_name) 
values ('Сидор', 'Ковпак');
insert into user (name, sur_name) 
values ('Ирина', 'Кошкина');
insert into user (name, sur_name) 
values ('Валентина', 'Минина');
insert into user (name, sur_name) 
values ('Кирил', 'Спирин');
insert into user (name, sur_name) 
values ('Елена', 'Прекрасная');

insert into account (account, user_id)
values (100, 1);
insert into account (account, user_id)
values (200, 2);
insert into account (account, user_id)
values (150, 3);
insert into account (account, user_id)
values (50, 4);
insert into account (account, user_id)
values (250, 5);
insert into account (account, user_id)
values (100, 6);
insert into account (account, user_id)
values (300, 7);
insert into account (account, user_id)
values (560, 8);
insert into account (account, user_id)
values (450, 9);
insert into account (account, user_id)
values (250, 10);
