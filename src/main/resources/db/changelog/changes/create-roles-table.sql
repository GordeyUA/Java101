--liquibase formatted sql
--changeset sgordievskiy:create-roles-table
CREATE TABLE roles (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),

    PRIMARY KEY (id)
) ENGINE=InnoDB;

--rollback DROP TABLE roles;
