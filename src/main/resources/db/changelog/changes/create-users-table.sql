--liquibase formatted sql
--changeset sgordievskiy:create-users-table
CREATE TABLE users (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255),

    PRIMARY KEY (id)
) ENGINE=InnoDB;

--rollback DROP TABLE users;
