CREATE TABLE Evento (
	id SERIAL PRIMARY KEY,
	titolo VARCHAR(50) NOT NULL,
	dataEvento DATE NOT NULL,
	descrizione VARCHAR(50) NOT NULL,
	tipoEvento VARCHAR(50) NOT NULL,
	numeroMassimoPartecipanti INTEGER NOT NULL
);