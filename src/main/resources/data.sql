CREATE TABLE T_RECORD_REQUEST(
id INT auto_increment primary key,
origin_ip VARCHAR(20) NOT NULL,
creation_date DATETIME NOT NULL,
execution_method VARCHAR(40) NOT NULL
);