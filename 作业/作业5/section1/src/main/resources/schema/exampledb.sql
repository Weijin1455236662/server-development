CREATE TABLE user (
   user_id   INT AUTO_INCREMENT PRIMARY KEY,
   user_name VARCHAR(30),
   password  VARCHAR(32),
   last_visit datetime,
   last_ip  VARCHAR(23)
);

CREATE TABLE login_log (
   login_log_id  INT AUTO_INCREMENT PRIMARY KEY,
   user_id   INT,
   ip  VARCHAR(23),
   login_datetime datetime
);

INSERT INTO user(user_name,password) VALUES ('admin','123456');

commit;