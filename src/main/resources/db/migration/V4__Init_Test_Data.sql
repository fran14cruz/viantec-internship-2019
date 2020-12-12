INSERT INTO POINT_NAME (id, name)
VALUES (1, 'Test');

INSERT INTO POINT_NAME (id, name)
VALUES (2, 'MyWiFi');

INSERT INTO POINT_NAME (id, name)
VALUES (3, 'Onlime');


INSERT INTO VENDOR (id, name, short_mac)
VALUES (1, 'Apple', '00:00:01');

INSERT INTO VENDOR (id, name, short_mac)
VALUES (2, 'HP', '00:00:02');

INSERT INTO VENDOR (id, name, short_mac)
VALUES (3, 'D-Link', '00:00:03');


INSERT INTO POINT (id, mac, id_name, id_vendor, id_sensor, id_sensor_last, status, last_active_date)
VALUES (1, '60:A4:4C:EF:AE:C8', 1, 3, 1, 2, 1, '2018-12-06 12:42:00');

INSERT INTO POINT (id, mac, id_name, id_vendor, id_sensor, id_sensor_last, status, last_active_date)
VALUES (2, 'CC:B2:55:9E:55:D2', 2, 1, 1, 2, 1, '2018-12-06 12:44:00');

INSERT INTO POINT (id, mac, id_name, id_vendor, id_sensor, id_sensor_last, status, last_active_date)
VALUES (3, '60:A4:4C:EF:AE:F0', 3, 2, 1, 2, 1, '2018-12-06 12:42:00');

INSERT INTO POINT (id, mac, id_name, id_vendor, id_sensor, id_sensor_last, status, last_active_date)
VALUES (4, 'CC:B2:55:9E:55:F1', 3, 1, 1, 2, 1, '2018-12-06 12:44:00');

INSERT INTO POINT (id, mac, id_name, id_vendor, id_sensor, id_sensor_last, status, last_active_date)
VALUES (5, '60:A4:4C:EF:AE:F2', 2, 1, 1, 2, 1, '2018-12-06 12:42:00');

INSERT INTO POINT (id, mac, id_name, id_vendor, id_sensor, id_sensor_last, status, last_active_date)
VALUES (6, 'CC:B2:55:9E:55:F3', 1, 3, 1, 2, 1, '2018-12-06 12:44:00');

INSERT INTO POINT (id, mac, id_name, id_vendor, id_sensor, id_sensor_last, status, last_active_date)
VALUES (7, '60:A4:4C:EF:AE:F4', 2, 3, 1, 2, 1, '2018-12-06 12:42:00');

INSERT INTO POINT (id, mac, id_name, id_vendor, id_sensor, id_sensor_last, status, last_active_date)
VALUES (8, 'CC:B2:55:9E:55:F5', 2, 2, 1, 2, 1, '2018-12-06 12:44:00');

INSERT INTO POINT (id, mac, id_name, id_vendor, id_sensor, id_sensor_last, status, last_active_date)
VALUES (9, '60:A4:4C:EF:AE:F6', 3, 1, 1, 2, 1, '2018-12-06 12:42:00');

INSERT INTO POINT (id, mac, id_name, id_vendor, id_sensor, id_sensor_last, status, last_active_date)
VALUES (10, 'CC:B2:55:9E:55:F7', 3, 3, 1, 2, 1, '2018-12-06 12:44:00');


INSERT INTO POINT_EVENT (id, id_mac, id_pos, flat, first_date_time, last_date_time, active, coding, packages, frequency, status, level)
VALUES (1, 1, 1, 1, '2018-12-06 12:44:00', '2018-12-07 12:44:00', true, 'OPN', 100, 1, 0, '-10');

INSERT INTO POINT_EVENT (id, id_mac, id_pos, flat, first_date_time, last_date_time, active, coding, packages, frequency, status, level)
VALUES (2, 2, 1, 1, '2018-12-05 12:44:00', '2018-12-07 12:44:00', true, 'OPN', 90, 1, 0, '-1');

INSERT INTO POINT_EVENT (id, id_mac, id_pos, flat, first_date_time, last_date_time, active, coding, packages, frequency, status, level)
VALUES (3, 3, 1, 1, '2018-12-05 12:44:00', '2018-12-07 12:44:00', true, 'OPN', 10, 1, 0, '-2');

INSERT INTO POINT_EVENT (id, id_mac, id_pos, flat, first_date_time, last_date_time, active, coding, packages, frequency, status, level)
VALUES (4, 4, 1, 1, '2018-12-05 12:44:00', '2018-12-07 12:44:00', true, 'OPN', 99, 1, 0, '-6');

INSERT INTO POINT_EVENT (id, id_mac, id_pos, flat, first_date_time, last_date_time, active, coding, packages, frequency, status, level)
VALUES (5, 5, 1, 1, '2018-12-05 12:44:00', '2018-12-07 12:44:00', true, 'OPN', 67, 1, 0, '-7');

INSERT INTO POINT_EVENT (id, id_mac, id_pos, flat, first_date_time, last_date_time, active, coding, packages, frequency, status, level)
VALUES (6, 6, 1, 1, '2018-12-05 12:44:00', '2018-12-07 12:44:00', true, 'OPN', 50, 1, 0, '-20');

INSERT INTO POINT_EVENT (id, id_mac, id_pos, flat, first_date_time, last_date_time, active, coding, packages, frequency, status, level)
VALUES (7, 7, 1, 1, '2018-12-05 12:44:00', '2018-12-07 12:44:00', true, 'OPN', 87, 1, 0, '-30');

INSERT INTO POINT_EVENT (id, id_mac, id_pos, flat, first_date_time, last_date_time, active, coding, packages, frequency, status, level)
VALUES (8, 8, 1, 1, '2018-12-05 12:44:00', '2018-12-07 12:44:00', true, 'OPN', 67, 1, 0, '-40');

INSERT INTO POINT_EVENT (id, id_mac, id_pos, flat, first_date_time, last_date_time, active, coding, packages, frequency, status, level)
VALUES (9, 9, 1, 1, '2018-12-05 12:44:00', '2018-12-07 12:44:00', true, 'OPN', 34, 1, 0, '-10');

INSERT INTO POINT_EVENT (id, id_mac, id_pos, flat, first_date_time, last_date_time, active, coding, packages, frequency, status, level)
VALUES (10, 10, 1, 1, '2018-12-05 12:44:00', '2018-12-07 12:44:00', true, 'OPN', 23, 1, 0, '0');



