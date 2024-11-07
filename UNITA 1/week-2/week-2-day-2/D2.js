/* ESERCIZIO 1
 Scrivi un algoritmo per trovare il più grande tra due numeri interi.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let num1 = 5
let num2 = 10
if(num1 > num2){
  console.log("il numero più grande e: " + num1)
}
else{
  console.log("il numero più grande e" + num2)
}

/* ESERCIZIO 2
  Scrivi un algoritmo che mostri "not equal" in console se un numero intero fornito è diverso da 5.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
const num3 = 5
let num4 = 10
if(num4 !== num3){
  console.log("il numero " + num4 + " non e uguale al numero " + num3)
}

/* ESERCIZIO 3
  Scrivi un algoritmo che mostri "divisibile per 5" in console se un numero fornito è perfettamente divisibile per 5 (suggerimento: usa l'operatore modulo)
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let num5 = 50
if(num5 % 5 === 0){
  console.log("il valore " + num5 + " è perfettamente divisibile per 5")
}

/* ESERCIZIO 4
  Scrivi un algoritmo per verificare che, dati due numeri interi, il valore di uno di essi sia 8 oppure se la loro addizione/sottrazione sia uguale a 8.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let intero1 = 8
let intero2 = 9
if(intero1 === 8){
  console.log("il primo valore e 8")
}
else{
  console.log("il secondo valore e 8")
}

intero1 = 4
intero2 = 4
let sum = intero1 + intero2
let sottrazione = intero1 - intero2
if(sum === 8){
  console.log("la somma dei due valori e uguale a 8")
}
if(sottrazione === 8){
  console.log("la sotrazione dei due valori e uguale a 8 8")
}

/* ESERCIZIO 5
  Stai lavorando su un sito di e-commerce. Stai salvando il saldo totale del carrello dell'utente in una variabile "totalShoppingCart".
  C'è una promozione in corso: se il totale del carrello supera 50, l'utente ha diritto alla spedizione gratuita (altrimenti la spedizione ha un costo fisso pari a 10).
  Crea un algoritmo che determini l'ammontare totale che deve essere addebitato all'utente per il checkout.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let totalShoppingCart = 60
const spedizione = 10
let total = totalShoppingCart + spedizione
if(totalShoppingCart > 50)
{
  console.log("ha superato i 50 euro per avere la spedizione gratuita, il suo totale e: " + totalShoppingCart)
}
else{
  console.log("mi spiace ma non ha supeato i 50 euro per avere la spedizione gratis, il suo totale e: " + total)
}

/* ESERCIZIO 6
  Stai lavorando su un sito di e-commerce. Oggi è il Black Friday e viene applicato il 20% su ogni prodotto.
  Modifica la risposta precedente includendo questa nuova promozione nell'algoritmo, determinando come prima se le spedizioni sono gratuite oppure no e e calcolando il totale.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
totalShoppingCart = 40
const BlackFriday = ((totalShoppingCart * 20) / 100)
total = BlackFriday + spedizione
if(totalShoppingCart > 50)
  {
    console.log("ha superato i 50 euro per avere la spedizione gratuita, l'articolo costa " + totalShoppingCart + " ma essendoci il Black Friday ogni merce e scontata del 20% il suo totale e: " + BlackFriday)
  }
  else{
    console.log("mi spiace ma non ha supeato i 50 euro per avere la spedizione gratis, ma essendoci il Black Friday ogni merce e scontata del 20% il suo totale e: " + total)
  }

/* ESERCIZIO 7
  Crea tre variabili, e assegna un valore numerico a ciascuna di esse.
  Utilizzando un blocco condizionale, crea un algoritmo per ordinarle secondo il loro valore, dal più alto al più basso.
  Alla fine mostra il risultato in console.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let numero1 = 10
let numero2 = 2
let numero3 = 8
let numeroTemporaneo
if(numero2 < numero1){
  numeroTemporaneo = numero1
  numero1 = numero2
  numero2 = numeroTemporaneo

  if(numero3 < numero2){
    numeroTemporaneo = numero2
    numero2 = numero3
    numero3 = numeroTemporaneo

    console.log("l'ordine crescente e: " + numero1 + ' ' + numero2  + ' ' + numero3)
  }
}

/* ESERCIZIO 8
  Crea un algoritmo per verificare che un valore fornito sia un numero oppure no (suggerimento: cerca su un motore di ricerca "typeof").
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let verifica = 5
console.log(("il valore e un number o string?") + ' ' + typeof verifica);

/* ESERCIZIO 9
  Crea un algoritmo per controllare se un numero fornito sia pari o dispari (suggerimento: cerca l'operatore modulo su un motore di ricerca)
*/

/* SCRIVI QUI LA TUA RISPOSTA */
const controllore = 8
if(controllore % 2 === 0){
  console.log("il valore " + controllore + " e pari")
}
else{
  console.log("il valore " + controllore + " e dispari")
}

/* ESERCIZIO 10
  Modifica la logica del seguente algoritmo in modo che mostri in console il messaggio corretto in ogni circostanza.
  let val = 7
  if (val < 10) {
      console.log("Meno di 10");
    } else if (val < 5) {
      console.log("Meno di 5");
    } else {
      console.log("Uguale a 10 o maggiore");
    }
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let val = 1
if (val < 10) {
      console.log("Meno di 10");
  }
if (val < 5) {
      console.log("Meno di 5");
  }
if(val >= 10){
      console.log("Uguale a 10 o maggiore");
  }

/* ESERCIZIO 11
  Fornito il seguente oggetto, scrivi del codice per aggiungere una proprietà "city", il cui valore sarà "Toronto".
*/

const me = {
  name: 'John',
  lastName: 'Doe',
  skills: ['javascript', 'html', 'css'],
}

/* SCRIVI QUI LA TUA RISPOSTA */
me.city = "Toronto"
console.log(me)

/* ESERCIZIO 12
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere la proprietà "lastName".
*/

/* SCRIVI QUI LA TUA RISPOSTA */
delete me.lastName
console.log(me)

/* ESERCIZIO 13
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere l'ultimo elemento della proprietà "skills".
*/

/* SCRIVI QUI LA TUA RISPOSTA */
me.skills.pop()
console.log(me);

/* ESERCIZIO 14
  Scrivi del codice per creare un array inizialmente vuoto. Riempilo successivamente con i numeri da 1 a 10.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
const arrayNumeri = []
arrayNumeri.push(1)
arrayNumeri.push(2)
arrayNumeri.push(3)
arrayNumeri.push(4)
arrayNumeri.push(5)
arrayNumeri.push(6)
arrayNumeri.push(7)
arrayNumeri.push(8)
arrayNumeri.push(9)
arrayNumeri.push(10)
console.log('arrayNumeri ' + arrayNumeri)

/* ESERCIZIO 15
  Scrivi del codice per sostituire l'ultimo elemento dell'array, ovvero il valore 10, con il valore 100.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
arrayNumeri.pop()
arrayNumeri.push(100)
console.log('arrayNumeri ' + arrayNumeri)