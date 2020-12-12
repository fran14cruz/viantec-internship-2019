create sequence device_sequence start 1 increment 1;

create TABLE DEVICE(
    id int8 not null default nextval('device_sequence'),
    x int4,
    y int4,
    r int4,
    flat int4,
    mac varchar(17),
    first_mac varchar(17),
    second_mac varchar(17),
    ip varchar(15),
    last_date_time timestamp,
    firmware_version varchar(10),
    primary key(id)
);