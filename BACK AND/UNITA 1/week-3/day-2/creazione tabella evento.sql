CREATE TYPE tipo AS ENUM ('PUBBLICO', 'PRIVATO');

CREATE TABLE Evento (
	id SERIAL PRIMARY KEY,
	titolo VARCHAR(50) NOT NULL,
	data_evento DATE NOT NULL,
	descrizione VARCHAR(50) NOT NULL,
	tipo_evento tipo NOT NULL,
	numero_massimo_partecipanti INTEGER NOT NULL
)