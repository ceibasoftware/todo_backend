INSERT INTO users (name, user_name) VALUES ('German A', 'german.arroyave');
INSERT INTO tasks (user_id, title, done,	category) VALUES (1, 'Hacer backend', false, 'IT');
INSERT INTO tasks (user_id, title, done,	category) VALUES (1, 'Hacer frontend', false, 'IT');
INSERT INTO tasks (user_id, title, done,	category) VALUES (1, 'Hacer docker Mysql', true, 'IT');

GRANT ALL PRIVILEGES ON *.* TO 'root'@'%'; 