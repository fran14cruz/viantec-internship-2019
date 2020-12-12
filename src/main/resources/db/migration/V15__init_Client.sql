create sequence client_sequence start 1 increment 1;
create sequence client_event_sequence start 1 increment 1;


create table CLIENT (
  id int8 not null default nextval('client_sequence'),
  mac varchar(17),
  id_point int8,
  id_vendor int8,
  id_sensor int8,
  id_sensor_last int8,
  status int4,
  last_active_date timestamp,
  primary key (id)
);

create table CLIENT_EVENT (
  id int8 not null default nextval('client_event_sequence'),
  id_mac int8,
  id_point int8,
  id_pos int8,
  flat int4,
  first_date_time timestamp,
  last_date_time timestamp,
  active boolean,
  packages int4,
  frequency int4,
  status int4,
  level int4,
  primary key (id)
);

INSERT INTO CLIENT (id, mac, id_point, id_vendor, id_sensor, id_sensor_last, status, last_active_date)
VALUES (1, '60:A4:4C:EF:AE:45', 1, 3, 1, 2, 1, '2018-12-06 12:42:00');

INSERT INTO CLIENT (id, mac, id_point, id_vendor, id_sensor, id_sensor_last, status, last_active_date)
VALUES (2, 'CC:B2:55:9E:55:EE', 2, 1, 1, 2, 1, '2018-12-06 12:44:00');

INSERT INTO CLIENT (id, mac, id_point, id_vendor, id_sensor, id_sensor_last, status, last_active_date)
VALUES (3, '60:A4:4C:EF:AE:F1', 3, 2, 1, 2, 1, '2018-12-06 12:42:00');

INSERT INTO CLIENT_EVENT (id, id_mac, id_point, id_pos, flat, first_date_time, last_date_time, active, packages, frequency, status, level)
VALUES (1, 1, 1, 1, 1, '2018-12-06 12:44:00', '2018-12-07 12:44:00', true, 1, 100, 0, '-10');

INSERT INTO CLIENT_EVENT (id, id_mac, id_point, id_pos, flat, first_date_time, last_date_time, active, packages, frequency, status, level)
VALUES (2, 2, 2, 1, 2, '2018-12-05 12:44:00', '2018-12-07 12:44:00', true, 1, 90, 0, '-1');

INSERT INTO CLIENT_EVENT (id, id_mac, id_point, id_pos, flat, first_date_time, last_date_time, active, packages, frequency, status, level)
VALUES (3, 3, 2, 1, 3, '2018-12-05 12:44:00', '2018-12-07 12:44:00', true, 1, 10, 0, '-2');

