-- PostgreSQL database dump

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

-- Set session parameters
SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

-- Create tables
CREATE TABLE categories (
                            id bigserial PRIMARY KEY,
                            category_type varchar(255),
                            category_title varchar(255)
);

CREATE TABLE contacts (
                          id bigserial PRIMARY KEY,
                          manager_id bigint,
                          description varchar(255),
                          full_address varchar(255),
                          phone_number varchar(255),
                          email varchar(255)
);

CREATE TABLE game (
                      id bigserial PRIMARY KEY,
                      game_list_id bigint,
                      title varchar(255),
                      price varchar(255),
                      description varchar(255),
                      info varchar(255)
);

CREATE TABLE game_images (
                             id bigserial PRIMARY KEY,
                             game_id bigint,
                             image_url varchar(255),
                             image_title varchar(255),
                             data bytea,
                             upload_time timestamp,
                             type varchar(255)
);

CREATE TABLE game_list (
                           id bigserial PRIMARY KEY,
                           categories_id bigint
);

CREATE TABLE game_rent_rules (
                                 id bigserial PRIMARY KEY,
                                 game_id bigint,
                                 rent_rules_id bigint,
                                 description varchar(255)
);

CREATE TABLE manager_images (
                                id bigserial PRIMARY KEY,
                                image_url varchar(255),
                                title varchar(255),
                                manager_id bigint,
                                data bytea,
                                upload_time timestamp,
                                type varchar(255)
);

CREATE TABLE managers (
                          id bigserial PRIMARY KEY,
                          first_name varchar(255),
                          last_name varchar(255),
                          patronymic varchar(255)
);

CREATE TABLE rent_rules (
                            id bigserial PRIMARY KEY,
                            description varchar(255)
);

CREATE TABLE translations (
                              id bigserial PRIMARY KEY,
                              entity_id bigint,
                              entity_type varchar(255),
                              language_code varchar(255),
                              translated_text varchar(255)
);

CREATE TABLE users (
                       id bigserial PRIMARY KEY,
                       email varchar(255),
                       password varchar(255),
                       name varchar(255),
                       role varchar(255)
);

-- Add foreign key constraints

-- Add foreign key to contacts table
ALTER TABLE contacts
    ADD CONSTRAINT fk_contacts_managers
        FOREIGN KEY (manager_id) REFERENCES managers(id);

-- Add foreign key to game table
ALTER TABLE game
    ADD CONSTRAINT fk_game_game_list
        FOREIGN KEY (game_list_id) REFERENCES game_list(id);

-- Add foreign key to game_images table
ALTER TABLE game_images
    ADD CONSTRAINT fk_game_images_game
        FOREIGN KEY (game_id) REFERENCES game(id);

-- Add foreign key to game_list table
ALTER TABLE game_list
    ADD CONSTRAINT fk_game_list_categories
        FOREIGN KEY (categories_id) REFERENCES categories(id);

-- Add foreign key to game_rent_rules table
ALTER TABLE game_rent_rules
    ADD CONSTRAINT fk_game_rent_rules_game
        FOREIGN KEY (game_id) REFERENCES game(id);

ALTER TABLE game_rent_rules
    ADD CONSTRAINT fk_game_rent_rules_rent_rules
        FOREIGN KEY (rent_rules_id) REFERENCES rent_rules(id);

-- Add foreign key to manager_images table
ALTER TABLE manager_images
    ADD CONSTRAINT fk_manager_images_managers
        FOREIGN KEY (manager_id) REFERENCES managers(id);
