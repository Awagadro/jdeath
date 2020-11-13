CREATE DATABASE bank_list DEFAULT CHARACTER SET 'utf8';

USE bank_list;

CREATE TABLE `user` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(45) NOT NULL,
	`sur_name` varchar(45) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `user_account` (
	`id` int NOT NULL AUTO_INCREMENT,
	`account` int NOT NULL,
	`user_id` int NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `user_account` ADD CONSTRAINT `user_id_fk0` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`);


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

insert into user_account (account, user_id)
values (100, 1);
insert into user_account (account, user_id)
values (500, 1);
insert into user_account (account, user_id)
values (200, 2);
insert into user_account (account, user_id)
values (350, 2);
insert into user_account (account, user_id)
values (50, 2);
insert into user_account (account, user_id)
values (150, 3);
insert into user_account (account, user_id)
values (50, 4);
insert into user_account (account, user_id)
values (250, 5);
insert into user_account (account, user_id)
values (100, 6);
insert into user_account (account, user_id)
values (300, 7);
insert into user_account (account, user_id)
values (560, 8);
insert into user_account (account, user_id)
values (450, 9);
insert into user_account (account, user_id)
values (250, 10);
