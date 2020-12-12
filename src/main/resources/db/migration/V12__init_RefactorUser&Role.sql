DROP TABLE users;
DROP TABLE role;

create sequence users_sequence start 1 increment 1;

CREATE TABLE role (
  id int8 not null,
  name varchar(255),
  primary key (id)
);

CREATE TABLE users (
  id int8 not null default nextval('device_sequence'),
  username varchar(255) not null unique,
  password varchar(255) not null,
  role_id int8,
  full_name varchar(255),
  email varchar(255),
  last_login timestamp,
  primary key (id)
);