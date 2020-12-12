create sequence tag_sequence start 1 increment 1;

create table TAG (
  id int8 not null default nextval('tag_sequence'),
  name varchar(80),
  primary key (id)
);

INSERT INTO TAG (name)
VALUES ('test1');

INSERT INTO TAG (name)
VALUES ('test2');

INSERT INTO TAG (name)
VALUES ('test3');