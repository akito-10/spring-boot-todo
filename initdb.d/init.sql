USE sample;
DROP TABLE IF EXISTS tasks;
CREATE TABLE tasks
(
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `title` varchar(100) NULL,
    `content` varchar(500) NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;