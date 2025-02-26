package esercizio1;

import java.util.Scanner;

public class MainConcatena {
    public static void main(String[] args) {

        //posso scegliere la stringha e il numero personalmente facendo come nel commenti sotto di parola  e num2
        //se vogli invece che sia l'utente a scegliere i numeri posso usare Scanner ricordando di ciuderlo, non e essenziare farlo ma e di buona pratica farlo

        //String parola = "hello"
        //int num2 = 5;

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Scegliere una parola: ");
        String parola = myScanner.nextLine();
        System.out.println("Scegliere un intero: ");
        int intero = myScanner.nextInt();

        concatena(parola, intero);

        //in caso dopo aver preso un numero dall'utente e volessi prendere successivamente una stringa e non un altro numero per evitare che il nextInt mi impedisca di far inserire una stringa
        //posso usare myScanner.nextLine() prima della stringa che l'utente inviera cosi che il next int mi impedisca di far inserire una stringa;
        //myScanner.nextLine();

        myScanner.close();
    }

    //il metodo essendo in un main devo metterlo come static che abbia ritorno oppure no
    //i motivi per cui il metodo e il main sono statici sono i seguenti:
    //Punto di ingresso: Il metodo main è il punto di ingresso del tuo programma Java. Quando esegui il tuo programma, la Java Virtual Machine (JVM) cerca il metodo main e inizia l'esecuzione da lì.
    //Esecuzione senza istanza: La JVM non crea un'istanza della classe contenente il metodo main prima di eseguire il programma. Invece, esegue il metodo main direttamente.
    //Metodi statici: I metodi statici appartengono alla classe stessa, non a un'istanza specifica. Questo significa che possono essere chiamati senza creare un oggetto della classe.

    //il nome che metto nei parametri puo essere diverso dal nome della variabile che do nel momento in cui chiamo il metodo, questo perche anche se nome differenti il valore e sempre della variabile che gli passo, ma devono combaciare il tipo delle variabili sia in chiamata sia nel parametro


    public static void concatena(String parola, int intero) {

        String frase = parola + intero;
        System.out.println("il risultato è: " + frase);
    }
}
