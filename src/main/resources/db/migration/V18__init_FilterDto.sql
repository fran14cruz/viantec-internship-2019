create sequence filter_sequence start 1 increment 1;

create table filter (
  id int8 not null default nextval('filter_sequence'),
  user_id int8,
  name varchar(100),
  fields text,
  primary key (id)
);