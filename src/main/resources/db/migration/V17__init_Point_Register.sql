create sequence point_register_sequence start 1 increment 1;

create table point_register (
  id int8 not null default nextval('point_register_sequence'),
  id_mac int8 ,
  id_name int8,
  id_vendor int8,
  id_sensor int8,
  last_active_date timestamp,
  packages int4,
  frequency int2,
  primary key (id)
);
