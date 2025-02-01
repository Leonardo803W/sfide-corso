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

//inserimento di un solo elemento

INSERT INTO clienti.clienti(Nome, Cognome, AnnoDiNascita, RegioneResidenza)
					VALUES('marco', 'galbusera', 1945, 'lombardia')

//inserimento di piu elementi in una volta sola

INSERT INTO clienti(Nome, Cognome, AnnoDiNascita, RegioneResidenza)
VALUES('marco', 'galbusera', '1945-03-21', 'lombardia'),
							('luigi', 'nesi', '2005-05-21', 'veneto');

//estrae solo gli elementi che contengono il valore 'lombardia'

select * from clienti where regioneresidenza = 'lombardia';

//estrae tutti gli elementi da tutti i campi senza condizione di valore

select * from clienti;

//estrae solo i campi nome contenenti il valore di condizione di where

select nome from clienti where regioneresidenza = 'lombardia';

//elimino la colonna cognome

alter table clienti drop column cognome;

//altero la tabella creando la colonna cognome;

alter table clienti add cognome varchar(15) not null default ' ';

//cambio il valore della colonna nome con condizione

update clienti set nome = 'franco' where nome = 'marco';

//elimino un valore nella colonna nome con condizione;

delete from clienti where nome = 'leo';

UPDATE fatture
SET idcliente = clienti.numerocliente
FROM clienti
WHERE fatture.idcliente = clienti.numerocliente
AND fatture.idcliente IS NULL;

UPDATE fatture: Indica che stiamo aggiornando la tabella fatture.
SET idcliente = clienti.id_cliente: Imposta il valore della colonna idcliente della tabella fatture al valore della colonna id_cliente della tabella clienti.
FROM clienti: Specifica che stiamo unendo la tabella clienti.
WHERE fatture.id_cliente = clienti.numero_cliente: Specifica la condizione di join tra le due tabelle.
AND fatture.idcliente IS NULL: Limita laggiornamento solo alle righe in cui idcliente è NULL.

esercizio: 

1) select * from clienti where nome = 'mario';
2) select * from clienti where annodinascita between '1982-01-01' and '1982-12-30';
3) select * from fatture where iva = 20;
4) select * from prodotti where dataattivazione  between '2017-01-01' and '2017-12-30';
