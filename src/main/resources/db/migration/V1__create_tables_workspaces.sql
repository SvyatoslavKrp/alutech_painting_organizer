CREATE TABLE masters
(
    id      INT PRIMARY KEY generated by default as identity,
    name    VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL
);

CREATE TABLE workplaces
(
    id        INT PRIMARY KEY generated by default as identity,
    name      VARCHAR(255) NOT NULL,
    master_id INTEGER      NOT NULL
);

CREATE TABLE workers
(
    id            INT PRIMARY KEY generated by default as identity,
    name          VARCHAR(255) NOT NULL,
    surname       VARCHAR(255) NOT NULL,
    start_working DATE         NOT NULL,
    workplace_id  INTEGER,
    profession    VARCHAR(255) NOT NULL,
    master_id     INTEGER      NOT NULL,
    auth_id       INTEGER,
    note          VARCHAR(255),
    is_available  BOOLEAN DEFAULT TRUE
);

CREATE TABLE employees
(
    id        INT PRIMARY KEY generated by default as identity,
    username  VARCHAR(255) NOT NULL,
    password  VARCHAR(255) NOT NULL,
    master_id INT,
    worker_id INT
);

CREATE TABLE roles
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);


CREATE TABLE employees_roles
(
    employee_id INTEGER,
    role_id     INTEGER
);




