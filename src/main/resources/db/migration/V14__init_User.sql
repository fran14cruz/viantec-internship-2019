
INSERT INTO role (id, name)
VALUES (1, 'ADMIN');

INSERT INTO role (id, name)
VALUES (2, 'USER');

INSERT INTO users (username, password, role_id, full_name, email, last_login)
VALUES ('admin', '$2a$08$xfJSxcDsAIHBWmXKV/82yOhtRQR8EwDmrPgVU/RZlkozrb8ge2A0O', 1, 'full_name', 'mail@m.ru', '2019-02-07 12:44:00');

INSERT INTO users (username, password, role_id, full_name, email, last_login)
VALUES ('user', '$2a$08$e9t/ckPmY0NrQAGv00pf/u.Et5Q5gEKyS4Z4vugGw7ok2oYNqVtde', 2, 'full_user_name', 'mail2@m.ru', '2019-03-07 12:44:00');