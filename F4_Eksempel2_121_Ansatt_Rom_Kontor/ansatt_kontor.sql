-- SQL for en-til-en-eksemplet gjennomg�tt i timen onsdag 23. mars 2022

-- Uten koblingstabell.
-- Koblingstabell for en-til-en-forhold er mulig, men gjør ting mer komplisert.

-- Hvis vi velger FK i Ansatt = RomNr vil ansatte uten kontor ha NULL for denne.
-- Hvis vi velger FK i Rom = AnsNr vil rom uten ansatt ha NULL for denne.
-- Velger å legge FK i Ansatt

CREATE SCHEMA IF NOT EXISTS forelesning4;
SET search_path TO forelesning4;

DROP TABLE IF EXISTS Rom, Ansatt;

CREATE TABLE Rom
(
    RomNr       CHAR(4),
    Kvm         FLOAT,
    CONSTRAINT RomPN PRIMARY KEY (RomNr)
);

CREATE TABLE Ansatt
(
    AnsNr       SERIAL,
    Fornavn     CHAR(20),
    Etternavn   CHAR(20),
    RomNr       CHAR(4),
    CONSTRAINT AnsattPN PRIMARY KEY (AnsNr),
    CONSTRAINT RomFN FOREIGN KEY (RomNr) REFERENCES Rom(RomNr)
);

INSERT INTO
  Rom(RomNr, Kvm)
VALUES
    ('E425', 10.5),
    ('F118', 120.4),
    ('E404', 12.3);

INSERT INTO
  Ansatt(Fornavn, Etternavn, RomNr)
VALUES
    ('Atle', 'Atlesen', 'E425'),
    ('Carsten', 'Carstensen', NULL), -- Carsten har ikke kontor
    ('Lars', 'Larsen', 'E404');
    
