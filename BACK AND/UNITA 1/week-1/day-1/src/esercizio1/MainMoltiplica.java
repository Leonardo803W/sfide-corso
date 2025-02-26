package esercizio1;

import java.util.Scanner;

public class MainMoltiplica {
    public static void main(String[] args) {

        //posso scegliere i numeri personalmente facendo come nel commenti sotto di num1 e num2
        //se vogli invece che sia l'utente a scegliere i numeri posso usare Scanner ricordando di ciuderlo, non e essenziare farlo ma e di buona pratica farlo

        //int num1 = 5;
        //int num2 = 5;

        Scanner myScanner = new Scanner(System.in);

        System.out.println("scegliere il primo numero: ");
        int num1 = myScanner.nextInt();
        System.out.println("scegliere il secondo numero: ");
        int num2 = myScanner.nextInt();

        moltiplica(num1, num2);

        //in caso dopo aver preso un numero dall'utente e volessi prendere successivamente una stringa e non un altro numero per evitare che il nextInt mi impedisca di far inserire una stringa
        //posso usare myScanner.nextLine() prima della stringa che l'utente inviera cosi che il next int mi impedisca di far inserire una stringa;
        //myScanner.nextLine();

        myScanner.close();
    }

    //posso fare il calcolo e stampare con il ritorno o senza
    //se scelgo di fare con il ritorno devo fare con le parti commentate se non voglio fare con il ritorno favccio con le parti non commentate
    //void se non ritorna niente mentre se ritorna con nel primo caso il metodo deve essere dello stesso tipo di ritorno

    //int total = moltiplica(num1, num2);

    //System.out.println("il risultato è: " + total);

    /*
    public static int moltiplica(int num1, int num2) {

        int total = num1 * num2;

        return total;
    }
    */

    //il metodo essendo in un main devo metterlo come static che abbia ritorno oppure no
    //i motivi per cui il metodo e il main sono statici sono i seguenti:
    //Punto di ingresso: Il metodo main è il punto di ingresso del tuo programma Java. Quando esegui il tuo programma, la Java Virtual Machine (JVM) cerca il metodo main e inizia l'esecuzione da lì.
    //Esecuzione senza istanza: La JVM non crea un'istanza della classe contenente il metodo main prima di eseguire il programma. Invece, esegue il metodo main direttamente.
    //Metodi statici: I metodi statici appartengono alla classe stessa, non a un'istanza specifica. Questo significa che possono essere chiamati senza creare un oggetto della classe.

    //il nome che metto nei parametri puo essere diverso dal nome della variabile che do nel momento in cui chiamo il metodo, questo perche anche se nome differenti il valore e sempre della variabile che gli passo, ma devono combaciare il tipo delle variabili sia in chiamata sia nel parametro


    public static void moltiplica(int num1, int num2) {

        int total = num1 * num2;
        System.out.println("il risultato è: " + total);
    }
}
