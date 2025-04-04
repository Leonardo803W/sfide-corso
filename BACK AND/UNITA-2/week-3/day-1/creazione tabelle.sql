CREATE TYPE stato AS ENUM ('in_programma', 'completato');

CREATE TABLE viaggio (
    id SERIAL PRIMARY KEY,
    destinazione VARCHAR(50) NOT NULL,
    data_viaggio DATA NOT NULL,
	stato_viaggio stato NOT NULL,
	dipendente_id INT,
	FOREIGN KEY (dipendente_id) REFERENCES dipendente(id)
);

CREATE TABLE dipendente (
    id SERIAL PRIMARY KEY,
	username VARCHAR(100) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    cognome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY, -- Chiave primaria con auto incremento
    username VARCHAR(255) NOT NULL UNIQUE, -- Nome utente, non nullo e unico
    password VARCHAR(255) NOT NULL, -- Password, non nulla
    account_non_expired BOOLEAN DEFAULT TRUE, -- L'account è non scaduto
    account_non_locked BOOLEAN DEFAULT TRUE, -- L'account è non bloccato
    credentials_non_expired BOOLEAN DEFAULT TRUE, -- Le credenziali non sono scadute
    enabled BOOLEAN DEFAULT TRUE -- L'account è abilitato
);
