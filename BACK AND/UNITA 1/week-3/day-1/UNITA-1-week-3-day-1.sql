CREATE TABLE Clienti
{
	NumeroCliente SERIAL PRIMARY KEY,
	Nome VARCHAR(50) NOT NULL,
	Cognome VARCHAR(50) NOT NULL,
	AmmoDiNascita VARCHAR(50) NOT NULL,
	RegioneResidenza VARCHAR(50) NOT NULL
}

CREATE TABLE Prodotti
{
	IdProdotto SERIAL PRIMARY KEY,
	Descrizione VARCHAR(150) NOT NULL,
	InProduzione INTEGER NOT NULL,
	InCommercio INTEGER NOT NULL,
	DataAttivazione VARCHAR(50) NOT NULL,
	DataDisattivazione VARCHAR(50) NOT NULL
}

CREATE TABLE Fornitori
{
	NumeroFornitore SERIAL PRIMARY KEY,
	Denominazione VARCHAR(50) NOT NULL,
	RegioneResidenza VACHAR(50) NOT NULL
}

CREATE TABLE Fatture
{
	NumeroFattura SERIAL PRIMARY KEY,
	Tipologia VACHAR(50) NOT NULL,
	Iva INTEGER NOT NULL,
	IdCliente INTEGER NOT NULL,
	DataFattura VACHAR(50) NOT NULL,
	NumeroFornitore INTEGER NOT NULL
}