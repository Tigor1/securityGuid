CREATE SCHEMA IF NOT EXISTS principal;

CREATE TABLE IF NOT EXISTS principal.account
(
    id                      UUID                        NOT NULL PRIMARY KEY,
    username                VARCHAR(128)                 NOT NULL,
    password                VARCHAR                     NOT NULL,
    email                   VARCHAR(128)                NOT NULL,
    age                     INT,
    created                 TIMESTAMP WITH TIME ZONE    NOT NULL,
    last_login_time         TIMESTAMP WITH TIME ZONE    NOT NULL,
    is_non_expired          BOOLEAN                     NOT NULL,
    is_non_lock             BOOLEAN                     NOT NULL,
    is_credentials_expired  BOOLEAN                     NOT NULL,
    is_enable               BOOLEAN                     NOT NULL
--     token                   VARCHAR                     UNIQUE
);

CREATE TABLE IF NOT EXISTS principal.role
(
    role_id UUID,
    roles INT,
    FOREIGN KEY (role_id) REFERENCES principal.account (id)
);

CREATE TABLE IF NOT EXISTS principal.book
(
    id          UUID                        PRIMARY KEY,
    release     TIMESTAMP WITH TIME ZONE,
    title       TEXT                        NOT NULL
);
