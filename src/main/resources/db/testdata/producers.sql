--liquibase formatted sql
--changeset matsior:8
INSERT INTO
    producer(name, description)
VALUES
    ('browar1', 'opis1'),
    ('browar2', 'opis2'),
    ('browar3', 'opis3');