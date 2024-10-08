CREATE TABLE persons
(
    id       UUID NOT NULL,
    login    VARCHAR(255),
    password VARCHAR(255),
    role     VARCHAR(255),
    CONSTRAINT pk_persons PRIMARY KEY (id)
);