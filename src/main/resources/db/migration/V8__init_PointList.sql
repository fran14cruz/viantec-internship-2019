create sequence pointlist_sequence start 1 increment 1;

create table POINT_LIST(
    id int8 not null default nextval('pointlist_sequence'),
    name varchar(255),
    primary key(id)
);