package esercizio1;

import java.util.Arrays;

public class MainInserisciArray {
    public static void main(String[] args) {

        String stringa = "ciao";
        String[] list = new String[5];
        list[0] = "bob";
        list[1] = "miao";
        list[2] = "cane";
        list[3] = "panda";
        list[4] = "gatto";

        //con gli array devo sempre inizializzarli volendo deciedendo la loro dimensione facendo String[] list = new String[5];
        //se voglio che venga inizializzato con un valore specifico faccio String[] list = {"bob", "miao", "cane", "panda", "gatto"}
        //mentre se voglio che i valori siano scelti dall'utente faccio come nei commenti sotto

        /*
        String[] list = new String[5];

        System.out.println("Scegliere una parola alla posizione 1: ");
        String parola1 = myScanner.nextLine();
        System.out.println("Scegliere una parola alla posizione 2: ");
        String parola2 = myScanner.nextLine();
        System.out.println("Scegliere una parola alla posizione 3: ");
        String parola3 = myScanner.nextLine();
        System.out.println("Scegliere una parola alla posizione 4: ");
        String parola4 = myScanner.nextLine();
        System.out.println("Scegliere una parola alla posizione 5: ");
        String parola5 = myScanner.nextLine();

        list[0] = parola1;
        list[1] = parola2;
        list[2] = parola3;
        list[3] = parola4;
        list[4] = parola5;

        System.out.println("Scegliere una parola da sostituire alla posizione 3: ");
        String stringa = myScanner.nextLine();
         */

        inserisciArray(stringa, list);
    }

    //il metodo essendo in un main devo metterlo come static che abbia ritorno oppure no
    //i motivi per cui il metodo e il main sono statici sono i seguenti:
    //Punto di ingresso: Il metodo main è il punto di ingresso del tuo programma Java. Quando esegui il tuo programma, la Java Virtual Machine (JVM) cerca il metodo main e inizia l'esecuzione da lì.
    //Esecuzione senza istanza: La JVM non crea un'istanza della classe contenente il metodo main prima di eseguire il programma. Invece, esegue il metodo main direttamente.
    //Metodi statici: I metodi statici appartengono alla classe stessa, non a un'istanza specifica. Questo significa che possono essere chiamati senza creare un oggetto della classe.

    //il nome che metto nei parametri puo essere diverso dal nome della variabile che do nel momento in cui chiamo il metodo, questo perche anche se nome differenti il valore e sempre della variabile che gli passo, ma devono combaciare il tipo delle variabili sia in chiamata sia nel parametro


    public static  void inserisciArray(String stringa, String[] list) {

        String[] newList = new String[6];

        for (int i = 0; i < list.length; i++) {

            newList[i] = list[i];

            if(list[i] == list[2]) {

                newList[2] = stringa;
            }

            newList[3] = list[2];
            newList[4] = list[3];
            newList[5] = list[4];
        }

        System.out.println(Arrays.toString(newList));
    }
}