create TABLE workplaces
(
    id        INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name      VARCHAR,
    master_id INT
);

create TABLE workers
(
    id            INT PRIMARY KEY generated by default as identity,
    name          VARCHAR(255) NOT NULL,
    profession    VARCHAR(255) NOT NULL,
    start_working DATE         NOT NULL,
    surname       VARCHAR(255) NOT NULL,
    is_available  BOOLEAN DEFAULT true,
    note          VARCHAR(255),
    workplace_id  INT,
    master_id     INT
);

CREATE TABLE masters (
    id INT PRIMARY KEY generated by default as identity,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL
);


create TABLE employees
(
    id      INT PRIMARY KEY generated by default as identity,
    username   VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    master_id   INT NOT NULL REFERENCES "masters" ("id"),
    worker_id   INT NOT NULL REFERENCES "workers" ("id")
);

CREATE TABLE employees (
    id      INT PRIMARY KEY generated by default as identity,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    passwordConfirm VARCHAR(255),
    master_id INT,
    worker_id INT,
    CONSTRAINT fk_master FOREIGN KEY (master_id) REFERENCES masters (id),
    CONSTRAINT fk_worker FOREIGN KEY (worker_id) REFERENCES workers (id)
);


create table roles
(
    id      INT PRIMARY KEY generated by default as identity,
    name    varchar(255)
);

create table employees_roles
(
user_employee_id    INT,
roles_id            INT
);



