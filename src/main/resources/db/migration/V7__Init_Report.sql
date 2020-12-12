create sequence report_sequence start 1 increment 1;

create table REPORT (
  id int8 not null default nextval('report_sequence'),
  file_name varchar(80),
  id_point int8,
  create_date_time timestamp,
  primary key (id)
);