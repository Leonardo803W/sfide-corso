CREATE TABLE Clienti (
	NumeroCliente SERIAL PRIMARY KEY,
	Nome VARCHAR(50) NOT NULL,
	Cognome VARCHAR(50) NOT NULL,
	AnnoDiNscita DATE NOT NULL,
	RegioneResidenza VARCHAR(50) NOT NULL
);

CREATE TABLE Prodotti (
	IdProdotto SERIAL PRIMARY KEY,
	Descrizione VARCHAR(50) NOT NULL,
	InProduzione INTEGER NOT NULL,
	InCommercio INTEGER NOT NULL,
	DataAttivazione DATE NOT NULL,
	DataDisattivazione DATE NOT NULL
);

CREATE TABLE Fornitori(
	NumeroFornitore SERIAL PRIMARY KEY,
	Denominazione VARCHAR(50) NOT NULL,
	RegioneResidenza VARCHAR(50) NOT NULL
);

CREATE TABLE Fatture (
	NumeroFattura SERIAL PRIMARY KEY,
	Tipologia VARCHAR(50) NOT NULL,
	Importo INTEGER NOT NULL,
	Iva INTEGER NOT NULL,
	IdCliente INTEGER REFERENCES Clienti(NumeroCliente),
	DataFattura DATE NOT NULL,
	IdFornitore INTEGER REFERENCES Fornitori(NumeroFornitore)
);

SELECT * FROM clienti WHERE nome = 'Mario';
SELECT nome, cognome FROM clienti WHERE anno_di_nascita = 1982;
SELECT COUNT(*) FROM fatture WHERE iva=20;
SELECT * FROM prodotti WHERE (data_attivazione BETWEEN '2017-01-01' AND '2017-12-31') AND (in_produzione = true OR in_commercio = false);
SELECT * FROM fatture WHERE importo < 1000 JOIN clienti ON id_cliente = numero_cliente;
SELECT numero_fattura, importo, iva, denominazione data FROM fatture JOIN fornitori USING(numero_fornitore);
SELECT COUNT(*), EXTRACT(YEAR FROM data_fattura) AS anno FROM fatture WHERE iva=20 GROUP BY anno;
SELECT COUNT(*), SUM(importo), EXTRACT(YEAR FROM data_fattura) AS anno FROM fatture WHERE iva=20 GROUP BY anno;
SELECT EXTRACT(YEAR FROM data_fattura), COUNT(*) AS totale FROM fatture WHERE tipologia = 'A' GROUP BY EXTRACT(YEAR FROM data_fattura) HAVING COUNT(*) >= 2;
SELECT COUNT(*), SUM(importo), regione_residenza FROM fatture JOIN clienti ON id_cliente = numero_cliente GROUP BY regione_residenza;
SELECT * FROM fatture WHERE id_cliente IN (SELECT numero_cliente FROM clienti WHERE anno_nascita = 1980) AND importo > 50;