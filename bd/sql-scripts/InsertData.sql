INSERT INTO users (name, user_name) VALUES ('German A', 'german.arroyave');
INSERT INTO lists (user_id, name, description) VALUES (1, 'Others', 'General activities');
INSERT INTO tasks (title, done, list_id) VALUES ('Hacer backend', false, 1);
INSERT INTO tasks (title, done, list_id) VALUES ('Hacer frontend', false, 1);
INSERT INTO tasks (title, done, list_id) VALUES ('Hacer docker Mysql', true, 1);

GRANT ALL PRIVILEGES ON *.* TO 'root'@'%'; 