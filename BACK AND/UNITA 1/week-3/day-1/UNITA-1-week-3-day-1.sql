CREATE TABLE Clienti (
	Id SERIAL PRIMARY KEY,
	Nome VARCHAR(50) NOT NULL,
	Cognome VARCHAR(50) NOT NULL,
	Anno_di_nscita DATE NOT NULL,
	Regione_residenza VARCHAR(50) NOT NULL
);

CREATE TABLE Prodotti (
	Id SERIAL PRIMARY KEY,
	Descrizione VARCHAR(50) NOT NULL,
	In_produzione INTEGER NOT NULL,
	In_commercio INTEGER NOT NULL,
	Data_attivazione DATE NOT NULL,
	Data_disattivazione DATE NOT NULL
);

CREATE TABLE Fornitori(
	Id SERIAL PRIMARY KEY,
	Denominazione VARCHAR(50) NOT NULL,
	Regione_residenza VARCHAR(50) NOT NULL
);

CREATE TABLE Fatture (
	Id SERIAL PRIMARY KEY,
	Tipologia VARCHAR(50) NOT NULL,
	Importo INTEGER NOT NULL,
	Iva INTEGER NOT NULL,
	Id_cliente INTEGER REFERENCES Clienti(Id),
	Data_fattura DATE NOT NULL,
	Id_fornitore INTEGER REFERENCES Fornitori(Id)
);

//esempio inserimento di un solo elemento

INSERT INTO clienti.clienti(Nome, Cognome, AnnoDiNascita, RegioneResidenza)
					VALUES('marco', 'galbusera', 1945, 'lombardia')

//inserimento di piu elementi in una volta sola

INSERT INTO prodotti(descrizione, in_produzione, in_commercio, data_attivazione, data_disattivazione)
VALUES('televisore', 10, 20, '2001-06-12', '2026-03-18'),
	('telefono', 5, 9, '2006-06-12', '2029-03-18'),
	('macchina', 2, 15, '2020-06-12', '2036-03-18'),
	('frusta elettrica', 0, 25, '2023-06-12', '2025-03-18'),
	('pelush', 30, 5, '2025-06-12', '2040-03-18');

INSERT INTO fornitori(denominazione, regione_residenza)
VALUES('luigi', 'veneto'),
	('bob', 'calabria'),
	('marco', 'monza'),
	('vespucci', 'sardegna'),
	('cassandra', 'roma');

INSERT INTO clienti(Nome, Cognome, Anno_di_nscita, Regione_residenza)
VALUES('marco', 'galbusera', '1945-03-21', 'lombardia'),
	('luigi', 'nesi', '1982-05-21', 'friuli venezia giulia'),
	('mario', 'umberto', '1982-01-25', 'milano'),
	('mario', 'rossi', '2005-05-21', 'veneto');

INSERT INTO fatture(tipologia, importo, iva, id_cliente, data_fattura, id_fornitore)
VALUES('televisore', 500, 20, 1, '2025-04-30', 1),
	('telefono', 1100, 15, 2, '2005-04-30', 2),
	('macchina', 5000, 25, 3, '2019-04-30', 4),
	('frusta eletrica', 60, 20, 4, '2023-04-30', 4);
	
esercizio: 

//con * seleziono tutti i campi, se invece voglio selezionare solo una colonna specifica devo fare come nel secondo caso
//ovviamente con il nome della colonna, from invece indico in quale tabella mentre where e la condizione
//in questo caso la condizione fa che estraggo gli elementi che hanno nome uguale a mario

1) select * from clienti where nome = 'mario'; oppure fare: select nome from clienti where nome = 'mario';

//con * seleziono tutti i campi, se invece voglio selezionare solo una colonna o piu come in questo caso si specifica, devo fare come nel secondo caso
//ovviamente con il nome delle colonne, from invece indico in quale tabella mentre between e la condizione che si usa quando si cerca un intervallo di tempo
//in questo caso la condizione fa che estraggo gli elementi che sono nellintervallo che specifico con and

2) select * from clienti where anno_di_nscita between '1982-01-01' and '1982-12-30'; oppure fare: select nome, cognome from clienti where anno_di_nscita between '1982-01-01' and '1982-12-30';

3) select * from fatture where iva = 20;
4) select * from prodotti where data_attivazione  between '2017-01-01' and '2017-12-30';

oppure in alternativa:

//AND (in_produzione = true OR in_commercio = false):
//Questa parte della condizione filtra ulteriormente i risultati:
//in_produzione = true: Seleziona i prodotti che sono attualmente in produzione.
//OR in_commercio = false: Oppure, seleziona i prodotti che non sono in commercio.
//Luso di OR significa che se una delle due condizioni è vera, il prodotto sarà incluso nei risultati.

SELECT * FROM prodotti WHERE (data_attivazione BETWEEN '2017-01-01' AND '2017-12-31') AND (in_produzione = true OR in_commercio = false)

//LINNER JOIN è utilizzata per combinare righe da entrambe le tabelle (in questo caso, fatture e clienti) in base a una condizione specifica. 
//Solo le righe che soddisfano questa condizione saranno incluse nel risultato finale.
//Questa è la condizione di join. Stai dicendo che vuoi unire le righe della tabella fatture con quelle della tabella clienti dove il campo id_cliente nella tabella fatture corrisponde al campo id nella tabella clienti. 
//Questo permette di associare ogni fattura al cliente corrispondente.

5)SELECT *  FROM fatture INNER JOIN clienti ON fatture.id_cliente = clienti.id  WHERE fatture.importo < 1000;

//in questo caso anche se denominazione non fa parte di fatture ma di fornitori devo comunque metterla nei campi iinsieme agli altyri dopo select poiche  il campo denominazione
//lo prende dallid del fornitore

6)SELECT importo, iva, data_fattura, denominazione FROM fatture INNER JOIN fornitori ON fatture.id_fornitore = fornitori.id;

extra: