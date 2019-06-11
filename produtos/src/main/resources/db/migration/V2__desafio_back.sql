CREATE TABLE `task`
(
    task_status INTEGER(1),
    task_id  VARCHAR(36) NOT NULL,
    task_description VARCHAR(500) NOT NULL,
    PRIMARY KEY (task_id)
);
