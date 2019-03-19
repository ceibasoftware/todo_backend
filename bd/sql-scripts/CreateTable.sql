CREATE TABLE IF NOT EXISTS users (
    user_id INT AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
	user_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (user_id)
)  ENGINE=INNODB;
CREATE TABLE IF NOT EXISTS lists (
    list_id INT AUTO_INCREMENT,
	user_id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
	description VARCHAR(50),
    PRIMARY KEY (list_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
)  ENGINE=INNODB;
CREATE TABLE IF NOT EXISTS tasks (
    task_id INT AUTO_INCREMENT,
	title VARCHAR(255) NOT NULL,
    done BOOLEAN NOT NULL,
	list_id INT NOT NULL,
    PRIMARY KEY (task_id),
    FOREIGN KEY (list_id) REFERENCES lists(list_id)
)  ENGINE=INNODB;

