create sequence point_sequence start 1 increment 1;
create sequence point_event_sequence start 1 increment 1;
create sequence point_name_sequence start 1 increment 1;
create sequence vendor_sequence start 1 increment 1;


create table POINT (
  id int8 not null default nextval('point_sequence'),
  mac varchar(17) unique,
  id_name int8,
  id_vendor int8,
  id_sensor int8,
  id_sensor_last int8,
  status int4,
  last_active_date timestamp,
  primary key (id)
);

create table POINT_EVENT (
  id int8 not null default nextval('point_event_sequence'),
  id_mac int8,
  id_pos int8,
  flat int4,
  first_date_time timestamp,
  last_date_time timestamp,
  active boolean,
  coding varchar(6),
  packages int4,
  frequency int4,
  status int4,
  level int4,
  primary key (id)
);

create table POINT_NAME (
  id int8 not null default nextval('point_name_sequence'),
  name varchar(40),
  primary key (id)
);

create table VENDOR (
  id int8 not null default nextval('vendor_sequence'),
  name varchar(225),
  short_mac varchar(10),
  primary key (id)
);



