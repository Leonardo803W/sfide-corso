package esercizio1;

public class Main {

    public static void main(String[] args) {

        String stringa = "Hello world!";

        stringPariDispari(stringa);
    }

    //il metodo essendo in un main devo metterlo come static che abbia ritorno oppure no
    //i motivi per cui il metodo e il main sono statici sono i seguenti:
    //Punto di ingresso: Il metodo main è il punto di ingresso del tuo programma Java. Quando esegui il tuo programma, la Java Virtual Machine (JVM) cerca il metodo main e inizia l'esecuzione da lì.
    //Esecuzione senza istanza: La JVM non crea un'istanza della classe contenente il metodo main prima di eseguire il programma. Invece, esegue il metodo main direttamente.
    //Metodi statici: I metodi statici appartengono alla classe stessa, non a un'istanza specifica. Questo significa che possono essere chiamati senza creare un oggetto della classe.

    //il nome che metto nei parametri puo essere diverso dal nome della variabile che do nel momento in cui chiamo il metodo, questo perche anche se nome differenti il valore e sempre della variabile che gli passo, ma devono combaciare il tipo delle variabili sia in chiamata sia nel parametro



    public static void stringPariDispari(String stringa) {

        if(stringa.length() % 2 == 0) {

            System.out.print("La stringa inserita e pari");
        }
        else
        {
                System.out.print("La stringa inserita e dispari");
        }
    }
}