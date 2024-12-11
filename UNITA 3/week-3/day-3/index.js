console.log('hello word');
//1) Quali sono i tipi primitivi principali in TypeScript?
console.log('i tipi primitivi principali di TypeScript sono: string, number, bollean, null e undefind.');
//2) Crea tre variabili tipizzate: una stringa con il tuo nome, un numero con la tua età, e un booleano che indica se stai studiando TypeScript.
var myName = 'Leonardo';
var age = 22;
var studyTypeScript = true;
console.log('mi chiamo ' + myName + ',' + ' anni: ' + age + ',' + ' studio TypeScript: ' + studyTypeScript);
//3) Tipizza il parametro della seguente funzione:
var greet = function (name) {
    return "Ciao " + name;
};
console.log(greet('leonardo'));
//4) Specifica il tipo di ritorno della seguente funzione:
var sum = function (a, b) {
    return a + b;
};
console.log(sum(5, 10));
//5) Crea una funzione che accetti un prezzo e restituisca il prezzo con IVA (22%). Usa i tipi appropriati.
var price = function (a) {
    var iva = 0;
    var sum = 0;
    iva = a * 22 / 100;
    sum = a + iva;
    return 'prezzo iniziale ' + a + ' totale ' + sum + ' di cui iva al 22%: ' + iva;
};
console.log(price(500));
//6) Crea una funzione che concateni due stringhe e restituisca la lunghezza totale.
var parola = function (str1, str2) {
    var stringa = ' ';
    stringa = str1.concat(str2);
    return 'la parola ' + stringa + ' e lunga: ' + stringa.length;
};
console.log(parola('fanta', 'stic'));
//7) Cos'è un Type Union e come si scrive?
var variabile = function (mix) {
    console.log('la varibaile mix: ' + mix);
};
variabile(500);
variabile('salve');
variabile(undefined);
console.log('come visto sopra la variabile e sempre la stessa, questo perche le Type Union sono variabili che possono essere piu tipi, ovvero un number o una stringa o un undefinde anziche soltanto uno di essi');
/*8) Crea una variabile che possa contenere un numero, null o undefined.

9) Crea un tipo per rappresentare i giorni della settimana usando union di stringhe letterali.

10) Tipizza il seguente array di numeri nei due modi possibili:

const numbers = [1, 2, 3]

11) Crea una tupla per definire un array di 5 elementi, i primi 3 devono essere stringhe e gli ultimi due numeri.

12) Qual è la differenza tra type e interface?

13) Definisci un'interfaccia in TypeScript per un oggetto dotato di proprietà "firstname", "lastname", e "age".

14) Crea un'interfaccia per un utente con email obbligatoria e telefono opzionale.

15) Crea un array tipizzato di oggetti "Studente" con nome e voto.

16) Crea un'interfaccia base "Veicolo" e estendila per creare "Auto".

17) Crea un oggetto che implementi l'interfaccia Auto.

18) Cosa sono i Generics in TypeScript?

19) È possibile avere più tipi generici in un'interfaccia?

20) Crea un'interfaccia generica per una risposta API.*/ 
