CREATE TYPE tipoSesso AS ENUM ('M', 'F');

CREATE TABLE Persona (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    data_nascita DATE NOT NULL,
    sesso tipoSesso NOT NULL,
    lista_partecipazioni INTEGER[]
);

CREATE TYPE tipoPartecipazione AS ENUM ('CONFERMATO', 'DA_CONFERMARE');

CREATE TABLE Partecipazione (
    id SERIAL PRIMARY KEY,
    persona_id INT,
    evento_id INT,
    stato tipoPartecipazione NOT NULL,
    FOREIGN KEY (persona_id) REFERENCES persona(id),
    FOREIGN KEY (evento_id) REFERENCES Evento(id)
);

CREATE TABLE Location (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    citta VARCHAR(50) NOT NULL
);

CREATE TYPE tipoEvento AS ENUM ('PUBBLICO', 'PRIVATO');

CREATE TABLE Evento (
    id SERIAL PRIMARY KEY,
    titolo VARCHAR(50) NOT NULL,
    data_evento DATE NOT NULL,
    descrizione VARCHAR(50) NOT NULL,
    tipo_evento tipoEvento NOT NULL,
    numero_massimo_partecipanti INTEGER NOT NULL
);