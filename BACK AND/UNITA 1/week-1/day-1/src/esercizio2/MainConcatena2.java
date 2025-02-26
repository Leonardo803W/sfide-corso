package esercizio2;

import java.util.Scanner;

public class MainConcatena2 {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Scegliere una parola: ");
        String parola1 = myScanner.nextLine();
        System.out.println("Scegliere una parola: ");
        String parola2 = myScanner.nextLine();
        System.out.println("Scegliere una parola: ");
        String parola3 = myScanner.nextLine();

        concatena(parola1, parola2, parola3);

        //in questo caso non avendo nessun intero o double da prendere posso evitare di mettere myScanner.nextLine();

        myScanner.close();
    }

    //il metodo essendo in un main devo metterlo come static che abbia ritorno oppure no
    //i motivi per cui il metodo e il main sono statici sono i seguenti:
    //Punto di ingresso: Il metodo main è il punto di ingresso del tuo programma Java. Quando esegui il tuo programma, la Java Virtual Machine (JVM) cerca il metodo main e inizia l'esecuzione da lì.
    //Esecuzione senza istanza: La JVM non crea un'istanza della classe contenente il metodo main prima di eseguire il programma. Invece, esegue il metodo main direttamente.
    //Metodi statici: I metodi statici appartengono alla classe stessa, non a un'istanza specifica. Questo significa che possono essere chiamati senza creare un oggetto della classe.

    //il nome che metto nei parametri puo essere diverso dal nome della variabile che do nel momento in cui chiamo il metodo, questo perche anche se nome differenti il valore e sempre della variabile che gli passo, ma devono combaciare il tipo delle variabili sia in chiamata sia nel parametro


    public static void concatena(String parola1, String parola2, String parola3) {

        String frase = parola1 + parola2 + parola3;
        System.out.println("il risultato è: " + frase);

        String fraseInversa = parola3 + parola2 + parola1;
        System.out.println("il risultato è: " + fraseInversa);
    }
}
