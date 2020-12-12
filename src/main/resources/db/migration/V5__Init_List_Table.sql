create sequence list_sequence start 1 increment 1;


create table LIST (
  id int8 not null default nextval('list_sequence'),
  name varchar(255),
  primary key (id)
);

INSERT INTO LIST (id, name) VALUES (1, 'Опасная');

INSERT INTO LIST (id, name) VALUES (2, 'Белая');

INSERT INTO LIST (id, name) VALUES (3, 'Подавленная');
