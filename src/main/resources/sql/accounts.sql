create database accounts;
drop database accounts;
use accounts;

create table users (
id int not null auto_increment,
first_name varchar(255) not null,
last_name varchar(255) not null,
username varchar(255) not null,
password varchar(255) not null,
city varchar(255),
address varchar(255),
phone int,
unique key unique_user (username),
primary key (id)
);

create table roles (
id int not null auto_increment,
rolename varchar(64),
primary key (id)
);

insert into roles values (1,'admin');

create table user_role(
roleid int not null,
userid int not null,
primary key (userid, roleid),
key roleid (roleid),
foreign key(roleid) references roles(id) on delete cascade
on update cascade,
foreign key(userid) references users(id) on delete cascade
on update cascade
);

create table trips(
trip_id int not null auto_increment,
user_id int not null,
trip_name varchar(255) not null,
date_from date,
date_to date,
impression varchar(255),
first_photo varchar(255),
first_photo_description varchar(64),
first_photo_detail varchar(255),
second_photo varchar(255),
second_photo_description varchar(64),
second_photo_detail varchar(255),
primary key (trip_id),
foreign key(user_id) references users(id),
unique key unique_trip (trip_name)
);

drop table users;
drop table roles;
drop table user_role;
drop table trips;

select * from  roles;
select * from  users;
select * from trips;
select * from user_role;