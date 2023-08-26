CREATE DATABASE crm_app;
USE crm_app;

CREATE TABLE IF NOT EXISTS roles (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users (
    id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    fullname VARCHAR(100) NOT NULL,
    avatar VARCHAR(100),
    role_id INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS status (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS jobs (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    start_date DATE,
    end_date DATE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tasks (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    start_date DATE,
    end_date DATE,
    user_id INT NOT NULL,
    job_id INT NOT NULL,
    status_id INT NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE users ADD FOREIGN KEY (role_id) REFERENCES roles (id)  ON DELETE CASCADE;
ALTER TABLE tasks ADD FOREIGN KEY (user_id) REFERENCES users (id)  ON DELETE CASCADE;
ALTER TABLE tasks ADD FOREIGN KEY (job_id) REFERENCES jobs (id)  ON DELETE CASCADE;
ALTER TABLE tasks ADD FOREIGN KEY (status_id) REFERENCES status (id)  ON DELETE CASCADE;

INSERT INTO roles( name, description ) VALUES ("ROLE_ADMIN", "Quản lý strang");
INSERT INTO roles( name, description ) VALUES ("ROLE_MANAGER", "Quản lý");
INSERT INTO roles( name, description ) VALUES ("ROLE_USER", "Nhân viên");
INSERT INTO roles( name, description ) VALUES ("ROLE_TEST", "Nhân viên TEST");

INSERT INTO status( name ) VALUES ("Chưa thực hiện");
INSERT INTO status( name ) VALUES ("Đang thực hiện");
INSERT INTO status( name ) VALUES ("Đã hoàn thành");

INSERT INTO users (email, password, fullname, avatar, role_id)
VALUES ("nguyenvana@gmail.com", "123456", "Nguyễn Văn A", "", 1);

INSERT INTO users (email, password, fullname, avatar, role_id)
VALUES ("nguyenvanb@gmail.com", "123456", "Nguyễn Văn B", "", 3);

INSERT INTO users (email, password, fullname, avatar, role_id)
VALUES ("nguyenvanc@gmail.com", "123456", "Nguyễn Văn C", "", 2);

SELECT * FROM users u where u.email = "" and u.password = "";
-- master data: đi hỏi BA

use crm_app;
select * from roles;

DELETE FROM roles r WHERE r.id = 4;