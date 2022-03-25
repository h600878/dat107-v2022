-- SQL for en-til-mange-eksemplet gjennomgått i timen onsdag 23. mars 2022

DROP SCHEMA IF EXISTS forelesning4 CASCADE;
CREATE SCHEMA forelesning4;
SET search_path TO forelesning4;
    
CREATE TABLE Todoliste
(
    ListeId     SERIAL,
    Navn        VARCHAR,
    CONSTRAINT TodolistePK PRIMARY KEY (ListeId)
);

CREATE TABLE Todo
(
    TodoId      SERIAL,
    Tekst       VARCHAR,
    ListeId     INTEGER,
    CONSTRAINT TodoPK PRIMARY KEY (TodoId),
    CONSTRAINT ListeFK FOREIGN KEY (ListeId) REFERENCES Todoliste(ListeId)
);
