create sequence hibernate_sequence start 1 increment 1;

create table role (
  id int8 not null,
  name varchar(255),
  primary key (id)
);

create table users (
  id int8 not null,
  password varchar(255),
  user_name varchar(255) unique,
  role_id int8,
  primary key (id)
);