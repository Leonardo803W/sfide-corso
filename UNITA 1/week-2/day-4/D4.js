/* ESERCIZIO 1
 Scrivi una funzione di nome "area", che riceve due parametri (l1, l2) e calcola l'area del rettangolo associato.
*/

/* SCRIVI QUI LA TUA RISPOSTA */

/* ESERCIZIO 2
 Scrivi una funzione di nome "crazySum", che riceve due numeri interi come parametri.
 La funzione deve ritornare la somma dei due parametri, ma se il valore dei due parametri è il medesimo deve invece tornare
 la loro somma moltiplicata per tre.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
const num1 = 8
const num2 = 8

const crazySum = (num1, num2) => {

    let sum = 0

    if(num1 === num2)
    {
        sum = num1 + num2
        sum = sum * 3

        return sum
    }

    sum = num1 + num2

    return sum
}

console.log(crazySum(num1, num2))

/* ESERCIZIO 3
 Scrivi una funzione di nome "crazyDiff" che calcola la differenza assoluta tra un numero fornito come parametro e 19.
 Deve inoltre tornare la differenza assoluta moltiplicata per tre qualora il numero fornito sia maggiore di 19.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
const num3 = -50

const crazyDiff = (num3) => {

    const diff = 19
    let total = 0

    if(num3 > diff)
    {
        total = (num3 - diff) * 3

        return Math.abs(total)
    }

    total = num3 - 19

    return Math.abs(total)
}

console.log(crazyDiff(num3))

/* ESERCIZIO 4
 Scrivi una funzione di nome "boundary" che accetta un numero intero n come parametro, e ritorna true se n è compreso tra 20 e 100 (incluso) oppure
 se n è uguale a 400.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
const boundary = (n) => {

    if (n >= 20 && n <= 100)
    {
        return n + ' e compreso tra 20 e 100: ' + true
    }
    if (n === 400)
    {
        return n + ' e uguale a 400: ' + true
    }
    else
    {
        return n + ' non e compreso tra 20 e 100 e nemmeno uguale a 400: ' + false
    }
    
}

console.log(boundary(19))
console.log(boundary(50))
console.log(boundary(400))

/* ESERCIZIO 5
 Scrivi una funzione di nome "epify" che accetta una stringa come parametro.
 La funzione deve aggiungere la parola "EPICODE" all'inizio della stringa fornita, ma se la stringa fornita comincia già con "EPICODE" allora deve
 ritornare la stringa originale senza alterarla.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
const epify = function (str) 
{
    const strSpecial = 'EPICODE';

    if (str.toUpperCase().startsWith(strSpecial)) 
    {
        return str;
    } 
    else 
    {
        return strSpecial + ' ' + str;
    }
}

console.log(epify('epicode ciao'))
console.log(epify('ciao'))
console.log(epify('EPICODE ciao'))

/* ESERCIZIO 6
 Scrivi una funzione di nome "check3and7" che accetta un numero positivo come parametro. La funzione deve controllare che il parametro sia un multiplo
 di 3 o di 7. (Suggerimento: usa l'operatore modulo)
*/

/* SCRIVI QUI LA TUA RISPOSTA */
const check3and7 = function (n) {

    const number1 = 3
    const number2 = 7

    if(n % 3 === 0)
    {
        return n + ' e un multiplo di 3'
    }
    else if(n % 7 === 0)
    {
        return n + ' e un multiplo di 7'
    }
    else
    {
        return n + ' non e ne un multiplo di 3 ne un multiplo di 7'
    }
}

console.log(check3and7(100))
console.log(check3and7(9))
console.log(check3and7(49))

/* ESERCIZIO 7
 Scrivi una funzione di nome "reverseString", il cui scopo è invertire una stringa fornita come parametro (es. "EPICODE" --> "EDOCIPE")
*/

/* SCRIVI QUI LA TUA RISPOSTA */
const reverseString = function (str) {

    //split per dividere le singole lettere
    console.log(str.split(''))
    //reverse dato che funziona solo con array, grazie a split la stringa diventa un array 
    // e reverse va ad invertire il suo contenuto
    console.log(str.split('').reverse())
    //join fa si che di unire i pezzi ovvero le lettere precedentemente separate e cosi da array
    //ritorna una stringa
    console.log(str.split('').reverse().join(''))
}

reverseString('ciao epicode')
reverseString('ciao')

/* ESERCIZIO 8
 Scrivi una funzione di nome "upperFirst", che riceve come parametro una stringa formata da diverse parole.
 La funzione deve rendere maiuscola la prima lettera di ogni parola contenuta nella stringa.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
const upperFirst = function (str) {

    // Suddivide la stringa in parole
    const words = str.split(' ');
    console.log(words)

    // Trasforma la prima lettera di ogni parola in maiuscolo
    const capitalizedWords = words.map(word => {

        console.log(word.charAt(0).toUpperCase())
        return word.charAt(0).toUpperCase() + word.slice(1);
    })
    console.log(capitalizedWords)

    // Unisce le parole in una stringa
    const result = capitalizedWords.join(' ')

    return result;
}

console.log(upperFirst('oggi e una giornata bella!!'))

/* ESERCIZIO 9
 Scrivi una funzione di nome "cutString", che riceve come parametro una stringa. La funzione deve creare una nuova stringa senza il primo e l'ultimo carattere
 della stringa originale.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
const cutString = function (str) {

    console.log(str.slice(1, -1))
}

cutString('buongiorno a tutti')

/* ESERCIZIO 10
 Scrivi una funzione di nome "giveMeRandom", che accetta come parametro un numero n e ritorna un'array contenente n numeri casuali inclusi tra 0 e 10.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
const giveMeRandom = function (n) {

    const numeriPerDifetto = []
    const numeriPerEcesso = []
    const numeri = []

    // Genera tot. numeri casuali per difetto
    for (let i = 0; i < 50; i++) {

        // Genera un numero casuale tra 0 e n
        const randomNum = Math.floor(Math.random() * (n + 1))

        if(randomNum >= 0 && randomNum <= 10)
        {
            numeriPerDifetto.push(randomNum) // Aggiunge il numero all'array
        }
    }

    // Genera tot. numeri casuali per ecesso
    for (let i = 0; i < 50; i++) {

        // Genera un numero casuale tra 0 e n
        const randomNum = Math.ceil(Math.random() * (n + 1))

        if(randomNum >= 0 && randomNum <= 10)
        {
            numeriPerEcesso.push(randomNum) // Aggiunge il numero all'array
        }
    }

    // Genera tot. numeri casuali per ecesso
    for (let i = 0; i < 50; i++) {

        // Genera un numero casuale tra 0 e n
        const randomNum = Math.random() * (n + 1)

        if(randomNum >= 0 && randomNum <= 10)
        {
            numeri.push(randomNum) // Aggiunge il numero all'array
        }
    }

    console.log('numeri non arrotondati: ' + numeri)
    console.log('numeri arrotondati per ecesso: ' + numeriPerEcesso)
    console.log('numeri arrotondati per difetto: ' + numeriPerDifetto)
}

giveMeRandom(100)
